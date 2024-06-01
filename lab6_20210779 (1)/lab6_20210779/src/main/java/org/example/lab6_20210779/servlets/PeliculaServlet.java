package org.example.lab6_20210779.servlets;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.lab6_20210779.beans.Peli;
import org.example.lab6_20210779.daos.DaoPeli;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "NombrePeliculas", value = "/nombrepeli")
public class PeliculaServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");

        DaoPeli daopeli = new DaoPeli();
        ArrayList<Peli> lista= daopeli.listandoPeliculas();

        String searchQuery = request.getParameter("search");


        if (searchQuery != null && !searchQuery.trim().isEmpty()) {
            lista = daopeli.getPeli(searchQuery);
        } else {
            lista = daopeli.listandoPeliculas();
        }

        request.setAttribute("Lista_peliculas",lista);
        RequestDispatcher view = request.getRequestDispatcher("listaPeliculas.jsp");
        view.forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }
    public void destroy() {
    }
}
