package entidades;


import com.mongodb.BasicDBObject;
import org.bson.types.ObjectId;

/**
 *
 * @author avld
 */
public class TccDBObject extends BasicDBObject
{
    
    public TccDBObject()
    {
        
    }
    
    public TccDBObject( Tcc tcc )
    {
        setTcc(tcc );
    }
    
    public void setTcc( Tcc tcc )
    {
        append( "titulo", tcc.getTitulo());
        append( "autor" , tcc.getAutor());
        append("orientador"  , tcc.getOrientador());
        append( "palavrasChave", tcc.getPalavrasChave());
        append( "resumo" , tcc.getResumo());
        append("ano"  , tcc.getAno());
        append( "area", tcc.getArea());
        append( "pdf" , tcc.getPdf());
        
    }
    
    public Tcc getTcc()
    {
        System.out.println( this );
        
 
        
        Tcc tcc = new Tcc();

        tcc.setTitulo("titulo");
        tcc.setAutor("autor");
        tcc.setOrientador("orientador");
        tcc.setPalavrasChave("palavrasChave");
        tcc.setResumo("resumo");
        tcc.setAno(Integer.parseInt("ano"));
        tcc.setArea("area");
        tcc.setPdf("pdf");
        
        return tcc;
    }
    
}
