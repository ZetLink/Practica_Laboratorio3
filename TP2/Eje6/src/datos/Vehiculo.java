package datos;

import utilidades.Consola;

public class Vehiculo {
    private int id;
    private String marca;
    private String patente;

    public Vehiculo(int id) {
        this.id = id;
        this.marca = "";
        this.patente = "";
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

    public String getPatente() {
        return patente;
    }

    public void setPatente(String patente) {
        this.patente = patente;
    }
    
    public void cargarDatos(){
        setMarca(cargarCadena("Marca: "));
        setPatente(cargarCadena("Patente: "));
    }
    
    private String cargarCadena(String msg){
        String sTemp = "";
        do{
            sTemp = Consola.readString(msg);
        }while(sTemp.equals(""));
        return sTemp;
    }
    
    protected void mostrarDatos(){
        String formato = "ID: %s\nMarca: %s\nPatente: %s\n";
        System.out.format(formato, this.getId(), this.getMarca(), this.getPatente());
    }
}
