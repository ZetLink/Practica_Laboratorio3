package principal;

/**
 * Alumno: Rojas Ulises Martin
 */

import java.util.Scanner;

public class Racional {
    private int numerador;
    private int denominador;

    public Racional() {
        cargarNumRacional();
        corregirSigno();
        obtenerFormaReducida();
    }

    public Racional(int numerador, int denominador) {
        this.numerador = numerador;
        this.denominador = denominador;
        corregirSigno();
        obtenerFormaReducida();
    }

    public int getNumerador() {
        return numerador;
    }

    private void setNumerador(int numerador) {
        this.numerador = numerador;
    }

    public int getDenominador() {
        return denominador;
    }

    private void setDenominador(int denominador) {
        this.denominador = denominador;
    }
    
    private void cargarNumRacional(){
        setNumerador(cargarInt("Numerador: "));
        setDenominador(cargarInt("Denominador: "));
    }

    private int cargarInt(String msg){
        Scanner sc = new Scanner(System.in);
        int iTemp = 0;
        do{
            System.out.print(msg);
            iTemp = Integer.parseInt(sc.nextLine());
        }while(iTemp == 0);
        return iTemp;
    }
    
//    Pide la carga de una cadena y filtra un Int negativo o positivo 
//    para evitar que se ingresen otros tipos de datos como Float o String.
//    Evitando asi un NumberFormatException.
//    
//    private int cargarInt(String msg){
//        Scanner sc = new Scanner(System.in);
//        String sTemp;
//        int iTemp = 0;
//        do{
//            System.out.print(msg);
//            sTemp = sc.nextLine();
//            if (!sTemp.isEmpty() && sTemp.matches("-?\\d+")) {
//                iTemp = Integer.parseInt(sTemp);
//            } else {
//                System.out.println("Error: Por favor, ingrese un número entero válido.");
//            }
//        }while(iTemp == 0);
//        return iTemp;
//    }
    
    private void corregirSigno(){
        if((getNumerador() < 0) && (getDenominador() < 0)){
            String aux1 = String.valueOf(getNumerador()).substring(1, String.valueOf(getNumerador()).length());
            String aux2 = String.valueOf(getDenominador()).substring(1, String.valueOf(getDenominador()).length());
            setNumerador(Integer.parseInt(aux1));
            setDenominador(Integer.parseInt(aux2));
        } else if(getDenominador() < 0){
            String aux1 = String.valueOf(getDenominador()).substring(1, String.valueOf(getDenominador()).length());
            setDenominador(Integer.parseInt(aux1));
            String aux2 = "-".concat(String.valueOf(getNumerador()));
            setNumerador(Integer.parseInt(aux2));
        }
    }
    
    private void obtenerFormaReducida(){
        int mayor = 0;
        if(getNumerador() > getDenominador()){
            mayor = getNumerador();
        } else {
            mayor = getDenominador();
        }
        for(int i = 1; i <= mayor; i++){
            if((getNumerador() % i == 0) && (getDenominador() % i == 0)){
                setNumerador(getNumerador() / i);
                setDenominador(getDenominador() / i);
            }
        }
        if(getNumerador() % getDenominador() == 0){
            setNumerador(getNumerador() / getDenominador());
            setDenominador(1);
        }
    }
    
    public void multiplicar(Racional x){
        int aux_num = getNumerador() * x.getNumerador();
        int aux_den = getDenominador() * x.getDenominador();
        Racional resul = new Racional(aux_num, aux_den);
        mostrarResultado(resul);
    }
    
    public void dividir(Racional x){
        int aux_num = getNumerador() * x.getDenominador();
        int aux_den = getDenominador() * x.getNumerador();
        Racional resul = new Racional(aux_num, aux_den);
        mostrarResultado(resul);        
    }
    
    private void mostrarResultado(Racional x){
        if(x.getDenominador() != 1){
            System.out.printf("Resultado: %d/%d\n", x.getNumerador(), x.getDenominador());    
        } else {
            System.out.printf("Resultado: %d\n", x.getNumerador());
        }
    }

    @Override
    public String toString() {
        return "Racional{" + "numerador=" + numerador + ", denominador=" + denominador + '}';
    }
    
}