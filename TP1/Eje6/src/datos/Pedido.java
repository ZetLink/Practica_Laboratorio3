package datos;

import utilidades.Consola;
import lista.Nodo;

import lista.LSE;

public class Pedido {
    private int id;
    private LSE productos;
    private int estado;

    public Pedido(int id) {
        this.id = id;
        this.productos = new LSE();
        this.estado = 0;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LSE getProductos() {
        return productos;
    }

    public void setProductos(LSE productos) {
        this.productos = productos;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public void cargarDatos(){
        setEstado(cargarEstado());
    }
    
    private int cargarEstado(){
        int iTemp = 0;
        do{
            iTemp = Consola.readInt(0, "1-Pendiente\n2-Enviado\n3-Entregado\nEstado: ");
        }while(iTemp != 1 && iTemp != 2 && iTemp != 3);
        return iTemp;
    }
    
    public void mostrarDatos(){
        System.out.format("-----Pedido ID: %d-----\nEstado: %d\n---Lista de Productos---\n", this.getId(), this.getEstado());
        mostrarProductos();
    }
    
    private void mostrarProductos(){
        if(!this.getProductos().listaVacia()){
            Nodo p = this.getProductos().inicio();
            while(p != null){
                Producto prTemp = (Producto) p.getDato();
                prTemp.mostrarDatos();
                p = p.getPs();
            }   
        }else{
            Consola.prtRed("Pedido sin productos");
        }
    }
}
