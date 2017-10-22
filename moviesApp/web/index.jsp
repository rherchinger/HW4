<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="./CSS/stylesheet.css"
        <title>My Movies</title>
    </head>
    <body>
        <div class="wrap"> <!--div to hold all other dives-->
        
            <%@ include file="includes/header.jsp" %>
        
            <!--Menu-->
            <%@ include file="includes/menu.jsp" %>
            
            <!--Main-->
            <div class="main"> <!-- main div-->
            
        <h1>Ryan's Movies Database</h1>
        
        <a href="read">View All Movies Now</a>
        <br><br>
        <a href="search.jsp">Search Movies</a>
        
            </div> <!--close main div-->
        
        <br><br>
        <!--footer-->
            <%@ include file="includes/footer.jsp" %>
        
        
        </div> <!-- close the wrap div -->
    </body>
</html>
