// 3. PATRÓN GRASP: CONTROLLER (Controlador)
// Aplicación en el Hotel: Coordinación del evento de Check-in desde el mostrador (HU-08)
public class Demo03Controller {

    static class Reserva {
        private String id;
        private String estado; // Pagada, En curso

        public Reserva(String id, String estado) {
            this.id = id;
            this.estado = estado;
        }

        public String getEstado() { return estado; }
        public void activarEstadia() { this.estado = "En curso"; }
    }

    static class ReservaService {
        public Reserva buscarPorId(String idReserva) {
            return new Reserva(idReserva, "Pagada");
        }
    }

    static class CheckInController {
        private ReservaService reservaService = new ReservaService();

        // Controller: Recibe el evento de la UI y coordina la lógica delegando al modelo
        public String procesarEventoCheckIn(String idReserva) {
            Reserva reserva = reservaService.buscarPorId(idReserva);

            if (!reserva.getEstado().equals("Pagada")) {
                return "Error: No se puede realizar el check-in, la reserva no está en estado Pagada.";
            }

            reserva.activarEstadia();
            return "Check-in registrado exitosamente para la reserva " + idReserva + ". Estado actual: " + reserva.getEstado();
        }
    }

    public static void main(String[] args) {
        CheckInController controller = new CheckInController();
        System.out.println(controller.procesarEventoCheckIn("RSV-20261001-001"));
    }
}
