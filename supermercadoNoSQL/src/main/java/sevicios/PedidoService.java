package sevicios;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import java.util.Date;

public class PedidoService {
    private URLService urlService;
    private MongoCollection<Document> collection;

    public PedidoService() {
        urlService = new URLService();
        MongoClient mongoClient = MongoClients.create(urlService.getConnectionStringMongoDB());
        MongoDatabase database = mongoClient.getDatabase(urlService.getDbComprasMongoDB());
        this.collection = database.getCollection(urlService.getPedidosCollectionMongoDB());
    }

    public void crearPedido(String formaDePago, Date fecha, double monto) {

    }
    
}
