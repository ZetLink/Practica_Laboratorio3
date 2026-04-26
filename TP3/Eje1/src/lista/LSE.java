package lista;

import datos.*;

public class LSE {
    protected Nodo list;
    
    public LSE(){
        list = null;
    }
    
    public Nodo inicio(){
        return list;
    }
    
    public boolean listaVacia() {
        return (list == null);
    }
    
    // Insertar
    public void insertar(Object entrada) {
        Nodo x = new Nodo(entrada);
        if (list == null) {
            list = x;
        } else {
            x.setPs(list);
            list = x;
        }
    }
    
    //Buscar LSE   
    public boolean buscar(String elem){
        boolean b = false;
        Nodo p = list;
        while (b == false && p != null){
            Figura oTemp = (Figura) p.getDato();
            if(oTemp.getNombre().equals(elem)){
                b = true;
            }
            p = p.getPs();
        }
        return b;
    }
    
    //Eliminar LSE
    public Nodo quitar(Nodo p, Nodo ant) {
        Nodo x = p;
        if (p == list) {
            list = p.getPs();
        } else {
            ant.setPs(p.getPs());
        }
        return x;
    }
    
    public Nodo eliminar(String elem) {
        Nodo x = null;
        Nodo p = list;
        Nodo ant = null;
        if(list == null){
            return x;
        }
        boolean band = false;
        while (p != null && !band) {
            
            Object oTemp = p.getDato();
            
            if(oTemp instanceof Figura){
                Figura peTemp = (Figura) oTemp;
                band = (peTemp.getNombre().equals(elem));
            }
            
            if(!band){
                ant = p;
                p = p.getPs();
            }
        }
        if (band == true) {
            quitar(p, ant);
            System.out.println("\u001B[32m" + "Elemento Eliminado" + "\u001B[0m\n");
            x = p;
        }
        return x;
    }
}
