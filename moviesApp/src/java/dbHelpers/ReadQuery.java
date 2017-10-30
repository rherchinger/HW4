package dbHelpers;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.NumberFormat;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Movies;


public class ReadQuery {
    private Connection conn;
    private ResultSet results;
    
    public ReadQuery() {
        
    Properties props = new Properties(); //MWC
    InputStream instr = getClass().getResourceAsStream("dbConn.properties");
        try {
            props.load(instr);
        } catch (IOException ex) {
            Logger.getLogger(ReadQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            instr.close();
        } catch (IOException ex) {
            Logger.getLogger(ReadQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    String driver = props.getProperty("driver.name");
    String url = props.getProperty("server.name");
    String username = props.getProperty("user.name");
    String passwd = props.getProperty("user.password");
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ReadQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            conn = DriverManager.getConnection(url, username, passwd);
        } catch (SQLException ex) {
            Logger.getLogger(ReadQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
    
    public void doRead() {
        
        try {
            String query = "SELECT * FROM movies ORDER BY movieID ASC";
            
            PreparedStatement ps = conn.prepareStatement(query);
            this.results = ps.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(ReadQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public String getHTMLTable(){
        
        String table = "";
        
        table += "<table>";
        
            table+= "<tr>";
            
            table+= "<th>Movie ID</th>";
            table+= "<th>Movie Title</th>";
            table+= "<th>Genre</th>";
            table+= "<th>Main Actor</th>";
            table+= "<th>Producer</th>";
            table+= "<th>Release Date</th>";
            table+= "<th>Box Office Earnings</th>";
            table+= "<th>Production Budget</th>";
            table+= "<th>Update/Delete</th>";
            
            
            
            
            
            table+= "</tr>";
        
        
        
        
        
        try {
            while(this.results.next()){
                
                Movies movie = new Movies();
                movie.setMovieID(this.results.getInt("movieID"));
                movie.setMovieTitle(this.results.getString("movieTitle"));
                movie.setGenre(this.results.getString("genre"));
                movie.setMainActor(this.results.getString("mainActor"));
                movie.setProducer(this.results.getString("producer"));
                movie.setReleaseDate(this.results.getString("releaseDate"));
                movie.setBoxOfficeEarnings(this.results.getDouble("boxOfficeEarnings"));
                movie.setProductionBudget(this.results.getDouble("productionBudget"));
                
                NumberFormat formatter = NumberFormat.getCurrencyInstance();
                
                table += "<tr>";
                
                table += "<td>";
                table += movie.getMovieID();
                table += "</td>";
                
                table += "<td>";
                table += movie.getMovieTitle();
                table += "</td>";
                
                table += "<td>";
                table += movie.getGenre();
                table += "</td>";
                
                table += "<td>";
                table += movie.getMainActor();
                table += "</td>";
                
                table += "<td>";
                table += movie.getProducer();
                table += "</td>";
                
                table += "<td>";
                table += movie.getReleaseDate();
                table += "</td>";
                
                
                table += "<td>";
                table += formatter.format(movie.getBoxOfficeEarnings());
                table += "</td>";
                
                table += "<td>";
                table += formatter.format(movie.getProductionBudget());
                table += "</td>";
                
                table += "<td>";
                table += "<a href=update?movieID=" + movie.getMovieID() + "> Update </a>" + "<a href=delete?movieID=" + movie.getMovieID() + "> Delete </a>";
                
                table += "</tr>";
                
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(ReadQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        table += "</table>";
        
            
                return table;
        
        
    }

    
}
