public class DatosLinea {

    private String estacion;
    private String contaminante;
    private String fecha;
    private String[] cantidadesMedidas;


    public DatosLinea(String estacion, String contaminante, String fecha, String[] cantidadesMedidas) {
        this.estacion = estacion;
        this.contaminante = contaminante;
        this.fecha = fecha;
        this.cantidadesMedidas = cantidadesMedidas;
    }

    public String getEstacion() {
        return estacion;
    }

    public void setEstacion(String estacion) {
        this.estacion = estacion;
    }

    public String getContaminante() {
        return contaminante;
    }

    public void setContaminante(String contaminante) {
        this.contaminante = contaminante;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String[] getCantidadesMedidas() {
        return cantidadesMedidas;
    }

    public void setCantidadesMedidas(String[] cantidadesMedidas) {
        this.cantidadesMedidas = cantidadesMedidas;
    }
}
