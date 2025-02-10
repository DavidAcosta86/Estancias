package persisitencia;

import entidades.Estancia;
import java.util.ArrayList;
import java.util.List;

public class EstanciaDAO extends DAO {

    public void crearEstancia(Estancia estancia) throws Exception {
        try {
            String sql = "INSERT INTO Estancias (id_estancia, id_cliente, id_casa, nombre_huesped, fecha_desde, fecha_hasta) VALUES ("
                    + estancia.getId_estancia() + ", "
                    + estancia.getId_cliente() + ", "
                    + estancia.getId_casa() + ", '"
                    + estancia.getNombre_huesped() + "', '"
                    + estancia.getFecha_desde() + "', '"
                    + estancia.getFecha_hasta() + "');";

            insertarModificarEliminarDataBase(sql);
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    public List<Estancia> listarEstancias() throws Exception {
        List<Estancia> estancias = new ArrayList<>();

        try {
            String sql = "SELECT id_estancia, id_cliente, id_casa, nombre_huesped, fecha_desde, fecha_hasta FROM Estancias";
            consultarDataBase(sql);

            while (resultSet.next()) {
                Estancia estancia = new Estancia(
                        resultSet.getInt("id_estancia"),
                        resultSet.getInt("id_cliente"),
                        resultSet.getInt("id_casa"),
                        resultSet.getString("nombre_huesped"),
                        resultSet.getDate("fecha_desde"),
                        resultSet.getDate("fecha_hasta"));

                estancias.add(estancia);
            }
            for (Estancia estancia : estancias) {
                System.out.println(estancia.toString());
            }

        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        } finally {
            desconectarDataBase();
        }

        return estancias;
    }
}