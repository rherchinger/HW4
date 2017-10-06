package model;

public class Movies {
    private int movieID;
    private String movieTitle;
    private String genre;
    private String mainActor;
    private String producer;
    private String releaseDate;
    private int boxOfficeEarnings;
    private int productionBudget;
    
    
    public Movies() {
        this.movieID = 0;
        this.movieTitle = "";
        this.genre = "";
        this.mainActor = "";
        this.producer = "";
        this.releaseDate = "";
        this.boxOfficeEarnings = 0;
        this.productionBudget = 0;
    }
    
    public Movies(int movieID, String movieTitle, String genre, String mainActor, String producer, String releaseDate, int boxOfficeEarnings, int productionBudget) {
        this.movieID = movieID;
        this.movieTitle = movieTitle;
        this.genre = genre;
        this.mainActor = mainActor;
        this.producer = producer;
        this.releaseDate = releaseDate;
        this.boxOfficeEarnings = boxOfficeEarnings;
        this.productionBudget = productionBudget;
    }

    public int getMovieID() {
        return movieID;
    }

    public void setMovieID(int movieID) {
        this.movieID = movieID;
    }

    public String getMovieTitle() {
        return movieTitle;
    }

    public void setMovieTitle(String movieTitle) {
        this.movieTitle = movieTitle;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getMainActor() {
        return mainActor;
    }

    public void setMainActor(String mainActor) {
        this.mainActor = mainActor;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    public int getBoxOfficeEarnings() {
        return boxOfficeEarnings;
    }

    public void setBoxOfficeEarnings(int boxOfficeEarnings) {
        this.boxOfficeEarnings = boxOfficeEarnings;
    }

    public int getProductionBudget() {
        return productionBudget;
    }

    public void setProductionBudget(int productionBudget) {
        this.productionBudget = productionBudget;
    }

    @Override
    public String toString() {
        return "Movies{" + "movieID=" + movieID + ", movieTitle=" + movieTitle + ", genre=" + genre + ", mainActor=" + mainActor + ", producer=" + producer + ", releaseDate=" + releaseDate + ", boxOfficeEarnings=" + boxOfficeEarnings + ", productionBudget=" + productionBudget + '}';
    }
    
    
    
    
    
    
    
}
