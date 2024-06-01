package org.example.lab6_20210779.daos;
import org.example.lab6_20210779.beans.Peli;
import java.sql.*;
import java.util.ArrayList;

public class DaoPeli {


    public ArrayList<Peli> listandoPeliculas() {
        ArrayList<Peli> lista = new ArrayList<>();

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }


        String url = "jdbc:mysql://localhost:3306/mydb";
        String username = "root";
        String pass = "PoCoYo137F";


        String query = "SELECT p.idPelicula, p.titulo, p.director, p.anoPublicacion, p.rating, p.boxOffice, g.nombre as genero "
                + "FROM Pelicula p JOIN Genero g ON p.idGenero = g.idGenero "
                + "ORDER BY p.rating DESC, p.boxOffice DESC";

        try (Connection conn = DriverManager.getConnection(url, username, pass);

             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            while (rs.next()) {
                Peli pelicula = new Peli();
                pelicula.setId1(rs.getInt(1));
                pelicula.setTitulo1(rs.getString(2));
                pelicula.setDirector1(rs.getString(3));
                pelicula.setAnio1(rs.getInt(4));
                pelicula.setRating1(rs.getDouble(5));
                pelicula.setBoxOffice1(rs.getDouble(6));
                pelicula.setGenero1(rs.getString(7));
                lista.add(pelicula);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }


    public ArrayList<Peli> getPeli(String titulo) {
        ArrayList<Peli> lista = new ArrayList<>();

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }


        String url = "jdbc:mysql://localhost:3306/mydb";
        String username = "root";
        String pass = "PoCoYo137F";


        String query = "SELECT p.idPelicula, p.titulo, p.director, p.anoPublicacion, p.rating, p.boxOffice, g.nombre as genero "
                + "FROM Pelicula p JOIN Genero g ON p.idGenero = g.idGenero "
                + "WHERE p.titulo LIKE ? ORDER BY p.rating DESC, p.boxOffice DESC";

        try (Connection conn = DriverManager.getConnection(url, username, pass);
             PreparedStatement pstmt = conn.prepareStatement(query)) {

            pstmt.setString(1, "%" + titulo + "%");
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                Peli pelicula = new Peli();
                pelicula.setId1(rs.getInt(1));
                pelicula.setTitulo1(rs.getString(2));
                pelicula.setDirector1(rs.getString(3));
                pelicula.setAnio1(rs.getInt(4));
                pelicula.setRating1(rs.getDouble(5));
                pelicula.setBoxOffice1(rs.getDouble(6));
                pelicula.setGenero1(rs.getString(7));
                lista.add(pelicula);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }

    public Peli getID(int id) {
        Peli pelicula = new Peli();

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }


        String url = "jdbc:mysql://localhost:3306/mydb";
        String username = "root";
        String pass = "PoCoYo137F";


        String query = "SELECT p.idPelicula, p.titulo, p.director, p.anoPublicacion, p.rating, p.boxOffice, g.nombre as genero "
                + "FROM Pelicula p JOIN Genero g ON p.idGenero = g.idGenero "
                + "WHERE p.idPelicula = ?";

        try (Connection conn = DriverManager.getConnection(url, username, pass);
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                pelicula.setId1(rs.getInt(1));
                pelicula.setTitulo1(rs.getString(2));
                pelicula.setDirector1(rs.getString(3));
                pelicula.setAnio1(rs.getInt(4));
                pelicula.setRating1(rs.getDouble(5));
                pelicula.setBoxOffice1(rs.getDouble(6));
                pelicula.setGenero1(rs.getString(7));

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return pelicula;
    }
}






