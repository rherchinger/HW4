/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dbHelpers.AddQuery;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Movies;

/**
 *
 * @author rherchinger
 */
@WebServlet(name = "AddServlet", urlPatterns = {"/addMovie"})
public class AddServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet AddServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet AddServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
            //Pass execution on to doPost
                doPost(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
            //get the data
            String movieTitle = request.getParameter("movieTitle");
            String genre = request.getParameter("genre");
            String mainActor = request.getParameter("mainActor");
            String producer = request.getParameter ("producer");
            String releaseDate = request.getParameter("releaseDate");
            double boxOfficeEarnings = Double.parseDouble(request.getParameter("boxOfficeEarnings"));
            double productionBudget = Double.parseDouble(request.getParameter("productionBudget"));
            
            
            //set up a movie object
            Movies movie = new Movies();
            movie.setMovieTitle(movieTitle);
            movie.setGenre(genre);
            movie.setMainActor(mainActor);
            movie.setProducer(producer);
            movie.setReleaseDate(releaseDate);
            movie.setBoxOfficeEarnings(boxOfficeEarnings);
            movie.setProductionBudget(productionBudget);
            
            //set up an addQuery object
            AddQuery aq = new AddQuery();
            
            
            //pass the friend to addQuery to add to the database
            aq.doAdd(movie);
            
            //pass execution control to the Read Servlet
            String url = "/read";
            
            RequestDispatcher dispatcher = request.getRequestDispatcher(url);
            dispatcher.forward (request,response);
            
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
