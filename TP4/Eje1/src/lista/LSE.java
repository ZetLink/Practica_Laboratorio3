package lista;
  
public class LSE<T>{
    protected Nodo<T> list;
    
    public LSE(){
        list = null;
    }
    
    public Nodo<T> inicio(){
        return list;
    }
    
    public boolean listaVacia() {
        return (list == null);
    }
    
    // Insertar
    public void insertarPrim(T elemento) {
        Nodo<T> x = new Nodo<>(elemento);
        if (list == null) {
            list = x;
        } else {
            x.setPs(list);
            list = x;
        }
    }
    
    //Eliminar LSE
    public Nodo<T> quitar(Nodo<T> p, Nodo<T> ant) {
        Nodo<T> x = p;
        if (p == list) {
            list = p.getPs();
        } else {
            ant.setPs(p.getPs());
        }
        return x;
    }
    
    public Nodo<T> eliminar(T elemento) {
        Nodo<T> x = null;
        Nodo<T> p = list;
        Nodo<T> ant = null;
        if(list == null){
            return x;
        }
        boolean band = false;
        while (p != null && !band) {
            if(p.getDato() == elemento){
                band = true;
            }else{
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
