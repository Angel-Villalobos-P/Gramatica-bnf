package analyzer;
import static analyzer.Tokens.*;

/**
 * This class is a scanner generated by 
 * <a href="http://www.jflex.de/">JFlex</a> 1.4.3
 * on 4/21/22, 9:43 PM from the specification file
 * <tt>C:/Users/Diego/OneDrive - Estudiantes ITCR/Documentos/GitHub/Gramatica-bnf/src/analyzer/Lexer.flex</tt>
 */
class Lexer {

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
   */
  private static final String ZZ_CMAP_PACKED = 
    "\11\0\1\3\1\5\2\0\1\3\22\0\1\3\1\51\1\47\1\32"+
    "\2\0\1\52\1\0\1\41\1\42\1\36\1\34\1\3\1\35\1\0"+
    "\1\4\12\2\2\0\1\50\1\33\1\50\2\0\32\1\1\45\1\0"+
    "\1\46\1\40\1\1\1\0\1\14\1\15\1\16\1\1\1\25\1\11"+
    "\1\22\1\17\1\6\1\1\1\31\1\12\1\30\1\7\1\13\1\27"+
    "\1\1\1\20\1\21\1\10\1\24\1\1\1\26\1\1\1\23\1\1"+
    "\1\43\1\53\1\44\1\37\uff81\0";

  /** 
   * Translates characters to character classes
   */
  private static final char [] ZZ_CMAP = zzUnpackCMap(ZZ_CMAP_PACKED);

  /** 
   * Translates DFA states to action switch labels.
   */
  private static final int [] ZZ_ACTION = zzUnpackAction();

  private static final String ZZ_ACTION_PACKED_0 =
    "\1\0\1\1\1\2\1\3\1\4\1\5\1\6\15\2"+
    "\1\7\1\10\1\11\1\12\1\13\1\14\1\15\1\16"+
    "\1\17\1\20\1\21\1\22\1\23\1\24\1\25\3\26"+
    "\1\4\1\2\1\27\20\2\1\25\1\30\1\31\1\0"+
    "\1\26\1\32\20\2\1\0\1\33\1\34\2\2\1\35"+
    "\1\2\1\36\1\37\3\2\1\40\2\2\1\41\1\3"+
    "\1\42\1\43\1\44\3\2\1\45\1\46\1\47\1\50"+
    "\1\51";

