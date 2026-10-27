// 5. PATRÓN GRASP: HIGH COHESION (Alta Cohesión)
// Aplicación en el Hotel: Gestión exclusiva del estado físico de la habitación (HU-11 y HU-15)
public class Demo05HighCohesion {

    static class Habitacion {
        private String numero;
        private String estado; // Disponible, Ocupada, En Limpieza, Mantenimiento

        public Habitacion(String numero) {
            this.numero = numero;
            this.estado = "Disponible";
        }

        // Alta Cohesión: Todos los métodos operan estrictamente sobre el ciclo de estado físico
        public void ocupar() {
            this.estado = "Ocupada";
        }

        public void enviarALimpieza() {
            this.estado = "En Limpieza";
        }

        public void habilitarDisponible() {
            this.estado = "Disponible";
        }

        public String getEstado() {
            return estado;
        }
    }

    public static void main(String[] args) {
        Habitacion hab205 = new Habitacion("205");
        hab205.ocupar();
        System.out.println("Tras Check-in: " + hab205.getEstado());
        hab205.enviarALimpieza();
        System.out.println("Tras Check-out: " + hab205.getEstado());
        hab205.habilitarDisponible();
        System.out.println("Tras Housekeeping: " + hab205.getEstado());
    }
}
