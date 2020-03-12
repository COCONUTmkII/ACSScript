/* The following code was generated by JFlex 1.7.0 tweaked for IntelliJ platform */

package by.home.acs.language;

import by.home.acs.language.psi.ACSScriptTokenType;
import com.intellij.lexer.FlexLexer;
import com.intellij.psi.TokenType;
import com.intellij.psi.tree.IElementType;


/**
 * This class is a scanner generated by 
 * <a href="http://www.jflex.de/">JFlex</a> 1.7.0
 * from the specification file <tt>ACSSCript.flex</tt>
 */
public class ACSScriptLexer implements FlexLexer {

  /** This character denotes the end of file */
  public static final int YYEOF = -1;

  /** initial size of the lookahead buffer */
  private static final int ZZ_BUFFERSIZE = 16384;

  /** lexical states */
  public static final int YYINITIAL = 0;

  /**
   * ZZ_LEXSTATE[l] is the state in the DFA for the lexical state l
   * ZZ_LEXSTATE[l+1] is the state in the DFA for the lexical state l
   *                  at the beginning of a line
   * l is of the form l = 2*k, k a non negative integer
   */
  private static final int ZZ_LEXSTATE[] = { 
     0, 0
  };

  /** 
   * Translates characters to character classes
   * Chosen bits are [9, 6, 6]
   * Total runtime size is 1568 bytes
   */
  public static int ZZ_CMAP(int ch) {
    return ZZ_CMAP_A[(ZZ_CMAP_Y[ZZ_CMAP_Z[ch>>12]|((ch>>6)&0x3f)]<<6)|(ch&0x3f)];
  }

  /* The ZZ_CMAP_Z table has 272 entries */
  static final char ZZ_CMAP_Z[] = zzUnpackCMap(
    "\1\0\1\100\1\200\u010d\100");

  /* The ZZ_CMAP_Y table has 192 entries */
  static final char ZZ_CMAP_Y[] = zzUnpackCMap(
    "\1\0\1\1\1\2\175\3\1\4\77\3");

  /* The ZZ_CMAP_A table has 320 entries */
  static final char ZZ_CMAP_A[] = zzUnpackCMap(
    "\11\0\1\10\1\5\2\6\1\5\22\0\1\10\1\0\1\4\7\0\1\12\4\0\1\11\1\2\11\3\7\0\1"+
    "\47\1\1\1\56\1\51\1\42\1\1\1\55\1\52\1\54\1\1\1\57\1\53\1\1\1\43\1\40\1\41"+
    "\1\1\1\45\1\35\1\44\1\46\1\1\1\50\3\1\4\0\1\1\1\0\1\31\1\30\1\15\1\20\1\21"+
    "\1\27\1\33\1\60\1\13\1\1\1\61\1\16\1\22\1\14\1\24\1\23\1\1\1\25\1\37\1\26"+
    "\1\17\1\36\1\34\1\1\1\32\1\1\12\0\1\7\242\0\2\7\26\0");

  /** 
   * Translates DFA states to action switch labels.
   */
  private static final int [] ZZ_ACTION = zzUnpackAction();

  private static final String ZZ_ACTION_PACKED_0 =
    "\1\0\1\1\1\2\1\3\1\1\1\4\1\1\27\2"+
    "\1\0\1\5\1\0\2\2\1\6\5\2\1\7\27\2"+
    "\1\10\1\0\1\2\1\11\1\2\1\12\10\2\1\13"+
    "\10\2\1\14\13\2\1\5\2\2\1\15\4\2\1\16"+
    "\1\2\1\17\2\2\1\20\5\2\1\21\1\2\1\22"+
    "\10\2\1\23\3\2\1\24\4\2\1\25\1\26\1\2"+
    "\1\27\1\30\2\2\1\31\4\2\1\32\3\2\1\33"+
    "\1\2\1\34\1\2\1\35\1\2\1\36\1\37\1\40"+
    "\1\2\1\41\3\2\1\42\1\43\1\44\1\2\1\45"+
    "\3\2\1\46\3\2\1\47\1\2\1\50\1\51";

