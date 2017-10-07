
package interfaces;

import entidades.Usuario;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Reginaldo
 */
public interface UsuarioDaoIF {
    
    public void inserir(Usuario u)throws SQLException;
    
    public Usuario getUsuario(String email) throws SQLException;
    
    public boolean logar(String email, String senha)throws SQLException; 
    
    public List<Usuario> listar() throws SQLException;
    
}
