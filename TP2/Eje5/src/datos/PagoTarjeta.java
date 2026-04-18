package datos;

import utilidades.Consola;

public class PagoTarjeta extends Pago{
    private long nroTarjeta;
    private int cantCuotas;

    public PagoTarjeta(int id) {
        super(id);
        this.nroTarjeta = 0;
        this.cantCuotas = 0;
    }

    public long getNroTarjeta() {
        return nroTarjeta;
    }

    public void setNroTarjeta(long nroTarjeta) {
        this.nroTarjeta = nroTarjeta;
    }

    public int getCantCuotas() {
        return cantCuotas;
    }

    public void setCantCuotas(int cantCuotas) {
        this.cantCuotas = cantCuotas;
    }
    
    @Override
    public void cargarDatos(){
        setMonto(super.cagarMonto());
        setNroTarjeta(cargarTarjeta());
        setCantCuotas(cargarCuotas());
    }
    
    private long cargarTarjeta(){
        String sTemp = "";
        do{
            sTemp = Consola.readString("Numero de Tarjeta: ");
        }while(!sTemp.matches("\\d+") || sTemp.length() < 16 || sTemp.length() > 16);
        long lTemp = Long.parseLong(sTemp);
        return lTemp;
    }
    
    private int cargarCuotas(){
        int iTemp = 0;
        iTemp = Consola.readInt(0, "Cantidad de Cuotas: ");
        return iTemp;
    }
    
    public void mostrarDatos(){
        String formato = "ID: %s\nMonto: %s\nNumero de Tarjeta: %s\nCantidad de Cuotas: %s\n\n";
        System.out.format(formato, this.getId(), this.getMonto(),
                this.getNroTarjeta(), this.getCantCuotas());
    }
}
