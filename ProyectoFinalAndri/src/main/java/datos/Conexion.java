package datos;

import java.sql.*;


public class Conexion {

    private static final String JDBC_URL = "jdbc:sqlite:C:\\Users\\alumno\\Desktop\\SQLite\\sqllite";

    
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(JDBC_URL);
    }
    
    public static void close(ResultSet rs){
        try {
            rs.close();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
    }
    
    public static void close(PreparedStatement stmt){
        try {
            stmt.close();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
    }
    
    public static void close(Connection conn){
        try {
            conn.close();
        } catch (SQLException ex) {
           ex.printStackTrace(System.out);
        }
    }
    
}
