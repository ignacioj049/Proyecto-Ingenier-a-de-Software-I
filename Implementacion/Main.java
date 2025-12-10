import java.util.Date;

public class Main {
    public static void main(String[] args) {
        Date fechaHoy = new Date();
        
        Cliente cliente1 = new Cliente(101, "Maria Gonzalez", "Calle Falsa 123");
        Cliente cliente2 = new Cliente(102, "Carlos Perez", "Av. Siempre Viva 742");
        Reciclador reciclador = new Reciclador("11.222.333-K", "Juan Recicla");
        
        SolicitudRetiro sol1 = new SolicitudRetiro(500, fechaHoy, cliente1);
        SolicitudRetiro sol2 = new SolicitudRetiro(501, fechaHoy, cliente2);
        
        Ruta rutaHoy = new Ruta(1, fechaHoy);
        rutaHoy.agregarSolicitud(sol1);
        rutaHoy.agregarSolicitud(sol2);
        
        reciclador.asignarRuta(rutaHoy);

        System.out.println(">>> INICIO FLUJO: Reciclador reporta un retiro <<<");
        reciclador.reportarResultado(500, "Retiro exitoso de 5kg de vidrio.");
        
        
        System.out.println("\n>>> INICIO FLUJO: Sistema consulta retiros del día <<<");
        SolicitudRetiro.consultarPorFecha(fechaHoy);
    }
}