/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gerenciadores;

import com.fasterxml.jackson.core.io.NumberInput;
import com.google.gson.Gson;
import dao.TccDao;
import entidades.Tcc;
import fabricas.DaoFactory;
import fabricas.DaoFactoryIF;
import interfaces.TccDaoIF;
import java.io.File;
import java.sql.SQLException;
import javax.json.Json;
import static javax.ws.rs.client.Entity.json;
import redis.clients.jedis.Jedis;

/**
 *
 * @author Reginaldo
 */
public class GerenciadorDeTcc {
     public void adicionarTccMongo(String titulo, String autor, String orientador, String palavrasChave, String resumo, int ano, String area, String pdf) throws SQLException{
        Tcc novoTcc = new Tcc();
        novoTcc.setTitulo(titulo);
        novoTcc.setAutor(autor);
        novoTcc.setOrientador(orientador);
        novoTcc.setPalavrasChave(palavrasChave);
        novoTcc.setResumo(resumo);
        novoTcc.setAno(ano);
        novoTcc.setArea(area);
        novoTcc.setPdf(pdf);
        

    
       
        TccDao tccDao = new TccDao();
        tccDao.inserir(novoTcc); 
    }
    
 
    public void adicionarTccRedis(String titulo, String autor, String orientador, String palavrasChave, String resumo, int ano, String area, String pdf) throws Exception{
        Tcc novoTcc = new Tcc();
        novoTcc.setTitulo(titulo);
        novoTcc.setAutor(autor);
        novoTcc.setOrientador(orientador);
        novoTcc.setPalavrasChave(palavrasChave);
        novoTcc.setResumo(resumo);
        novoTcc.setAno(ano);
        novoTcc.setArea(area);
        novoTcc.setPdf(pdf);
        
        Jedis jedis = new Jedis("127.0.0.1",6379);  
        Gson gson = new Gson();
        int cont=1;
        String json = null;
        novoTcc.setSessionId(""+cont);
        cont++;
        json = gson.toJson(novoTcc);
        System.out.println(jedis.set(""+novoTcc.getSessionId(), json));
        
    }
    
    public Tcc retornaJson(String titulo, String autor, String orientador, String palavrasChave, String resumo, int ano, String area, String pdf){
        Tcc novoTcc = new Tcc();
        novoTcc.setTitulo(titulo);
        novoTcc.setAutor(autor);
        novoTcc.setOrientador(orientador);
        novoTcc.setPalavrasChave(palavrasChave);
        novoTcc.setResumo(resumo);
        novoTcc.setAno(ano);
        novoTcc.setArea(area);
        novoTcc.setPdf(pdf);
        
        Jedis jedis = new Jedis("127.0.0.1",6379);
        Gson gson2 = new Gson();
        Tcc tcc2 = gson2.fromJson(jedis.get(""+novoTcc.getSessionId()), Tcc.class);
        
        return tcc2;
//        System.out.println("\n---------------------------------------" +
//                "\nTitulo: " + tcc2.getTitulo() +
//                "\nPDF : " + tcc2.getPdf());
        
    }
}
