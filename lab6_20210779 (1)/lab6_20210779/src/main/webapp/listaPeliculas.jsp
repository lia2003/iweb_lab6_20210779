

<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="org.example.lab6_20210779.beans.Peli" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.text.NumberFormat" %>
<%@ page import="java.util.Locale" %>
<%
    ArrayList<Peli> listaPeliculas = (ArrayList<Peli>) request.getAttribute("Lista_peliculas");
%>
    <!DOCTYPE html>
    <html>
        <head>
            <meta charset="utf-8">
            <meta name="viewport" content="width=device-width, initial-scale=1">
            <title>Lista de películas</title>
        </head>
        <body>
            <h1>Lista de películas</h1>

            <form method="get" action="nombrepeli">
                <input type="text" name="search" placeholder="Buscar por título">
                <input type="submit" value="Buscar">
            </form>

            <%
                if (listaPeliculas == null || listaPeliculas.isEmpty()) {
            %>
            <p>No se encontraron películas;</p>
            <%
            } else {
            %>
            <table border="1">
                <thead>
                <tr>
                    <th>Título</th>
                    <th>Director</th>
                    <th>Año de Publicación</th>
                    <th>Rating</th>
                    <th>Box Office</th>
                    <th>Género</th>
                    <th>Actores</th>
                </tr>
                </thead>
                <tbody>
                <%
                    NumberFormat formatter = NumberFormat.getNumberInstance(Locale.US);
                    for (Peli pelicula : listaPeliculas) {
                        String boxOfficeFormatted = formatter.format(pelicula.getBoxOffice1());
                %>
                        <tr>
                            <td><a href="Detalles?id=<%=pelicula.getId1()%>"><%=pelicula.getTitulo1()%></a></td>
                            <td><%=pelicula.getDirector1()%></td>
                            <td><%=pelicula.getAnio1()%></td>
                            <td><%=pelicula.getRating1()%>/10</td>
                            <td>$<%=boxOfficeFormatted%></td>
                            <td><%=pelicula.getGenero1()%></td>
                            <td><a href="Actores?id=<%=pelicula.getId1()%>">Ver Actores</a></td>
                        </tr>
                <%
                    }
                %>
            </tbody>
        </table>
        <%
            }
        %>
        </body>
    </html>
