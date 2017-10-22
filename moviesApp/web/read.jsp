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
         <div class="wrap"> <!--div to hold all other dives-->
        
            <%@ include file="includes/header.jsp" %>
        
            <!--Menu-->
            <%@ include file="includes/menu.jsp" %>
            
            <!--Main-->
            <div class="main"> <!-- main div-->
        
        <h1>Ryan's Movies</h1>
        
        <%= table %>
        
        <br><br>
        
        <a href="add">Add A New Movie</a>
        <br><br>
        <a href="search.jsp">Search Movies</a>
        
        </div> <!--close main div-->
        
        <br><br>
        <!--footer-->
            <%@ include file="includes/footer.jsp" %>
        
        
        </div> <!-- close the wrap div -->
        
        
    </body>
</html>
