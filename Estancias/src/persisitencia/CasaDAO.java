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

    public void listarCasasConFechas () throws Exception {

        try {
            String sql = "SELECT c.id_casa, c.calle, c.numero, c.codigo_postal, c.ciudad, c.pais, c.fecha_desde, c.fecha_hasta FROM casas c WHERE\r\n" + //
                                "'2020-08-31' < c.fecha_hasta AND '2020-08-01' > c.fecha_desde AND c.pais = 'Reino Unido';";
            consultarDataBase(sql);
            Casa casa = null;
            List <Casa> casas = new ArrayList<>();
            while (resultSet.next()) {
                casa = new Casa();
                casa.setId_casa(resultSet.getInt("c.id_casa"));
                casa.setCalle(resultSet.getString("c.calle"));
                casa.setNumero(resultSet.getInt("c.numero"));
                casa.setCodigo_postal(resultSet.getString("c.codigo_postal"));
                casa.setCiudad(resultSet.getString("c.ciudad"));
                casa.setPais(resultSet.getString("c.pais"));
                casa.setFecha_desde(resultSet.getDate("c.fecha_desde"));
                casa.setFecha_hasta(resultSet.getDate("c.fecha_hasta"));
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
