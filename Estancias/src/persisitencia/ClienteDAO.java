package persisitencia;
import entidades.Cliente;
import java.util.ArrayList;
import java.util.List;

public class ClienteDAO extends DAO{

    public void CrearCliente (Cliente cliente) throws Exception{
        try {
            String Sql = "INSERT INTO Clientes (id_cliente,nombre,calle,numero,codigo_postal,ciudad,pais,email) VALUES ("
            +cliente.getId_cliente() + "','" 
            +cliente.getNombre() +"','"
            +cliente.getCalle() +"','" 
            +cliente.getNumero()+"','"
            +cliente.getCodigo_postal()+"','"
            +cliente.getCiudad()+"','"
            +cliente.getPais()+"','"
            +cliente.getEmail()+");";
            insertarModificarEliminarDataBase(Sql);
            

        } catch (Exception e) {
            System.out.println("Error al insertar Cliente");// TODO: handle exception
        }
    }

    public List <Cliente> MostrarClientes (){
        try {
            String sql = "Select * FROM clientes";
            consultarDataBase(sql);
            List <Cliente> listadoCli = new ArrayList<>();

            while (resultSet.next()) {
            Cliente individuo = new Cliente();
            individuo.setId_cliente(resultSet.getInt("id_cliente"));
            individuo.setNombre(resultSet.getString("nombre"));    
            individuo.setCalle(resultSet.getString("calle"));
            individuo.setNumero(resultSet.getInt("numero"));
            individuo.setCodigo_postal(resultSet.getString("codigo_postal"));
            individuo.setCiudad(resultSet.getString("ciudad"));
            individuo.setPais(resultSet.getString("pais"));
            individuo.setEmail(resultSet.getString("email"));
            listadoCli.add(individuo);
            }
        
            for (Cliente cliente : listadoCli) {
                System.out.println(cliente.toString());
                System.out.println("***********************************");
            }
            System.out.println("");
            resultSet.close();
            return listadoCli;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
                   }
          
    }

}