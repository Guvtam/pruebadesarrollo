
package Controlador;

import Modelo.Usuario;
import Modelo.VideoJuego;
import bd.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author Tamara Gutierrez
 */
public class Registro {
    
    public boolean agregarJuego(VideoJuego videoJuego) {
       
        try {
            Conexion con = new Conexion();
            Connection cnx = con.obtenerConexion();

            
            String query = "INSERT INTO videojuego(nombreJuego,categoria,precio,plataforma,disponible) VALUES(?,?,?,?,?)";
            PreparedStatement stmt = cnx.prepareStatement(query);
            stmt.setString(1, videoJuego.getNombreJuego());
            stmt.setString(2, videoJuego.getCategoria());
            stmt.setInt(3, videoJuego.getPrecio());
            stmt.setString(4, videoJuego.getPlataforma());
            stmt.setBoolean(5, videoJuego.isDisponible());

            stmt.executeUpdate();
            stmt.close();
            cnx.close();

            return true;

        } catch (SQLException e) {
            System.out.println("Error de SQL al agregar Juego");
            return false;
        } catch (Exception e) {
            System.out.println("Error al agregar Juego(Exception)");
            return false;
        }

    }
    
    
    public boolean actualizarJuego(VideoJuego videoJuego) {

        try {
            Conexion con = new Conexion();
            Connection cnx = con.obtenerConexion();

            String query = "UPDATE videojuego set nombreJuego = ?, categoria = ?, precio = ?, plataforma = ?,disponible = ? WHERE idlibro = ?";
            PreparedStatement stmt = cnx.prepareStatement(query);
            stmt.setString(1, videoJuego.getNombreJuego());
            stmt.setString(2, videoJuego.getCategoria());
            stmt.setInt(3, videoJuego.getPrecio());
            stmt.setString(4, videoJuego.getPlataforma());
            stmt.setBoolean(5, videoJuego.isDisponible());
            stmt.setInt(6, videoJuego.getIdJuego());

            stmt.executeUpdate();
            stmt.close();
            cnx.close();

            return true;

        } catch (SQLException e) {
            System.out.println("Error de SQL al agregar el Juego");
            return false;
        } catch (Exception e) {
            System.out.println("Error al agregar el Juego(Exception)");
            return false;
        }

    }
    
    
    
