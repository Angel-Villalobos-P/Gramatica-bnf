package analyzer;

import java_cup.runtime.Symbol;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.StringReader;
import java.nio.file.Files;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MainFrm extends javax.swing.JFrame{



    public MainFrm(){

        btn_file.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser chooser = new JFileChooser();
                chooser.showOpenDialog(null);
                File archivo = new File(chooser.getSelectedFile().getAbsolutePath());

                try {
                    String ST = new String(Files.readAllBytes(archivo.toPath()));
                    txt_file.setText(ST);
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(MainFrm.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    Logger.getLogger(MainFrm.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        btn_lexico.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    analisis_lexico();
                } catch (IOException ex) {
                    Logger.getLogger(MainFrm.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        btn_sintactico.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
//                String ST = txt_file.getText();
//                Sintax s = new Sintax(new analyzer.LexerCup(new StringReader(ST)));
//
//                try {
//                    s.parse();
//                    txt_sintactico.setText("Analisis realizado correctamente");
//                    txt_sintactico.setForeground(new Color(25, 111, 61));
//                } catch (Exception ex) {
//                    Symbol sym = s.getS();
//                    txt_sintactico.setText("Error de sintaxis. Linea: " + (sym.right + 1) + " Columna: " + (sym.left + 1) + ", Texto: \"" + sym.value + "\"");
//                    txt_sintactico.setForeground(Color.red);
//                }
            }
        });}

        private void analisis_lexico() throws IOException{
            int cont = 1;
            String expresion = (String) txt_file.getText();
            Lexer lexer = new Lexer(new StringReader(expresion));

            table1.setShowGrid(false);
            DefaultTableModel model = (DefaultTableModel) table1.getModel();
            model.addColumn("Símbolos");
            model.addColumn("Línea");
            model.addRow(new Object[]{"<html><b>LINEA" + cont + "</b></html>","<html><b>SÍMBOLO</b></html>"});

            while (true) {
                Tokens token = lexer.yylex();
                if (token == null) {
                    return;
                }
                switch (token) {

                    case Linea:
                        cont++;
                        model.addRow(new Object[]{"<html><b>LINEA " + cont + "</b></html>"});
                        break;
                    case Int:
                        model.addRow(new Object[]{lexer.lexema, "<Tipo de dato Entero>"});
                        
                        break;
                    case Float:
                        model.addRow(new Object[]{lexer.lexema, "<Tipo de dato Flotante>"});
                        
                        break;
                    case Bool:
                        model.addRow(new Object[]{lexer.lexema, "<Tipo de dato Booleano>"});
                        
                        break;
                    case Char:
                        model.addRow(new Object[]{lexer.lexema, "<Tipo de dato Caracter>"});
                        
                        break;
                    case String:
                        model.addRow(new Object[]{lexer.lexema, "<Tipo de dato String>"});
                        
                        break;
                    case Array:
                        model.addRow(new Object[]{lexer.lexema, "<Tipo de dato Arreglo>"});
                        
                        break;
                    case Null:
                        model.addRow(new Object[]{lexer.lexema, "<Tipo de dato Nulo>"});
                        
                        break;
                    case If:
                        model.addRow(new Object[]{lexer.lexema, "<Reservada If>"});
                        
                        break;
                    case Else:
                        model.addRow(new Object[]{lexer.lexema, "<Reservada Else>"});
                        
                        break;
                    case While:
                        model.addRow(new Object[]{lexer.lexema, "<Reservada While>"});
                        
                        break;
                    case Switch:
                        model.addRow(new Object[]{lexer.lexema, "<Reservada Switch>"});
                        
                        break;
                    case Case:
                        model.addRow(new Object[]{lexer.lexema, "<Reservada Case>"});
                        
                        break;
                    case Print:
                        model.addRow(new Object[]{lexer.lexema, "<Reservada Print>"});
                        
                        break;
                    case Return:
                        model.addRow(new Object[]{lexer.lexema, "<Reservada Return>"});
                        
                        break;
                    case Main:
                        model.addRow(new Object[]{lexer.lexema, "<Reservada Main>"});
                        
                        break;
                    case Break:
                        model.addRow(new Object[]{lexer.lexema, "<Reservada Break>"});

                        break;
                    case Numeral:
                        model.addRow(new Object[]{lexer.lexema, "<Numeral>"});
                        
                        break;
                    case Igual:
                        model.addRow(new Object[]{lexer.lexema, "<Operador Igual>"});
                        
                        break;
                    case Suma:
                        model.addRow(new Object[]{lexer.lexema, "<Operador Suma>"});
                        
                        break;
                    case Resta:
                        model.addRow(new Object[]{lexer.lexema, "<Operador Resta>"});
                        
                        break;
                    case Division:
                        model.addRow(new Object[]{lexer.lexema, "<Operador División>"});
                        
                        break;
                    case Multiplicacion:
                        model.addRow(new Object[]{lexer.lexema, "<Operador Multiplicación>"});
                        
                        break;
                    case Modulo:
                        model.addRow(new Object[]{lexer.lexema, "<Operador Módulo>"});
                        
                        break;
                    case Potencia:
                        model.addRow(new Object[]{lexer.lexema, "<Operador Potencia>"});
                        
                        break;
                    case Parentesis_apertura:
                        model.addRow(new Object[]{lexer.lexema, "<Parentesis de apertura>"});
                        
                        break;
                    case Parentesis_cierre:
                        model.addRow(new Object[]{lexer.lexema, "<Parentesis de cierre>"});
                        
                        break;
                    case Llave_apertura:
                        model.addRow(new Object[]{lexer.lexema, "<Llave de apertura>"});
                        
                        break;
                    case Llave_cierre:
                        model.addRow(new Object[]{lexer.lexema, "<Llave de cierre>"});
                        
                        break;
                    case Corchete_apertura:
                        model.addRow(new Object[]{lexer.lexema, "<Corchete de apertura>"});
                        
                        break;
                    case Corchete_cierre:
                        model.addRow(new Object[]{lexer.lexema, "<Corchete de cierre>"});
                        
                        break;
                    case Comillas:
                        model.addRow(new Object[]{lexer.lexema, "<Comillas>"});
                        
                        break;
                    case Op_Incremento:
                        model.addRow(new Object[]{lexer.lexema, "<Operador de incremento>"});
                        
                        break;
                    case Op_Decremento:
                        model.addRow(new Object[]{lexer.lexema, "<Operador de decremento>"});
                        
                        break;
                    case Op_Relacional:
                        model.addRow(new Object[]{lexer.lexema, "<Operador Relacional>"});
                        
                        break;
                    case Op_Logico:
                        model.addRow(new Object[]{lexer.lexema, "<Operador Lógico>"});
                        
                        break;
                    case Op_Booleano:
                        model.addRow(new Object[]{lexer.lexema, "<Operador Booleano>"});
                        
                        break;
                    case Identificador:
                        model.addRow(new Object[]{lexer.lexema, "<Identificador>"});
                        
                        break;
                    case Numero:
                        model.addRow(new Object[]{lexer.lexema, "<Numero>"});
                        
                        break;
                    case ERROR:
                        model.addRow(new Object[]{lexer.lexema, "<Símbolo no encontrado>"});
                        
                        break;
                    default:
                        model.addRow(new Object[]{lexer.lexema, "<Símbolo no definido>"});
                        
                        break;
                }
            }


        }

    public static void main(String[] args) {
        /*java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainFrm().setVisible(true);
            }
        });*/
        JFrame frm = new JFrame();
        frm.setContentPane(new MainFrm().panel);
        frm.setLocationRelativeTo(null);
        frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frm.pack();
        frm.setVisible(true);
    }

    private JTextArea txt_sintactico;
    private JButton btn_file;
    private JButton btn_lexico;
    private JPanel panel;
    private JTextArea txt_file;
    private JButton btn_sintactico;
    private JTable table1;
    private JScrollBar scrollBar1;
}
