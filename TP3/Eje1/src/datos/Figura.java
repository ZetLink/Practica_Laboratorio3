package datos;

/**
 * Alumno: Rojas Ulises Martin
 */
public abstract class Figura{
    private String nombre;

    public Figura(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public abstract void cargarDatos();
    public abstract double calcularSuperficie();
    public abstract double calcularPerimetro();

    public void dibujar() {
        System.out.println("Representación no disponible para la figura: " + nombre);
        System.out.println("Superficie: " + calcularSuperficie());
        System.out.println("Perimetro: " + calcularPerimetro());
    }
}
