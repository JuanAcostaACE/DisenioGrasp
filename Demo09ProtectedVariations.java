// 9. PATRÓN GRASP: PROTECTED VARIATIONS (Variaciones Protegidas)
// Aplicación en el Hotel: Protección ante cambios en las leyes de impuestos locales por sede (HU-12)
public class Demo09ProtectedVariations {

    // Punto de variación inestable encapsulado en una interfaz
    interface CalculadoraImpuestoLocal {
        double calcularImpuesto(double subtotalCuenta);
    }

    static class ImpuestoSedeNacional implements CalculadoraImpuestoLocal {
        @Override
        public double calcularImpuesto(double subtotalCuenta) {
            return subtotalCuenta * 0.19; // IVA estándar 19%
        }
    }

    static class ImpuestoZonaFrancaTuristica implements CalculadoraImpuestoLocal {
        @Override
        public double calcularImpuesto(double subtotalCuenta) {
            return subtotalCuenta * 0.05; // Tarifa diferencial 5%
        }
    }

    static class Factura {
        private double subtotal;
        // La clase Factura está blindada frente a reformas tributarias o cambios por sede
        private CalculadoraImpuestoLocal reglaImpuesto;

        public Factura(double subtotal, CalculadoraImpuestoLocal reglaImpuesto) {
            this.subtotal = subtotal;
            this.reglaImpuesto = reglaImpuesto;
        }

        public double obtenerTotalConImpuestos() {
            return subtotal + reglaImpuesto.calcularImpuesto(subtotal);
        }
    }

    public static void main(String[] args) {
        Factura facturaNorte = new Factura(500000, new ImpuestoSedeNacional());
        Factura facturaSur = new Factura(500000, new ImpuestoZonaFrancaTuristica());

        System.out.println("Total Factura Sede Norte (IVA 19%): $" + facturaNorte.obtenerTotalConImpuestos());
        System.out.println("Total Factura Sede Sur (Zona Turística 5%): $" + facturaSur.obtenerTotalConImpuestos());
    }
}
