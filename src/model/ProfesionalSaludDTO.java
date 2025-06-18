package model;

public class ProfesionalSaludDTO {
    private int idProfesional;
    private String nombre;
    private String especialidad;

    public ProfesionalSaludDTO() {}

    public ProfesionalSaludDTO(int idProfesional, String nombre, String especialidad) {
        this.idProfesional = idProfesional;
        this.nombre = nombre;
        this.especialidad = especialidad;
    }

    public int getIdProfesional() {
        return idProfesional;
    }

    public void setIdProfesional(int idProfesional) {
        this.idProfesional = idProfesional;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }
}
