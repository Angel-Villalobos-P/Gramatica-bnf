package analyzer;

public class Simbolo {
    protected String identificador;
    protected String scope;

    protected int fila;
    protected int columna;

    public Simbolo(String identificador, String scope, int fila, int columna) {
        this.identificador = identificador;
        this.scope = scope;
        this.fila = fila;
        this.columna = columna;
    }

    public Simbolo() {
        this.identificador = "";
        this.scope = "";
        this.fila = -1;
        this.columna = -1;
    }

    public Simbolo(String id, String scope) {
        this.identificador = id;
        this.scope = scope;
    }

    public String getIdentificador() {
        return identificador;
    }

    public void setIdentificador(String identificador) {
        this.identificador = identificador;
    }

    public String getScope() {
        return scope;
    }

    public void setScope(String scope) {
        this.scope = scope;
    }

    public int getFila() {
        return fila;
    }

    public void setFila(int fila) {
        this.fila = fila;
    }

    public int getColumna() {
        return columna;
    }

    public void setColumna(int columna) {
        this.columna = columna;
    }
}
