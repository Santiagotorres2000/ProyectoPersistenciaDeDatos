package model;

public class RegistroVacunacionDTO {
    private int idRegistro;
    private int idPersona;
    private int idProfesional;
    private int idCampania;
    private String fecha;
    private String vacuna;

    public RegistroVacunacionDTO() {}

    public RegistroVacunacionDTO(int idRegistro, int idPersona, int idProfesional, int idCampania, String fecha, String vacuna) {
        this.idRegistro = idRegistro;
        this.idPersona = idPersona;
        this.idProfesional = idProfesional;
        this.idCampania = idCampania;
        this.fecha = fecha;
        this.vacuna = vacuna;
    }

    public int getIdRegistro() { return idRegistro; }
    public void setIdRegistro(int idRegistro) { this.idRegistro = idRegistro; }

    public int getIdPersona() { return idPersona; }
    public void setIdPersona(int idPersona) { this.idPersona = idPersona; }

    public int getIdProfesional() { return idProfesional; }
    public void setIdProfesional(int idProfesional) { this.idProfesional = idProfesional; }

    public int getIdCampania() { return idCampania; }
    public void setIdCampania(int idCampania) { this.idCampania = idCampania; }

    public String getFecha() { return fecha; }
    public void setFecha(String fecha) { this.fecha = fecha; }

    public String getVacuna() { return vacuna; }
    public void setVacuna(String vacuna) { this.vacuna = vacuna; }
}