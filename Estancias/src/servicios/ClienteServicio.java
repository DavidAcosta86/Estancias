package servicios;

import entidades.Cliente;
import persisitencia.ClienteDAO;
import java.util.List;
import java.util.regex.Pattern;

public class ClienteServicio {
    private ClienteDAO clienteDAO = new ClienteDAO();
    
    private static final Pattern EMAIL_PATTERN = Pattern.compile("^[A-Za-z0-9+_.-]+@(.+)$");

    public void crearCliente(int id, String nombre, String calle, int numero, String codigo_postañ,String ciudad, String pais, String email) throws Exception {
        // Validaciones
        if (nombre == null || nombre.trim().isEmpty()) throw new IllegalArgumentException("El nombre no puede estar vacío.");
        if (ciudad == null || ciudad.trim().isEmpty()) throw new IllegalArgumentException("La ciudad no puede estar vacía.");
        if (pais == null || pais.trim().isEmpty()) throw new IllegalArgumentException("El país no puede estar vacío.");
        if (!EMAIL_PATTERN.matcher(email).matches()) throw new IllegalArgumentException("El email no es válido.");

        Cliente cliente = new Cliente(id, nombre, calle, numero,codigo_postañ,ciudad, pais, email);
        clienteDAO.CrearCliente(cliente);
        System.out.println("Cliente creado correctamente.");
    }

    public void listarClientes() throws Exception {
        List<Cliente> clientes = clienteDAO.MostrarClientes();
        if (clientes.isEmpty()) {
            System.out.println("No hay clientes registrados.");
        } else {
            for (Cliente cliente : clientes) {
                System.out.println(cliente);
            }
        }
    }
}
