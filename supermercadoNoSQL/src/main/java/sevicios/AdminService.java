package sevicios;

import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

public class AdminService {

    private MongoCollection<Document> collection;
    private URLService urlService = new URLService();

    public AdminService(String connectionString, String dbName) {
        MongoClient mongoClient = MongoClients.create(urlService.getConnectionStringMongoDB());
        MongoDatabase database = mongoClient.getDatabase(urlService.getDbPerfilesMongoDB());
        this.collection = database.getCollection(urlService.getAdministradoresCollectionMongoDB());
    }

    public String crearAdministrador(String nombre, String direccion, String documentoIdentidad) {
        Document nuevoAdministrador = new Document("nombre", nombre)
                .append("direccion", direccion)
                .append("documento_identidad", documentoIdentidad)
                .append("role", "admin");
        collection.insertOne(nuevoAdministrador);
        return nuevoAdministrador.getObjectId("_id").toString();
    }
}