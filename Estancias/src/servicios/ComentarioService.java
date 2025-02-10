package servicios;

import entidades.Comentarios;
import persisitencia.ComentariosDAO;
import java.util.List;

public class ComentarioService {
    private ComentariosDAO comentarioDAO = new ComentariosDAO();

    public void crearComentario(int idComentario, int idCasa, String comentario) throws Exception {
        // Validaciones
        if (comentario == null || comentario.trim().isEmpty()) 
            throw new IllegalArgumentException("El comentario no puede estar vacío.");
        if (idCasa <= 0) 
            throw new IllegalArgumentException("El ID de la casa debe ser válido.");

        Comentarios nuevoComentario = new Comentarios(idComentario, idCasa, comentario);
        comentarioDAO.crearComentario(nuevoComentario);
        System.out.println("Comentario agregado correctamente.");
    }

    public void listarComentarios() throws Exception {
        List<Comentarios> comentarios = comentarioDAO.mostrarComentarios();
        if (comentarios.isEmpty()) {
            System.out.println("No hay comentarios registrados.");
        } else {
            for (Comentarios comentario : comentarios) {
                System.out.println(comentario);
            }
        }
    }
}
