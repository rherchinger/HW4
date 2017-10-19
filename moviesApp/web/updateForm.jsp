<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="model.Movies"%>
<% Movies movie = (Movies) request.getAttribute("movie"); %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="./CSS/newcss.css"/>
        <title>Update A Movie</title>
    </head>
    <body>
        <h1>Update A Movie Record</h1>
        
        <form name="updateForm" action="updateMovie" method="get" class="update">
        
            <label>Movie ID:</label>
            <input type="text" name="id" value="<%= movie.getMovieID() %>" />
            <br>
            
            <label>Movie Title:</label>
            <input type="text" name="movieTitle" value="<%= movie.getMovieTitle() %>" />
            <br>
            
            <label>Genre:</label>
            <input type="text" name="genre" value="<%= movie.getGenre() %>" />
            <br>
            
            <label>Main Actor:</label>
            <input type="text" name="mainActor" value="<%= movie.getMainActor() %>" />
            <br>
            
            <label>Producer:</label>
            <input type="text" name="producer" value="<%= movie.getProducer() %>" />
            <br>
            
            <label>Release Date:</label>
            <input type="text" name="releaseDate" value="<%= movie.getReleaseDate() %>" />
            <br>
            
            <label>Box Office Earnings:</label>
            <input type="text" name="boxOfficeEarnings" value="<%= movie.getBoxOfficeEarnings() %>" />
            <br>
            
            <label>Production Budget:</label>
            <input type="text" name="productionBudget" value="<%= movie.getProductionBudget() %>" />
            <br>
            <input type="submit" name="submit" value="Update" />
        </form>
    </body>
</html>
