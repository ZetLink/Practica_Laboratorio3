package datos;

import utilidades.Consola;

public class VueloComercial extends Vuelo {
    private String aerolinea;

    public VueloComercial(int nroVuelo) {
        super(nroVuelo);
    }

    public String getAerolinea() {
        return aerolinea;
    }

    public void setAerolinea(String aerolinea) {
        this.aerolinea = aerolinea;
    }

    @Override
    public void cargarDatos() {
        super.setOrigen(Consola.readString("Origen: "));
        super.setDestino(Consola.readString("Destino: "));
        super.setMonto(Consola.readFloat(0, "Monto: "));
        super.setCantPlazas(Consola.readInt(0, "Cantidad de Plazas: "));
        this.setAerolinea(Consola.readString("Aerolinea: "));
    }
    
    @Override
    public String getTipo(){ 
        return "Comercial"; 
    }

    @Override
    public String toString() {
        return super.toString()
             + String.format("Aerolínea: %s\n", aerolinea);
    }
}
