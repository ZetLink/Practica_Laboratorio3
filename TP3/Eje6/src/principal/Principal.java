package principal;

import datos.Vuelo;
import utilidades.Consola;

public class Principal {

    private GestorVuelos<Vuelo> gestor = new GestorVuelos<Vuelo>();
    
    private void generarVuelo() {
         String[] tiposMenu = {
             "1. Nacional",
             "2. Internacional",
             "3. Comercial",
             "4. Carga"
         };
         Consola.imprimirMenu(tiposMenu, "Tipo de vuelo");
         int op = Consola.readInt(1, "--> ");
         gestor.agregarVuelo(op);
    }
   
    private void actualizarReservas() {
        int nroVuelo = Consola.readInt(1, "Numero de vuelo: ");
        if (gestor.existeVuelo(nroVuelo) != null) {
            System.out.println("Reservas actuales: " + gestor.existeVuelo(nroVuelo).getDato().consultarReservas());
            int cantidad = Consola.readInt(1, "Cantidad: ");
            String[] opReservas = {
                "1. Registrar reserva", 
                "2. Cancelar reserva" 
            };
            Consola.imprimirMenu(opReservas, "Gestión de reservas");
            int op = 0;
            do{
                switch(op){
                    case 1:
                        gestor.actualizarReservas(nroVuelo, cantidad, false);
                        break;
                    case 2:
                        gestor.actualizarReservas(nroVuelo, cantidad, true);
                        break;
                }
            }while(op != 0);
            
        }else{
            Consola.prtRed("No existe un vuelo con el número " + nroVuelo + ".");
        }
    }
    
    private void imprimirMenuPrincipal() {
        String[] opciones = {
            "1. Generar vuelos",
            "2. Actualizar reservas",
            "3. Informe de vuelos",
            "0. Salir"
        };
        Consola.imprimirMenu(opciones, "Gestion Vuelos");
    }
    
    public void menu(){
        int op;
        do {
            imprimirMenuPrincipal();
            op = Consola.readInt(0, "--> ");
            switch (op) {
                case 1: 
                    generarVuelo();
                    break;
                case 2: 
                    actualizarReservas();
                    break;
                case 3: 
                    gestor.informe();
                    break;
            }
        } while (op != 0);
    }

    public static void main(String[] args) {
        Principal app = new Principal();
        app.menu();
    }
}

