package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import model.ProfesionalSaludDTO;

public class ProfesionalSaludDAO {
    private Connection conn;

    public ProfesionalSaludDAO(Connection conn) {
        this.conn = conn;
    }

    public List<ProfesionalSaludDTO> obtenerProfesionales() throws SQLException {
        List<ProfesionalSaludDTO> lista = new ArrayList<>();
        String sql = "SELECT * FROM profesional_salud";
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(sql);
        while (rs.next()) {
            ProfesionalSaludDTO p = new ProfesionalSaludDTO(
                rs.getInt("id_profesional"),
                rs.getString("nombre"),
                rs.getString("especialidad")
            );
            lista.add(p);
        }
        rs.close();
        stmt.close();
        return lista;
    }
}
