package sevicios;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.result.DeleteResult;
import org.bson.Document;

import java.util.ArrayList;
import java.util.List;

public class ClienteService {

    private URLService urlService = new URLService();
    private MongoCollection<Document> collection;

    public ClienteService() {
        MongoClient mongoClient = MongoClients.create(urlService.getConnectionStringMongoDB());
        MongoDatabase database = mongoClient.getDatabase(urlService.getDbPerfilesMongoDB());
        this.collection = database.getCollection(urlService.getClientesCollectionMongoDB());
    }

    public String crearCliente(String nombre, String direccion, String documentoIdentidad) {
        Document nuevoCliente = new Document("nombre", nombre)
                .append("direccion", direccion)
                .append("documento_identidad", documentoIdentidad);
        collection.insertOne(nuevoCliente);
        return nuevoCliente.getObjectId("_id").toString();
    }

    public List<Document> obtenerTodosLosClientes() {
        List<Document> clientes = new ArrayList<>();
        for (Document doc : collection.find()) {
            clientes.add(doc);
        }
        return clientes;
    }

    public void imprimirClientes() {
        List<Document> clientes = obtenerTodosLosClientes();
        for (Document cliente : clientes) {
            System.out.println(cliente.toJson());
        }
    }

    public long borrarTodosLosClientes() {
        DeleteResult result = collection.deleteMany(new Document());
        return result.getDeletedCount();
    }

    public boolean iniciarSesion(String nombre, String documentoIdentidad) {
        Document query = new Document("nombre", nombre).append("documento_identidad", documentoIdentidad);
        Document cliente = collection.find(query).first();
        return cliente != null;
    }

    public Document obtenerCliente(String nombre, String direccion, String documentoIdentidad) {
        Document query = new Document("nombre", nombre)
                .append("direccion", direccion)
                .append("documento_identidad", documentoIdentidad);
        return collection.find(query).first();
    }
}

