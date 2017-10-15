
package fabricas;

import interfaces.TccDaoIF;
import interfaces.UsuarioDaoIF;

/**
 *
 * @author Reginaldo
 */
public interface DaoFactoryIF {
    
    public UsuarioDaoIF criaUsuarioDao();
   
    public TccDaoIF criaTccDao();
}
