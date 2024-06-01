
<%@ page import="org.example.lab6_20210779.beans.Peli" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.text.NumberFormat" %>
<%@ page import="java.util.Locale" %>
<%
    Peli pelicula = (Peli) request.getAttribute("peliculamostrar");
    NumberFormat formatter = NumberFormat.getNumberInstance(Locale.US);
    String boxOfficeFormatted = formatter.format(pelicula.getBoxOffice1());
%>
<!DOCTYPE html>
<html>
<head>
    <title><%=pelicula.getTitulo1()%></title>
</head>
<body>
<h1><%=pelicula.getTitulo1()%></h1>
<table border="1">
    <tr>
        <th>idPelicula</th>
        <td><%=pelicula.getId1()%></td>
    </tr>
    <tr>
        <th>Director</th>
        <td><%=pelicula.getDirector1()%></td>
    </tr>
    <tr>
        <th>Año</th>
        <td><%=pelicula.getAnio1()%></td>
    </tr>
    <tr>
        <th>Rating</th>
        <td><%=pelicula.getRating1()%>/10</td>
    </tr>
    <tr>
        <th>Box Office</th>
        <td>$<%=boxOfficeFormatted%></td>
    </tr>
    <tr>
        <th>Género</th>
        <td><%=pelicula.getGenero1()%></td>
    </tr>
    <tr>
        <th>Actores</th>
        <td><a href="ListaActores?id=<%=pelicula.getId1()%>">Ver Actores</a></td>
    </tr>
</table>

</body>
</html>