package datos;

import utilidades.Consola;

/**
 * @author Rojas Ulises Martin
 */
public abstract class Empleado implements Imprimible{
    private int id;
    private String nom;

    public Empleado(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
    
    public abstract void cargarDatos();
    public abstract float calcularSueldo();
    
    @Override
    public void imprimirRecibo(){
        System.out.println(Consola.repeat("=", 36));
        System.out.format("%-8s", "Recibo de Sueldo\n");
        System.out.println(Consola.repeat("=", 36));
        System.out.format("ID: %s\nNombre: %s\nTipo de Empleado: %s\nGanancia: %.2f\n",
                this.getId(),Consola.obtenerNombreFormateado(this.getNom()),
                this.getClass().getSimpleName(),this.calcularSueldo());
        System.out.println(Consola.repeat("=", 36) + "\n");
    }
}
