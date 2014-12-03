package wallet;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.MongoClient;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;
import com.mongodb.WriteConcern;
import java.net.UnknownHostException;
import java.util.Arrays;
import java.util.HashMap;

public class DBTest {

	public static void main(String[] args) throws UnknownHostException {
		getConnection();
	}
	public static void getConnection() throws UnknownHostException
	{
		//MongoClient mongoClient = new MongoClient( "mongodb://<abc>:<213>@ds047050.mongolab.com:47050/wallet");
		//DB db = mongoClient.getDB( "walletdb" );
		
		MongoCredential credential = MongoCredential.createMongoCRCredential("sanket2407", "walletdb","007bondymknysnS@".toCharArray());
    	MongoClient mongoClient = new MongoClient(new ServerAddress("ds041140.mongolab.com",41140), Arrays.asList(credential));
    	
    	DB db = mongoClient.getDB( "walletdb" );
		DBCollection coll = db.getCollection("new");
		System.out.println("connected");
		mongoClient.setWriteConcern(WriteConcern.JOURNALED);
		
		HashMap<String,String> hm1 = new HashMap<String, String>();
		
		hm1.put("card_id", "2121");
		hm1.put("card_name", "tower");
		
		BasicDBObject doc=new BasicDBObject();
		doc.put("checking", hm1);
		coll.insert(doc);
		System.out.println("done");
		/*
		BasicDBObject query11 = new BasicDBObject("password", "123");
    	DBCursor cursor = coll.find(query11);
    	try {
    	if(cursor.hasNext())
    	{
    		int flag = 0;
    		BasicDBObject query1 = (BasicDBObject) cursor.next();
    		System.out.println(query1.get("IDCards"));
    		BasicDBList dblist = (BasicDBList) query1.get("IDCards"); 
    		for(int i=0; i<dblist.size(); i++)
    		{
    			DBObject o = (DBObject) dblist.get(0);
    			System.out.println("1");
    			if(o.get("card_id").equals("c-20141016202520"))
    			{
    				dblist.remove(i);
    				BasicDBObject doc1=new BasicDBObject();
    				doc1.put("IDCards",dblist);
    	        	coll.update(query11,new BasicDBObject("$set",doc1));
    	        	flag = 1;
    	        	break;
    			}
 
    		}
    		if(flag == 1)
    		{
    			System.out.println("deleted");
    		}
    		else
    		{
    			System.out.println("no data");
    		}
    		/*for(int i=dblist.size()-1 ; i>=0; i--)
    		{
    			DBObject temp = (DBObject)dblist.get(i);
    			if(temp.get("card_number").toString().equals("23454"))
    			{
    				
    			}
    		}
    		System.out.println("done");
    	}
    	else{
    		System.out.println("no data");
    		}
    	}finally{
    		cursor.close();
    	}
		
		/*
		 BasicDBObject document = new BasicDBObject("IDCard", hm1);
	     coll.insert(document);
	     System.out.println("done");
		
		BasicDBObject doc=new BasicDBObject();
		BasicDBObject query = new BasicDBObject("userid", "U-20141016182803");
		doc.put("card_id","from");
		doc.put("card_name","too");
		doc.put("card_number","too");
		doc.put("expiration_date","too");
		BasicDBObject doc1=new BasicDBObject();
		doc1.put("IDCard",doc);
		coll.update(query,new BasicDBObject("$set",doc1));
		
		BasicDBObject query11 = new BasicDBObject("userid", "U-20141016182803");
    	DBCursor cursor = coll.find(query11);
    	try {
    	if(cursor.hasNext())
    	{
    		DBObject query1 = cursor.next();
    		System.out.println(query1);
    		
    		BasicDBObject q=new BasicDBObject("userid", "U-20141016182803");
    	
    		BasicDBObject doc1=new BasicDBObject();
    		doc1.put("IDCards",hm1);
    		
    		coll.update(q,new BasicDBObject("$push",doc1));
    		
    		
    		System.out.println("done");
    	}
    	else{
    		System.out.println("no data");
    		}
    	}finally{
    		cursor.close();
    	}
  */
	}
}
	

