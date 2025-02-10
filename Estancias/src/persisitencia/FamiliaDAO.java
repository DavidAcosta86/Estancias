package persisitencia;

import entidades.Familia;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FamiliaDAO extends DAO {

    public void crearFamilia(Familia familia) throws SQLException {
        try {
            String sql = "INSERT INTO familias (id, nombre, edad_minima, edad_maxima, num_hijos, email) VALUES ("
                    + familia.getId() + ", '" + familia.getNombre() + "', " + familia.getEdadMinima() + ", "
                    + familia.getEdadMaxima() + ", " + familia.getNumHijos() + ", '" + familia.getEmail() + "');";
            insertarModificarEliminarDataBase(sql);
        } catch (Exception e) {
            e.printStackTrace();
            throw new SQLException("Error al insertar familia en la base de datos");
        }
    }

    public List<Familia> listarFamilias() throws Exception {
        List<Familia> familias = new ArrayList<>();
        try {
            String sql = "SELECT id, nombre, edad_minima, edad_maxima, num_hijos, email FROM familias";
            consultarDataBase(sql);

            while (resultSet.next()) {
                Familia familia = new Familia();
                familia.setId(resultSet.getInt("id"));
                familia.setNombre(resultSet.getString("nombre"));
                familia.setEdadMinima(resultSet.getInt("edad_minima"));
                familia.setEdadMaxima(resultSet.getInt("edad_maxima"));
                familia.setNumHijos(resultSet.getInt("num_hijos"));
                familia.setEmail(resultSet.getString("email"));

                familias.add(familia);
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception("Error al listar las familias");
        } finally {
            desconectarDataBase();
        }
        return familias;
    }

    // Buscar y listar aquellas familias que tienen al menos 3 hijos, y con edad
    // máxima inferior a 10 años.

    public List<Familia> listarFamiliasConHijos(int num_hijos, int edad_maxima) throws Exception {
        List<Familia> familias = new ArrayList<>();
        try {
            String sql = "SELECT * FROM familias WHERE num_hijos > " + num_hijos + " AND edad_maxima <= " + edad_maxima
                    + ";";
            consultarDataBase(sql);

            while (resultSet.next()) {
                Familia familia = new Familia();
                familia.setId(resultSet.getInt("id"));
                familia.setNombre(resultSet.getString("nombre"));
                familia.setEdadMinima(resultSet.getInt("edad_minima"));
                familia.setEdadMaxima(resultSet.getInt("edad_maxima"));
                familia.setNumHijos(resultSet.getInt("num_hijos"));
                familia.setEmail(resultSet.getString("email"));

                familias.add(familia);
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception("Error al listar las familias");
        } finally {
            desconectarDataBase();
        }
        return familias;
    }
}