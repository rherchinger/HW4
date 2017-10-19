<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Movies JSP page</title>
        <link rel="stylesheet" type="text/css" href="./CSS/stylesheet.css"/>
    </head>
    
    <% String table = (String) request.getAttribute("table"); %>
    
    <body>
        <h1>Ryan's Movies</h1>
        
        <%= table %>
        
        <br><br>
        
        <a href="add">Add A New Movie</a>
        <br><br>
        <a href="search.jsp">Search Movies</a>
        
        
    </body>
</html>
