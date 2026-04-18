package datos;

import utilidades.Consola;

public class Colectivo extends Vehiculo{
    private int cantPasajeros;

    public Colectivo(int id) {
        super(id);
        this.cantPasajeros = 0;
    }

    public int getCantPasajeros() {
        return cantPasajeros;
    }

    public void setCantPasajeros(int cantPasajeros) {
        this.cantPasajeros = cantPasajeros;
    }
    
    @Override
    public void cargarDatos(){
        super.cargarDatos();
        setCantPasajeros(cargarCPasajeros());
    }
    
    private int cargarCPasajeros(){
        int iTemp = 0;
        iTemp = Consola.readInt(0, "Cantidad de Pasajeros: ");
        return iTemp;
    }
    
    @Override
    public void mostrarDatos(){
        super.mostrarDatos();
        String formato = "Cantidad de Pasajeros: %s\n\n";
        System.out.format(formato, this.getCantPasajeros());
    }
}
