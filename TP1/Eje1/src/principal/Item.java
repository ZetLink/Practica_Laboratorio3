package principal;

/**
 * Alumno: Rojas Ulises Martin
 */

import java.util.Scanner;

public class Item {
    private int codigo;
    private String nombre;

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public void cargarDatos(){
        setCodigo(cargarInt());
        setNombre(cargarString());
    }
    
    private int cargarInt(){
        Scanner sc = new Scanner(System.in);
        int iTemp = 0;
        do{
            System.out.print("Codigo: ");
            iTemp = Integer.parseInt(sc.nextLine());
        }while(iTemp <= 0);
        return iTemp;
    }
    
    private String cargarString(){
        Scanner sc = new Scanner(System.in);
        String sTemp = "";
        do{
            System.out.print("Nombre: ");
            sTemp = sc.nextLine();
        }while(sTemp.equals(""));
        return sTemp;
    }

    @Override
    public String toString() {
        return "Item{" + "codigo=" + codigo + ", nombre=" + nombre + '}';
    }
}
