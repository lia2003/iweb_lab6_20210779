
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="org.example.lab6_20210779.beans.Actor" %>
<%@ page import="java.util.ArrayList" %>
<%
    ArrayList<Actor> listaActores = (ArrayList<Actor>) request.getAttribute("listaactores");
    String nombrePelicula = (String) request.getAttribute("nombrePelicula");
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title><%=nombrePelicula%></title>
</head>
<body>
<h1><%=nombrePelicula%></h1>



<%
    if (listaActores == null || listaActores.isEmpty()) {
%>
<p>No se encontraron películas;</p>
<%
} else {
%>
<table border="1">
    <thead>
    <tr>
        <th>idActor</th>
        <th>Nombre</th>
        <th>Apellido</th>
        <th>Ano Nacimiento</th>
        <th>Ganador Premio Oscar</th>

    </tr>
    </thead>
    <tbody>
    <%
        for (Actor actor : listaActores) {
    %>
    <tr>
        <td><%=actor.getIdActor()%></td>
        <td><%=actor.getNombre()%></td>
        <td><%=actor.getApellido()%></td>
        <td><%=actor.getAnioNacimiento()%></td>
        <td><%=actor.isGanador()%></td>
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
