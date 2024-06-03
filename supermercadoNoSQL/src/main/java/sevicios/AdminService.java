package sevicios;

import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.result.DeleteResult;
import org.bson.Document;

import java.util.ArrayList;
import java.util.List;

public class AdminService {

    private MongoCollection<Document> collection;
    private URLService urlService = new URLService();

    public AdminService() {
        MongoClient mongoClient = MongoClients.create(urlService.getConnectionStringMongoDB());
        MongoDatabase database = mongoClient.getDatabase(urlService.getDbPerfilesMongoDB());
        this.collection = database.getCollection(urlService.getAdministradoresCollectionMongoDB());
    }

    public String crearAdministrador(String username, String contraseña) {
        Document nuevoAdministrador = new Document("usuario", username)
                .append("contraseña", contraseña);
        collection.insertOne(nuevoAdministrador);
        return nuevoAdministrador.getObjectId("_id").toString();
    }

    public List<Document> obtenerTodosLosAdministradores() {
        List<Document> admins = new ArrayList<>();
        for (Document doc : collection.find()) {
            admins.add(doc);
        }
        return admins;
    }

    public void imprimirAdministradores() {
        List<Document> administradores = obtenerTodosLosAdministradores();
        for (Document admin : administradores) {
            System.out.println(admin.toJson());
        }
    }

    public long borrarTodosLosAdministradores() {
        DeleteResult result = collection.deleteMany(new Document());
        return result.getDeletedCount();
    }

    public boolean iniciarSesion(String username, String contraseña) {
        Document query = new Document("usuario", username).append("contraseña", contraseña);
        Document cliente = collection.find(query).first();
        return cliente != null;
    }

    public Document obtenerAdmin(String username, String contraseña) {
        Document query = new Document("usuario", username).append("contraseña", contraseña);
        return collection.find(query).first();
    }
}