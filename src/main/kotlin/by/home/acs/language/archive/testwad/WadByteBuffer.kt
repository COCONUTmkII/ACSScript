package by.home.acs.language.archive.testwad

import java.io.IOException
import java.nio.BufferOverflowException
import java.nio.ByteBuffer
import java.nio.ByteOrder
import java.nio.ReadOnlyBufferException
import java.nio.channels.FileChannel

class WadByteBuffer {
    var byteBuffer: ByteBuffer
    var length: Int

    constructor(buffersize: Int) {
        byteBuffer = ByteBuffer.allocate(buffersize)
        byteBuffer.order(ByteOrder.LITTLE_ENDIAN)
        length = 0
        byteBuffer.rewind()
    }

    @JvmOverloads
    constructor(bufferchannel: FileChannel, bufferlength: Int = -1, position: Int = 0) {
        var bufferlength = bufferlength
        try {
            bufferchannel.position(position.toLong())
        } catch (var7: IOException) {
            throw RuntimeException("Position out of file bounds.", var7)
        }
        if (bufferlength < 0) {
            bufferlength = try {
                bufferchannel.size().toInt()
            } catch (var6: IOException) {
                throw RuntimeException("WAD file cannot be read.", var6)
            }
        }
        byteBuffer = ByteBuffer.allocate(bufferlength)
        byteBuffer.order(ByteOrder.LITTLE_ENDIAN)
        try {
            bufferchannel.read(byteBuffer, position.toLong())
        } catch (var5: IOException) {
            throw RuntimeException("WAD file cannot be read.", var5)
        }
        length = 0
        byteBuffer.rewind()
    }

    constructor(bytebuffer: WadByteBuffer) : this(bytebuffer.array) {}
    constructor(bytearray: ByteArray?) {
        byteBuffer = ByteBuffer.wrap(bytearray)
        byteBuffer.order(ByteOrder.LITTLE_ENDIAN)
        length = bytearray!!.size
        byteBuffer.rewind()
    }

    private val array: ByteArray?
        get() {
            val temp: ByteArray? = if (byteBuffer.hasArray()) {
                byteBuffer.array()
            } else {
                null
            }
            return temp
        }
    val byte: Byte
        get() = byteBuffer.get()

    fun getByte(index: Int): Byte {
        val temp = byteBuffer[index]
        setPosition(index + 1)
        return temp
    }

    fun getByteBuffer(offset: Int, length: Int): WadByteBuffer {
        val temp = ByteArray(length)
        byteBuffer[temp, offset, length]
        return WadByteBuffer(temp)
    }

    val short: Short
        get() = byteBuffer.short

    fun getShort(index: Int): Short {
        val temp = byteBuffer.getShort(index)
        setPosition(index + 2)
        return temp
    }

    val int: Int
        get() = byteBuffer.int

    fun getInt(index: Int): Int {
        val temp = byteBuffer.getInt(index)
        setPosition(index + 4)
        return temp
    }

    fun getEightByteString(index: Int): String {
        setPosition(index)
        return eightByteString
    }

    val eightByteString: String
        get() {
            var temp = ""
            for (i in 0..7) {
                temp += byteBuffer.get().toChar()
            }
            return temp
        }

    @Throws(BufferOverflowException::class, ReadOnlyBufferException::class)
    fun put(b: Byte): WadByteBuffer {
        byteBuffer.put(b)
        ++length
        return this
    }

    @Throws(IndexOutOfBoundsException::class, ReadOnlyBufferException::class)
    fun put(index: Int, b: Byte): WadByteBuffer {
        byteBuffer.put(index, b)
        ++length
        setPosition(index + 1)
        return this
    }

    @Throws(BufferOverflowException::class, IllegalArgumentException::class, ReadOnlyBufferException::class)
    fun put(src: WadByteBuffer): WadByteBuffer {
        byteBuffer.put(src.byteBuffer)
        length += src.length
        return this
    }

    @Throws(IndexOutOfBoundsException::class, ReadOnlyBufferException::class)
    fun putShort(value: Short): WadByteBuffer {
        byteBuffer.putShort(value)
        length += 2
        return this
    }

    @Throws(IndexOutOfBoundsException::class, ReadOnlyBufferException::class)
    fun putShort(index: Int, value: Short): WadByteBuffer {
        byteBuffer.putShort(index, value)
        length += 2
        setPosition(index + 2)
        return this
    }

    @Throws(IndexOutOfBoundsException::class, ReadOnlyBufferException::class)
    fun putInt(value: Int): WadByteBuffer {
        byteBuffer.putInt(value)
        length += 4
        return this
    }

    @Throws(IndexOutOfBoundsException::class, ReadOnlyBufferException::class)
    fun putInt(index: Int, value: Int): WadByteBuffer {
        byteBuffer.putInt(index, value)
        length += 4
        setPosition(index + 4)
        return this
    }

    @Throws(IndexOutOfBoundsException::class, ReadOnlyBufferException::class)
    fun putEightByteString(index: Int, value: String): WadByteBuffer {
        setPosition(index)
        return this.putEightByteString(value)
    }

    @Throws(IndexOutOfBoundsException::class, ReadOnlyBufferException::class)
    fun putEightByteString(value: String): WadByteBuffer {
        return this.putEightByteString(value.toCharArray())
    }

    @Throws(IndexOutOfBoundsException::class, ReadOnlyBufferException::class)
    fun putEightByteString(index: Int, value: CharArray): WadByteBuffer {
        setPosition(index)
        return this.putEightByteString(value)
    }

    @Throws(IndexOutOfBoundsException::class, ReadOnlyBufferException::class)
    fun putEightByteString(value: CharArray): WadByteBuffer {
        for (i in 0..7) {
            byteBuffer.put(value[i].toByte())
        }
        length += 8
        return this
    }

    fun hasRemaining(): Boolean {
        return byteBuffer.hasRemaining()
    }

    val position: Int
        get() = byteBuffer.position()

    @Throws(IllegalArgumentException::class)
    fun setPosition(index: Int): WadByteBuffer {
        byteBuffer.position(index)
        return this
    }

    val capacity: Int
        get() = byteBuffer.capacity()

    @JvmOverloads
    @Throws(IOException::class)
    fun writeToFile(filechannel: FileChannel, position: Long = filechannel.position()): Boolean {
        val temppos = byteBuffer.position()
        byteBuffer.position(0)
        filechannel.position(position)
        filechannel.write(byteBuffer)
        byteBuffer.position(temppos)
        return true
    }

    fun alterBufferSize(newsize: Int): Boolean {
        var tempbuffer: ByteBuffer? = byteBuffer
        byteBuffer = ByteBuffer.allocate(newsize)
        byteBuffer.rewind()
        byteBuffer.put(tempbuffer)
        byteBuffer.position(tempbuffer!!.position())
        tempbuffer = null
        return true
    }

    companion object {
        fun convertToEightByteString(string: String): String {
            var string = string
            if (string.length > 8) {
                string = string.substring(0, 8)
            } else if (string.length < 8) {
                val temp = string.toCharArray()
                val newtemp = CharArray(8)
                for (i in 0..7) {
                    if (i < temp.size) {
                        newtemp[i] = temp[i]
                    } else {
                        newtemp[i] = 0.toChar() //maybe toChar is wrong
                    }
                }
                string = String(newtemp)
            }
            string = string.toUpperCase()
            string = string.replace("[^A-Z0-9\\[\\]\\-_\\\\\\x00]".toRegex(), "-")
            return string
        }
    }
}
