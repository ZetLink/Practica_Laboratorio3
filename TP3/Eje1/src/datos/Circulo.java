package datos;

/**
 * Alumno: Rojas Ulises Martin
 */

import utilidades.Consola;

public class Circulo extends Figura{
    private double radio;

    public Circulo(String nombre) {
        super(nombre);
    }

    public double getRadio() {
        return radio;
    }

    public void setRadio(double radio) {
        this.radio = radio;
    }

    @Override
    public void cargarDatos(){
        setRadio(Consola.readFloat(0, "Radio: "));
    }
    
    @Override
    public double calcularSuperficie() {
        return Math.PI * Math.pow(radio, 2);
    }

    @Override
    public double calcularPerimetro() {
        return 2 * Math.PI * radio;
    }
    
    // No sobreescribir dibujar() por que no se puede representar un circulo
}
