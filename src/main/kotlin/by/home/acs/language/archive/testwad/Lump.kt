package by.home.acs.language.archive.testwad

import java.io.File
import java.io.FileNotFoundException
import java.io.IOException
import java.io.RandomAccessFile
import java.nio.channels.FileChannel

class Lump(private var name: String) {

    private lateinit var content: WadByteBuffer

    constructor(lumpName: String, data: ByteArray?) : this(lumpName, WadByteBuffer(data))

    constructor(name: String, data: WadByteBuffer) : this(WadByteBuffer.convertToEightByteString(name)) {
        this.content = data
    }

    constructor(name: String, size: Int, fileChannel: FileChannel, pointer: Int)
            : this(
        name = WadByteBuffer.convertToEightByteString(name),
        data = if (size == 0) WadByteBuffer(0) else WadByteBuffer(fileChannel, size, pointer)
    )

    fun getRawLumpData(): WadByteBuffer = this.content
    fun getNumberOfBytes(): Int = TODO()
    fun getSize(): Int = this.content.capacity

    fun changeName(name: String) {
        this.name = WadByteBuffer.convertToEightByteString(name)
    }

    fun alterRawLumpData(data: ByteArray): Boolean {
        return alterRawLumpData(WadByteBuffer(data))
    }

    fun alterRawLumpData(data: WadByteBuffer): Boolean {
        this.content = data
        return true
    }

    fun appendRawLumpData(data: ByteArray?): Boolean {
        return appendRawLumpData(WadByteBuffer(data))
    }

    fun appendRawLumpData(data: WadByteBuffer): Boolean {
        content.alterBufferSize(content.length + data.length)
        content.put(data)
        return true
    }

    //@Throws(UnableToWriteLumpFileException::class)
    fun writeToFile(directory: File?): Boolean {
        return directory?.let { writeToFile(it, name) } == true
    }

    //@Throws(UnableToWriteLumpFileException::class)
    fun writeToFile(directory: File, filename: String): Boolean {
        var filename = filename
        return if (!directory.isDirectory) {
            throw RuntimeException("Invalid directory.")
        } else {
            filename = filename.replace("[\\x00]".toRegex(), "")
            filename = filename.replace("[\\[\\]\\\\]".toRegex(), "_")
            var temp = File(directory.path, "$filename.lmp")
            var numericextension = 2
            while (temp.exists()) {
                temp = File(directory, "$filename.lmp.$numericextension")
                ++numericextension
            }
            val raf: RandomAccessFile = try {
                RandomAccessFile(temp, "rw")
            } catch (var7: FileNotFoundException) {
                throw RuntimeException("Random Access File could not be created.", var7)
            }
            this.writeToFile(raf)
        }
    }

    //    @Throws(UnableToWriteLumpFileException::class)
    fun writeToFile(file: RandomAccessFile): Boolean {
        return this.writeToFile(file.channel)
    }

    //    @Throws(UnableToWriteLumpFileException::class)
    fun writeToFile(fileChannel: FileChannel): Boolean {
        return this.writeToFile(fileChannel, 0L)
    }

    //    @Throws(UnableToWriteLumpFileException::class)
    fun writeToFile(fileChannel: FileChannel, position: Long): Boolean {
        content.setPosition(0)
        try {
            fileChannel.position(position)
        } catch (var6: IOException) {
            throw RuntimeException("The specified position is out of bounds.", var6)
        }
        return try {
            fileChannel.write(this.content.byteBuffer)
            true
        } catch (var5: IOException) {
            throw RuntimeException("The lump file could not be written.", var5)
        }
    }
}

