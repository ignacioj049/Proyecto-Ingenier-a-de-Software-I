import java.util.Date;
import java.util.Random;

public class Comprobante {
    private int idComprobante;
    private Date fecha;
    private String hora; 

    public Comprobante() {
        this.idComprobante = new Random().nextInt(9000) + 1000;
        this.fecha = new Date();
        this.hora = String.format("%tR", this.fecha); 
    }

    public int getId() { return idComprobante; }
    
    @Override
    public String toString() {
        return "Folio #" + idComprobante + " (" + fecha + " " + hora + ")";
    }
}