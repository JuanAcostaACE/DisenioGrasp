// 4. PATRÓN GRASP: LOW COUPLING (Bajo Acoplamiento)
// Aplicación en el Hotel: Envío de comprobantes sin acoplarse a un proveedor de correo fijo (HU-05)
public class Demo04LowCoupling {

    // Interfaz que desacopla el negocio del mecanismo de envío
    interface CanalNotificacion {
        void enviarComprobante(String destinatario, String mensaje);
    }

    static class NotificadorEmail implements CanalNotificacion {
        @Override
        public void enviarComprobante(String destinatario, String mensaje) {
            System.out.println("[Email enviado a " + destinatario + "]: " + mensaje);
        }
    }

    static class ReservaService {
        // Bajo acoplamiento: depende de la abstracción (interfaz), no de la clase concreta
        private CanalNotificacion notificador;

        public ReservaService(CanalNotificacion notificador) {
            this.notificador = notificador;
        }

        public void confirmarReserva(String emailCliente, String idReserva) {
            notificador.enviarComprobante(emailCliente, "Su reserva " + idReserva + " ha sido confirmada con código QR.");
        }
    }

    public static void main(String[] args) {
        CanalNotificacion canal = new NotificadorEmail();
        ReservaService servicio = new ReservaService(canal);
        servicio.confirmarReserva("huesped@correo.com", "RSV-2026-009");
    }
}
