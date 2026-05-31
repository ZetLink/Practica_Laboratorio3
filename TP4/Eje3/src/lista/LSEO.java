package lista;

import utilidades.Consola;

public class LSEO<T extends Comparable<T>> extends LSE<T>{

    public LSEO() {
        super();
    }
    
    public void insertarMedio(Nodo<T> p, Nodo<T> ant, Nodo<T> x) {
        x.setPs(p);
        ant.setPs(x);
    }
    
    public void insertarFin(Nodo<T> ant, Nodo<T> p, Nodo<T> x) {
        if (p == null) {
            x.setPs(null);
            ant.setPs(x);
        }
    }
    
    public void insertar(T entrada) {
        Nodo<T> p = inicio();
        Nodo<T> ant = null;
        int b = 0;
        
        while (p != null && b == 0) {
            if ((p.getDato().compareTo(entrada)) > 0) {
                b = 1;
            } else {
                ant = p;
                p = p.getPs();
            }
        }
        Nodo<T> x = new Nodo<>(entrada);
        if (b == 1) {
            if (p == list) {
                insertarPrim(entrada);
            } else {
                insertarMedio(p, ant, x);
            }
        } else {
            if (ant == null) {
                list = x;
            } else {
                insertarFin(ant, p, x);
            }
        }
    }
    
    public boolean buscar(T elemento){
        boolean b = false;
        Nodo<T> p = inicio();
        while(!b && p != null){
            if(p.getDato().compareTo(elemento) == 0){
                b = true;
            }
            p = p.getPs();
        }
        return b;
    }
    
    @Override
    public Nodo<T> eliminar(T elemento){
        Nodo<T> x = null;
        Nodo<T> p = inicio();
        Nodo<T> ant = null;
        if(list == null){
            return x;
        }
        boolean band = false;
        while (p != null && !band) {
            if (p.getDato().compareTo(elemento) == 0) {
                x = quitar(p, ant);
                band = true;
            } else {
                ant = p;
                p = p.getPs();
            }
        }
        if (band == true) {
            Consola.prtGreen("Elemento eliminado!!!");
        } else {
            Consola.prtRed("Elemento inexistente!!!");
        }
        return x;
    }
}