package datos;

import utilidades.Consola;

public class Camion extends Vehiculo{
    private float cargaMaxima;

    public Camion(int id) {
        super(id);
        this.cargaMaxima = 0;
    }

    public float getCargaMaxima() {
        return cargaMaxima;
    }

    public void setCargaMaxima(float cargaMaxima) {
        this.cargaMaxima = cargaMaxima;
    }
    
    @Override
    public void cargarDatos(){
        super.cargarDatos();
        setCargaMaxima(cargarCMaxima());
    }
    
    private float cargarCMaxima(){
        float fTemp = 0;
        fTemp = Consola.readFloat(0, "Carga Maxima del Camion (Ton): ");
        return fTemp;
    }
    
    @Override
    public void mostrarDatos(){
        super.mostrarDatos();
        String formato = "Carga Maxima del Camion en Toneladas: %s\n\n";
        System.out.format(formato, this.getCargaMaxima());
    }
}
