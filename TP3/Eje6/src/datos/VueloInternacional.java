package datos;

import utilidades.Consola;

public class VueloInternacional extends Vuelo {
    private String pais;

    public VueloInternacional(int nroVuelo) {
        super(nroVuelo);
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    @Override
    public void cargarDatos() {
        super.setOrigen(Consola.readString("Origen: "));
        super.setDestino(Consola.readString("Destino: "));
        super.setMonto(Consola.readFloat(0, "Monto: "));
        super.setCantPlazas(Consola.readInt(0, "Cantidad de Plazas: "));
        this.setPais(Consola.readString("Pais: "));
    }
    
    @Override
    public String getTipo(){
        return "Internacional"; 
    }

    @Override
    public String toString() {
        return super.toString() + String.format("País destino: %s\n", pais);
    }
}
