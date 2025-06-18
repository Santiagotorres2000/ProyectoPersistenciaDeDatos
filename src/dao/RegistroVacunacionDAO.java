package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import model.RegistroVacunacionDTO;

public class RegistroVacunacionDAO {
    private Connection conn;

    public RegistroVacunacionDAO(Connection conn) {
        this.conn = conn;
    }

    public List<RegistroVacunacionDTO> obtenerTodos() throws SQLException {
        List<RegistroVacunacionDTO> lista = new ArrayList<>();
        String sql = "SELECT * FROM registro_vacunacion";
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(sql);
        while (rs.next()) {
            RegistroVacunacionDTO rv = new RegistroVacunacionDTO(
                rs.getInt("id_registro"),
                rs.getInt("id_persona"),
                rs.getInt("id_profesional"),
                rs.getInt("id_campania"),
                rs.getString("fecha"),
                rs.getString("vacuna")
            );
            lista.add(rv);
        }
        rs.close();
        stmt.close();
        return lista;
    }
    public List<String> obtenerRegistrosConDetalle() throws SQLException {
    List<String> resultados = new ArrayList<>();
    String sql = "SELECT rv.id_registro, p.nombre AS nombre_persona, pr.nombre AS nombre_profesional, " +
                 "cv.nombre_campaña, rv.fecha_vacunacion " +
                 "FROM registro_vacunacion rv " +
                 "INNER JOIN persona p ON rv.id_persona = p.id_persona " +
                 "INNER JOIN profesional_salud pr ON rv.id_profesional = pr.id_profesional " +
                 "INNER JOIN campaña_vacunacion cv ON rv.id_campaña = cv.id_campaña";

    Statement stmt = conn.createStatement();
    ResultSet rs = stmt.executeQuery(sql);

    while (rs.next()) {
        String fila = " Registro " + rs.getInt("id_registro") +
                      " Persona: " + rs.getString("nombre_persona") +
                      " Profesional: " + rs.getString("nombre_profesional") +
                      " Campaña: " + rs.getString("nombre_campaña") +
                      " Fecha: " + rs.getDate("fecha_vacunacion");
        resultados.add(fila);
    }

    rs.close();
    stmt.close();
    return resultados;
}
public List<String> obtenerDetalleVacunaciones() throws SQLException {
    List<String> lista = new ArrayList<>();
    String sql = """
        SELECT p.nombre AS persona, pr.nombre AS profesional, rv.fecha_vacunacion 
        FROM registro_vacunacion rv
        INNER JOIN persona p ON rv.id_persona = p.id_persona
        INNER JOIN profesional_salud pr ON rv.id_profesional = pr.id_profesional
    """;
    Statement stmt = conn.createStatement();
    ResultSet rs = stmt.executeQuery(sql);
    while (rs.next()) {
        String registro = "Persona: " + rs.getString("persona") +
                          " | Profesional: " + rs.getString("profesional") +
                          " | Fecha: " + rs.getDate("fecha_vacunacion");
        lista.add(registro);
    }
    rs.close();
    stmt.close();
    return lista;
}

}