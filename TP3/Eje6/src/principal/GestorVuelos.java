package principal;

import datos.*;
import lista.LSEO;
import lista.Nodo;
import utilidades.Consola;

public class GestorVuelos<T extends Vuelo> {

    private LSEO<Vuelo> vuelos;

    public GestorVuelos() {
        vuelos = new LSEO<Vuelo>();
    }

    public void agregarVuelo(int tipo){
        int nroVuelo = validarNumeroV();
        Vuelo vuelo = null;
        switch(tipo) {
            case 1:
                vuelo = new VueloNacional(nroVuelo);
                break;
            case 2:
                vuelo = new VueloInternacional(nroVuelo);
                break;
            case 3:
                vuelo = new VueloComercial(nroVuelo);
                break;
            case 4:
                vuelo = new VueloCarga(nroVuelo);
                break;
        }
        vuelo.cargarDatos();
        vuelos.insertar(vuelo);
        Consola.prtGreen("Vuelo " + vuelo.getNroVuelo() + " (" + vuelo.getTipo() + ") agregado");
    }

    public void actualizarReservas(int nroVuelo, int cantidad, boolean esCancelacion) {
        Nodo<Vuelo> nodo = existeVuelo(nroVuelo);
        Vuelo vuelo = nodo.getDato();
        if (nodo != null && esCancelacion) {
            vuelo.cancelarReserva(cantidad);
        }else if(nodo != null && !esCancelacion){
            vuelo.registrarReserva(cantidad);
        }else{
            Consola.prtRed("Error: no existe un vuelo con el número " + nroVuelo + ".");
        }
    }

    public void informe() {
        if (vuelos.listaVacia()) {
            Consola.prtYellow("No hay vuelos registrados en el sistema.");
            return;
        }
        System.out.println();
        Nodo<Vuelo> p = vuelos.inicio();
        while (p != null) {
            System.out.println(p.getDato().toString());
            System.out.println();
            p = p.getPs();
        }
    }
    
    private int validarNumeroV(){
        int iTemp = 0;
        Nodo<Vuelo> busc = null;
        do{
            iTemp = Consola.readInt(0, "Numero de Vuelo: ");
            busc = existeVuelo(iTemp);
            if(busc != null){
                Consola.prtRed("Numero de vuelo existente. Ingrese otro...");
            }
        }while(busc != null);
        return iTemp;
    }

    public Nodo<Vuelo> existeVuelo(int nroVuelo) {
        Nodo<Vuelo> p = vuelos.inicio();
        boolean b = false;
        while (!b && p != null) {
            if (p.getDato().getNroVuelo() == nroVuelo) {
                b = true;
            }else{
                p = p.getPs();
            }
        }
        return p;
    }
}
