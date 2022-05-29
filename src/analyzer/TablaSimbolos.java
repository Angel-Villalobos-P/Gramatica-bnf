package analyzer;

import java.util.ArrayList;

public class TablaSimbolos {
    static ArrayList<Simbolo> tablaSimbolos = new ArrayList<>();

    //contiene todas las variables EN ORDEN SECUENCIAL
    public ArrayList<Variable> variables;

    public TablaSimbolos() {
        tablaSimbolos = new ArrayList<>();
        this.variables = new ArrayList<>();
    }

    /**
     * Inserta un simbolo en la tabla de simbolos
     *
     * @param simbolo simbolo dado para insertar
     */
    public void insertar(Simbolo simbolo) {
        tablaSimbolos.add(simbolo);
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
//                        return true;
                }
            }
        }
        return false;
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
        for (Simbolo simbolo : tablaSimbolos) {
            if (simbolo instanceof Variable && simbolo.identificador.equals(nombre) && simbolo.scope.equals("Global")) {
                return (Variable) simbolo;
            }
        }
        return null;
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

        //Agrega la primera variable de la producción
        variables.add(var);
    }

    public String getTablaSimbolos() {
        StringBuilder stringTable = new StringBuilder();
        for (Simbolo s : tablaSimbolos) {
            if (s instanceof Variable) {
                stringTable.append("Variable: ").append(s.identificador).append(", tipo: ").append(((Variable) s).getTipoDato()).append(", Scope: ").append(s.scope).append("\n");
            }        }
        return stringTable.toString();
    }

    public void printTablaSimbolos() {
        System.out.println(getTablaSimbolos());
    }
}
