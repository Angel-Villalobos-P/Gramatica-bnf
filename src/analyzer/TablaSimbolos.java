package analyzer;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

public class TablaSimbolos {
    //    static ArrayList<Simbolo> tablaSimbolos = new ArrayList<>();
    private final ArrayList<Simbolo> tablaSimbolos;

    //contiene todas las variables EN ORDEN SECUENCIAL
    public ArrayList<Variable> variables;
    public ArrayList<Funcion> funciones;

    //pila que almacena todos los tipos de datos que se definen
    public Deque<TipoDato> tiposDato = new LinkedList<>();

    public TablaSimbolos() {
        tablaSimbolos = new ArrayList<>();
        this.variables = new ArrayList<>();
        this.funciones = new ArrayList<>();
    }

    public int getTablaSimbolosSize() {
        return tablaSimbolos.size();
    }

    /**
     * Inserta un simbolo en la tabla de simbolos
     *
     * @param simbolo simbolo dado para insertar
     */
    public void insertarSimbolo(Simbolo simbolo) {
        tablaSimbolos.add(simbolo);
    }

    public void insertarVariable(Variable variable) {
        variable.setTipoDato(tiposDato.pollLast());
        this.variables.add(variable);
        this.insertarSimbolo(variable);
    }

    public void insertarFuncion(Funcion funcion) {
        funcion.setTipoDatoRetorno(tiposDato.pollLast());
        this.funciones.add(funcion);
        this.insertarSimbolo(funcion);
    }

    /**
     * Verifica si ya existe el simbolo en la tabla
     *
     * @param simbolo simbolo a verificar
     * @return true si existe false sino
     */
    public boolean existeSimbolo(Simbolo simbolo) {
        Simbolo auxSimbol;
        if (simbolo instanceof Variable auxVar) {
            for (Simbolo simbol : tablaSimbolos) {
                auxSimbol = simbol;
                if (auxSimbol instanceof Variable) {
                    return (auxSimbol.identificador.equals(auxVar.identificador) && auxSimbol.scope.equals(auxVar.scope));
                }
            }
        }
        return false;
    }

    public boolean existeSimbolo(Simbolo simbolo, String scope) {
        for (Simbolo simbol : tablaSimbolos) {
            if (simbolo.getIdentificador().equals(simbol.getIdentificador()) && simbolo.getScope().equals(scope)) {
                return true;
            }
        }
        return false;
//        Simbolo auxSimbol;
//        if (simbolo instanceof Variable auxVar) {
//            for (Simbolo simbol : tablaSimbolos) {
//                auxSimbol = simbol;
//                if (auxSimbol instanceof Variable) {
//                    return (auxSimbol.identificador.equals(auxVar.identificador) && auxSimbol.scope.equals(auxVar.scope));
//                }
//            }
//        }
//        return false;
    }

    /**
     * Verifica si un identificador existe dentro de las variables en la tabla de símbolos
     *
     * @param identificador nombre de la variable
     * @param scope         nombre de la funcion a la que pertenece
     * @return true existe, false no existe
     */
    public boolean existeVariable(String identificador, String scope) {
        for (Simbolo simbolo : tablaSimbolos) {
            if (simbolo instanceof Variable) {
                return simbolo.identificador.equals(identificador) && simbolo.scope.equals(scope);
            }
        }
        return false;
    }

    /**
     * Obtiene la variable existente en la tabla
     *
     * @param nombre nombre de la variable
     * @param scope  alcance, nombre de la funcion a la que pertenece
     * @return retorna la variable si la encuentra
     */
    public Variable getVariable(String nombre, String scope) {
        for (Simbolo simbolo : tablaSimbolos) {
            if (simbolo instanceof Variable && simbolo.identificador.equals(nombre) && simbolo.scope.equals(scope)) {
                return (Variable) simbolo;
            }
        }
        //Si no la encuentra en el ámbito, busca en las globales
//        for (Simbolo simbolo : tablaSimbolos) {
//            if (simbolo instanceof Variable && simbolo.identificador.equals(nombre) && simbolo.scope.equals("Global")) {
//                return (Variable) simbolo;
//            }
//        }
        return null;
    }

    public Simbolo getSimbolo(String nombre, String scope) {
        for (Simbolo simbolo : tablaSimbolos) {
            if (simbolo.getIdentificador().equals(nombre) && simbolo.getScope().equals(scope)) {
                return simbolo;
            }
        }
        return null;
    }

    public boolean verificarTipo(String id, String scope, TipoDato tipoAsig) {
        Variable auxVar = getVariable(id, scope); //encuentra el simbolo
        return auxVar.getTipoDato() == tipoAsig;
//        return switch (tipoAsig) { // evalúa si el simbolo es del mismo tipo que de la asignación
//            case Int, Float, Bool -> auxVar.getTipoDato() == tipoAsig;
//            default -> false;
//        };
    }

//    public Simbolo getSimbolo(String id) {
//
//    }

    /**
     * Agrega los tipos de dato que se definen
     *
     * @param tipoDato valor del enunm del tipo de dato
     */
    public void agregarTipoDato(TipoDato tipoDato) {
        this.tiposDato.add(tipoDato);
    }


    //    public void agregarVariable(String identificador, String scope, int fila, int columna, TipoDato tipo) {
//        Variable var = new Variable(identificador, scope, fila, columna, tipo);
//
//        //Agrega la primera variable de la producción
//        variables.add(var);
//    }
    public void agregarVariable(String identificador, int fila, int columna) {
        Variable var = new Variable();
        var.identificador = identificador;
        var.setFila(fila + 1);
        var.setColumna(columna);
        var.setTipoDato(tiposDato.pollLast());

        //Agrega la primera variable de la producción
        variables.add(var);
    }

    public void agregarVariable(String identificador, int fila, int columna, String scope) {
        Variable var = new Variable();
        var.identificador = identificador;
        var.setFila(fila + 1);
        var.setColumna(columna);
        var.setTipoDato(tiposDato.pollLast());
        var.setScope(scope);

        //Agrega la primera variable de la producción
        variables.add(var);
    }

    public String getTablaSimbolos() {
        StringBuilder stringTable = new StringBuilder();
        for (Simbolo s : tablaSimbolos) {
            if (s instanceof Variable) {
                stringTable.append("Variable: ").append(s.identificador).append(", tipo: ").append(((Variable) s).getTipoDato()).append(", Scope: ").append(s.scope).append("\n");
            }
        }
        return stringTable.toString();
    }

    public void printTablaSimbolos() {
        System.out.println(getTablaSimbolos());
    }
}
