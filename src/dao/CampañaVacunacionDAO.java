package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import model.CampañaVacunacionDTO;

public class CampañaVacunacionDAO {
    private Connection conn;

    public CampañaVacunacionDAO(Connection conn) {
        this.conn = conn;
    }

    public List<CampañaVacunacionDTO> obtenerCampañas() throws SQLException {
        List<CampañaVacunacionDTO> lista = new ArrayList<>();
        String sql = "SELECT * FROM campaña_vacunacion";
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(sql);
        while (rs.next()) {
            CampañaVacunacionDTO c = new CampañaVacunacionDTO(
                rs.getInt("id_campaña"),
                rs.getString("nombre"),
                rs.getString("fecha_inicio"),
                rs.getString("fecha_fin")
            );
            lista.add(c);
        }
        rs.close();
        stmt.close();
        return lista;
    }
}