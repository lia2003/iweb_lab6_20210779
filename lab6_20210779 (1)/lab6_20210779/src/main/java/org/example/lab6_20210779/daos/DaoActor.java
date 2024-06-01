
package org.example.lab6_20210779.daos;
import org.example.lab6_20210779.beans.Actor;
import java.sql.*;
import java.util.ArrayList;

public class DaoActor {


    public ArrayList<Actor> listar(int idPeli) {

        ArrayList<Actor> lista = new ArrayList<>();

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }


        String url = "jdbc:mysql://localhost:3306/mydb";
        String username = "root";
        String password = "PoCoYo137F";


        String query = "SELECT a.idActor, a.nombre, a.apellido, a.anoNacimiento, a.premioOscar " +
                "FROM Actor a " +
                "JOIN Protagonistas p ON a.idActor = p.idActor " +
                "WHERE p.idPelicula = ?";

        try (Connection conn = DriverManager.getConnection(url, username, password);
             PreparedStatement pstmt = conn.prepareStatement(query)) {

            pstmt.setInt(1, idPeli);
            ResultSet rs = pstmt.executeQuery();


            while (rs.next()) {
                Actor actor = new Actor();
                actor.setIdActor(rs.getInt("idActor"));
                actor.setNombre(rs.getString("nombre"));
                actor.setApellido(rs.getString("apellido"));
                actor.setAnioNacimiento(rs.getInt("anoNacimiento"));
                actor.setGanador(rs.getBoolean("premioOscar"));
                lista.add(actor);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return lista;
    }

    public String obtenerNombre(int id) {

        String nombre = ".";


        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }


        String url = "jdbc:mysql://localhost:3306/mydb";
        String username = "root";
        String password = "PoCoYo137F";


        String query = "SELECT titulo FROM Pelicula WHERE idPelicula = ?";

        try (Connection conn = DriverManager.getConnection(url, username, password);
             PreparedStatement pstmt = conn.prepareStatement(query)) {

            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                nombre = rs.getString("titulo");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return nombre;
    }
}