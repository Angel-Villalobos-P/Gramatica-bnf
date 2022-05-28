package analyzer;

import analyzer.Tokens.*;
import java_cup.Lexer;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {

//    public static void test() {
//
//        String str = "+";
//        File archivo = new File("file.txt");
//        PrintWriter escribir;
//
//        //escribir el archivo
//        try {
//            escribir = new PrintWriter(archivo);
//            escribir.print(str);
//            escribir.close();
//        } catch (FileNotFoundException ex) {
//            System.out.println(ex.getMessage());
//        }
//
//        //Leer el file
//        try {
//            Reader lector = new BufferedReader(new FileReader("file.txt"));
//            Lexer lexer = new Lexer(lector);
//            String resultado = "";
//            while (true) {
//                Tokens token = lexer.yylex();
//                if (token == null) {
//                    resultado += "FIN";
//                    System.out.println(resultado);
//                    return;
//                }
//                switch (token) {
//                    case ERROR:
//                        resultado += "Simbolo no definido\n";
//                        break;
//                    case Identificador:
//                    case Suma:
//                        resultado += lexer.lexema + ": ->> Es un " + token + "\n";
//                        break;
//                    case Resta:
//                        resultado += lexer.lexema + ": ->> Es un " + token + "\n";
//                        break;
//                    case Multiplicacion:
//                        resultado += lexer.lexema + ": ->> Es un " + token + "\n";
//                        break;
//                    default:
//                        resultado += "Token: " + token + "\n";
//                        break;
//                }
//            }
//        } catch (FileNotFoundException ex) {
//            System.out.println(ex.getMessage());
//        } catch (IOException ex) {
//            System.out.println(ex.getMessage());
//        }
//    }

    /*
    Add this to lexer.flex:
    package analyzer;
    import static analyzer.Tokens.*;
     */

    public static void main(String[] args) throws Exception {
//        System.out.println("--- generar lexer ---");
//
//        String ruta = "/Users/angel/OneDrive - Estudiantes ITCR/I-Semestre 2022/Compiladores/Gramatica-bnf/src/analyzer/Lexer.flex";
//        String ruta ="C:/Users/Diego/OneDrive - Estudiantes ITCR/Documentos/GitHub/Gramatica-bnf/src/analyzer/Lexer.flex";
//        generarLexer(ruta);
//        System.out.println("--- lexer generado ---");
//

        //Generar todos
//        String lexer_Path = "/Users/angel/OneDrive - Estudiantes ITCR/I-Semestre 2022/Compiladores/Gramatica-bnf/src/analyzer/Lexer.flex";
//        String lexerCup_path = "/Users/angel/OneDrive - Estudiantes ITCR/I-Semestre 2022/Compiladores/Gramatica-bnf/src/analyzer/LexerCup.flex";
//        String[] sintax_path = {"-parser", "Sintax", "/Users/angel/OneDrive - Estudiantes ITCR/I-Semestre 2022/Compiladores/Gramatica-bnf/src/analyzer/Sintax.cup"};

        String lexer_Path = "/Users/Diego/OneDrive - Estudiantes ITCR/Documentos/GitHub/Gramatica-bnf/src/analyzer/Lexer.flex";
        String lexerCup_path = "/Users/Diego/OneDrive - Estudiantes ITCR/Documentos/GitHub/Gramatica-bnf/src/analyzer/LexerCup.flex";
        String[] sintax_path = {"-parser", "Sintax", "/Users/Diego/OneDrive - Estudiantes ITCR/Documentos/GitHub/Gramatica-bnf/src/analyzer/Sintax.cup"};
        generar(lexer_Path, lexerCup_path, sintax_path);
    }

    public static void generarLexer(String ruta) {
        File archivo = new File(ruta);
        JFlex.Main.generate(archivo);
    }

    public static void generar(String ruta1, String ruta2, String[] rutaS) throws IOException, Exception {
        File archivo;
        archivo = new File(ruta1);
        JFlex.Main.generate(archivo);
        archivo = new File(ruta2);
        JFlex.Main.generate(archivo);
        java_cup.Main.main(rutaS);

        // Verifica si ya existe el file sym, para eliminarlo y mover el otro recién generado
//        Path rutaSym = Paths.get("/Users/angel/OneDrive - Estudiantes ITCR/I-Semestre 2022/Compiladores/Gramatica-bnf/src/analyzer/sym.java");
        Path rutaSym = Paths.get("/Users/Diego/OneDrive - Estudiantes ITCR/Documentos/GitHub/Gramatica-bnf/src/analyzer/sym.java");

        if (Files.exists(rutaSym)) {
            Files.delete(rutaSym);
        }
        Files.move(
//                Paths.get("/Users/angel/OneDrive - Estudiantes ITCR/I-Semestre 2022/Compiladores/Gramatica-bnf/sym.java"),
//                Paths.get("/Users/angel/OneDrive - Estudiantes ITCR/I-Semestre 2022/Compiladores/Gramatica-bnf/src/analyzer/sym.java")

                Paths.get("/Users/Diego/OneDrive - Estudiantes ITCR/Documentos/GitHub/Gramatica-bnf/sym.java"),
                Paths.get("/Users/Diego/OneDrive - Estudiantes ITCR/Documentos/GitHub/Gramatica-bnf/src/analyzer/sym.java")

        );
        // Verifica si ya existe el file sintax, para eliminarlo y mover el otro recién generado
//        Path rutaSin = Paths.get("/Users/angel/OneDrive - Estudiantes ITCR/I-Semestre 2022/Compiladores/Gramatica-bnf/src/analyzer/Sintax.java");
        Path rutaSin = Paths.get("/Users/Diego/OneDrive - Estudiantes ITCR/Documentos/GitHub/Gramatica-bnf/src/analyzer/Sintax.java");

        if (Files.exists(rutaSin)) {
            Files.delete(rutaSin);
        }
        Files.move(
//                Paths.get("/Users/angel/OneDrive - Estudiantes ITCR/I-Semestre 2022/Compiladores/Gramatica-bnf/Sintax.java"),
//                Paths.get("/Users/angel/OneDrive - Estudiantes ITCR/I-Semestre 2022/Compiladores/Gramatica-bnf/src/analyzer/Sintax.java")

                Paths.get("/Users/Diego/OneDrive - Estudiantes ITCR/Documentos/GitHub/Gramatica-bnf/Sintax.java"),
                Paths.get("/Users/Diego/OneDrive - Estudiantes ITCR/Documentos/GitHub/Gramatica-bnf/src/analyzer/Sintax.java")

        );
    }
}
