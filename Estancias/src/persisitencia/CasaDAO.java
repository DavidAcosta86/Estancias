package persisitencia;

import entidades.Casa;
import java.sql.SQLDataException;
import java.util.ArrayList;
import java.util.List;

public class CasaDAO extends DAO {

    public void crearCasa(Casa casa) throws SQLDataException {

        try {

            String sql = "INSERT INTO  casas (id_casa,calle,numero,codigo_postal,ciudad,pais,fecha_desde,fecha_hasta,tiempo_minimo,tiempo_maximo,precio_habitacion,tipo_vivienda) VALUES ("
                    + casa.getId_casa() + "','" + casa.getCalle() + "','" + casa.getNumero() + "','" +
                    casa.getCodigo_postal() + "','" + casa.getCiudad() + "','" + casa.getPais() + "','"
                    + casa.getFecha_desde() + "','" + casa.getFecha_hasta() + "','" + casa.getTiempo_minimo() + "','"
                    + casa.getTiempo_maximo() + "','" + casa.getPrecio_habitacion() + "','" + casa.getTipo_vivienda()
                    + ");";
            insertarModificarEliminarDataBase(sql);
        } catch (Exception e) {
            // TODO: handle exception
        }

    }


    public void listarCasas () throws Exception {

        try {
            String sql = "Select id_casa,calle,numero,codigo_postal,ciudad,pais FROM Casas";
            consultarDataBase(sql);
            Casa casa = null;
            List <Casa> casas = new ArrayList<>();
            while (resultSet.next()) {
                casa = new Casa();
                casa.setId_casa(resultSet.getInt("id_casa"));
                casa.setCalle(resultSet.getString("calle"));
                casa.setNumero(resultSet.getInt("numero"));
                casa.setCodigo_postal(resultSet.getString("codigo_postal"));
                casa.setCiudad(resultSet.getString("codigo_postal"));
                casa.setPais("pais");

                casas.add(casa);
            }

            for (Casa casaita : casas) {
                System.out.println(casaita.toString());
              System.out.println("*");
            }
            System.out.println("");
            desconectarDataBase();
        } catch (Exception e) {
            desconectarDataBase();
            e.printStackTrace();
            throw e;
        }

    }
}
