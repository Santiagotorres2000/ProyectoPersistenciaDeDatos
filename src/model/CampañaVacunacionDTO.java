package model;

public class CampañaVacunacionDTO {
    private int idCampaña;
    private String nombre;
    private String fechaInicio;
    private String fechaFin;

    public CampañaVacunacionDTO() {}

    public CampañaVacunacionDTO(int idCampaña, String nombre, String fechaInicio, String fechaFin) {
        this.idCampaña = idCampaña;
        this.nombre = nombre;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
    }

    public int getIdCampaña() {
        return idCampaña;
    }

    public void setIdCampaña(int idCampaña) {
        this.idCampaña = idCampaña;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(String fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public String getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(String fechaFin) {
        this.fechaFin = fechaFin;
    }
}