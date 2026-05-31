package datos;

import utilidades.Consola;

public class VueloCarga extends Vuelo {
    private float pesoMax;

    public VueloCarga(int nroVuelo) {
        super(nroVuelo);
    }

    public float getPesoMax() {
        return pesoMax;
    }

    public void setPesoMax(float pesoMax) {
        this.pesoMax = pesoMax;
    }
    
    @Override
    public void cargarDatos(){
        super.setOrigen(Consola.readString("Origen: "));
        super.setDestino(Consola.readString("Destino: "));
        super.setMonto(Consola.readFloat(0, "Monto: "));
        super.setCantPlazas(Consola.readInt(0, "Cantidad de Plazas: "));
        this.setPesoMax(Consola.readFloat(0, "Peso Maximo (Kg): "));
    }

    @Override
    public String getTipo(){ 
        return "Carga"; 
    }

    @Override
    public String toString(){
        return super.toString() + String.format("Peso maximo: %.2f kg\n", pesoMax);
    }
}
