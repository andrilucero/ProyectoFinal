package test;

import datos.Conexion;
import datos.UsuarioJDBC_DAO;
import datos.UsuarioJDBC_DAO;
import dominio.UsuarioDTO;
import dominio.UsuarioDTO;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class ManejoUsuarios {

    public static void main(String[] args) {

        Connection conexion = null;
        try {
            conexion = Conexion.getConnection();
            if (conexion.getAutoCommit()) {
                conexion.setAutoCommit(false);
            }

            UsuarioJDBC_DAO usuarioJdbc = new UsuarioJDBC_DAO(conexion);

           // UsuarioDTO cambioUsuario = new UsuarioDTO();
            //cambioUsuario.setId_usuario(1);
            //cambioUsuario.setUsername("manuel");
           // cambioUsuario.setPassword("586");
            //usuarioJdbc.update(cambioUsuario);

            UsuarioDTO nuevoUsuario = new UsuarioDTO();
           nuevoUsuario.setId_usuario(1);
          nuevoUsuario.setUsername("iris");
         nuevoUsuario.setPassword("867");
            usuarioJdbc.insert(nuevoUsuario);
            
           // UsuarioDTO eliminarUsuario = new UsuarioDTO();
           // eliminarUsuario.setId_usuario(1);
          // usuarioJdbc.delete(eliminarUsuario);
           
           // UsuarioDTO verUsuario = new UsuarioDTO();         
           // usuarioJdbc.select();


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
