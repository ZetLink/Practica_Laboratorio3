package principal;

/**
 * Alumno: Rojas Ulises Martin
 */

import java.util.Scanner;

public class Principal {

    CajaFuerte cf = new CajaFuerte();
    
    public void menu(){
        Scanner sc = new Scanner(System.in);
        int op;
        do{
            System.out.println("--- Menu ---");
            System.out.println("1. Crear caja fuerte");
            System.out.println("2. Abrir caja fuerte");
            System.out.println("3. Cambiar clave");
            System.out.println("0. Salir");
            System.out.print("-->");
            op = Integer.parseInt(sc.nextLine());
            switch(op){
                case 1:
                    if(!cf.isCreada()){
                        cf.crearCajaFuerte();
                    } else {
                        System.out.println("Ya fue creada la caja fuerte");
                    }
                    break;
                case 2:
                    if(cf.isCreada()){
                        cf.abrirCajaFuerte();
                    } else {
                        System.out.println("Primero debe crear la caja fuerte");
                    }
                    break;
                case 3:
                    if(cf.isCreada()){
                        cf.cambiarClave();
                    } else {
                        System.out.println("Primero debe crear la caja fuerte");
                    }
                    break;

            }
        }while(op != 0);
    }
    
    public static void main(String[] args) {
        Principal app = new Principal();
        app.menu();
    }

}
