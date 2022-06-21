package analyzer.Generador;

import java.util.ArrayList;
import java.util.List;

public class PilaSemantica {
    private List<RegistroSemantico> pilaSemantica;

    public PilaSemantica() {
        pilaSemantica = new ArrayList<>();
    }

    public void push_init(String valor) // inserta de primero
    {
        pilaSemantica.add(0, new RegistroSemantico(valor));
    }

    public void push_end(String valor) // inserta de ultimo
    {
        pilaSemantica.add(pilaSemantica.size(), new RegistroSemantico(valor));
    }

    public RegistroSemantico pop_init() // saca el primero de la lista
    {
        RegistroSemantico temp = null;
        try
        {
            temp = pilaSemantica.get(0);
            pilaSemantica.remove(0);
        }
        catch(IndexOutOfBoundsException e) { System.err.println("Error en la pila: pop_init()"); }

        return temp;
    }

    public RegistroSemantico pop_end() // saca el último o el tope
    {
        RegistroSemantico temp = null;
        try
        {
            temp = pilaSemantica.get(pilaSemantica.size() - 1);
            pilaSemantica.remove(pilaSemantica.size() - 1);
        }
        catch (IndexOutOfBoundsException e) { System.err.println("Error en la pila: pop_end()"); }

        return temp;
    }

    public Boolean isEmpty()
    {
        return pilaSemantica.isEmpty();
    }

    public void clear()
    {
        pilaSemantica.clear();
    }

    public int size()
    {
        return pilaSemantica.size();
    }

    public void print() {

        for(int i = 0; i < pilaSemantica.size(); i++)
        {
            System.out.println(pilaSemantica.get(i));
        }
    }
}
