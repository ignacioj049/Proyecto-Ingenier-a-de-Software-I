import java.util.Date;
import java.util.ArrayList;
import java.util.List;

public class Ruta {
    private int idRuta;
    private Date fechaRuta;
    
    private List<SolicitudRetiro> solicitudesAsignadas;

    public Ruta(int id, Date fecha) {
        this.idRuta = id;
        this.fechaRuta = fecha;
        this.solicitudesAsignadas = new ArrayList<>();
    }

    public void agregarSolicitud(SolicitudRetiro s) {
        solicitudesAsignadas.add(s);
    }
    
    public Date getFecha() { return fechaRuta; }

   
    public void reportar(int idSolicitud, String observaciones) {
        System.out.println("  [Ruta " + idRuta + "] Buscando solicitud " + idSolicitud + "...");
        
        SolicitudRetiro solicitudEncontrada = null;
        for (SolicitudRetiro s : solicitudesAsignadas) {
            if (s.getId() == idSolicitud) {
                solicitudEncontrada = s;
                break;
            }
        }

        if (solicitudEncontrada != null) {
            solicitudEncontrada.reportarObs(observaciones);
        } else {
            System.out.println("Error: Solicitud no encontrada en esta ruta.");
        }
    }
}