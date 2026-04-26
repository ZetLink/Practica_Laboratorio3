package datos;

import utilidades.Consola;

/**
 * Alumno: Rojas Ulises Martin
 */

public class Triangulo extends Figura{
    private double lado; 

    public Triangulo(String nombre) {
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
        return (Math.sqrt(3) / 4) * Math.pow(lado, 2);
    }

    @Override
    public double calcularPerimetro() {
        return 3 * lado;
    }

    @Override
    public void dibujar() {
        System.out.println("\nSuperficie: " + calcularSuperficie());
        System.out.println("Perimetro: " + calcularPerimetro());
        System.out.println("Dibujando " + getNombre() + ":");
        int l = (int) Math.round(lado);
        for (int i = 1; i <= l; i++) {
            for (int j = i; j < l; j++) {
                System.out.print(" ");
            }
            for (int k = 1; k <= (2 * i - 1); k++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
    
}
