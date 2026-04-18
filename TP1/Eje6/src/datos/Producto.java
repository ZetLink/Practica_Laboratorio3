package datos;

import utilidades.Consola;

public class Producto {
    private int id;
    private String nombre;
    private float precio;
    private int cantstock;

    public Producto(int id) {
        this.id = id;
        this.nombre = "";
        this.precio = 0;
        this.cantstock = 0;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public int getCantstock() {
        return cantstock;
    }

    public void setCantstock(int cantstock) {
        this.cantstock = cantstock;
    }

    public void cargarDatos(){
        setNombre(cargarNombre());
        setPrecio(cargarPrecio());
        setCantstock(cargarStock());
    }
    
    private String cargarNombre(){
        String sTemp = "";
        do{
            sTemp = Consola.readString("Nombre: ");
        }while(sTemp.equals(""));
        return sTemp;
    }
    
    private float cargarPrecio(){
        float fTemp = 0;
        do{
            fTemp = Consola.readFloat(0, "Precio: ");
        }while(fTemp < 0);
        return fTemp;
    }
    
    private int cargarStock(){
        int iTemp = 0;
        do{
            iTemp = Consola.readInt(0, "Cantidad en stock disponible: ");
        }while(iTemp < 0);
        return iTemp;
    }
    
    public void mostrarDatos(){
        System.out.format("ID: %d\nNombre: %s\nPrecio: %.2f\nCantidad en stock: %d\n\n", this.getId(), this.getNombre(), this.getPrecio(), this.getCantstock());
    }
}
