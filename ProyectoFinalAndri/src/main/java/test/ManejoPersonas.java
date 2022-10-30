package test;

import datos.Conexion;
import datos.PersonaJDBC_DAO;
import dominio.PersonaDTO;
import java.sql.*;

public class ManejoPersonas {

    public static void main(String[] args) {


        Connection conexion = null;
        try {
            conexion = Conexion.getConnection();

            if (conexion.getAutoCommit()) {
                conexion.setAutoCommit(false);
            }

            PersonaJDBC_DAO personaJdbc = new PersonaJDBC_DAO(conexion);
            
            PersonaDTO cambioPersona = new PersonaDTO();
            cambioPersona.setId_persona(2);
            cambioPersona.setNombre("Pedro");
            cambioPersona.setApellido("Picapiedra");
            cambioPersona.setEmail("pedrito@gmail.com");
            cambioPersona.setTelefono("12345678910");
            personaJdbc.update(cambioPersona);
            
            PersonaDTO nuevaPersona = new PersonaDTO();
            nuevaPersona.setNombre("Mario");

            nuevaPersona.setApellido("Bros");
            personaJdbc.insert(nuevaPersona);
            
            conexion.commit();
            System.out.println("Se ha hecho commit de la transaccion");
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
            System.out.println("Entramos al rollback");
            try {
                conexion.rollback();
            } catch (SQLException ex1) {
                ex1.printStackTrace(System.out);
            }
        }

    }
}
