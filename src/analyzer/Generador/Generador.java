package analyzer.Generador;

import java.util.Objects;
import java.util.HashMap;

public class Generador {

    public static String data = ".data\n";
    public static String text = ".text\n";

    public static int contadorTemp = 0;
    public static int contadorEtiq = 1;

    private static HashMap<String, EtiquetasRedir> funciones = new HashMap<String, EtiquetasRedir>();

    public static String getCode() {
        setCodetoFunc("main", instructions("Exit"));

        for (String i : funciones.keySet()) {
            setText(getFunciones(i));
        }

        printRead();

        return getData() + "\n\n" + getText();
    }

    public static String ExpresionesAritméticas(Object var1, Object var2, String tipo, String operacion){
        return "";
    }

    public static String ExpresionesVariables(){
        return "";
    }

    public static void declareVariable(String var, String tipo, String valor){
        if(Objects.equals(valor, "0")){
            switch (tipo){
                case "Bool", "String" -> valor = "\"\"";
                case "Char" -> valor = "\'\'";
                case "Float" -> valor = "0.0";
                default ->  valor = "0";
            }
        }
        System.out.println(var + ": " + getDataType(tipo) + " " + valor);
        setData(var + ": " + getDataType(tipo) + " " + valor);
    }

    public static String printVar(String var, String tipo){
        return switch (tipo) {
            case "Int" -> "";
            case "Float" -> "l.s $f1, " + var + "\n" + "mov.s $f12, $f1" + getSalto("printFloat");
            default -> "la $a0, " + var + "\n" + getSalto("printStr");
        };
    }

    private static void printRead(){
        setText(print("Str"));
        setText(print("Int"));
        setText(print("Float"));
        setText(read("Int"));
        setText(read("Float"));
    }

    public static String print(String tipo){
        return switch (tipo) {
            case "Str" -> """
                    printStr:
                        li   $v0, 4
                        syscall
                        jr $ra
                    .end printStr
                    """;
            case "Int" -> """
                    printInt:
                        li   $v0, 1
                        syscall
                        jr $ra
                    .end printInt
                    """;
            case "Float" -> """
                    printFloat:
                        li   $v0, 2
                        syscall
                        jr $ra
                    .end printFloat
                    """;
            default -> "";
        };
    }

    public static String read(String tipo){
        return switch (tipo) {
            case "Int" -> """
                    readInt:
                        li   $v0, 5
                        syscall
                        jr $ra
                    .end readInt
                    """;
            case "Float" -> """
                    readFloat:
                        li   $v0, 6
                        syscall
                        jr $ra
                    .end readFloat
                    """;
            default -> "";
        };
    }

    public static String instructions(String comm){
        switch (comm){
            case "Exit": return """
                    li $v0,10
                    syscall	\s
                    """;
            default: return "";
        }
    }

    public static String getDataType(String tipo){
        return switch (tipo) {
            case "Int" -> ".word";
            case "Float" -> ".float";
            case "String", "Bool" -> ".asciiz";
            case "Char" -> ".byte";
            default -> "";
        };
    }

    public static void newFunc(String funcName){
        EtiquetasRedir etiquetas = new EtiquetasRedir(funcName + ": \n",".end " + funcName + "\n");
        funciones.put(funcName, etiquetas);
    }

    public static String getSalto(String etiqueta){
        if (etiqueta.charAt(0) == '$'){
            return "jr " + etiqueta + "\n";
        }else{
            return "jal " + etiqueta + "\n";
        }

    }



    public static String getData() {
        return data;
    }

    public static void setData(String data) {
        Generador.data += data + "\n";
    }

    public static String getText() {
        return text;
    }

    public static void setText(String text) {
        Generador.text += text + "\n";
    }

    public static String getFunciones(String funcion) {
        EtiquetasRedir e = funciones.get(funcion);
        return e.getEtiqueta_Inicio() + e.getCodigo() + e.getEtiqueta_Final() + "\n";
    }

    public static String etiquetaCondicional(String operador){
        return switch (operador) {
            case "<" -> "blt";
            case "<=" -> "ble";
            case ">" -> "bgt";
            case ">=" -> "bge";
            case "<>" -> "bne";
            case "=" -> "beq";
            default -> "";
        };
    }

    public static void setCodetoFunc(String funcion, String codigo){
        funciones.get(funcion).setCodigo(codigo);
    }

    public static String nuevoTemp()
    {
        return "t" + contadorTemp++;
    }

    public static void setNull(){
        data = ".data\n";
        text = ".text\n";
    }
}
