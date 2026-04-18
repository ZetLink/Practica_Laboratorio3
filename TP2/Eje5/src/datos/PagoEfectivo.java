package datos;

import utilidades.Consola;

public class PagoEfectivo extends Pago{
    private float dineroEntregado;

    public PagoEfectivo(int id) {
        super(id);
        this.dineroEntregado = 0;
    }

    public float getDineroPagado() {
        return dineroEntregado;
    }

    public void setDineroPagado(float dineroPagado) {
        this.dineroEntregado = dineroPagado;
    }
    
    @Override
    public void cargarDatos(){
        setMonto(super.cagarMonto());
        setDineroPagado(cargarEntreado());
    }
    
    private float cargarEntreado(){
        float fTemp = 0;
        fTemp = Consola.readFloat(0, "Cantidad de Dinero a Entregar: ");
        return fTemp;
    }
    
    public void mostrarDatos(){
        String formato = "ID: %s\nMonto: %s\nDinero Entregado: %s\n\n";
        if(this.getDineroPagado() >= this.getMonto()){
            System.out.format(formato, this.getId(), this.getMonto(), this.getDineroPagado());
        } else {
            System.out.println("ID: " + this.getId() + "\nDinero insuficiente para realizar el pago\n");
        }
    }
}
