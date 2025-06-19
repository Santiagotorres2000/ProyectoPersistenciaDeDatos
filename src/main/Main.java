package main;

import java.sql.Connection;
import java.sql.SQLException;
import dao.PersonaDAO;
import dao.ProfesionalSaludDAO;
import dao.RegistroVacunacionDAO;
import model.PersonaDTO;
import model.ProfesionalSaludDTO;
import model.RegistroVacunacionDTO;
import dao.CampañaVacunacionDAO;
import dao.Conexion;
import model.CampañaVacunacionDTO;

public class Main {
    public static void main(String[] args) {
        Connection conn = Conexion.conectar();
        if (conn != null) {
            try {
                 PersonaDAO personaDAO = new PersonaDAO(conn);

                // // Insertar una persona nueva
                // PersonaDTO persona = new PersonaDTO(1, "Laura Gómez", "123456789", 25);
                // personaDAO.insertarPersona(persona);
                // System.out.println(" Persona insertada correctamente.");

                //Mostrar todas las personas
                System.out.println(" Lista de personas:");
                for (PersonaDTO p : personaDAO.obtenerPersonas()) {
                    System.out.println("ID: " + p.getIdPersona() + " | Nombre: " + p.getNombre() + 
                        " | Cédula: " + p.getCedula() + " | Edad: " + p.getEdad());
                        
                }
                System.out.println("Personas mayores de 60 años:");
                for (PersonaDTO persona : personaDAO.obtenerMayoresDe60()) 
                {
                    System.out.println("🔹 " + persona.getNombre() + " - " + persona.getEdad() + " años");
                }
                

                ProfesionalSaludDAO profDAO = new ProfesionalSaludDAO (conn);
                for (ProfesionalSaludDTO prof : profDAO.obtenerProfesionales()){
                    System.out.println(prof.getNombre()+ "-" + prof.getEspecialidad());

                }
                System.out.println(" Lista unificada de nombres (personas y profesionales de salud):");
                for (String nombre : personaDAO.obtenerNombresUnificados()) 
                {
                    System.out.println(nombre);
                }
               
                RegistroVacunacionDAO rvDAO = new RegistroVacunacionDAO(conn);
                 System.out.println("\n Lista de registros de vacunación:");
                 for (RegistroVacunacionDTO rv : rvDAO.obtenerTodos()) {
                 System.out.println("ID Registro: " + rv.getIdRegistro() + " | Persona: " + rv.getIdPersona() +
                " | Fecha: " + rv.getFecha() + " | Vacuna: " + rv.getVacuna());
            }
            
                RegistroVacunacionDAO registroDAO = new RegistroVacunacionDAO(conn);
                System.out.println(" Detalle de vacunaciones:");
                for (String detalle : registroDAO.obtenerDetalleVacunaciones()) {
                System.out.println(detalle);
            }
            

                CampañaVacunacionDAO campañaDAO = new CampañaVacunacionDAO(conn);
                System.out.println(" Lista de campañas de vacunación:");
                for (CampañaVacunacionDTO c : campañaDAO.obtenerCampañas()) 
             {
                System.out.println("ID: " + c.getIdCampaña() +
                           " | Nombre: " + c.getNombre() +
                           " | Inicio: " + c.getFechaInicio() +
                           " | Fin: " + c.getFechaFin());
                        }

         } catch (SQLException e) {
                System.out.println(" Error SQL: " + e.getMessage());
            }
        }
    }
}