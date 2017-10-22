package dbHelpers;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Movies;


public class UpdateQuery {
    
    private Connection conn;
    
    public UpdateQuery() {
    Properties props = new Properties(); //MWC
    InputStream instr = getClass().getResourceAsStream("dbConn.properties");
        try {
            props.load(instr);
        } catch (IOException ex) {
            Logger.getLogger(UpdateQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            instr.close();
        } catch (IOException ex) {
            Logger.getLogger(UpdateQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    String driver = props.getProperty("driver.name");
    String url = props.getProperty("server.name");
    String username = props.getProperty("user.name");
    String passwd = props.getProperty("user.password");
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UpdateQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            conn = DriverManager.getConnection(url, username, passwd);
        } catch (SQLException ex) {
            Logger.getLogger(UpdateQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    
}
    
    public void doUpdate(Movies movie){
        
        PreparedStatement ps = null;
        try {
            String query = "UPDATE movies SET movieTitle = ?, genre = ?, mainActor = ?, producer = ?, releaseDate = ?, boxOfficeEarnings = ?, productionBudget = ? WHERE movieID = ?";
            ps = conn.prepareStatement(query);
            ps.setString(1, movie.getMovieTitle());
            ps.setString(2, movie.getGenre());
            ps.setString(3, movie.getMainActor());
            ps.setString(4, movie.getProducer());
            ps.setString(5, movie.getReleaseDate());
            ps.setDouble(6, movie.getBoxOfficeEarnings());
            ps.setDouble(7, movie.getProductionBudget());
            ps.setInt(8, movie.getMovieID());
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(UpdateQuery.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                ps.close();
            } catch (SQLException ex) {
                Logger.getLogger(UpdateQuery.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }
}
