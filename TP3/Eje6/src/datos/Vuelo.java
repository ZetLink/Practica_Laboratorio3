package datos;

import utilidades.Consola;

public abstract class Vuelo implements Reservable, Comparable<Vuelo> {
    private int nroVuelo;
    private String origen;
    private String destino;
    private float monto;
    private int cantPlazas;
    protected int cantReservas;

    public Vuelo(int nroVuelo) {
        this.nroVuelo = nroVuelo;
        this.cantReservas = 0;
    }

    public int getNroVuelo() {
        return nroVuelo;
    }

    public void setNroVuelo(int nroVuelo) {
        this.nroVuelo = nroVuelo;
    }

    public String getOrigen() {
        return origen;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public float getMonto() {
        return monto;
    }

    public void setMonto(float monto) {
        this.monto = monto;
    }

    public int getCantPlazas() {
        return cantPlazas;
    }

    public void setCantPlazas(int cantPlazas) {
        this.cantPlazas = cantPlazas;
    }

    public int getCantReservas() {
        return cantReservas;
    }

    public void setCantReservas(int cantReservas) {
        this.cantReservas = cantReservas;
    }

    @Override
    public void registrarReserva(int cantidad) {
        int plazasLibres = cantPlazas - cantReservas;
        if(cantidad > cantPlazas - cantReservas){
            Consola.prtRed("No hay plazas suficientes. Plazas libres: " + plazasLibres);
        }else{
            this.setCantReservas(this.getCantReservas() + cantidad);
            Consola.prtGreen("Reservas registradas. Plazas libres: " + plazasLibres);
        }
    }

    @Override
    public void cancelarReserva(int cantidad) {
        if (cantidad > cantReservas) {
            Consola.prtRed("No se puede cancelar mas reservas");
        } else {
            this.setCantReservas(this.getCantReservas() - cantidad);
            Consola.prtGreen("Reservas canceladas.");
        }
    }

    @Override
    public int consultarReservas() {
        return this.getCantReservas();
    }
    
    @Override
    public int compareTo(Vuelo t) {
        return Integer.compare(this.nroVuelo, t.nroVuelo);
    }
    
    public abstract void cargarDatos();    
    public abstract String getTipo();


    @Override
    public String toString() {
        return String.format("*** Número de vuelo: %d\nOrigen: %-20s\nDestino: %s\nMonto: %-22.2f\nCantidad de plazas: %-6d\nReservas: %d\n",
                nroVuelo,origen, destino,monto, cantPlazas, cantReservas);
    }
}
