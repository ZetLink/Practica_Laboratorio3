package datos;

/**
 * Alumno: Rojas Ulises Martin
 */

import utilidades.Consola;

public class Computadora extends Dispositivo{
    private String os;

    public Computadora(int id) {
        super(id);
    }

    public String getOs() {
        return os;
    }

    public void setOs(String os) {
        this.os = os;
    }

    @Override
    public void cargarDatos(){
        super.cargarDatos();
        setOs(cargarOS());
    }
    
    private String cargarOS(){
        String sTemp = "";
        sTemp = Consola.readString("Sistema Operativo: ");
        return sTemp;
    }
    
    @Override
    public void mostrarDatos(){
        super.mostrarDatos();
        String formato = "Sistema Operativo: %s\n\n";
        System.out.format(formato, this.getOs());
    }
}
