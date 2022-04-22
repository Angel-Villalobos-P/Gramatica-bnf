package analyzer;

import analyzer.Tokens;

import java.io.*;

public class Main {

    public static void test() {

        String str = "testing lexer 123 + -";
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


    public static void main(String[] args) {
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
    }

    public static void generarLexer(String ruta) {
        File archivo = new File(ruta);
        JFlex.Main.generate(archivo);
    }
}
