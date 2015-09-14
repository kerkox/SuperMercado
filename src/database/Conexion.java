/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import java.io.File;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.derby.drda.NetworkServerControl;

/**
 *
 * @author Polker
 */
public class Conexion {

    private static Conexion conexion = null;

    public String driver = "org.apache.derby.jdbc.EmbeddedDriver";
    private Connection conn;

    private Conexion() throws Exception {
        NetworkServerControl server = new NetworkServerControl();
        server.start(null);

        File file = new File("greendb");
        if (!file.exists()) {
            Class.forName(driver);
            conn = DriverManager.getConnection("jdbc:derby:greendb;create=true;user=avsoft;password=avsoft");
        }
    }

    // Patron Singleton
    public static Conexion getInstance() throws Exception {
        if (conexion == null) {
            conexion = new Conexion();
        }
        return conexion;
    }

    public Connection getConnection() throws SQLException {
        if (conn == null || conn.isClosed()) {
            conn = DriverManager.getConnection("jdbc:derby:greendb;create=true;user=avsoft;password=avsoft");
        }
        return conn;
    }

    public void closeConnection() {

        try {
            if (conn != null && !conn.isClosed()) {
                conn.close();
            }
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
