package analyzer;

public class Variable extends Simbolo {
    private TipoDato tipoDato;

    public Variable(String identificador, String scope, int fila, int columna, TipoDato tipoDato) {
        super(identificador, scope, fila, columna);
        this.tipoDato = tipoDato;
    }

    public Variable() {
        super();
        this.tipoDato = null;
    }
    public Variable(String id, String scope, TipoDato tipoDato) {
        super(id, scope);
        this.tipoDato = tipoDato;
    }
    public Variable(String id, String scope) {
        super(id, scope);
    }

    public TipoDato getTipoDato() {
        return tipoDato;
    }

    public void setTipoDato(TipoDato tipoDato) {
        this.tipoDato = tipoDato;
    }

}
