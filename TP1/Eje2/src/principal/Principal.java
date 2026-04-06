package principal;

/**
 * Alumno: Rojas Ulises Martin
 */

import java.util.Scanner;

public class Principal {
    
    Racional r1, r2;
    boolean cargado = false;
    
    public void menu(){
        Scanner sc = new Scanner(System.in);
        int op;
        do{
            System.out.println("--- Menu ---");
            System.out.println("1. Ingresar racionales");
            System.out.println("2. Operar multiplicacion");
            System.out.println("3. Operar division");
            System.out.println("0. Salir");
            System.out.print("-->");
            op = Integer.parseInt(sc.nextLine());
            switch(op){
                case 1:
                    if(!cargado){
                        r1 = new Racional();
                        r2 = new Racional();   
                        cargado = true;
                    } else {
                        System.out.println("Racionales ya cargados");
                    }
                    break;
                case 2:
                    if(cargado){
                        r1.multiplicar(r2);
                    } else {
                        System.out.println("Primero cague los numeros raciones");
                    }
                    break;
                case 3:
                    if(cargado){
                        r1.dividir(r2);
                    } else {
                        System.out.println("Primero cague los numeros raciones");
                    }
                    break;
//                case 4:
//                    System.out.println(r1.toString());
//                    System.out.println(r2.toString());
//                    break;

            }
        }while(op != 0);
    }
    
    public static void main(String[] args) {
        Principal app = new Principal();
        app.menu();
    }

}