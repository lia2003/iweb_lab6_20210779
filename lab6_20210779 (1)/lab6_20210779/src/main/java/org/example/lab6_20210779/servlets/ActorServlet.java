package org.example.lab6iweb.servlets;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.lab6_20210779.beans.Actor;
import org.example.lab6_20210779.daos.DaoPeli;
import org.example.lab6_20210779.daos.DaoActor;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "Lista de Actores", value = "/Actores")

public class ActorServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");

        DaoActor actoresDao = new DaoActor();

        int idPelicula = Integer.parseInt(request.getParameter("id"));
        ArrayList<Actor> listaActores = actoresDao.listar(idPelicula);
        String nombrePelicula = actoresDao.obtenerNombre(idPelicula);


        request.setAttribute("listaactores", listaActores);
        request.setAttribute("nombrePelicula", nombrePelicula);
        RequestDispatcher view = request.getRequestDispatcher("listaActores.jsp");
        view.forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
    public void destroy() {
    }
}

