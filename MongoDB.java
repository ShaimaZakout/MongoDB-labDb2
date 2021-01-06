import java.util.ArrayList;
import java.util.Arrays;

import org.bson.Document;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoIterable;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;
import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.UpdateResult;

public class MongoDB {

	public static void main(String[] args) {
		// Create Connection with MongoDB server
		MongoClient client=new MongoClient("localhost",27017); // 127.0.0.1
//		System.out.println(client.getConnectPoint());
		
		// create DB
		MongoDatabase db=client.getDatabase("school");
//		for(String name:client.listDatabaseNames()) {
//			System.out.println(name);
//		}
//		System.out.println("--------------------");
		// create collection 
		MongoCollection<Document> collection=db.getCollection("students");
		
		// list all exiting collections in the database
//		for(String name:db.listCollectionNames()) {
//			System.out.println(name);
//		}
		// create document
		Document doc1=new Document("id", 1)
				.append("name", "Haneen")
				.append("age", 22)
				.append("Courses", Arrays.asList("DS","DB2","WS"))
				.append("More Information",
						new Document("NoOfEndedHours",70)
						.append("GPA", 94.2))
				;
		// insert One document in the collection 
//		collection.insertOne(doc1);
//		System.out.println("--------------------");
		// count no. of documents added in the collection 
//		System.out.println("count"+collection.count());

		// insert many documents in the collection 
		Document doc2=new Document("id", 2)
				.append("name", "Ali")
				.append("age", 23)
				.append("Courses", Arrays.asList("DS","DB2"))
				.append("City", "Gaza")
				
				;
		Document doc3=new Document("gender", "Female")
				.append("street", "street")
				;
		ArrayList<Document> list=new ArrayList<Document>();
		list.add(doc2);
		list.add(doc3);
//		collection.insertMany(list);
//		System.out.println("count"+collection.count());
		// retrieve first document in the collection
//		Document doc=collection.find().first();
//		System.out.println("First Doc "+doc.toJson());
		// retrieve all documents from collection
//		MongoCursor<Document> it=collection.find().iterator();
//		while(it.hasNext()) {
//			System.out.println("Doc "+it.next().toJson());
//		}
		// retrieve specific documents from collection
//		MongoCursor<Document> it=collection.find(Filters.eq("id", 2)).iterator();
//		while(it.hasNext()) {
//			System.out.println("Doc "+it.next().toJson());
//		}
		// update one document 
//		UpdateResult rs=collection.updateOne(Filters.eq("id", 1), Updates.set("name", "Hala"));
//		System.out.println(rs.getModifiedCount());
		// update many documents
//		UpdateResult rs=collection.updateMany(Filters.gt("id", 2), Updates.set("age", 21));
//		System.out.println(rs.getModifiedCount());
		// delete one document
//		DeleteResult dre=collection.deleteOne(Filters.eq("id", 1));
//		System.out.println(dre.getDeletedCount());
		// delete many documents
//		DeleteResult dre=collection.deleteMany(Filters.gt("age", 20));
//		System.out.println(dre.getDeletedCount());
//		System.out.println("count"+collection.count());
		// delete collection
		collection.drop();
		for(String name:db.listCollectionNames()) {
		System.out.println(name);
	}
		db.drop();
	}

}
