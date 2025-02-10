import persisitencia.*;
public class App {
    public static void main(String[] args) throws Exception {
    CasaDAO casaDao = new CasaDAO();
    ComentariosDAO comentariosDao = new ComentariosDAO();
    ClienteDAO cliDao = new ClienteDAO();
    EstanciaDAO estDao = new EstanciaDAO();
    estDao.listarEstancias();
  

    }
}
