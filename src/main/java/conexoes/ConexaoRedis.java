/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conexoes;

import redis.clients.jedis.Jedis;

/**
 *
 * @author Reginaldo
 */
public class ConexaoRedis {
    public static void main(String[] args) { 
       // A ligar ao servidor Redis em localhost 
       Jedis jedis = new Jedis("localhost") ; 
       System.out.println("Connection to server sucessfully") ; 
       // verifica se o servidor está sendo executado ou não 
       System.out.println("Server is running: "+jedis.ping() ); 
  } 
}
