package datos;

import utilidades.Consola;

/**
 * Alumno: Rojas Ulises Martin
 */

public class Cuadrado extends Figura{
    private double lado;

    public Cuadrado(String nombre) {
        super(nombre);
    }

    public double getLado() {
        return lado;
    }

    public void setLado(double lado) {
        this.lado = lado;
    }

    @Override
    public void cargarDatos(){
        setLado(Consola.readFloat(0, "Lado: "));
    }
    
    @Override
    public double calcularSuperficie() {
        return lado * lado;
    }

    @Override
    public double calcularPerimetro() {
        return 4 * lado;
    }

    @Override
    public void dibujar() {
        System.out.println("\nSuperficie: " + calcularSuperficie());
        System.out.println("Perimetro: " + calcularPerimetro());
        System.out.println("Dibujando " + getNombre() + ":");
        int l = (int) Math.round(lado);
        for (int i = 0; i < l; i++) {
            for (int j = 0; j < l; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }
    
}
