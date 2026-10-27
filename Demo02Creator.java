import java.util.ArrayList;
import java.util.List;

// 2. PATRÓN GRASP: CREATOR (Creador)
// Aplicación en el Hotel: Registro de consumos en la cuenta de la habitación (HU-09)
public class Demo02Creator {

    static class Consumo {
        private String nombreItem;
        private int cantidad;
        private double valorUnitario;

        public Consumo(String nombreItem, int cantidad, double valorUnitario) {
            this.nombreItem = nombreItem;
            this.cantidad = cantidad;
            this.valorUnitario = valorUnitario;
        }

        @Override
        public String toString() {
            return cantidad + "x " + nombreItem + " ($" + (cantidad * valorUnitario) + ")";
        }
    }

    static class CuentaHabitacion {
        private String numeroHabitacion;
        private List<Consumo> consumos = new ArrayList<>();

        public CuentaHabitacion(String numeroHabitacion) {
            this.numeroHabitacion = numeroHabitacion;
        }

        // Creator: CuentaHabitacion contiene y agrega objetos Consumo, por ende ella los instancia
        public void registrarConsumo(String nombreItem, int cantidad, double valorUnitario) {
            Consumo nuevoConsumo = new Consumo(nombreItem, cantidad, valorUnitario);
            this.consumos.add(nuevoConsumo);
            System.out.println("Consumo creado y registrado en Habitación " + numeroHabitacion + ": " + nuevoConsumo);
        }
    }

    public static void main(String[] args) {
        CuentaHabitacion cuenta205 = new CuentaHabitacion("205");
        cuenta205.registrarConsumo("Servicio de Spa", 1, 120000);
    }
}
