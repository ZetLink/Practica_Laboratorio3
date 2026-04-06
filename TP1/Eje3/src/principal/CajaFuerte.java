package principal;

/**
 * Alumno: Rojas Ulises Martin
 */

import java.util.Scanner;

public class CajaFuerte {
    private int clave;
    private boolean creada;

    public CajaFuerte() {
        this.creada = false;
    }

    public int getClave() {
        return clave;
    }

    public void setClave(int clave) {
        this.clave = clave;
    }

    public boolean isCreada() {
        return creada;
    }

    public void setCreada(boolean creada) {
        this.creada = creada;
    }
    
    public void crearCajaFuerte(){
        setClave(cargarInt("Clave para la caja fuerte: "));
        setCreada(true);
        System.out.println("--- Caja creada ---");
    }
    
    private int cargarInt(String msg){
        Scanner sc = new Scanner(System.in);
        int iTemp = 0;
        do{
            System.out.print(msg);
            iTemp = Integer.parseInt(sc.nextLine());
        }while(iTemp < 100 || iTemp > 999);
        return iTemp;
    }
    
    public void abrirCajaFuerte(){
        Scanner sc = new Scanner(System.in);
        char op = 's';
        int iTemp = 0, intento = 1;
        while(op == 's' && intento <= 3){
            System.out.print("Ingrese la clave (Intento " + intento + "): ");
            iTemp = Integer.parseInt(sc.nextLine());
            if(iTemp == getClave()){
                System.out.println("--- Caja Abierta ---");
                System.out.println("Contenido: \u001B[41mNada\u001B[0m\n");
                op = 'n';
            } else {
                if(intento != 3){
                    System.out.print("Clave incorrecta, volver a intentar (S/N): ");
                    op = sc.nextLine().toLowerCase().charAt(0);
                }
                intento++;
            }
        }
    }
    
    public void cambiarClave(){
        Scanner sc = new Scanner(System.in);
        char op = 's';
        int iTemp = 0, intento = 1;
        while(op == 's' && intento <= 3){
            System.out.print("Ingrese la clave (Intento " + intento + "): ");
            iTemp = Integer.parseInt(sc.nextLine());
            if(iTemp == getClave()){
                setClave(cargarInt("Nueva clave para la caja fuerte: "));
                System.out.println("--- Clave actualizada ---");
                op = 'n';
            } else {
                if(intento != 3){
                    System.out.print("Clave incorrecta, volver a intentar (S/N): ");
                    op = sc.nextLine().toLowerCase().charAt(0);
                }
                intento++;
            }
        }
    }
}