    public boolean eliminarJuego(int idJuego) {

        try {
            Conexion con = new Conexion();
            Connection cnx = con.obtenerConexion();

            String query = "DELETE FROM videoJuego WHERE idJuego = ?";
            PreparedStatement stmt = cnx.prepareStatement(query);

            stmt.setInt(1, idJuego);

            stmt.executeUpdate();
            stmt.close();
            cnx.close();

            return true;

        } catch (SQLException e) {
            System.out.println("Error de SQL al eliminar el Juego");
            return false;
        } catch (Exception e) {
            System.out.println("Error al eliminar el Juego(Exception)");
            return false;
        }

    }
    
    
    public VideoJuego buscarJuego(int idJuego) {

        VideoJuego videoJuego = new VideoJuego();

        try {
            Conexion con = new Conexion();
            Connection cnx = con.obtenerConexion();

            String query = "SELECT idJuego,nombreJuego,categoria,precio,plataforma,disponible FROM videoJuego WHERE idJuego = ?";
            PreparedStatement stmt = cnx.prepareStatement(query);
            stmt.setInt(1, idJuego);

            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                videoJuego.setIdJuego(rs.getInt("idJuego"));
                videoJuego.setNombreJuego(rs.getString("nombreJuego"));
                videoJuego.setCategoria(rs.getString("categoria"));
                videoJuego.setPrecio(rs.getInt("precio"));
                videoJuego.setPlataforma(rs.getString("plataforma"));
                videoJuego.setDisponible(rs.getBoolean("disponible"));
            }

            rs.close();
            stmt.close();
            cnx.close();

        } catch (SQLException e) {
            System.out.println("Error de SQL al buscar el Juego");

        } catch (Exception e) {
            System.out.println("Error al buscar el Juego(Exception)");

        }
        return videoJuego;
    }
    
    
    
    public List<VideoJuego> buscarTodosJuegos() {

        List<VideoJuego> lista = new ArrayList<>();

        try {
            Conexion con = new Conexion();
            Connection cnx = con.obtenerConexion();

            String query = "SELECT idJuego,nombreJuego,categoria,precio,plataforma,disponible FROM videoJuego ORDER BY idJuego";
            PreparedStatement stmt = cnx.prepareStatement(query);

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                VideoJuego videoJuego = new VideoJuego();
                videoJuego.setIdJuego(rs.getInt("idJuego"));
                videoJuego.setNombreJuego(rs.getString("nombreJuego"));
                videoJuego.setCategoria(rs.getString("categoria"));
                videoJuego.setPrecio(rs.getInt("precio"));
                videoJuego.setPlataforma(rs.getString("plataforma"));
                videoJuego.setDisponible(rs.getBoolean("disponible"));

                lista.add(videoJuego);

            }

            rs.close();
            stmt.close();
            cnx.close();

        } catch (SQLException e) {
            System.out.println("Error de SQL al buscar Juego");

        } catch (Exception e) {
            System.out.println("Error al buscar Juego(Exception)");

        }
        return lista;
    }
    
    
    public boolean buscarNombreJuego(List<VideoJuego> lista, String nombreJuego) {
        for (VideoJuego videoJuego : lista) {
            if (videoJuego.getNombreJuego().equals(nombreJuego)) {
                return true;
            }

        }
        return false;
    }
    
    
    public boolean agregarUsuario(Usuario usuario) {
       
        try {
            Conexion con = new Conexion();
            Connection cnx = con.obtenerConexion();

            
            String query = "INSERT INTO usuario(nombreUsuario,contrasena) VALUES(?,?)";
            PreparedStatement stmt = cnx.prepareStatement(query);
            stmt.setString(1, usuario.getNombreUsuario());
            stmt.setString(2, usuario.getContrasena());
            

            stmt.executeUpdate();
            stmt.close();
            cnx.close();

            return true;

        } catch (SQLException e) {
            System.out.println("Error de SQL al agregar Usuario");
            return false;
        } catch (Exception e) {
            System.out.println("Error al agregar Usuario(Exception)");
            return false;
        }

    }
    
    
    public boolean actualizarUsuario(Usuario usuario) {

        try {
            Conexion con = new Conexion();
            Connection cnx = con.obtenerConexion();

            String query = "UPDATE usuario set nombreUsuario = ?,contrasena = ? WHERE idUsuario = ?";
            PreparedStatement stmt = cnx.prepareStatement(query);
            stmt.setString(1, usuario.getNombreUsuario());
            stmt.setString(2, usuario.getContrasena());
            stmt.setInt(3, usuario.getIdUsuario());

            stmt.executeUpdate();
            stmt.close();
            cnx.close();

            return true;

        } catch (SQLException e) {
            System.out.println("Error de SQL al Actualizar Usuario");
            return false;
        } catch (Exception e) {
            System.out.println("Error al Actualizar Usuario(Exception)");
            return false;
        }

    }
    
    
    
    public boolean eliminarUsuario(int idUsuario) {

        try {
            Conexion con = new Conexion();
            Connection cnx = con.obtenerConexion();

            String query = "DELETE FROM usuario WHERE idUsuario = ?";
            PreparedStatement stmt = cnx.prepareStatement(query);

            stmt.setInt(1, idUsuario);

            stmt.executeUpdate();
            stmt.close();
            cnx.close();

            return true;

        } catch (SQLException e) {
            System.out.println("Error de SQL al eliminar el Usuario");
            return false;
        } catch (Exception e) {
            System.out.println("Error al eliminar el Usuario(Exception)");
            return false;
        }

    }
    
    
    public Usuario buscarUsuario(int idUsuario) {

        Usuario usuario = new Usuario();

        try {
            Conexion con = new Conexion();
            Connection cnx = con.obtenerConexion();

            String query = "SELECT idUsuario,nombreUsuario,contrasena FROM usuario WHERE idUsuario = ?";
            PreparedStatement stmt = cnx.prepareStatement(query);
            stmt.setInt(1, idUsuario);

            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                usuario.setIdUsuario(rs.getInt("idUsuario"));
                usuario.setNombreUsuario(rs.getString("nombreUsuario"));
                usuario.setContrasena(rs.getString("contrasena"));
                
            }

            rs.close();
            stmt.close();
            cnx.close();

        } catch (SQLException e) {
            System.out.println("Error de SQL al buscar el Usuario");

        } catch (Exception e) {
            System.out.println("Error al buscar el Usuario(Exception)");

        }
        return usuario;
    }
    
    
    
    public List<Usuario> buscarTodosUsu() {

        List<Usuario> lista = new ArrayList<>();

        try {
            Conexion con = new Conexion();
            Connection cnx = con.obtenerConexion();

            String query = "SELECT idUsuario,nombreUsuario,contrasena FROM usuario ORDER BY idUsuario";
            PreparedStatement stmt = cnx.prepareStatement(query);

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Usuario usuario = new Usuario();
                usuario.setIdUsuario(rs.getInt("idUsuario"));
                usuario.setNombreUsuario(rs.getString("nombreUsuario"));
                usuario.setContrasena(rs.getString("contrasena"));
                

                lista.add(usuario);

            }

            rs.close();
            stmt.close();
            cnx.close();

        } catch (SQLException e) {
            System.out.println("Error de SQL al buscar Usuario");

        } catch (Exception e) {
            System.out.println("Error al buscar Usuario(Exception)");

        }
        return lista;
    }
    
    
    public boolean buscarNombreUsuario(List<Usuario> lista, String nombreUsuario) {
        for (Usuario usuario : lista) {
            if (usuario.getNombreUsuario().equals(nombreUsuario)) {
                return true;
            }

        }
        return false;
    }
    
    
}
