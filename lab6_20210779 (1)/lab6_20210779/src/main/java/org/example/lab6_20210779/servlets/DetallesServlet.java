package org.example.lab6_20210779.servlets;
import org.example.lab6_20210779.beans.Peli;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.lab6_20210779.daos.DaoPeli;

import java.io.IOException;
import java.util.ArrayList;

    @WebServlet(name = "Detalles de la película", value = "/Detalles")
    public class DetallesServlet extends HttpServlet {

        @Override
        protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            response.setContentType("text/html");

            DaoPeli dao_pelicula = new DaoPeli();
            int id = Integer.parseInt(request.getParameter("id"));
            Peli peliculas = dao_pelicula.getID(id);
            request.setAttribute("peliculamostrar",peliculas);
            RequestDispatcher view = request.getRequestDispatcher("viewPelicula.jsp");
            view.forward(request,response);

        }

        @Override
        protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        }

        public void destroy() {
        }
    }

