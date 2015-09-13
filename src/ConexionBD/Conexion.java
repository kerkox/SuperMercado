/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ConexionBD;

import java.sql.*;
import org.apache.derby.drda.NetworkServerControl;

/**
 *
 * @author Polker
 */
public class Conexion {

    
    public String driver = "org.apache.derby.jdbc.EmbeddedDriver";
    private Connection conn ;
    
    public Conexion() throws Exception {
        
        NetworkServerControl server = new NetworkServerControl();
        server.start(null);
        
        
        
    }

}
