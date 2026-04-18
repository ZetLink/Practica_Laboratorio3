package datos;

import utilidades.Consola;
import lista.*;

public class Cliente {
    private int id;
    private String nombre;
    private LSE vehiculos;

    public Cliente(int id) {
        this.id = id;
        this.nombre = "";
        this.vehiculos = new LSE();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public LSE getVehiculos() {
        return vehiculos;
    }

    public void setVehiculos(LSE vehiculos) {
        this.vehiculos = vehiculos;
    }
    
    public void cargarDatos(){
        setNombre(cargarNombre());
    }
    
    private String cargarNombre(){
        String sTemp = "";
        do{
            sTemp = Consola.readString("Nombre: ");
        }while(sTemp.equals(""));
        return sTemp;
    }
    
    public void mostrarDatos(){
        System.out.format("-----Cliente ID: %d-----\nNombre: %s\n---Lista de Vehiculos---\n", 
                this.getId(), Consola.obtenerNombreFormateado(this.getNombre()));
        if(!this.getVehiculos().listaVacia()){
            mostrarVehiculos();
        }else{
            Consola.prtRed("Cliente Sin Vehiculos Alquilados");
        }
    }
    
    private void mostrarVehiculos(){
        Nodo p = this.getVehiculos().inicio();
        while(p != null){
            Vehiculo vTemp = (Vehiculo) p.getDato();
            vTemp.mostrarDatos();
            p = p.getPs();
        }
    }
}
