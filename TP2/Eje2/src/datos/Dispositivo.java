package datos;

/**
 * Alumno: Rojas Ulises Martin
 */

import utilidades.Consola;

public class Dispositivo {
    protected int id;
    protected String marca;
    protected String modelo;
    protected boolean estado; // False = Apagado = 0 | True = Encendido = 1

    public Dispositivo(int id) {
        this.id = id;
        this.estado = false;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }
    
    public void cargarDatos(){
        this.setMarca(cargarCadena("Marca: "));
        this.setModelo(cargarCadena("Modelo: "));
    }
    
    protected String cargarCadena(String msg){
        String sTemp = "";
        do{
            sTemp = Consola.readString(msg);
        }while(sTemp.equals(""));
        return sTemp;
    }
    
    protected boolean modificarEstado(){
        return !this.isEstado();
    }
    
    protected void mostrarDatos(){
        String formato = "ID: %s\nMarca: %s\nModelo: %s\n";
        System.out.format(formato, this.getId(), this.getMarca(), this.getModelo());
    }
}
