package dbHelpers;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Movies;

public class ReadRecord {

    private Connection conn;
    private ResultSet results;

    private Movies movie = new Movies();
    private int movieID;

    public ReadRecord(int movieID) {
        Properties props = new Properties(); //MWC
        InputStream instr = getClass().getResourceAsStream("dbConn.properties");
        try {
            props.load(instr);
        } catch (IOException ex) {
            Logger.getLogger(ReadRecord.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            instr.close();
        } catch (IOException ex) {
            Logger.getLogger(ReadRecord.class.getName()).log(Level.SEVERE, null, ex);
        }

        String driver = props.getProperty("driver.name");
        String url = props.getProperty("server.name");
        String username = props.getProperty("user.name");
        String passwd = props.getProperty("user.password");

        this.movieID = movieID;

        try {
            Class.forName(driver);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ReadRecord.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            conn = DriverManager.getConnection(url, username, passwd);
        } catch (SQLException ex) {
            Logger.getLogger(ReadRecord.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void doRead() {

        PreparedStatement ps = null;
        try {
            //set up a string to hold our query
            String query = "SELECT * FROM movies WHERE movieID = ?";
            //create a preparedstatement using our query string
            ps = conn.prepareStatement(query);
            //fill in the preparedstatement
            ps.setInt(1, movieID);
            //execute the query
            this.results = ps.executeQuery();
            this.results.next();
            movie.setMovieID(this.results.getInt("movieID"));
            movie.setMovieTitle(this.results.getString("movieTitle"));
            movie.setGenre(this.results.getString("genre"));
            movie.setMainActor(this.results.getString("mainActor"));
            movie.setProducer(this.results.getString("producer"));
            movie.setReleaseDate(this.results.getString("releaseDate"));
            movie.setBoxOfficeEarnings(this.results.getDouble("boxOfficeEarnings"));
            movie.setProductionBudget(this.results.getDouble("productionBudget"));
        } catch (SQLException ex) {
            Logger.getLogger(ReadRecord.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                ps.close();
            } catch (SQLException ex) {
                Logger.getLogger(ReadRecord.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

    public Movies getMovie() {

        return this.movie;
    }

}
