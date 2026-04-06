package principal;

/**
 * Alumno: Rojas Ulises Martin
 */

import java.util.Scanner;

public class Menu {

    private Item[] items;
    private int cantidad;

    public Menu(int maxCantidad) {
        this.items = new Item[maxCantidad];
        this.cantidad = 0;
    }  

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
    
    public void agregarItem() {
        int i = 0;
        boolean b = false;
        while(i < items.length && !b){
            if(items[i] == null){
                b = true;
                Item oAux = new Item();
                oAux.cargarDatos();
                items[i] = oAux;
                setCantidad(getCantidad() + 1);
            }
            i++;
        }
        if(!b){
            System.out.println("No hay mas espacio en el vector");
        }
    }
    
    public void eliminarItem() {
        int cod = cargarInt("Codigo del item a eliminar: ");
        if(getCantidad() > 0){
            int i = 0;
            boolean b = false;
            while(i < getCantidad() && !b){
                if(items[i] != null && items[i].getCodigo() == cod){
                    b = true;
                    items[i] = null;
                    setCantidad(getCantidad() - 1);
                }
                i++;
            }
            if(!b){
                System.out.println("Item No Encontrado");
            } else {
                System.out.println("Item Eliminado");
            }   
        } else {
            System.out.println("Vector sin items");
        }
    }
    
    public void mostrarItems() {
        if(getCantidad() > 0){
            for(int i = 0; i < items.length; i++){
                if(items[i] != null){
                    System.out.println(items[i].toString());
                }
            }
        } else {
            System.out.println("Vector sin items");
        }
    }
    
    private int cargarInt(String msg){
        Scanner sc = new Scanner(System.in);
        int iTemp = 0;
        do{
            System.out.print(msg);
            iTemp = Integer.parseInt(sc.nextLine());
        }while(iTemp <= 0);
        return iTemp;
    }
    
    public static void main(String[] args) {
        
        Menu app = new Menu(10);
        
        Scanner sc = new Scanner(System.in);
        int op;
        do{
            System.out.println("--- Menu ---");
            System.out.println("1. Cargar item");
            System.out.println("2. Eliminar item");
            System.out.println("3. Mostrar items");
            System.out.println("0. Salir");
            System.out.print("-->");
            op = Integer.parseInt(sc.nextLine());
            switch(op){
                case 1:
                    app.agregarItem();
                    break;
                case 2:
                    app.eliminarItem();
                    break;
                case 3:
                    app.mostrarItems();
                    break;

            }
        }while(op != 0);
    }

}
