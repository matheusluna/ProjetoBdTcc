
package fabricas;

import dao.UsuarioDao;
import interfaces.UsuarioDaoIF;

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

  
}
