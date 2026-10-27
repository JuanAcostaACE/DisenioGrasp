// 8. PATRÓN GRASP: INDIRECTION (Indirección)
// Aplicación en el Hotel: Intermediario para hablar con la pasarela externa PSE (HU-03)
public class Demo08Indirection {

    // Simulación de API bancaria externa con su propio formato
    static class ApiExternaBancoPSE {
        public boolean ejecutarTransaccionBancaria(String referencia, double valor) {
            System.out.println("Conectando con PSE para referencia " + referencia + " por $" + valor);
            return true;
        }
    }

    // Objeto intermediario (Indirección) que evita acoplar Reserva directamente con el banco
    static class AdaptadorPasarelaPSE {
        private ApiExternaBancoPSE apiBanco = new ApiExternaBancoPSE();

        public String procesarPagoReserva(String idReserva, double monto) {
            boolean exito = apiBanco.ejecutarTransaccionBancaria(idReserva, monto);
            return exito ? "Aprobado" : "Rechazado";
        }
    }

    public static void main(String[] args) {
        AdaptadorPasarelaPSE pasarela = new AdaptadorPasarelaPSE();
        String estadoPago = pasarela.procesarPagoReserva("RSV-2026-001", 300000);
        System.out.println("Resultado del pago en el sistema del hotel: " + estadoPago);
    }
}