  private static int [] zzUnpackAction() {
    int [] result = new int[107];
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
    "\0\0\0\54\0\130\0\204\0\260\0\334\0\54\0\u0108"+
    "\0\u0134\0\u0160\0\u018c\0\u01b8\0\u01e4\0\u0210\0\u023c\0\u0268"+
    "\0\u0294\0\u02c0\0\u02ec\0\u0318\0\54\0\u0344\0\u0370\0\u039c"+
    "\0\54\0\54\0\54\0\u03c8\0\54\0\54\0\54\0\54"+
    "\0\54\0\54\0\u0344\0\u0344\0\u03f4\0\u0420\0\u044c\0\u0478"+
    "\0\130\0\u04a4\0\u04d0\0\u04fc\0\u0528\0\u0554\0\u0580\0\u05ac"+
    "\0\u05d8\0\u0604\0\u0630\0\u065c\0\u0688\0\u06b4\0\u06e0\0\u070c"+
    "\0\u0738\0\54\0\54\0\54\0\u0764\0\54\0\130\0\u0790"+
    "\0\u07bc\0\u07e8\0\u0814\0\u0840\0\u086c\0\u0898\0\u08c4\0\u08f0"+
    "\0\u091c\0\u0948\0\u0974\0\u09a0\0\u09cc\0\u09f8\0\u0a24\0\u0a50"+
    "\0\130\0\130\0\u0a7c\0\u0aa8\0\130\0\u0ad4\0\130\0\130"+
    "\0\u0b00\0\u0b2c\0\u0b58\0\130\0\u0b84\0\u0bb0\0\130\0\54"+
    "\0\130\0\130\0\130\0\u0bdc\0\u0c08\0\u0c34\0\130\0\130"+
    "\0\130\0\130\0\130";

  private static int [] zzUnpackRowMap() {
    int [] result = new int[107];
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
    "\1\2\1\3\1\4\1\5\1\6\1\7\1\10\1\11"+
    "\1\12\1\13\2\3\1\14\1\15\1\16\1\3\1\17"+
    "\1\20\3\3\1\21\1\22\1\23\1\24\1\3\1\25"+
    "\1\26\1\27\1\30\1\31\1\32\1\33\1\34\1\35"+
    "\1\36\1\37\1\40\1\41\1\42\1\43\1\44\1\45"+
    "\1\46\55\0\2\3\3\0\24\3\24\0\1\4\54\0"+
    "\1\5\54\0\1\47\50\0\2\3\3\0\1\3\1\50"+
    "\1\3\1\51\20\3\23\0\2\3\3\0\16\3\1\52"+
    "\5\3\23\0\2\3\3\0\12\3\1\53\11\3\23\0"+
    "\2\3\3\0\4\3\1\54\1\3\1\55\15\3\23\0"+
    "\2\3\3\0\12\3\1\56\11\3\23\0\2\3\3\0"+
    "\5\3\1\57\4\3\1\60\11\3\23\0\2\3\3\0"+
    "\6\3\1\61\2\3\1\62\12\3\23\0\2\3\3\0"+
    "\17\3\1\63\4\3\23\0\2\3\3\0\2\3\1\64"+
    "\15\3\1\65\3\3\23\0\2\3\3\0\4\3\1\66"+
    "\17\3\23\0\2\3\3\0\11\3\1\67\12\3\23\0"+
    "\2\3\3\0\12\3\1\70\11\3\23\0\2\3\3\0"+
    "\6\3\1\71\15\3\55\0\1\72\54\0\1\73\54\0"+
    "\1\74\53\0\1\75\70\0\1\76\54\0\1\76\5\47"+
    "\1\0\46\47\1\0\2\3\3\0\2\3\1\77\21\3"+
    "\23\0\2\3\3\0\4\3\1\100\17\3\23\0\2\3"+
    "\3\0\16\3\1\101\5\3\23\0\2\3\3\0\5\3"+
    "\1\102\16\3\23\0\2\3\3\0\4\3\1\103\17\3"+
    "\23\0\2\3\3\0\12\3\1\104\11\3\23\0\2\3"+
    "\3\0\5\3\1\105\16\3\23\0\2\3\3\0\17\3"+
    "\1\106\4\3\23\0\2\3\3\0\13\3\1\107\10\3"+
    "\23\0\2\3\3\0\6\3\1\110\15\3\23\0\2\3"+
    "\3\0\2\3\1\111\21\3\23\0\2\3\3\0\12\3"+
    "\1\112\11\3\23\0\2\3\3\0\1\113\23\3\23\0"+
    "\2\3\3\0\13\3\1\114\10\3\23\0\2\3\3\0"+
    "\1\115\23\3\23\0\2\3\3\0\1\116\23\3\23\0"+
    "\2\3\3\0\1\117\23\3\24\0\1\120\52\0\2\3"+
    "\3\0\4\3\1\121\17\3\23\0\2\3\3\0\17\3"+
    "\1\122\4\3\23\0\2\3\3\0\6\3\1\123\15\3"+
    "\23\0\2\3\3\0\13\3\1\101\10\3\23\0\2\3"+
    "\3\0\6\3\1\124\15\3\23\0\2\3\3\0\4\3"+
    "\1\125\17\3\23\0\2\3\3\0\6\3\1\126\15\3"+
    "\23\0\2\3\3\0\17\3\1\127\4\3\23\0\2\3"+
    "\3\0\12\3\1\130\11\3\23\0\2\3\3\0\16\3"+
    "\1\131\5\3\23\0\2\3\3\0\1\132\23\3\23\0"+
    "\2\3\3\0\2\3\1\133\21\3\23\0\2\3\3\0"+
    "\17\3\1\134\4\3\23\0\2\3\3\0\4\3\1\135"+
    "\17\3\23\0\2\3\3\0\1\3\1\136\22\3\23\0"+
    "\2\3\3\0\1\3\1\137\22\3\24\0\1\120\37\0"+
    "\1\140\12\0\2\3\3\0\2\3\1\141\21\3\23\0"+
    "\2\3\3\0\15\3\1\142\6\3\23\0\2\3\3\0"+
    "\23\3\1\143\23\0\2\3\3\0\12\3\1\144\11\3"+
    "\23\0\2\3\3\0\1\3\1\145\22\3\23\0\2\3"+
    "\3\0\10\3\1\146\13\3\23\0\2\3\3\0\17\3"+
    "\1\147\4\3\23\0\2\3\3\0\2\3\1\150\21\3"+
    "\23\0\2\3\3\0\1\3\1\151\22\3\23\0\2\3"+
    "\3\0\14\3\1\152\7\3\23\0\2\3\3\0\11\3"+
    "\1\153\12\3\22\0";

  private static int [] zzUnpackTrans() {
    int [] result = new int[3168];
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
  private static final String ZZ_ERROR_MSG[] = {
    "Unkown internal scanner error",
    "Error: could not match input",
    "Error: pushback value was too large"
  };

  /**
   * ZZ_ATTRIBUTE[aState] contains the attributes of state <code>aState</code>
   */
  private static final int [] ZZ_ATTRIBUTE = zzUnpackAttribute();

  private static final String ZZ_ATTRIBUTE_PACKED_0 =
    "\1\0\1\11\4\1\1\11\15\1\1\11\3\1\3\11"+
    "\1\1\6\11\27\1\3\11\1\0\1\11\21\1\1\0"+
    "\17\1\1\11\13\1";

  private static int [] zzUnpackAttribute() {
    int [] result = new int[107];
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
  private char zzBuffer[] = new char[ZZ_BUFFERSIZE];

  /** the textposition at the last accepting state */
  private int zzMarkedPos;

  /** the current text position in the buffer */
  private int zzCurrentPos;

  /** startRead marks the beginning of the yytext() string in the buffer */
  private int zzStartRead;

  /** endRead marks the last character in the buffer, that has been read
      from input */
  private int zzEndRead;

  /** number of newlines encountered up to the start of the matched text */
  private int yyline;

  /** the number of characters up to the start of the matched text */
  private int yychar;

  /**
   * the number of characters from the last newline up to the start of the 
   * matched text
   */
  private int yycolumn;

  /** 
   * zzAtBOL == true <=> the scanner is currently at the beginning of a line
   */
  private boolean zzAtBOL = true;

  /** zzAtEOF == true <=> the scanner is at the EOF */
  private boolean zzAtEOF;

  /** denotes if the user-EOF-code has already been executed */
  private boolean zzEOFDone;

  /* user code: */
    public String lexema;


  /**
   * Creates a new scanner
   * There is also a java.io.InputStream version of this constructor.
   *
   * @param   in  the java.io.Reader to read input from.
   */
  Lexer(java.io.Reader in) {
    this.zzReader = in;
  }

  /**
   * Creates a new scanner.
   * There is also java.io.Reader version of this constructor.
   *
   * @param   in  the java.io.Inputstream to read input from.
   */
  Lexer(java.io.InputStream in) {
    this(new java.io.InputStreamReader(in));
  }

  /** 
   * Unpacks the compressed character translation table.
   *
   * @param packed   the packed character translation table
   * @return         the unpacked character translation table
   */
  private static char [] zzUnpackCMap(String packed) {
    char [] map = new char[0x10000];
    int i = 0;  /* index in packed string  */
    int j = 0;  /* index in unpacked array */
    while (i < 130) {
      int  count = packed.charAt(i++);
      char value = packed.charAt(i++);
      do map[j++] = value; while (--count > 0);
    }
    return map;
  }


  /**
   * Refills the input buffer.
   *
   * @return      <code>false</code>, iff there was new input.
   * 
   * @exception   java.io.IOException  if any I/O-Error occurs
   */
  private boolean zzRefill() throws java.io.IOException {

    /* first: make room (if you can) */
    if (zzStartRead > 0) {
      System.arraycopy(zzBuffer, zzStartRead,
                       zzBuffer, 0,
                       zzEndRead-zzStartRead);

      /* translate stored positions */
      zzEndRead-= zzStartRead;
      zzCurrentPos-= zzStartRead;
      zzMarkedPos-= zzStartRead;
      zzStartRead = 0;
    }

    /* is the buffer big enough? */
    if (zzCurrentPos >= zzBuffer.length) {
      /* if not: blow it up */
      char newBuffer[] = new char[zzCurrentPos*2];
      System.arraycopy(zzBuffer, 0, newBuffer, 0, zzBuffer.length);
      zzBuffer = newBuffer;
    }

    /* finally: fill the buffer with new input */
    int numRead = zzReader.read(zzBuffer, zzEndRead,
                                            zzBuffer.length-zzEndRead);

    if (numRead > 0) {
      zzEndRead+= numRead;
      return false;
    }
    // unlikely but not impossible: read 0 characters, but not at end of stream    
    if (numRead == 0) {
      int c = zzReader.read();
      if (c == -1) {
        return true;
      } else {
        zzBuffer[zzEndRead++] = (char) c;
        return false;
      }     
    }

	// numRead < 0
    return true;
  }

    
  /**
   * Closes the input stream.
   */
  public final void yyclose() throws java.io.IOException {
    zzAtEOF = true;            /* indicate end of file */
    zzEndRead = zzStartRead;  /* invalidate buffer    */

    if (zzReader != null)
      zzReader.close();
  }


  /**
   * Resets the scanner to read from a new input stream.
   * Does not close the old reader.
   *
   * All internal variables are reset, the old input stream 
   * <b>cannot</b> be reused (internal buffer is discarded and lost).
   * Lexical state is set to <tt>ZZ_INITIAL</tt>.
   *
   * @param reader   the new input stream 
   */
  public final void yyreset(java.io.Reader reader) {
    zzReader = reader;
    zzAtBOL  = true;
    zzAtEOF  = false;
    zzEOFDone = false;
    zzEndRead = zzStartRead = 0;
    zzCurrentPos = zzMarkedPos = 0;
    yyline = yychar = yycolumn = 0;
    zzLexicalState = YYINITIAL;
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
  public final String yytext() {
    return new String( zzBuffer, zzStartRead, zzMarkedPos-zzStartRead );
  }


  /**
   * Returns the character at position <tt>pos</tt> from the 
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
    return zzBuffer[zzStartRead+pos];
  }


  /**
   * Returns the length of the matched text region.
   */
  public final int yylength() {
    return zzMarkedPos-zzStartRead;
  }


  /**
   * Reports an error that occured while scanning.
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
  public Tokens yylex() throws java.io.IOException {
    int zzInput;
    int zzAction;

    // cached fields:
    int zzCurrentPosL;
    int zzMarkedPosL;
    int zzEndReadL = zzEndRead;
    char [] zzBufferL = zzBuffer;
    char [] zzCMapL = ZZ_CMAP;

    int [] zzTransL = ZZ_TRANS;
    int [] zzRowMapL = ZZ_ROWMAP;
    int [] zzAttrL = ZZ_ATTRIBUTE;

    while (true) {
      zzMarkedPosL = zzMarkedPos;

      zzAction = -1;

      zzCurrentPosL = zzCurrentPos = zzStartRead = zzMarkedPosL;
  
      zzState = ZZ_LEXSTATE[zzLexicalState];


      zzForAction: {
        while (true) {
    
          if (zzCurrentPosL < zzEndReadL)
            zzInput = zzBufferL[zzCurrentPosL++];
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
              zzInput = zzBufferL[zzCurrentPosL++];
            }
          }
          int zzNext = zzTransL[ zzRowMapL[zzState] + zzCMapL[zzInput] ];
          if (zzNext == -1) break zzForAction;
          zzState = zzNext;

          int zzAttributes = zzAttrL[zzState];
          if ( (zzAttributes & 1) == 1 ) {
            zzAction = zzState;
            zzMarkedPosL = zzCurrentPosL;
            if ( (zzAttributes & 8) == 8 ) break zzForAction;
          }

        }
      }

      // store back cached position
      zzMarkedPos = zzMarkedPosL;

      switch (zzAction < 0 ? zzAction : ZZ_ACTION[zzAction]) {
        case 33: 
          { lexema = yytext(); return Main;
          }
        case 42: break;
        case 18: 
          { lexema = yytext(); return Corchete_apertura;
          }
        case 43: break;
        case 5: 
          { lexema = yytext(); return Division;
          }
        case 44: break;
        case 8: 
          { lexema = yytext(); return Igual;
          }
        case 45: break;
        case 6: 
          { return Linea;
          }
        case 46: break;
        case 34: 
          { lexema = yytext(); return Float;
          }
        case 47: break;
        case 37: 
          { lexema = yytext(); return While;
          }
        case 48: break;
        case 23: 
          { lexema = yytext(); return If;
          }
        case 49: break;
        case 11: 
          { lexema = yytext(); return Multiplicacion;
          }
        case 50: break;
        case 15: 
          { lexema = yytext(); return Parentesis_cierre;
          }
        case 51: break;
        case 41: 
          { lexema = yytext(); return Switch;
          }
        case 52: break;
        case 17: 
          { lexema = yytext(); return Llave_cierre;
          }
        case 53: break;
        case 31: 
          { lexema = yytext(); return Char;
          }
        case 54: break;
        case 27: 
          { lexema = yytext(); return Null;
          }
        case 55: break;
        case 36: 
          { lexema = yytext(); return Break;
          }
        case 56: break;
        case 20: 
          { lexema = yytext(); return Comillas;
          }
        case 57: break;
        case 19: 
          { lexema = yytext(); return Corchete_cierre;
          }
        case 58: break;
        case 7: 
          { lexema = yytext(); return Numeral;
          }
        case 59: break;
        case 9: 
          { lexema = yytext(); return Suma;
          }
        case 60: break;
        case 2: 
          { lexema = yytext(); return Identificador;
          }
        case 61: break;
        case 21: 
          { lexema = yytext(); return Op_Relacional;
          }
        case 62: break;
        case 25: 
          { lexema = yytext(); return Op_Decremento;
          }
        case 63: break;
        case 26: 
          { lexema = yytext(); return Int;
          }
        case 64: break;
        case 24: 
          { lexema = yytext(); return Op_Incremento;
          }
        case 65: break;
        case 13: 
          { lexema = yytext(); return Potencia;
          }
        case 66: break;
        case 12: 
          { lexema = yytext(); return Modulo;
          }
        case 67: break;
        case 32: 
          { lexema = yytext(); return Else;
          }
        case 68: break;
        case 35: 
          { lexema = yytext(); return Array;
          }
        case 69: break;
        case 30: 
          { lexema = yytext(); return Case;
          }
        case 70: break;
        case 39: 
          { lexema = yytext(); return Return;
          }
        case 71: break;
        case 28: 
          { lexema = yytext(); return Op_Booleano;
          }
        case 72: break;
        case 38: 
          { lexema = yytext(); return Print;
          }
        case 73: break;
        case 40: 
          { lexema = yytext(); return String;
          }
        case 74: break;
        case 29: 
          { lexema = yytext(); return Bool;
          }
        case 75: break;
        case 1: 
          { return ERROR;
          }
        case 76: break;
        case 22: 
          { lexema = yytext(); return Op_Logico;
          }
        case 77: break;
        case 14: 
          { lexema = yytext(); return Parentesis_apertura;
          }
        case 78: break;
        case 10: 
          { lexema = yytext(); return Resta;
          }
        case 79: break;
        case 3: 
          { lexema = yytext(); return Numero;
          }
        case 80: break;
        case 16: 
          { lexema = yytext(); return Llave_apertura;
          }
        case 81: break;
        case 4: 
          { 
          }
        case 82: break;
        default: 
          if (zzInput == YYEOF && zzStartRead == zzCurrentPos) {
            zzAtEOF = true;
            return null;
          } 
          else {
            zzScanError(ZZ_NO_MATCH);
          }
      }
    }
  }


}
