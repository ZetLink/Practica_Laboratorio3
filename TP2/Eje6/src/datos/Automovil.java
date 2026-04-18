package datos;

import utilidades.Consola;

public class Automovil extends Vehiculo{
    private int cantPuertas;

    public Automovil(int id) {
        super(id);
        this.cantPuertas = 0;
    }

    public int getCantPuertas() {
        return cantPuertas;
    }

    public void setCantPuertas(int cantPuertas) {
        this.cantPuertas = cantPuertas;
    }
    
    @Override
    public void cargarDatos(){
        super.cargarDatos();
        setCantPuertas(cargarCPuertas());
    }
    
    private int cargarCPuertas(){
        int iTemp = 0;
        iTemp = Consola.readInt(0, "Cantidad de Puertas: ");
        return iTemp;
    }
    
    @Override
    public void mostrarDatos(){
        super.mostrarDatos();
        String formato = "Cantidad de Puertas: %s\n\n";
        System.out.format(formato, this.getCantPuertas());
    }
}
