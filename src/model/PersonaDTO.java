package model;

public class PersonaDTO {
    private int idPersona;
    private String nombre;
    private String cedula;
    private int edad;

    // Constructor vacío
    public PersonaDTO() {}

    // Constructor con parámetros
    public PersonaDTO(int idPersona, String nombre, String cedula, int edad) {
        this.idPersona = idPersona;
        this.nombre = nombre;
        this.cedula = cedula;
        this.edad = edad;
    }

    // Getters y Setters
    public int getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(int idPersona) {
        this.idPersona = idPersona;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }
}