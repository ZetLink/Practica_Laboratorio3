package datos;

import utilidades.Consola;

public class VueloNacional extends Vuelo {
    private String provincia;

    public VueloNacional(int nroVuelo) {
        super(nroVuelo);
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    @Override
    public void cargarDatos() {
        super.setOrigen(Consola.readString("Origen: "));
        super.setDestino(Consola.readString("Destino: "));
        super.setMonto(Consola.readFloat(0, "Monto: "));
        super.setCantPlazas(Consola.readInt(0, "Cantidad de Plazas: "));
        this.setProvincia(Consola.readString("Provincia: "));
    }

    @Override
    public String getTipo(){ 
        return "Nacional"; 
    }

    @Override
    public String toString() {
        return super.toString() + String.format("Provincia: %s\n", provincia);
    }
}
