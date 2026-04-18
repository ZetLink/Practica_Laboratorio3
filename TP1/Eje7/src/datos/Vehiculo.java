package datos;

import utilidades.Consola;

public class Vehiculo {
    private int id;
    private String modelo;
    private String marca;
    private int anio;
    private int estado;

    public Vehiculo(int id) {
        this.id = id;
        this.modelo = "";
        this.marca = "";
        this.anio = 0;
        this.estado = 0;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int ano) {
        this.anio = ano;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }
    
    public void cargarDatos(){
        setModelo(cargarString("Modelo: "));
        setMarca(cargarString("Marca: "));
        setAnio(cargarAnio());
        setEstado(cargarEstado());
    }
    
    private String cargarString(String msg){
        String sTemp = "";
        do{
            sTemp = Consola.readString(msg);
        }while(sTemp.equals(""));
        return sTemp;
    }
    
    private int cargarAnio(){
        int iTemp = 0;
        do{
            iTemp = Consola.readInt(0, "Año: ");
        }while(iTemp < 0);
        return iTemp;
    }
    
    private int cargarEstado(){
        int iTemp = 0;
        do{
            iTemp = Consola.readInt(0, "1-Disponible\n2-Alquilado\n3-En Mantenimiento\nEstado: ");
        }while(iTemp != 1 && iTemp != 2 && iTemp != 3);
        return iTemp;
    }
    
    public void mostrarDatos(){
        System.out.format("ID: %d\nModelo: %s\nMarca: %s\nAño: %d\nEstado: %d\n\n", 
                this.getId(), this.getModelo(), this.getMarca(), 
                this.getAnio(), this.getEstado());
    }
}
