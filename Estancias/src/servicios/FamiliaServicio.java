package servicios;

import entidades.Familia;
import persisitencia.FamiliaDAO;
import java.util.List;
import java.util.regex.Pattern;

public class FamiliaServicio {
    private FamiliaDAO familiaDAO = new FamiliaDAO();

    private static final Pattern EMAIL_PATTERN = Pattern.compile("^[A-Za-z0-9+_.-]+@(.+)$");

    public void crearFamilia(int id, String nombre, int edadMinima, int edadMaxima, int numHijos, String email)
            throws Exception {
        // Validaciones
        if (nombre == null || nombre.trim().isEmpty())
            throw new IllegalArgumentException("El nombre no puede estar vacío.");
        if (edadMinima <= 0 || edadMaxima <= 0 || edadMinima > edadMaxima)
            throw new IllegalArgumentException("Edades inválidas.");
        if (numHijos < 0)
            throw new IllegalArgumentException("El número de hijos no puede ser negativo.");
        if (!EMAIL_PATTERN.matcher(email).matches())
            throw new IllegalArgumentException("El email no es válido.");

        Familia familia = new Familia(id, nombre, edadMinima, edadMaxima, numHijos, email);
        familiaDAO.crearFamilia(familia);
        System.out.println("Familia creada correctamente.");
    }

    public void listarFamilias() throws Exception {
        List<Familia> familias = familiaDAO.listarFamilias();
        if (familias.isEmpty()) {
            System.out.println("No hay familias registradas.");
        } else {
            for (Familia familia : familias) {
                System.out.println(familia);
            }
        }
    }

    public void listarFamiliasConHijos(int cant_hijos, int edad_maxima) {
        try {
            validarHijosYCantidad(cant_hijos, edad_maxima);
            List<Familia> familias = familiaDAO.listarFamiliasConHijos(cant_hijos, edad_maxima);
            if (familias.isEmpty()) {
                System.out.println("No hay familias registradas.");
            } else {
                for (Familia familia : familias) {
                    System.out.println(familia.toString());
                }
            }

        } catch (Exception e) {
            e.getStackTrace();
        }

    }

    public void validarHijosYCantidad(int cant_hijos, int edad_maxima) throws Exception {

        if ((cant_hijos < 0) || (edad_maxima < 0)) {
            throw new Exception("Parametro no valido, numero negativo");

        }

    }
}
