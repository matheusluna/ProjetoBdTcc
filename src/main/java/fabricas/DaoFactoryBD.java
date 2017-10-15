
package fabricas;

import dao.UsuarioDao;
import interfaces.UsuarioDaoIF;
import dao.TccDao;
import interfaces.TccDaoIF;

/**
 *
 * @author Reginaldo
 */
public class DaoFactoryBD implements DaoFactoryIF{
    
    private DaoFactoryBD instance;

    @Override
    public UsuarioDaoIF criaUsuarioDao() {
        return new UsuarioDao();
    }

    public TccDaoIF criaTccDao() {
        return (TccDaoIF) new TccDao();
    }
  
}
