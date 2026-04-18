package datos;

import utilidades.Consola;

public class Pago {
    private int id;
    private float monto;

    public Pago(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public float getMonto() {
        return monto;
    }

    public void setMonto(float monto) {
        this.monto = monto;
    }
    
    public void cargarDatos(){
        // Sobreescribir
    }
    
    protected float cagarMonto(){
        float fTemp = 0;
        fTemp = Consola.readFloat(0, "Monto del pago: ");
        return fTemp;
    }
}
