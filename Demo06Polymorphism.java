// 6. PATRÓN GRASP: POLYMORPHISM (Polimorfismo)
// Aplicación en el Hotel: Políticas de reembolso por cancelación (>48h vs <48h) (HU-04)
public class Demo06Polymorphism {

    interface PoliticaReembolso {
        double calcularReembolso(double totalPagado, double valorUnaNoche);
    }

    // Cancelación con más de 48 horas de anticipación
    static class ReembolsoTotal implements PoliticaReembolso {
        @Override
        public double calcularReembolso(double totalPagado, double valorUnaNoche) {
            return totalPagado; // 100% de devolución
        }
    }

    // Cancelación con menos de 48 horas de anticipación (Penalidad de 1 noche)
    static class ReembolsoConPenalidad implements PoliticaReembolso {
        @Override
        public double calcularReembolso(double totalPagado, double valorUnaNoche) {
            return totalPagado - valorUnaNoche;
        }
    }

    public static void main(String[] args) {
        PoliticaReembolso politicaTemprana = new ReembolsoTotal();
        PoliticaReembolso politicaTardia = new ReembolsoConPenalidad();

        System.out.println("Reembolso (>48h): $" + politicaTemprana.calcularReembolso(450000, 150000));
        System.out.println("Reembolso (<48h): $" + politicaTardia.calcularReembolso(450000, 150000));
    }
}
