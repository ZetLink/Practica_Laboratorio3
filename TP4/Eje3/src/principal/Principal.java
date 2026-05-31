package principal;

import datos.Vehiculo;
import lista.LSEO;
import lista.Nodo;
import utilidades.Consola;
import exceptions.VehiculoException;

public class Principal {

    private final LSEO vehiculos;

    public Principal() {
        this.vehiculos = new LSEO<Vehiculo>();
    }
    
    private void agregarDatos() throws VehiculoException {
        do {
            String petente = validarPatente();
            Vehiculo vTemp = new Vehiculo(petente);
            vTemp.cargarDatos();
            vehiculos.insertar(vTemp);
        }while(Consola.continuar("Agregar otro vehiculo? (S/N): "));
    }
    
    private String validarPatente() throws VehiculoException {
        String sTemp = "";
        do{
            sTemp = Consola.readString("Patente: ").toUpperCase();
        }while(vehiculos.buscar(new Vehiculo(sTemp)));
        return sTemp;
    }
    
    private void mostrarLista(){
        if(!vehiculos.listaVacia()){
            Nodo p = vehiculos.inicio();
            while(p != null){
                Vehiculo vTemp = (Vehiculo) p.getDato();
                vTemp.mostrarDatos();
                p = p.getPs();
            }
        }else{
            Consola.prtRed("Lista Vacia");
        }
    }
    
    public void menu() throws VehiculoException{
        String titulo = "Menu Vahiculos";
        String[] opciones = {
            "1. Registrar vehiculo",
            "2. Mostrar vehiculo",
            "0. Salir"
        };
        int op;
        do{
            Consola.imprimirMenu(opciones, titulo);
            op = Consola.readInt(0, "--> ");
            switch(op){
                case 1:
                    agregarDatos();
                    break;
                case 2:
                    mostrarLista();
                    break;
            }
        }while(op != 0);
    }
    
    public static void main(String[] args) throws VehiculoException {
        Principal app = new Principal();
        app.menu();
    }
    
}
