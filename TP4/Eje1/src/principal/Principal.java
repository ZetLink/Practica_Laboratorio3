package principal;

import datos.Empleado;
import exceptions.DniInvalidoException;
import lista.LSEO;
import lista.Nodo;
import utilidades.Consola;
import exceptions.EmpleadoException;

public class Principal {

    private final LSEO empleados;

    public Principal() {
        this.empleados = new LSEO<Empleado>();
    }
    
    private void agregarDatos() throws EmpleadoException {
        do {
            int dni = 0;
            boolean dniValido = false;
            while (!dniValido) {
                try {
                    dni = validarDNI();
                    dniValido = true; 
                } catch (EmpleadoException e) {
                    System.err.println("Error: " + e.getMessage());
                    System.out.println("Ingrese nuevamente el DNI...");
                }
            }
            Empleado eTemp = new Empleado(dni);
            eTemp.cargarDatos();
            empleados.insertar(eTemp);
        }while(Consola.continuar("Agregar otro empleado? (S/N): "));
    }
    
    private int validarDNI() throws EmpleadoException {
        int iTemp = 0;
        do{
            iTemp = Consola.readInt(0, "DNI del Empleado: ");
        }while(empleados.buscar(new Empleado(iTemp)));
        if(iTemp > 99999999 || iTemp < 1000000){
            throw new DniInvalidoException("El DNI debe tener 7 u 8 digitos.");
        }
        return iTemp;
    }
    
    private void mostrarLista(){
        if(!empleados.listaVacia()){
            Nodo p = empleados.inicio();
            while(p != null){
                Empleado eTemp = (Empleado) p.getDato();
                eTemp.mostrarDatos();
                p = p.getPs();
            }
        }else{
            Consola.prtRed("Lista Vacia");
        }
    }
    
    public void menu() throws EmpleadoException{
        String titulo = "Menu Empleados";
        String[] opciones = {
            "1. Registrar empleado",
            "2. Mostrar empleados",
            "0. Salir"
        };
        int op;
        do{
            Consola.imprimirMenu(opciones, titulo);
            op = Consola.readInt(0, "--> ");
            switch(op){
                case 1:
                    agregarDatos();
                    break;
                case 2:
                    mostrarLista();
                    break;
            }
        }while(op != 0);
    }
    
    public static void main(String[] args) throws EmpleadoException {
        Principal app = new Principal();
        app.menu();
    }
    
}
