package datos;

/**
 * Alumno: Rojas Ulises Martin
 */

import utilidades.Consola;

public class Tablet extends Dispositivo{
    private float tamPantalla;

    public Tablet(int id) {
        super(id);
    }

    public float getTamPantalla() {
        return tamPantalla;
    }

    public void setTamPantalla(float tamPantalla) {
        this.tamPantalla = tamPantalla;
    }
    
    @Override
    public void cargarDatos(){
        super.cargarDatos();
        setTamPantalla(cargarTamPantalla());
    }
    
    private float cargarTamPantalla(){
        float fTemp = 0;
        fTemp = Consola.readFloat(0, "Tamaño de Pantalla: ");
        return fTemp;
    }

    @Override
    public void mostrarDatos(){
        super.mostrarDatos();
        String formato = "Tamaño de Pantalla: %s\n\n";
        System.out.format(formato, this.getTamPantalla());
    }
}
