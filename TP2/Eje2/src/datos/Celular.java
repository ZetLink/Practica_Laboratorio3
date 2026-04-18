package datos;

/**
 * Alumno: Rojas Ulises Martin
 */

import utilidades.Consola;

public class Celular extends Dispositivo{
    private long numero;

    public Celular(int id) {
        super(id);
    }

    public long getNumero() {
        return numero;
    }

    public void setNumero(long numero) {
        this.numero = numero;
    }
    
    @Override
    public void cargarDatos(){
        super.cargarDatos();
        this.setNumero(cargarNumeroTelefono());
    }

    private long cargarNumeroTelefono(){
        long lTemp = 0;
        lTemp = Consola.readLong(0, "Telefono: ");
        return lTemp;
    }
    
    @Override
    public void mostrarDatos(){
        super.mostrarDatos();
        String formato = "Numero: %s\n\n";
        System.out.format(formato, this.getNumero());
    }
}
