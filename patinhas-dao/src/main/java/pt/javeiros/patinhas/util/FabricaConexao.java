package pt.javeiros.patinhas.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FabricaConexao {

    private static String url = "jdbc:postgresql://localhost:5432/patinhas";
    private static String usuario = "postgres";
    private static String senha = "root";
    public static  Connection conexao;

    private static Logger LOG = Logger.getLogger(FabricaConexao.class.getName());

    public static Connection getConnection() {

        try {
            Class.forName("org.postgresql.Driver");
            conexao = DriverManager.getConnection(url, usuario, senha);
            return conexao;
        } catch (Exception e) {
            LOG.log(Level.SEVERE, e.getMessage());
            e.printStackTrace();
            return null;
        }


    }

    public static void main(String[] args) {

        Connection con = FabricaConexao.getConnection();

        try {
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void closeConnection() {
        try {
            conexao.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
