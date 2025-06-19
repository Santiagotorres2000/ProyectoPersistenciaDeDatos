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

    // INSERTAR persona
    public int insertarPersona(PersonaDTO p) throws SQLException {
        String sql = "INSERT INTO persona (nombre, cedula, edad, genero, direccion) VALUES (?, ?, ?, ?, ?)";
        PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        stmt.setString(1, p.getNombre());
        stmt.setString(2, p.getCedula());
        stmt.setInt(3, p.getEdad());
        stmt.setString(4, p.getGenero());
        stmt.setString(5, p.getDireccion());

        int filas = stmt.executeUpdate();
        ResultSet rs = stmt.getGeneratedKeys();
        if (rs.next()) {
            p.setIdPersona(rs.getInt(1)); // ID auto generado
        }

        stmt.close();
        return filas;
    }

    // OBTENER todas las personas
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
                rs.getInt("edad"),
                rs.getString("genero"),
                rs.getString("direccion")
            );
            lista.add(persona);
        }

        rs.close();
        stmt.close();
        return lista;
    }

    // ACTUALIZAR persona
    public int actualizarPersona(PersonaDTO p) throws SQLException {
        String sql = "UPDATE persona SET nombre = ?, cedula = ?, edad = ?, genero = ?, direccion = ? WHERE id_persona = ?";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setString(1, p.getNombre());
        stmt.setString(2, p.getCedula());
        stmt.setInt(3, p.getEdad());
        stmt.setString(4, p.getGenero());
        stmt.setString(5, p.getDireccion());
        stmt.setInt(6, p.getIdPersona());

        int filas = stmt.executeUpdate();
        stmt.close();
        return filas;
    }

    // ELIMINAR persona
    public int eliminarPersona(int idPersona) throws SQLException {
        String sql = "DELETE FROM persona WHERE id_persona = ?";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setInt(1, idPersona);

        int filas = stmt.executeUpdate();
        stmt.close();
        return filas;
    }

    // BUSCAR persona por ID
    public PersonaDTO buscarPorId(int id) throws SQLException {
        String sql = "SELECT * FROM persona WHERE id_persona = ?";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setInt(1, id);
        ResultSet rs = stmt.executeQuery();

        PersonaDTO persona = null;
        if (rs.next()) {
            persona = new PersonaDTO(
                rs.getInt("id_persona"),
                rs.getString("nombre"),
                rs.getString("cedula"),
                rs.getInt("edad"),
                rs.getString("genero"),
                rs.getString("direccion")
            );
        }

        rs.close();
        stmt.close();
        return persona;
    }
    public List<PersonaDTO> obtenerMayoresDe60() throws SQLException {
    List<PersonaDTO> lista = new ArrayList<>();
    String sql = "SELECT * FROM persona WHERE edad >= 60";
    Statement stmt = conn.createStatement();
    ResultSet rs = stmt.executeQuery(sql);

    while (rs.next()) {
        PersonaDTO persona = new PersonaDTO(
            rs.getInt("id_persona"),
            rs.getString("nombre"),
            rs.getString("cedula"),
            rs.getInt("edad"),
            rs.getString("genero"),
            rs.getString("direccion")
        );
        lista.add(persona);
    }

    rs.close();
    stmt.close();
    return lista;
}
public List<String> obtenerNombresUnificados() throws SQLException {
    List<String> nombres = new ArrayList<>();
    String sql = "SELECT DISTINCT nombre FROM persona";
    Statement stmt = conn.createStatement();
    ResultSet rs = stmt.executeQuery(sql);

    while (rs.next()) {
        nombres.add(rs.getString("nombre"));
    }

    rs.close();
    stmt.close();
    return nombres;
}
}
