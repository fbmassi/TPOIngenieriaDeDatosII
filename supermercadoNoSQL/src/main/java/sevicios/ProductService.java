package sevicios;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

public class ProductService {

    private URLService urlService;
    private MongoCollection<Document> collection;


    public ProductService() {
        urlService = new URLService();
        MongoClient mongoClient = MongoClients.create(urlService.getConnectionStringMongoDB());
        MongoDatabase database = mongoClient.getDatabase(urlService.getDbSupermercadoMongoDB());
        this.collection = database.getCollection(urlService.getProductsCollectionMongoDB());
    }

    public String crearProducto(String nombreProducto, String descripcion, double precio) {
        Document nuevoProducto = new Document("nombre", nombreProducto)
                .append("descripcion", descripcion)
                .append("precio", precio);
        collection.insertOne(nuevoProducto);
        return nuevoProducto.getObjectId("_id").toString();
    }
}
