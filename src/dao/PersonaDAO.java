package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import model.PersonaDTO;

public class PersonaDAO {
    private Connection conn;

    public PersonaDAO(Connection conn) {
        this.conn = conn;
    }

    // Insertar persona
    // public void insertarPersona(PersonaDTO persona) throws SQLException {
    //     String sql = "INSERT INTO persona (id_persona, nombre, cedula, edad) VALUES (?, ?, ?, ?)";
    //     PreparedStatement stmt = conn.prepareStatement(sql);
    //     stmt.setInt(1, persona.getIdPersona());
    //     stmt.setString(2, persona.getNombre());
    //     stmt.setString(3, persona.getCedula());
    //     stmt.setInt(4, persona.getEdad());
    //     stmt.executeUpdate();
    //     stmt.close();
    // }

    // Obtener todas las personas
    public List<PersonaDTO> obtenerPersonas() throws SQLException {
        List<PersonaDTO> lista = new ArrayList<>();
        String sql = "SELECT * FROM persona";
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(sql);
        while (rs.next()) {
            PersonaDTO persona = new PersonaDTO(
                rs.getInt("id_persona"),
                rs.getString("nombre"),
                rs.getString("cedula"),
                rs.getInt("edad")
            );
            lista.add(persona);
        }
        rs.close();
        stmt.close();
        return lista;
    }

    // Actualizar edad de una persona
    public void actualizarEdad(int idPersona, int nuevaEdad) throws SQLException {
        String sql = "UPDATE persona SET edad = ? WHERE id_persona = ?";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setInt(1, nuevaEdad);
        stmt.setInt(2, idPersona);
        stmt.executeUpdate();
        stmt.close();
    }
    public List<String> obtenerNombresPersonas() throws SQLException {
    List<String> lista = new ArrayList<>();
    String sql = "SELECT nombre FROM persona";
    Statement stmt = conn.createStatement();
    ResultSet rs = stmt.executeQuery(sql);
    while (rs.next()) {
        lista.add(rs.getString("nombre"));
    }
    rs.close();
    stmt.close();
    return lista;
}
public List<String> obtenerNombresUnificados() throws SQLException {
    List<String> lista = new ArrayList<>();
    String sql = """
        SELECT nombre FROM persona
        UNION
        SELECT nombre FROM profesional_salud
    """;
    Statement stmt = conn.createStatement();
    ResultSet rs = stmt.executeQuery(sql);
    while (rs.next()) {
        lista.add(rs.getString("nombre"));
    }
    rs.close();
    stmt.close();
    return lista;
}
public List<PersonaDTO> obtenerMayoresDe60() throws SQLException {
    List<PersonaDTO> lista = new ArrayList<>();
    String sql = "SELECT * FROM persona WHERE edad > 60";
    Statement stmt = conn.createStatement();
    ResultSet rs = stmt.executeQuery(sql);
    while (rs.next()) {
        lista.add(new PersonaDTO(
            rs.getInt("id_persona"),
            rs.getString("nombre"),
            rs.getString("cedula"),
            rs.getInt("edad")
        ));
    }
    rs.close();
    stmt.close();
    return lista;
}

}
