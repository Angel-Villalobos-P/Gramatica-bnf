package analyzer;

import analyzer.Tokens;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {

    public static void test() {

        String str = "+";
        File archivo = new File("file.txt");
        PrintWriter escribir;

        //escribir el archivo
        try {
            escribir = new PrintWriter(archivo);
            escribir.print(str);
            escribir.close();
        } catch (FileNotFoundException ex) {
            System.out.println(ex.getMessage());
        }

        //Leer el file
        try {
            Reader lector = new BufferedReader(new FileReader("file.txt"));
            Lexer lexer = new Lexer(lector);
            String resultado = "";
            while (true) {
                Tokens token = lexer.yylex();
                if (token == null) {
                    resultado += "FIN";
                    System.out.println(resultado);
                    return;
                }
                switch (token) {
                    case ERROR:
                        resultado += "Simbolo no definido\n";
                        break;
                    case Identificador:
                    case Suma:
                        resultado += lexer.lexema + ": ->> Es un " + token + "\n";
                        break;
                    case Resta:
                        resultado += lexer.lexema + ": ->> Es un " + token + "\n";
                        break;
                    case Multiplicacion:
                        resultado += lexer.lexema + ": ->> Es un " + token + "\n";
                        break;
                    default:
                        resultado += "Token: " + token + "\n";
                        break;
                }
            }
        } catch (FileNotFoundException ex) {
            System.out.println(ex.getMessage());
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }


    public static void main(String[] args) throws Exception {
//        System.out.println("--- generar lexer ---");
//
//        String ruta = "/Users/angel/OneDrive - Estudiantes ITCR/I-Semestre 2022/Compiladores/Gramatica-bnf/src/analyzer/Lexer.flex";
//        String ruta1 ="C:/Users/Diego/OneDrive - Estudiantes ITCR/Documentos/GitHub/Gramatica-bnf/src/analyzer/Lexer.flex";
//        generarLexer(ruta1);
//
//        System.out.println("--- lexer generado ---");
//
//        System.out.println("===TESTING===");
//        test();

        //Generar todo
        String ruta1 = "/Users/angel/OneDrive - Estudiantes ITCR/I-Semestre 2022/Compiladores/Gramatica-bnf/src/analyzer/Lexer.flex";
        String ruta2 = "/Users/angel/OneDrive - Estudiantes ITCR/I-Semestre 2022/Compiladores/Gramatica-bnf/src/analyzer/Lexer.flex";
        String[] rutaS = {"-parser", "Sintax", "/Users/angel/OneDrive - Estudiantes ITCR/I-Semestre 2022/Compiladores/Gramatica-bnf/src/analyzer/Sintax.cup"};
        generar(ruta1, ruta2, rutaS);
    }

//    public static void generarLexer(String ruta) {
//        File archivo = new File(ruta);
//        JFlex.Main.generate(archivo);
//    }

    public static void generar(String ruta1, String ruta2, String[] rutaS) throws IOException, Exception{
        File archivo;
        archivo = new File(ruta1);
        JFlex.Main.generate(archivo);
        archivo = new File(ruta2);
        JFlex.Main.generate(archivo);
        java_cup.Main.main(rutaS);

//        Path rutaSym = Paths.get("/Users/angel/OneDrive - Estudiantes ITCR/I-Semestre 2022/Compiladores/AnalizadorLexico/src/codigo/codigo/sym.java");
        Path rutaSym = Paths.get("/Users/angel/OneDrive - Estudiantes ITCR/I-Semestre 2022/Compiladores/Gramatica-bnf/src/analyzer/sym.java");
        if (Files.exists(rutaSym)) {
            Files.delete(rutaSym);
        }
        Files.move(
                Paths.get("/Users/angel/OneDrive - Estudiantes ITCR/I-Semestre 2022/Compiladores/Gramatica-bnf/src/analyzer/sym.java"),
                Paths.get("/Users/angel/OneDrive - Estudiantes ITCR/I-Semestre 2022/Compiladores/Gramatica-bnf/src/analyzer/sym.java")
        );
        Path rutaSin = Paths.get("/Users/angel/OneDrive - Estudiantes ITCR/I-Semestre 2022/Compiladores/Gramatica-bnf/src/analyzer/Sintax.java");
        if (Files.exists(rutaSin)) {
            Files.delete(rutaSin);
        }
        Files.move(
                Paths.get("/Users/angel/OneDrive - Estudiantes ITCR/I-Semestre 2022/Compiladores/Gramatica-bnf/Sintax.java "),
                Paths.get("/Users/angel/OneDrive - Estudiantes ITCR/I-Semestre 2022/Compiladores/Gramatica-bnf/src/analyzer/Sintax.java")
        );
    }
}
