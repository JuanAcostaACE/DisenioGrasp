import java.util.ArrayList;
import java.util.List;

// 1. PATRÓN GRASP: INFORMATION EXPERT (Experto en Información)
// Aplicación en el Hotel: Cálculo del total de la cuenta en el Check-out (HU-10)
public class Demo01InformationExpert {

    static class Consumo {
        private String item;
        private int cantidad;
        private double valorUnitario;

        public Consumo(String item, int cantidad, double valorUnitario) {
            this.item = item;
            this.cantidad = cantidad;
            this.valorUnitario = valorUnitario;
        }

        public double getSubtotal() {
            return cantidad * valorUnitario;
        }
    }

    static class Reserva {
        private int noches;
        private double precioPorNoche;
        private List<Consumo> consumos = new ArrayList<>();

        public Reserva(int noches, double precioPorNoche) {
            this.noches = noches;
            this.precioPorNoche = precioPorNoche;
        }

        public void agregarConsumo(Consumo c) {
            this.consumos.add(c);
        }

        // Reserva es la experta: posee las noches, la tarifa y la lista de consumos
        public double calcularTotalCuenta() {
            double totalEstadia = noches * precioPorNoche;
            double totalConsumos = 0;
            for (Consumo c : consumos) {
                totalConsumos += c.getSubtotal();
            }
            return totalEstadia + totalConsumos;
        }
    }

    public static void main(String[] args) {
        Reserva reserva = new Reserva(3, 150000);
        reserva.agregarConsumo(new Consumo("Minibar - Agua", 2, 5000));
        reserva.agregarConsumo(new Consumo("Restaurante - Almuerzo", 1, 35000));
        System.out.println("Total a cobrar en Check-out: $" + reserva.calcularTotalCuenta());
    }
}
