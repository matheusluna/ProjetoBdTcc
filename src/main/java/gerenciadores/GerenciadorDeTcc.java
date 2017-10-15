/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gerenciadores;

import dao.TccDao;
import entidades.Tcc;
import fabricas.DaoFactory;
import fabricas.DaoFactoryIF;
import interfaces.TccDaoIF;
import java.io.File;
import java.sql.SQLException;

/**
 *
 * @author Reginaldo
 */
public class GerenciadorDeTcc {
     public void adicionarTcc(String titulo, String autor, String orientador, String palavrasChave, String resumo, int ano, String area, String pdf) throws SQLException{
        Tcc novoTcc = new Tcc();
        novoTcc.setTitulo(titulo);
        novoTcc.setAutor(autor);
        novoTcc.setOrientador(orientador);
        novoTcc.setPalavrasChave(palavrasChave);
        novoTcc.setResumo(resumo);
        novoTcc.setAno(ano);
        novoTcc.setArea(area);
        novoTcc.setPdf(pdf);
        
        //DaoFactoryIF fabrica = DaoFactory.creatFactory();
        TccDao tccDao = new TccDao();
        tccDao.inserir(novoTcc); 
    }
    
//    private TccDao dao;
//    public GerenciadorDeTcc(){
//        dao = new TccDao();
//    }
//    
//    public void adicionar(Tcc tcc) throws Exception{
//        if(tcc == null){
//            throw new Exception("O produto é nulo!");
//        }
//        dao.inserir(tcc);
//    }
}
