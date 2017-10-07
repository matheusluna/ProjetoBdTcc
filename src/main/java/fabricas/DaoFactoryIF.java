
package fabricas;

import interfaces.UsuarioDaoIF;

/**
 *
 * @author Reginaldo
 */
public interface DaoFactoryIF {
    
    public UsuarioDaoIF criaUsuarioDao();
   
}