  private static int [] zzUnpackAction() {
    int [] result = new int[185];
    int offset = 0;
    offset = zzUnpackAction(ZZ_ACTION_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackAction(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }


  /** 
   * Translates a state to a row index in the transition table
   */
  private static final int [] ZZ_ROWMAP = zzUnpackRowMap();

  private static final String ZZ_ROWMAP_PACKED_0 =
    "\0\0\0\62\0\144\0\226\0\310\0\372\0\u012c\0\u015e"+
    "\0\u0190\0\u01c2\0\u01f4\0\u0226\0\u0258\0\u028a\0\u02bc\0\u02ee"+
    "\0\u0320\0\u0352\0\u0384\0\u03b6\0\u03e8\0\u041a\0\u044c\0\u047e"+
    "\0\u04b0\0\u04e2\0\u0514\0\u0546\0\u0578\0\u05aa\0\u05dc\0\u060e"+
    "\0\u0640\0\u0672\0\u06a4\0\144\0\u06d6\0\u0708\0\u073a\0\u076c"+
    "\0\u079e\0\144\0\u07d0\0\u0802\0\u0834\0\u0866\0\u0898\0\u08ca"+
    "\0\u08fc\0\u092e\0\u0960\0\u0992\0\u09c4\0\u09f6\0\u0a28\0\u0a5a"+
    "\0\u0a8c\0\u0abe\0\u0af0\0\u0b22\0\u0b54\0\u0b86\0\u0bb8\0\u0bea"+
    "\0\u0c1c\0\62\0\u0c4e\0\u0c80\0\144\0\u0cb2\0\144\0\u0ce4"+
    "\0\u0d16\0\u0d48\0\u0d7a\0\u0dac\0\u0dde\0\u0e10\0\u0e42\0\144"+
    "\0\u0e74\0\u0ea6\0\u0ed8\0\u0f0a\0\u0f3c\0\u0f6e\0\u0fa0\0\u0fd2"+
    "\0\144\0\u1004\0\u1036\0\u1068\0\u109a\0\u10cc\0\u10fe\0\u1130"+
    "\0\u1162\0\u1194\0\u11c6\0\u11f8\0\62\0\u122a\0\u125c\0\144"+
    "\0\u128e\0\u12c0\0\u12f2\0\u1324\0\144\0\u1356\0\144\0\u1388"+
    "\0\u13ba\0\144\0\u13ec\0\u141e\0\u1450\0\u1482\0\u14b4\0\144"+
    "\0\u14e6\0\144\0\u1518\0\u154a\0\u157c\0\u15ae\0\u15e0\0\u1612"+
    "\0\u1644\0\u1676\0\144\0\u16a8\0\u16da\0\u170c\0\144\0\u173e"+
    "\0\u1770\0\u17a2\0\u17d4\0\144\0\144\0\u1806\0\144\0\144"+
    "\0\u1838\0\u186a\0\144\0\u189c\0\u18ce\0\u1900\0\u1932\0\144"+
    "\0\u1964\0\u1996\0\u19c8\0\144\0\u19fa\0\144\0\u1a2c\0\144"+
    "\0\u1a5e\0\144\0\144\0\144\0\u1a90\0\144\0\u1ac2\0\u1af4"+
    "\0\u1b26\0\144\0\144\0\144\0\u1b58\0\144\0\u1b8a\0\u1bbc"+
    "\0\u1bee\0\144\0\u1c20\0\u1c52\0\u1c84\0\144\0\u1cb6\0\144"+
    "\0\144";

  private static int [] zzUnpackRowMap() {
    int [] result = new int[185];
    int offset = 0;
    offset = zzUnpackRowMap(ZZ_ROWMAP_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackRowMap(String packed, int offset, int [] result) {
    int i = 0;  /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int high = packed.charAt(i++) << 16;
      result[j++] = high | packed.charAt(i++);
    }
    return j;
  }

  /** 
   * The transition table of the DFA
   */
  private static final int [] ZZ_TRANS = zzUnpackTrans();

  private static final String ZZ_TRANS_PACKED_0 =
    "\1\2\1\3\1\2\1\4\1\5\2\6\1\2\1\6"+
    "\1\7\1\2\1\10\1\11\1\12\1\13\1\14\1\15"+
    "\1\16\3\3\1\17\1\20\1\21\1\22\2\3\1\23"+
    "\1\24\1\25\1\26\1\27\1\30\1\3\1\31\2\3"+
    "\1\32\1\33\2\3\1\34\1\3\1\35\3\3\1\36"+
    "\2\3\63\0\3\3\7\0\47\3\2\0\2\4\56\0"+
    "\5\37\3\0\52\37\5\0\2\6\1\0\1\6\62\0"+
    "\1\40\1\41\50\0\3\3\7\0\1\3\1\42\5\3"+
    "\1\43\4\3\1\44\32\3\1\0\3\3\7\0\6\3"+
    "\1\45\40\3\1\0\3\3\7\0\16\3\1\46\30\3"+
    "\1\0\3\3\7\0\1\47\46\3\1\0\3\3\7\0"+
    "\1\3\1\50\45\3\1\0\3\3\7\0\6\3\1\51"+
    "\2\3\1\52\35\3\1\0\3\3\7\0\3\3\1\53"+
    "\43\3\1\0\3\3\7\0\6\3\1\54\40\3\1\0"+
    "\3\3\7\0\12\3\1\55\34\3\1\0\3\3\7\0"+
    "\4\3\1\56\4\3\1\57\4\3\1\60\30\3\1\0"+
    "\3\3\7\0\11\3\1\61\1\62\34\3\1\0\3\3"+
    "\7\0\3\3\1\63\43\3\1\0\3\3\7\0\11\3"+
    "\1\64\33\3\1\65\1\3\1\0\3\3\7\0\2\3"+
    "\1\66\44\3\1\0\3\3\7\0\11\3\1\67\35\3"+
    "\1\0\3\3\7\0\13\3\1\70\5\3\1\71\25\3"+
    "\1\0\3\3\7\0\26\3\1\72\20\3\1\0\3\3"+
    "\7\0\30\3\1\73\16\3\1\0\3\3\7\0\27\3"+
    "\1\74\17\3\1\0\3\3\7\0\30\3\1\75\16\3"+
    "\1\0\3\3\7\0\27\3\1\76\11\3\1\77\5\3"+
    "\1\0\3\3\7\0\41\3\1\100\5\3\1\0\3\3"+
    "\7\0\41\3\1\101\5\3\4\37\1\102\55\37\5\40"+
    "\1\0\54\40\12\41\1\103\47\41\1\0\3\3\7\0"+
    "\2\3\1\104\10\3\1\105\33\3\1\0\3\3\7\0"+
    "\10\3\1\106\36\3\1\0\3\3\7\0\13\3\1\107"+
    "\33\3\1\0\3\3\7\0\24\3\1\110\22\3\1\0"+
    "\3\3\7\0\15\3\1\111\31\3\1\0\3\3\7\0"+
    "\13\3\1\112\33\3\1\0\3\3\7\0\14\3\1\113"+
    "\32\3\1\0\3\3\7\0\24\3\1\114\22\3\1\0"+
    "\3\3\7\0\13\3\1\115\33\3\1\0\3\3\7\0"+
    "\4\3\1\116\42\3\1\0\3\3\7\0\1\3\1\117"+
    "\45\3\1\0\3\3\7\0\12\3\1\120\34\3\1\0"+
    "\3\3\7\0\3\3\1\121\43\3\1\0\3\3\7\0"+
    "\11\3\1\122\35\3\1\0\3\3\7\0\6\3\1\123"+
    "\40\3\1\0\3\3\7\0\11\3\1\124\35\3\1\0"+
    "\3\3\7\0\12\3\1\125\34\3\1\0\3\3\7\0"+
    "\1\126\46\3\1\0\3\3\7\0\12\3\1\127\34\3"+
    "\1\0\3\3\7\0\1\130\46\3\1\0\3\3\7\0"+
    "\12\3\1\131\34\3\1\0\3\3\7\0\1\132\46\3"+
    "\1\0\3\3\7\0\27\3\1\133\17\3\1\0\3\3"+
    "\7\0\31\3\1\134\15\3\1\0\3\3\7\0\22\3"+
    "\1\135\2\3\1\136\3\3\1\137\15\3\1\0\3\3"+
    "\7\0\40\3\1\140\6\3\1\0\3\3\7\0\34\3"+
    "\1\141\12\3\1\0\3\3\7\0\22\3\1\142\24\3"+
    "\1\0\3\3\7\0\42\3\1\143\4\3\1\0\3\3"+
    "\7\0\40\3\1\144\6\3\11\41\1\145\1\103\47\41"+
    "\1\0\3\3\7\0\3\3\1\146\43\3\1\0\3\3"+
    "\7\0\11\3\1\147\35\3\1\0\3\3\7\0\6\3"+
    "\1\150\40\3\1\0\3\3\7\0\12\3\1\151\34\3"+
    "\1\0\3\3\7\0\1\152\46\3\1\0\3\3\7\0"+
    "\1\153\15\3\1\154\30\3\1\0\3\3\7\0\6\3"+
    "\1\155\40\3\1\0\3\3\7\0\4\3\1\156\42\3"+
    "\1\0\3\3\7\0\6\3\1\157\40\3\1\0\3\3"+
    "\7\0\2\3\1\160\44\3\1\0\3\3\7\0\24\3"+
    "\1\161\22\3\1\0\3\3\7\0\3\3\1\162\43\3"+
    "\1\0\3\3\7\0\16\3\1\163\30\3\1\0\3\3"+
    "\7\0\15\3\1\164\31\3\1\0\3\3\7\0\3\3"+
    "\1\165\43\3\1\0\3\3\7\0\3\3\1\166\43\3"+
    "\1\0\3\3\7\0\1\167\46\3\1\0\3\3\7\0"+
    "\5\3\1\170\41\3\1\0\3\3\7\0\13\3\1\171"+
    "\33\3\1\0\3\3\7\0\30\3\1\172\16\3\1\0"+
    "\3\3\7\0\27\3\1\173\17\3\1\0\3\3\7\0"+
    "\26\3\1\174\20\3\1\0\3\3\7\0\26\3\1\175"+
    "\20\3\1\0\3\3\7\0\33\3\1\176\13\3\1\0"+
    "\3\3\7\0\25\3\1\177\21\3\1\0\3\3\7\0"+
    "\31\3\1\200\15\3\1\0\3\3\7\0\43\3\1\201"+
    "\3\3\1\0\3\3\7\0\37\3\1\202\7\3\1\0"+
    "\3\3\7\0\40\3\1\203\6\3\1\0\3\3\7\0"+
    "\4\3\1\204\42\3\1\0\3\3\7\0\12\3\1\205"+
    "\34\3\1\0\3\3\7\0\16\3\1\206\30\3\1\0"+
    "\3\3\7\0\3\3\1\207\43\3\1\0\3\3\7\0"+
    "\1\3\1\210\45\3\1\0\3\3\7\0\4\3\1\211"+
    "\42\3\1\0\3\3\7\0\12\3\1\212\34\3\1\0"+
    "\3\3\7\0\13\3\1\213\33\3\1\0\3\3\7\0"+
    "\6\3\1\214\40\3\1\0\3\3\7\0\46\3\1\215"+
    "\1\0\3\3\7\0\16\3\1\216\30\3\1\0\3\3"+
    "\7\0\5\3\1\217\41\3\1\0\3\3\7\0\6\3"+
    "\1\220\40\3\1\0\3\3\7\0\10\3\1\221\36\3"+
    "\1\0\3\3\7\0\2\3\1\222\44\3\1\0\3\3"+
    "\7\0\32\3\1\223\14\3\1\0\3\3\7\0\34\3"+
    "\1\224\12\3\1\0\3\3\7\0\27\3\1\225\17\3"+
    "\1\0\3\3\7\0\32\3\1\226\14\3\1\0\3\3"+
    "\7\0\34\3\1\227\12\3\1\0\3\3\7\0\37\3"+
    "\1\230\7\3\1\0\3\3\7\0\25\3\1\231\21\3"+
    "\1\0\3\3\7\0\31\3\1\232\15\3\1\0\3\3"+
    "\7\0\5\3\1\233\41\3\1\0\3\3\7\0\13\3"+
    "\1\234\33\3\1\0\3\3\7\0\12\3\1\235\34\3"+
    "\1\0\3\3\7\0\6\3\1\236\40\3\1\0\3\3"+
    "\7\0\3\3\1\237\43\3\1\0\3\3\7\0\1\3"+
    "\1\240\45\3\1\0\3\3\7\0\1\241\46\3\1\0"+
    "\3\3\7\0\3\3\1\242\43\3\1\0\3\3\7\0"+
    "\13\3\1\243\33\3\1\0\3\3\7\0\45\3\1\244"+
    "\1\3\1\0\3\3\7\0\35\3\1\245\11\3\1\0"+
    "\3\3\7\0\30\3\1\246\16\3\1\0\3\3\7\0"+
    "\30\3\1\240\16\3\1\0\3\3\7\0\36\3\1\247"+
    "\10\3\1\0\3\3\7\0\30\3\1\250\16\3\1\0"+
    "\3\3\7\0\30\3\1\251\16\3\1\0\3\3\7\0"+
    "\6\3\1\252\40\3\1\0\3\3\7\0\17\3\1\253"+
    "\27\3\1\0\3\3\7\0\13\3\1\254\33\3\1\0"+
    "\3\3\7\0\11\3\1\255\35\3\1\0\3\3\7\0"+
    "\30\3\1\256\16\3\1\0\3\3\7\0\41\3\1\257"+
    "\5\3\1\0\3\3\7\0\30\3\1\260\16\3\1\0"+
    "\3\3\7\0\41\3\1\261\5\3\1\0\3\3\7\0"+
    "\1\3\1\262\45\3\1\0\3\3\7\0\30\3\1\263"+
    "\16\3\1\0\3\3\7\0\27\3\1\264\17\3\1\0"+
    "\3\3\7\0\30\3\1\265\16\3\1\0\3\3\7\0"+
    "\42\3\1\266\4\3\1\0\3\3\7\0\43\3\1\267"+
    "\3\3\1\0\3\3\7\0\42\3\1\270\4\3\1\0"+
    "\3\3\7\0\31\3\1\271\15\3";

  private static int [] zzUnpackTrans() {
    int [] result = new int[7400];
    int offset = 0;
    offset = zzUnpackTrans(ZZ_TRANS_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackTrans(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      value--;
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }


  /* error codes */
  private static final int ZZ_UNKNOWN_ERROR = 0;
  private static final int ZZ_NO_MATCH = 1;
  private static final int ZZ_PUSHBACK_2BIG = 2;

  /* error messages for the codes above */
  private static final String[] ZZ_ERROR_MSG = {
    "Unknown internal scanner error",
    "Error: could not match input",
    "Error: pushback value was too large"
  };

  /**
   * ZZ_ATTRIBUTE[aState] contains the attributes of state <code>aState</code>
   */
  private static final int [] ZZ_ATTRIBUTE = zzUnpackAttribute();

  private static final String ZZ_ATTRIBUTE_PACKED_0 =
    "\1\0\1\11\34\1\1\0\1\1\1\0\40\1\1\11"+
    "\1\0\41\1\1\11\124\1";

  private static int [] zzUnpackAttribute() {
    int [] result = new int[185];
    int offset = 0;
    offset = zzUnpackAttribute(ZZ_ATTRIBUTE_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackAttribute(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }

  /** the input device */
  private java.io.Reader zzReader;

  /** the current state of the DFA */
  private int zzState;

  /** the current lexical state */
  private int zzLexicalState = YYINITIAL;

  /** this buffer contains the current text to be matched and is
      the source of the yytext() string */
  private CharSequence zzBuffer = "";

  /** the textposition at the last accepting state */
  private int zzMarkedPos;

  /** the current text position in the buffer */
  private int zzCurrentPos;

  /** startRead marks the beginning of the yytext() string in the buffer */
  private int zzStartRead;

  /** endRead marks the last character in the buffer, that has been read
      from input */
  private int zzEndRead;

  /**
   * zzAtBOL == true <=> the scanner is currently at the beginning of a line
   */
  private boolean zzAtBOL = true;

  /** zzAtEOF == true <=> the scanner is at the EOF */
  private boolean zzAtEOF;

  /** denotes if the user-EOF-code has already been executed */
  private boolean zzEOFDone;


  /**
   * Creates a new scanner
   *
   * @param   in  the java.io.Reader to read input from.
   */
  public ACSScriptLexer(java.io.Reader in) {
    this.zzReader = in;
  }


  /** 
   * Unpacks the compressed character translation table.
   *
   * @param packed   the packed character translation table
   * @return         the unpacked character translation table
   */
  private static char [] zzUnpackCMap(String packed) {
    int size = 0;
    for (int i = 0, length = packed.length(); i < length; i += 2) {
      size += packed.charAt(i);
    }
    char[] map = new char[size];
    int i = 0;  /* index in packed string  */
    int j = 0;  /* index in unpacked array */
    while (i < packed.length()) {
      int  count = packed.charAt(i++);
      char value = packed.charAt(i++);
      do map[j++] = value; while (--count > 0);
    }
    return map;
  }

  public final int getTokenStart() {
    return zzStartRead;
  }

  public final int getTokenEnd() {
    return getTokenStart() + yylength();
  }

  public void reset(CharSequence buffer, int start, int end, int initialState) {
    zzBuffer = buffer;
    zzCurrentPos = zzMarkedPos = zzStartRead = start;
    zzAtEOF  = false;
    zzAtBOL = true;
    zzEndRead = end;
    yybegin(initialState);
  }

  /**
   * Refills the input buffer.
   *
   * @return      {@code false}, iff there was new input.
   *
   * @exception   java.io.IOException  if any I/O-Error occurs
   */
  private boolean zzRefill() throws java.io.IOException {
    return true;
  }


  /**
   * Returns the current lexical state.
   */
  public final int yystate() {
    return zzLexicalState;
  }


  /**
   * Enters a new lexical state
   *
   * @param newState the new lexical state
   */
  public final void yybegin(int newState) {
    zzLexicalState = newState;
  }


  /**
   * Returns the text matched by the current regular expression.
   */
  public final CharSequence yytext() {
    return zzBuffer.subSequence(zzStartRead, zzMarkedPos);
  }


  /**
   * Returns the character at position {@code pos} from the
   * matched text.
   *
   * It is equivalent to yytext().charAt(pos), but faster
   *
   * @param pos the position of the character to fetch.
   *            A value from 0 to yylength()-1.
   *
   * @return the character at position pos
   */
  public final char yycharat(int pos) {
    return zzBuffer.charAt(zzStartRead+pos);
  }


  /**
   * Returns the length of the matched text region.
   */
  public final int yylength() {
    return zzMarkedPos-zzStartRead;
  }


  /**
   * Reports an error that occurred while scanning.
   *
   * In a wellformed scanner (no or only correct usage of
   * yypushback(int) and a match-all fallback rule) this method
   * will only be called with things that "Can't Possibly Happen".
   * If this method is called, something is seriously wrong
   * (e.g. a JFlex bug producing a faulty scanner etc.).
   *
   * Usual syntax/scanner level error handling should be done
   * in error fallback rules.
   *
   * @param   errorCode  the code of the errormessage to display
   */
  private void zzScanError(int errorCode) {
    String message;
    try {
      message = ZZ_ERROR_MSG[errorCode];
    }
    catch (ArrayIndexOutOfBoundsException e) {
      message = ZZ_ERROR_MSG[ZZ_UNKNOWN_ERROR];
    }

    throw new Error(message);
  }


  /**
   * Pushes the specified amount of characters back into the input stream.
   *
   * They will be read again by then next call of the scanning method
   *
   * @param number  the number of characters to be read again.
   *                This number must not be greater than yylength()!
   */
  public void yypushback(int number)  {
    if ( number > yylength() )
      zzScanError(ZZ_PUSHBACK_2BIG);

    zzMarkedPos -= number;
  }


  /**
   * Resumes scanning until the next regular expression is matched,
   * the end of input is encountered or an I/O-Error occurs.
   *
   * @return      the next token
   * @exception   java.io.IOException  if any I/O-Error occurs
   */
  public IElementType advance() throws java.io.IOException {
    int zzInput;
    int zzAction;

    // cached fields:
    int zzCurrentPosL;
    int zzMarkedPosL;
    int zzEndReadL = zzEndRead;
    CharSequence zzBufferL = zzBuffer;

    int [] zzTransL = ZZ_TRANS;
    int [] zzRowMapL = ZZ_ROWMAP;
    int [] zzAttrL = ZZ_ATTRIBUTE;

    while (true) {
      zzMarkedPosL = zzMarkedPos;

      zzAction = -1;

      zzCurrentPosL = zzCurrentPos = zzStartRead = zzMarkedPosL;

      zzState = ZZ_LEXSTATE[zzLexicalState];

      // set up zzAction for empty match case:
      int zzAttributes = zzAttrL[zzState];
      if ( (zzAttributes & 1) == 1 ) {
        zzAction = zzState;
      }


      zzForAction: {
        while (true) {

          if (zzCurrentPosL < zzEndReadL) {
            zzInput = Character.codePointAt(zzBufferL, zzCurrentPosL/*, zzEndReadL*/);
            zzCurrentPosL += Character.charCount(zzInput);
          }
          else if (zzAtEOF) {
            zzInput = YYEOF;
            break zzForAction;
          }
          else {
            // store back cached positions
            zzCurrentPos  = zzCurrentPosL;
            zzMarkedPos   = zzMarkedPosL;
            boolean eof = zzRefill();
            // get translated positions and possibly new buffer
            zzCurrentPosL  = zzCurrentPos;
            zzMarkedPosL   = zzMarkedPos;
            zzBufferL      = zzBuffer;
            zzEndReadL     = zzEndRead;
            if (eof) {
              zzInput = YYEOF;
              break zzForAction;
            }
            else {
              zzInput = Character.codePointAt(zzBufferL, zzCurrentPosL/*, zzEndReadL*/);
              zzCurrentPosL += Character.charCount(zzInput);
            }
          }
          int zzNext = zzTransL[ zzRowMapL[zzState] + ZZ_CMAP(zzInput) ];
          if (zzNext == -1) break zzForAction;
          zzState = zzNext;

          zzAttributes = zzAttrL[zzState];
          if ( (zzAttributes & 1) == 1 ) {
            zzAction = zzState;
            zzMarkedPosL = zzCurrentPosL;
            if ( (zzAttributes & 8) == 8 ) break zzForAction;
          }

        }
      }

      // store back cached position
      zzMarkedPos = zzMarkedPosL;

      if (zzInput == YYEOF && zzStartRead == zzCurrentPos) {
        zzAtEOF = true;
        return null;
      }
      else {
        switch (zzAction < 0 ? zzAction : ZZ_ACTION[zzAction]) {
          case 1: 
            { return TokenType.BAD_CHARACTER;
            } 
            // fall through
          case 42: break;
          case 2: 
            { return ACSScriptTypes.IDENTIFIER;
            } 
            // fall through
          case 43: break;
          case 3: 
            { return ACSScriptTypes.NUMBER;
            } 
            // fall through
          case 44: break;
          case 4: 
            { return TokenType.WHITE_SPACE;
            } 
            // fall through
          case 45: break;
          case 5: 
            { return ACSScriptTypes.COMMENT;
            } 
            // fall through
          case 46: break;
          case 6: 
            { return ACSScriptTypes.IF;
            } 
            // fall through
          case 47: break;
          case 7: 
            { return ACSScriptTypes.DO;
            } 
            // fall through
          case 48: break;
          case 8: 
            { return ACSScriptTypes.STRING;
            } 
            // fall through
          case 49: break;
          case 9: 
            { return ACSScriptTypes.INT;
            } 
            // fall through
          case 50: break;
          case 10: 
            { return ACSScriptTypes.NET;
            } 
            // fall through
          case 51: break;
          case 11: 
            { return ACSScriptTypes.FOR;
            } 
            // fall through
          case 52: break;
          case 12: 
            { return ACSScriptTypes.STR;
            } 
            // fall through
          case 53: break;
          case 13: 
            { return ACSScriptTypes.CASE;
            } 
            // fall through
          case 54: break;
          case 14: 
            { return ACSScriptTypes.ELSE;
            } 
            // fall through
          case 55: break;
          case 15: 
            { return ACSScriptTypes.TRUE;
            } 
            // fall through
          case 56: break;
          case 16: 
            { return ACSScriptTypes.BOOL;
            } 
            // fall through
          case 57: break;
          case 17: 
            { return ACSScriptTypes.VOID;
            } 
            // fall through
          case 58: break;
          case 18: 
            { return ACSScriptTypes.OPEN;
            } 
            // fall through
          case 59: break;
          case 19: 
            { return ACSScriptTypes.KILL;
            } 
            // fall through
          case 60: break;
          case 20: 
            { return ACSScriptTypes.UNTIL;
            } 
            // fall through
          case 61: break;
          case 21: 
            { return ACSScriptTypes.FALSE;
            } 
            // fall through
          case 62: break;
          case 22: 
            { return ACSScriptTypes.BREAK;
            } 
            // fall through
          case 63: break;
          case 23: 
            { return ACSScriptTypes.WORLD;
            } 
            // fall through
          case 64: break;
          case 24: 
            { return ACSScriptTypes.WHILE;
            } 
            // fall through
          case 65: break;
          case 25: 
            { return ACSScriptTypes.ENTER;
            } 
            // fall through
          case 66: break;
          case 26: 
            { return ACSScriptTypes.DEATH;
            } 
            // fall through
          case 67: break;
          case 27: 
            { return ACSScriptTypes.IMPORT;
            } 
            // fall through
          case 68: break;
          case 28: 
            { return ACSScriptTypes.DEFINE;
            } 
            // fall through
          case 69: break;
          case 29: 
            { return ACSScriptTypes.RETURN;
            } 
            // fall through
          case 70: break;
          case 30: 
            { return ACSScriptTypes.GLOBAL;
            } 
            // fall through
          case 71: break;
          case 31: 
            { return ACSScriptTypes.SCRIPT;
            } 
            // fall through
          case 72: break;
          case 32: 
            { return ACSScriptTypes.SWITCH;
            } 
            // fall through
          case 73: break;
          case 33: 
            { return ACSScriptTypes.REOPEN;
            } 
            // fall through
          case 74: break;
          case 34: 
            { return ACSScriptTypes.INCLUDE;
            } 
            // fall through
          case 75: break;
          case 35: 
            { return ACSScriptTypes.LIBRARY;
            } 
            // fall through
          case 76: break;
          case 36: 
            { return ACSScriptTypes.DEFAULT;
            } 
            // fall through
          case 77: break;
          case 37: 
            { return ACSScriptTypes.RESPAWN;
            } 
            // fall through
          case 78: break;
          case 38: 
            { return ACSScriptTypes.FUNCTION;
            } 
            // fall through
          case 79: break;
          case 39: 
            { return ACSScriptTypes.UNLOADING;
            } 
            // fall through
          case 80: break;
          case 40: 
            { return ACSScriptTypes.LIGHTNING;
            } 
            // fall through
          case 81: break;
          case 41: 
            { return ACSScriptTypes.DISCONNECT;
            } 
            // fall through
          case 82: break;
          default:
            zzScanError(ZZ_NO_MATCH);
          }
      }
    }
  }


}
