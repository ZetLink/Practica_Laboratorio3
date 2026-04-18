package datos;

/**
 * Alumno: Rojas Ulises Martin
 */

import lista.*;
import utilidades.Consola;

public class Directivo extends Empleado{
    private int cat; // Categorias validas 1 y 2
    private LSE subordinados;

    public Directivo() {
        super();
        this.cat = 0;
        this.subordinados = new LSE();
    }

    public int getCat() {
        return cat;
    }

    public void setCat(int cat) {
        this.cat = cat;
    }

    public LSE getSubordinados() {
        return subordinados;
    }

    public void setSubordinados(LSE subordinados) {
        this.subordinados = subordinados;
    }
    
    @Override
    public void cargarDatos(int id){
        setId(id);
        setNombre(super.cargarNombre());
        setEdad(super.cargarEdad());
        setSueldoB(super.cargarSueldo());
        setCat(cargarCategoria());
    }
    
    private int cargarCategoria(){
        int iTemp = 0;
        do{
            iTemp = Consola.readInt(0, "Categoria (1/2): ");
        }while(iTemp != 1 && iTemp != 2);
        return iTemp;
    }
    
    @Override
    public void mostrarDatos(String formato){
        System.out.format(formato, this.getId(), super.obtenerNombreFormateado(), this.getEdad(), this.getSueldoB(), this.getCat());
        mostrarSubordinados();
    }
    
    private void mostrarSubordinados(){
        if(!subordinados.listaVacia()){
            Nodo p = subordinados.inicio();
            System.out.println("Empleados de " + this.getId() + ": " + super.obtenerNombreFormateado());
            String formato = "|%-8s|%-20s|%-10s|%-16s|\n";
            String sTemp = String.format(formato, "ID", "Nombre", "Edad", "SueldoBase");
            System.out.println(Consola.repeat("-", sTemp.length()));
            System.out.print(sTemp);
            System.out.println(Consola.repeat("-", sTemp.length()));
            while(p != null){
                Empleado oTemp = (Empleado) p.getDato();
                oTemp.mostrarDatos(formato);
                System.out.println(Consola.repeat("-", sTemp.length()));
                p = p.getPs();
            }
        }else{
            Consola.prtRed("Directivo sin subordinados");
        }
    }
}
