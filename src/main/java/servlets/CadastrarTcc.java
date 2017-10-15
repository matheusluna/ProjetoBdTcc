/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import entidades.LeitorPdf;
import gerenciadores.GerenciadorDeTcc;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.tika.exception.TikaException;
import org.xml.sax.SAXException;

/**
 *
 * @author Reginaldo
 */
@WebServlet(name = "CadastrarTcc", urlPatterns = {"/CadastrarTcc"})
@MultipartConfig
public class CadastrarTcc extends HttpServlet {
private GerenciadorDeTcc tccGer = new GerenciadorDeTcc();
   @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    

        if (ServletFileUpload.isMultipartContent(request)) {
            try {
//            FileItemFactory factory = new DiskFileItemFactory();
//            ServletFileUpload upload = new ServletFileUpload(factory);
//
//            try {
//                List<FileItem> itens;
//                itens = (ArrayList<FileItem>) upload.parseRequest(request);

String titulo = request.getParameter("titulo");
String autor = request.getParameter("autor");
String orientador = request.getParameter("orientador");
String palavrasChave = request.getParameter("palavrasChave");
String resumo = request.getParameter("resumo");
String a = request.getParameter("ano");
int ano = Integer.parseInt(a);
String area = request.getParameter("area");

//                String titulo = itens.get(1).getString("UTF-8");
//                String autor = itens.get(2).getString("UTF-8");
//                String orientador  = itens.get(3).getString("UTF-8");
//                String palavrasChave = itens.get(4).getString("UTF-8");                
//                String resumo  = itens.get(6).getString("UTF-8");
//                String a = itens.get(5).getString("UTF-8");
//                int ano = Integer.parseInt(a);
//                String area = itens.get(7).getString("UTF-8");

String caminho = getServletContext().getRealPath("/tcc")+File.separator+"pdf";

File caminhoUser = new File(caminho);
if(!caminhoUser.exists()) {
    caminhoUser.mkdirs();
}

Part path = request.getPart("pdf");
String cam = caminho+File.separator+path.getSubmittedFileName();
path.write(cam);
LeitorPdf leitor = new LeitorPdf(cam);
String pdf = leitor.getText();


try {
    
    
    tccGer.adicionarTcc(titulo, autor, orientador, palavrasChave, resumo, ano, area, pdf);
} catch (SQLException ex) {
    Logger.getLogger(CadastrarTcc.class.getName()).log(Level.SEVERE, null, ex);
}



//            } catch (FileUploadException ex) {
//            Logger.getLogger(CadastrarUsuario.class.getName()).log(Level.SEVERE, null, ex);
//        } catch (TikaException ex) {
//                Logger.getLogger(CadastrarTcc.class.getName()).log(Level.SEVERE, null, ex);
//            } catch (org.xml.sax.SAXException ex) {
//                Logger.getLogger(CadastrarTcc.class.getName()).log(Level.SEVERE, null, ex);
//            }

            } catch (TikaException ex) {
                    Logger.getLogger(CadastrarTcc.class.getName()).log(Level.SEVERE, null, ex);
                }

                
            catch (SAXException ex) {
                Logger.getLogger(CadastrarTcc.class.getName()).log(Level.SEVERE, null, ex);
            }

                

//            } catch (FileUploadException ex) {
//            Logger.getLogger(CadastrarUsuario.class.getName()).log(Level.SEVERE, null, ex);
//        } catch (TikaException ex) {
//                Logger.getLogger(CadastrarTcc.class.getName()).log(Level.SEVERE, null, ex);
//            } catch (org.xml.sax.SAXException ex) {
//                Logger.getLogger(CadastrarTcc.class.getName()).log(Level.SEVERE, null, ex);
//            }

        }
        request.getRequestDispatcher("principal.jsp").forward(request, response);
    }

}
