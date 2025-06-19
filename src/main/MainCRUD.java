package main;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import dao.Conexion;
import dao.PersonaDAO;
import model.PersonaDTO;

public class MainCRUD {
    public static void main(String[] args) {
        Connection conn = Conexion.conectar();
        if (conn != null) {
            PersonaDAO personaDAO = new PersonaDAO(conn);
            Scanner sc = new Scanner(System.in);

            while (true) {
                System.out.println("1. Crear persona");
                System.out.println("2. Listar personas");
                System.out.println("3. Buscar persona por ID");
                System.out.println("4. Actualizar persona");
                System.out.println("5. Eliminar persona");
                System.out.println("0. Salir");
                System.out.print("Seleccione una opción: ");
                int opcion = sc.nextInt();
                sc.nextLine(); // limpiar buffer

                try {
                    switch (opcion) {
                        case 1:
                            System.out.print("Nombre: ");
                            String nombre = sc.nextLine();
                            System.out.print("Cédula: ");
                            String cedula = sc.nextLine();
                            System.out.print("Edad: ");
                            int edad = sc.nextInt(); sc.nextLine();
                            System.out.print("Género: ");
                            String genero = sc.nextLine();
                            System.out.print("Dirección: ");
                            String direccion = sc.nextLine();

                            PersonaDTO nueva = new PersonaDTO(0, nombre, cedula, edad, genero, direccion);
                            personaDAO.insertarPersona(nueva);
                            System.out.println("Persona creada con ID: " + nueva.getIdPersona());
                            break;

                        case 2:
                            List<PersonaDTO> personas = personaDAO.obtenerPersonas();
                            System.out.println("\n Lista de personas:");
                            for (PersonaDTO p : personas) {
                                System.out.println("ID: " + p.getIdPersona()
                                        + " | Nombre: " + p.getNombre()
                                        + " | Cédula: " + p.getCedula()
                                        + " | Edad: " + p.getEdad()
                                        + " | Género: " + p.getGenero()
                                        + " | Dirección: " + p.getDireccion());
                            }
                            break;

                        case 3:
                            System.out.print("Ingrese ID de la persona a buscar: ");
                            int buscarId = sc.nextInt(); sc.nextLine();
                            PersonaDTO buscada = personaDAO.buscarPorId(buscarId);
                            if (buscada != null) {
                                System.out.println(" Persona encontrada:");
                                System.out.println("Nombre: " + buscada.getNombre()
                                        + " | Cédula: " + buscada.getCedula()
                                        + " | Edad: " + buscada.getEdad()
                                        + " | Género: " + buscada.getGenero()
                                        + " | Dirección: " + buscada.getDireccion());
                            } else {
                                System.out.println("Persona no encontrada.");
                            }
                            break;

                        case 4:
                            System.out.print("Ingrese ID de la persona a actualizar: ");
                            int idAct = sc.nextInt(); sc.nextLine();
                            PersonaDTO actual = personaDAO.buscarPorId(idAct);
                            if (actual != null) {
                                System.out.println("Deje en blanco si no desea cambiar un campo.");

                                System.out.print("Nuevo nombre (" + actual.getNombre() + "): ");
                                String nuevoNombre = sc.nextLine();
                                if (!nuevoNombre.isEmpty()) actual.setNombre(nuevoNombre);

                                System.out.print("Nueva cédula (" + actual.getCedula() + "): ");
                                String nuevaCedula = sc.nextLine();
                                if (!nuevaCedula.isEmpty()) actual.setCedula(nuevaCedula);

                                System.out.print("Nueva edad (" + actual.getEdad() + "): ");
                                String nuevaEdad = sc.nextLine();
                                if (!nuevaEdad.isEmpty()) actual.setEdad(Integer.parseInt(nuevaEdad));

                                System.out.print("Nuevo género (" + actual.getGenero() + "): ");
                                String nuevoGenero = sc.nextLine();
                                if (!nuevoGenero.isEmpty()) actual.setGenero(nuevoGenero);

                                System.out.print("Nueva dirección (" + actual.getDireccion() + "): ");
                                String nuevaDireccion = sc.nextLine();
                                if (!nuevaDireccion.isEmpty()) actual.setDireccion(nuevaDireccion);

                                personaDAO.actualizarPersona(actual);
                                System.out.println("Persona actualizada correctamente.");
                            } else {
                                System.out.println("Persona no encontrada.");
                            }
                            break;

                        case 5:
                            System.out.print("Ingrese ID de la persona a eliminar: ");
                            int eliminarId = sc.nextInt(); sc.nextLine();
                            personaDAO.eliminarPersona(eliminarId);
                            System.out.println("Persona eliminada correctamente.");
                            break;

                        case 0:
                            System.out.println(" Hasta luego.");
                            sc.close();
                            conn.close();
                            return;

                        default:
                            System.out.println("Opción no válida.");
                    }
                } catch (SQLException e) {
                    System.out.println(" Error SQL: " + e.getMessage());
                }
            }
        } else {
            System.out.println(" No se pudo conectar a la base de datos.");
        }
    }
}