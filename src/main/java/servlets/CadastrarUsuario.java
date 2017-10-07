package servlets;


import converterInformacao.ConverterData;
import gerenciadores.GerenciadorDeUsuario;
import gerenciadores.GerenciadorImagem;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;


/**
 *
 * @author Reginaldo
 */
    
public class CadastrarUsuario extends HttpServlet {

    private GerenciadorDeUsuario usuarioGer = new GerenciadorDeUsuario();
    ConverterData converter = new ConverterData();
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    
    if (ServletFileUpload.isMultipartContent(request)) {
            FileItemFactory factory = new DiskFileItemFactory();
            ServletFileUpload upload = new ServletFileUpload(factory);

            try {
                List<FileItem> itens;
                itens = (ArrayList<FileItem>) upload.parseRequest(request);

                String nome = itens.get(1).getString("UTF-8");
                String email = itens.get(2).getString("UTF-8");
                String senha = itens.get(3).getString("UTF-8");
                String dataNascimento = itens.get(4).getString("UTF-8");                
                String telefone = itens.get(5).getString("UTF-8");
                String sexo = itens.get(6).getString("UTF-8");
               
                
                String realPath = getServletContext().getRealPath("/imagensPerfil");
                String nomeImagem = nome;
                String foto;
                if (itens.get(0).getString().equals("")) {
                    foto = "images/usuario.png";
                } else {
                    new GerenciadorImagem().inserirImagemPerfil(itens.get(0), realPath, nomeImagem);
                    foto = "imagensPerfil/" + nomeImagem + ".jpg";
                }

                    usuarioGer.adicionarUsuario(nome, email, converter.stringParaDate(dataNascimento), senha, sexo, telefone, foto);

                

            } catch (SQLException ex) {
            Logger.getLogger(CadastrarUsuario.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(CadastrarUsuario.class.getName()).log(Level.SEVERE, null, ex);
        } catch (FileUploadException ex) {
            Logger.getLogger(CadastrarUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }

        }
        request.getRequestDispatcher("login.jsp").forward(request, response);
    }

}
