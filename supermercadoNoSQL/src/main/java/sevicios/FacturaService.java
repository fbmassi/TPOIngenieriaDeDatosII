package sevicios;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import java.util.List;

public class FacturaService {
    private URLService urlService;
    private MongoCollection<Document> facturasCollection;

    public FacturaService() {
        urlService = new URLService();
        MongoClient mongoClient = MongoClients.create(urlService.getConnectionStringMongoDB());
        MongoDatabase database = mongoClient.getDatabase(urlService.getDbComprasMongoDB());
        this.facturasCollection = database.getCollection(urlService.getFacturasCollectionMongoDB());
    }

    public void generarFacturas(List<String> pedidos) {

    }

    public Document generarFactura(Document pedido) {
        pedido.g
        return null;
    }

}
