package sevicios;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import negocios.Pago;
import org.bson.Document;
import org.bson.types.ObjectId;

import java.util.ArrayList;
import java.util.List;

public class PagoService {
    private URLService urlService;
    private MongoCollection<Document> pedidosCollection;
    private MongoCollection<Document> pagosCollection;

    public PagoService() {
        urlService = new URLService();
        MongoClient mongoClient = MongoClients.create(urlService.getConnectionStringMongoDB());
        MongoDatabase database = mongoClient.getDatabase(urlService.getDbComprasMongoDB());
        this.pedidosCollection = database.getCollection(urlService.getPedidosCollectionMongoDB());
        this.pagosCollection = database.getCollection(urlService.getPagosCollectionMongoDB());
    }

    public void registrarPagoEnEfectivo() {

    }

    public List<Double> obtenerMontosDePedidos(List<String> idsDePedidos) {
        List<Double> montos = new ArrayList<>();
        for (String id : idsDePedidos) {
            Document query = new Document("_id", new ObjectId(id));
            Document pedido = pedidosCollection.find(query).first();
            if (pedido != null && pedido.containsKey("importe_final")) {
                Double monto = pedido.getDouble("importe_final");
                montos.add(monto);
            } else {
                montos.add(0.0);
            }
        }
        return montos;
    }
}
