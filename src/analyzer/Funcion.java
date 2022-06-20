package analyzer;

import java.util.ArrayList;

public class Funcion extends Simbolo{
    private TipoDato tipoDatoRetorno;
    private ArrayList<Variable> parametros;

    public Funcion(){
        super();
        parametros = new ArrayList<>();
        tipoDatoRetorno = null;
    }
    public Funcion(String identificador, String scope, int fila, int columna, TipoDato tipoDatoRetorno, ArrayList<Variable> parametros) {
        super(identificador, scope, fila, columna);
        this.tipoDatoRetorno = tipoDatoRetorno;
        this.parametros = parametros;
    }

    public Funcion(TipoDato tipoDatoRetorno, ArrayList<Variable> parametros) {
        this.tipoDatoRetorno = tipoDatoRetorno;
        this.parametros = parametros;
    }

    public Funcion(String id, String scope, TipoDato tipoDatoRetorno, ArrayList<Variable> parametros) {
        super(id, scope);
        this.tipoDatoRetorno = tipoDatoRetorno;
        this.parametros = parametros;
    }
    public Funcion(String id, String scope, ArrayList<Variable> parametros) {
        super(id, scope);
        this.parametros = parametros;
    }

    public TipoDato getTipoDatoRetorno() {
        return tipoDatoRetorno;
    }

    public ArrayList<Variable> getParametros() {
        return parametros;
    }

    public void setTipoDatoRetorno(TipoDato tipoDatoRetorno) {
        this.tipoDatoRetorno = tipoDatoRetorno;
    }


}
