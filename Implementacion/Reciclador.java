import java.util.Date;
import java.util.ArrayList;
import java.util.List;
import java.text.SimpleDateFormat;

public class Reciclador {
    private String rut;
    private String nombre;
    
    private List<Ruta> historialRutas;

    public Reciclador(String rut, String nombre) {
        this.rut = rut;
        this.nombre = nombre;
        this.historialRutas = new ArrayList<>();
    }

    public void asignarRuta(Ruta r) {
        historialRutas.add(r);
    }

    
    public void reportarResultado(int idSolicitud, String observaciones) {
        System.out.println("[Reciclador " + nombre + "] Iniciando reporte...");
        Date hoy = new Date();
        
        Ruta rutaDeHoy = null;
        SimpleDateFormat fmt = new SimpleDateFormat("yyyyMMdd");
        
        for (Ruta r : historialRutas) {
            if (fmt.format(r.getFecha()).equals(fmt.format(hoy))) {
                rutaDeHoy = r;
                break;
            }
        }

        if (rutaDeHoy != null) {
            rutaDeHoy.reportar(idSolicitud, observaciones);
        } else {
            System.out.println("Error: No hay ruta asignada para hoy.");
        }
    }
}