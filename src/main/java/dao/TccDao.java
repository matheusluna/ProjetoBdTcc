/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.MongoClient;
import conexoes.ConnectionFactory;
import conexoes.MongoConnection;
import entidades.Tcc;
import entidades.TccDBObject;
import java.sql.Connection;
import java.sql.SQLException;
import org.bson.types.ObjectId;

/**
 *
 * @author Reginaldo
 */
public class TccDao {
    ConnectionFactory factory = new ConnectionFactory();
    MongoConnection conexao = new MongoConnection();
    Connection con;

    public TccDao() {
        try {
            con = factory.getConnection();
        } catch (Exception e) {
            
        }
    }
    
    public int inserir(Tcc tcc) throws SQLException {
        
      try
        {
            MongoClient mongoClient = new MongoClient("localhost", 27017);
            DB db = mongoClient.getDB("tcc");
            
            DBCollection coll  = db.getCollection( "tccs" );
//            tcc.setSessionId(new ObjectId()._inc());
//            System.out.println(tcc.getSessionId());
            coll.insert( new TccDBObject( tcc ) );
            
           // client.close();
            
            
        }
        catch( Exception err )
        {
            System.out.println(err);
        }
        return 0;
    }
}
