package servicios;

import entidades.Estancia;
import persisitencia.EstanciaDAO;
import java.sql.Date;
import java.util.List;

public class EstanciaServicio {
    private EstanciaDAO estanciaDAO = new EstanciaDAO();

    public void crearEstancia(int idEstancia, int idCliente, int idCasa, String nombreHuesped, Date fechaDesde,
            Date fechaHasta) throws Exception {
        // Validaciones
        if (nombreHuesped == null || nombreHuesped.trim().isEmpty())
            throw new IllegalArgumentException("El nombre del huésped no puede estar vacío.");
        if (fechaDesde == null || fechaHasta == null)
            throw new IllegalArgumentException("Las fechas no pueden ser nulas.");
        if (fechaDesde.after(fechaHasta))
            throw new IllegalArgumentException("La fecha de inicio no puede ser posterior a la fecha de fin.");

        Estancia estancia = new Estancia(idEstancia, idCliente, idCasa, nombreHuesped, fechaDesde, fechaHasta);
        estanciaDAO.crearEstancia(estancia);
        System.out.println("Estancia creada correctamente.");
    }

    public void listarEstancias() throws Exception {
        List<Estancia> estancias = estanciaDAO.listarEstancias();
        if (estancias.isEmpty()) {
            System.out.println("No hay estancias registradas.");
        } else {
            for (Estancia estancia : estancias) {
                System.out.println(estancia);
            }
        }
    }
}
