package analyzer.Generador;

public class Generador {

    public static String data = ".data\n";
    public static String text = ".text\n";



    public static String getCode() {
        setText(instructions("Exit"));
        printRead();

        return getData() + "\n\n" + getText();
    }

    public static void declareVariable(String var, String tipo, String valor){
        System.out.println(var + ": " + getDataType(tipo) + " " + valor);
//        setData(var + ": " + getDataType(tipo) + " " + valor);
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
            case "String" -> ".asciiz";
            case "Bool" -> ".asciiz";
            case "Char" -> ".byte";
            default -> "";
        };
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
}
