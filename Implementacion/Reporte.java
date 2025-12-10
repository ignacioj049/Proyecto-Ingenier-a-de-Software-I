import java.util.Date;

public class Reporte {
    private String observaciones;
    private Date fechaCreacion;

    
    public Reporte(String observaciones) {
        this.observaciones = observaciones;
        this.fechaCreacion = new Date(); // Fecha actual del sistema
    }
    
    public String getObservaciones() {
        return this.observaciones;
    }
}