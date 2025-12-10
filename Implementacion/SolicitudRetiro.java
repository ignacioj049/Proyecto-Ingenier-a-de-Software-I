import java.util.Date;
import java.util.ArrayList;
import java.util.List;
import java.text.SimpleDateFormat;

public class SolicitudRetiro {
    public static List<SolicitudRetiro> repositorioSolicitudes = new ArrayList<>();

    private int idSolicitud;
    private Date fechaRetiro;
    private String estadoRetiro;
    
    private Cliente cliente;
    private Reporte reporte; 
    private Comprobante comprobante; 

    public SolicitudRetiro(int id, Date fecha, Cliente cliente) {
        this.idSolicitud = id;
        this.fechaRetiro = fecha;
        this.cliente = cliente;
        this.estadoRetiro = "Pendiente"; 
        this.reporte = null;
        this.comprobante = null; 
        
        repositorioSolicitudes.add(this);
    }

    public int getId() { return idSolicitud; }
    public Date getFechaRetiro() { return fechaRetiro; }


    public void reportarObs(String observaciones) {
        this.reporte = new Reporte(observaciones);
        
        this.estadoRetiro = "Retirada";
        
        this.comprobante = new Comprobante();
        
        System.out.println("   [Solicitud " + idSolicitud + "] Estado: Retirada. " + 
                           "Reporte creado. Comprobante generado: " + this.comprobante.toString());
    }

    public static void consultarPorFecha(Date fechaBusqueda) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        System.out.println("\n--- RESULTADO CONSULTA (Fecha: " + sdf.format(fechaBusqueda) + ") ---");
        
        for (SolicitudRetiro sol : repositorioSolicitudes) {
            if (esMismaFecha(sol.fechaRetiro, fechaBusqueda)) {
                
                String detalleReporte = (sol.reporte != null) ? sol.reporte.getObservaciones() : "Sin reporte";
                String nombreCliente = sol.cliente.getNombre();
                
                String infoComprobante = (sol.comprobante != null) ? " | " + sol.comprobante.toString() : " | Sin Comprobante";
                
                System.out.println("Solicitud ID: " + sol.idSolicitud + 
                                   " | Cliente: " + nombreCliente +
                                   " | Estado: " + sol.estadoRetiro +
                                   " | Obs: " + detalleReporte +
                                   infoComprobante);
            }
        }
    }
    
    private static boolean esMismaFecha(Date d1, Date d2) {
        SimpleDateFormat fmt = new SimpleDateFormat("yyyyMMdd");
        return fmt.format(d1).equals(fmt.format(d2));
    }
}