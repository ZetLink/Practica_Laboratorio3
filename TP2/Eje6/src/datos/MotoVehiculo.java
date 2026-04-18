package datos;

import utilidades.Consola;

public class MotoVehiculo extends Vehiculo{
    private int cilindradas;

    public MotoVehiculo(int id) {
        super(id);
    }

    public int getCilindradas() {
        return cilindradas;
    }

    public void setCilindradas(int cilindradas) {
        this.cilindradas = cilindradas;
    }
    
    @Override
    public void cargarDatos(){
        super.cargarDatos();
        setCilindradas(cargarCilindradas());
    }
    
    private int cargarCilindradas(){
        int iTemp = 0;
        iTemp = Consola.readInt(0, "Cilindradas: ");
        return iTemp;
    }
    
    @Override
    public void mostrarDatos(){
        super.mostrarDatos();
        String formato = "Cilindradas: %s\n\n";
        System.out.format(formato, this.getCilindradas());
    }
}
