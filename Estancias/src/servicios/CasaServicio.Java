package servicios;

import entidades.Casa;
import persisitencia.CasaDAO;
import java.util.List;

public class CasaServicio {

    public CasaServicio(){

    }
    private CasaDAO casaDAO = new CasaDAO();

    public void crearCasa(int id, String calle, int numero, String codigoPostal, String ciudad, String pais, 
                          java.sql.Date fechaDesde, java.sql.Date fechaHasta, int tiempoMin, int tiempoMax, 
                          double precioHabitacion, String tipoVivienda) throws Exception {
        // Validaciones
        if (calle == null || calle.trim().isEmpty()) throw new IllegalArgumentException("La calle no puede estar vacía.");
        if (ciudad == null || ciudad.trim().isEmpty()) throw new IllegalArgumentException("La ciudad no puede estar vacía.");
        if (pais == null || pais.trim().isEmpty()) throw new IllegalArgumentException("El país no puede estar vacío.");
        if (tiempoMin <= 0 || tiempoMax <= 0 || tiempoMin > tiempoMax) throw new IllegalArgumentException("Tiempo mínimo y máximo inválidos.");
        if (precioHabitacion < 0) throw new IllegalArgumentException("El precio debe ser positivo.");

        Casa casa = new Casa(id, calle, numero, codigoPostal, ciudad, pais, fechaDesde, fechaHasta, tiempoMin, tiempoMax, precioHabitacion, tipoVivienda);
        casaDAO.crearCasa(casa);
        System.out.println("Casa creada correctamente.");
    }
    /* 
    public void listarCasas() throws Exception {
        List<Casa> casas = casaDAO.listarCasas();
        if (casas.isEmpty()) {
            System.out.println("No hay casas registradas.");
        } else {
            for (Casa casa : casas) {
                System.out.println(casa);
            }
        }
    }*/

    public void listarCasasConFechas(String pais){
        try{
            if (pais != null)
                casaDAO.listarCasasConFechas();
            else{
                throw new Exception();
            }
        }catch(Exception e){
            System.out.println("El país no puede ser nulo");
        }
    }
}
