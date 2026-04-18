package principal;

import lista.*;
import utilidades.Consola;
import datos.*;

public class Principal {

    private LSE l1; // Lista para Pedidos
    private LSE l2; // Lista para almacenar los ID y verificar que no se repitan
    
    public Principal(){
        l1 = new LSE();
        l2 = new LSE();
    }
    
    private void cargarPedido(){
        do{
            int iTemp = 0;
            do{
                iTemp = Consola.readInt(0, "ID del Pedido: ");
            }while(l2.buscar(iTemp));
            Pedido peTemp = new Pedido(iTemp);
            l2.insertar(iTemp);
            do{
                peTemp.getProductos().insertar(cargarProductos());
            }while(Consola.continuar("¿Agregar otro producto? (S/N): "));
            peTemp.cargarDatos();
            l1.insertar(peTemp);
        }while(Consola.continuar("¿Agregar otro pedido? (S/N): "));
    }
    
    private Producto cargarProductos(){
        Producto prTemp = null;
        int iTemp = 0;
        do{
            iTemp = Consola.readInt(0, "ID del Producto: ");
        }while(l2.buscar(iTemp));
        prTemp = new Producto(iTemp);
        prTemp.cargarDatos();
        l2.insertar(iTemp);
        return prTemp;
    }
    
    private void productoAE(){
        int idPedido = Consola.readInt(0, "Ingrese ID del Pedido: ");

        Nodo p = l1.inicio();
        Pedido pedido = null;


        while(p != null){
            Pedido peTemp = (Pedido) p.getDato();
            if(peTemp.getId() == idPedido){
                pedido = peTemp;
                break;
            }
            p = p.getPs();
        }

        if(pedido != null){
            String[] opciones = {
                "1. Agregar producto",
                "2. Eliminar producto"
            };

            Consola.imprimirMenu(opciones, "Productos del Pedido");
            int op = Consola.readInt(0, "--> ");

            switch(op){
                case 1:
                    // Agregar producto
                    Producto nuevo = cargarProductos();
                    pedido.getProductos().insertar(nuevo);
                    break;

                case 2:
                    // Eliminar producto
                    int idProd = Consola.readInt(0, "ID del producto a eliminar: ");
                    pedido.getProductos().eliminar(idProd);
                    break;
            }
        }else{
            Consola.prtRed("Pedido no encontrado");
        }
    }
    
    private void actualizarEstado(){
        int idPedido = Consola.readInt(0, "Ingrese ID del Pedido: ");

        Nodo p = l1.inicio();
        Pedido pedido = null;


        while(p != null){
            Pedido peTemp = (Pedido) p.getDato();
            if(peTemp.getId() == idPedido){
                pedido = peTemp;
                break;
            }
            p = p.getPs();
        }

        if(pedido != null){
            int estado;
            do{
                estado = Consola.readInt(0, 
                    "Nuevo estado:\n1-Pendiente\n2-Enviado\n3-Entregado\n--> ");
            }while(estado != 1 && estado != 2 && estado != 3);

            pedido.setEstado(estado);
            System.out.println("Estado actualizado correctamente");
        }else{
            Consola.prtRed("Pedido no encontrado");
        }
    }
    
    private void mostrarInfoPedido(){
        if(!l1.listaVacia()){
            Nodo p = l1.inicio();
            while(p != null){
                Pedido peTemp = (Pedido) p.getDato(); // Es necesario hacer el downcasting para usar los metodos del Nodo, ya que la lista guarda objetos de tipo Object
                peTemp.mostrarDatos();
                p = p.getPs();
            }   
        }else{
            Consola.prtRed("Lista de Pedidos Vacia");
        }
    }
    
    public void menu(){
        String titulo = "Gestion de Pedidos";
        String[] opciones = {
            "1. Crear pedido con productos",
            "2. Agregar o eliminar productos de un pedido",
            "3. Cambiar el estado de un pedido",
            "4. Mostrar la información de un pedido",
            "0. Salir"
        };
        int op;
        do{
            Consola.imprimirMenu(opciones, titulo);
            op = Consola.readInt(0, "--> ");
            switch(op){
                case 1:
                    cargarPedido();
                    break;
                case 2:
                    productoAE();
                    break;
                case 3:
                    actualizarEstado();
                    break;
                case 4:
                    mostrarInfoPedido();
                    break;
            }
        }while(op != 0);
    }
    
    public static void main(String[] args) {
        Principal app = new Principal();
        app.menu();
    }

}
