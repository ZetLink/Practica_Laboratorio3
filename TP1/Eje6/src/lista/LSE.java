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
    public boolean buscar(int elem){
        boolean b = false;
        Nodo p = list;
        while (b == false && p != null){
            
            Object oTemp = p.getDato();
            
            if(oTemp instanceof Pedido){
                Pedido peTemp = (Pedido) oTemp;
                b = (peTemp.getId() == elem);
            }else if(oTemp instanceof Producto){
                Producto prTemp = (Producto) oTemp;
                b = (prTemp.getId() == elem);
            }else if(oTemp instanceof Integer){
                Integer iTemp = (Integer) oTemp;
                b = (iTemp == elem);
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
    
    public Nodo eliminar(int elem) {
        Nodo x = null;
        Nodo p = list;
        Nodo ant = null;
        if(list == null){
            return x;
        }
        boolean band = false;
        while (p != null && !band) {
            
            Object oTemp = p.getDato();
            
            if(oTemp instanceof Pedido){
                Pedido peTemp = (Pedido) oTemp;
                band = (peTemp.getId() == elem);
            }else if(oTemp instanceof Producto){
                Producto prTemp = (Producto) oTemp;
                band = (prTemp.getId() == elem);
            } else {
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
