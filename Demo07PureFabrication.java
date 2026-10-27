// 7. PATRÓN GRASP: PURE FABRICATION (Fabricación Pura)
// Aplicación en el Hotel: Generación de documentos PDF y códigos QR (HU-05 y HU-12)
public class Demo07PureFabrication {

    // Fabricación Pura: Clase artificial que no pertenece al dominio hotelero real,
    // creada para no ensuciar la clase Reserva con lógica de bytes y PDFs.
    static class GeneradorPdfQR {

        public byte[] generarComprobante(String idReserva, String nombreHuesped) {
            String codigoQR = "[QR_CODE:" + idReserva + "]";
            String contenidoPdf = "COMPROBANTE OFICIAL | Reserva: " + idReserva +
                                  " | Huésped: " + nombreHuesped + " | " + codigoQR;
            return contenidoPdf.getBytes();
        }
    }

    public static void main(String[] args) {
        GeneradorPdfQR generador = new GeneradorPdfQR();
        byte[] pdfBytes = generador.generarComprobante("RSV-20261001-001", "Juan David Acosta");
        System.out.println("PDF generado en memoria (" + pdfBytes.length + " bytes): " + new String(pdfBytes));
    }
}
