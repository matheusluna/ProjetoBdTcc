package gerenciadores;




import entidades.ImagemDeRequisicao;
import java.io.IOException;
import org.apache.commons.fileupload.FileItem;


public class GerenciadorImagem {
    
 
    public void inserirImagemPerfil(FileItem item, String realPath, String nomeDaImagem) throws IOException{
        
        ImagemDeRequisicao.inserirImagem(item, realPath, nomeDaImagem);
    }
}
