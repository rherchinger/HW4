<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="./CSS/newcss.css"/>
        <title>Add A New Movie</title>
    </head>
    <body>
        <h1>Add A New Movie</h1>
        
        <form name="addForm" action="addMovie" method="get" class="add">
        
            <label>Movie Title:</label>
            <input type="text" name="movieTitle" value="" />
            <br>
            
            <label>Genre:</label>
            <input type="text" name="genre" value="" />
            <br>
            
            <label>Main Actor:</label>
            <input type="text" name="mainActor" value="" />
            <br>
            
            <label>Producer:</label>
            <input type="text" name="producer" value="" />
            <br>
            
            <label>Release Date:</label>
            <input type="text" name="releaseDate" value="" />
            <br>
            
            <label>Box Office Earnings:</label>
            <input type="text" name="boxOfficeEarnings" value="" />
            <br>
            
            <label>Production Budget:</label>
            <input type="text" name="productionBudget" value="" />
            <br>
            <input type="submit" name="submit" value="Submit" />
        </form>
        
    </body>
</html>
