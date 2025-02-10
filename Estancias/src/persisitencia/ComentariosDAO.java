package persisitencia;
import java.util.ArrayList;
import java.util.List;

import entidades.Comentarios;
public class ComentariosDAO extends DAO {
  
    public void crearComentario(Comentarios comment) {
    try {
        
        String sql = "INSERT INTO comentarios (id_comentario,id_casa,comentario) VALUES (" +
         comment.getId_comentario() +"','"+
         comment.getId_casa() +"','"+
         comment.getId_comentario() +
              ");";
         insertarModificarEliminarDataBase(sql);      
    } catch (Exception e) {
    
        e.printStackTrace();
    }
    }


    public List<Comentarios> mostrarComentarios(){
        try {
            String query = "SELECT id_comentario,id_casa,comentario FROM comentarios";   
            List<Comentarios> comentario = new ArrayList<>();
            consultarDataBase(query);
            while (resultSet.next()) {
                Comentarios comment = new Comentarios();
                comment.setId_comentario(resultSet.getInt("id_comentario"));
                comment.setId_casa(resultSet.getInt("id_casa") );
                comment.setComentario(resultSet.getString("comentario"));
                comentario.add(comment);
                            }

            for (Comentarios comentInd : comentario) {

                System.out.println(comentInd.toString());
                System.out.println("---------------------------------------------------------");
                
            }
            System.out.println("");
            return comentario;
            
        } catch (Exception e) {
            e.printStackTrace();
            return null;
            // TODO: handle exception
        }


    }
};

