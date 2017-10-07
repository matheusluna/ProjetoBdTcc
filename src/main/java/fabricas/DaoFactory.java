
package fabricas;

/**
 *
 * @author Reginaldo
 */
public class DaoFactory {
    public static DaoFactoryIF creatFactory(){
        return new DaoFactoryBD();
    }
}
