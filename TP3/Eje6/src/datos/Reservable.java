package datos;

public interface Reservable {

    void registrarReserva(int cantidad);

    void cancelarReserva(int cantidad);

    int consultarReservas();
}
