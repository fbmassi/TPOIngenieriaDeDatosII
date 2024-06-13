package sevicios;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.bson.types.ObjectId;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class FacturaService {
    private URLService urlService;
    private MongoCollection<Document> facturasCollection;
    private MongoCollection<Document> pedidosCollection;

    public FacturaService() {
        urlService = new URLService();
        MongoClient mongoClient = MongoClients.create(urlService.getConnectionStringMongoDB());
        MongoDatabase database = mongoClient.getDatabase(urlService.getDbComprasMongoDB());
        this.facturasCollection = database.getCollection(urlService.getFacturasCollectionMongoDB());
        this.pedidosCollection = database.getCollection(urlService.getPedidosCollectionMongoDB());
    }

    public void generarFactura(ObjectId idPedido, String nombreCliente, Date fecha, List<Document> productos, Double importeParcial,
                               Double importeFinal, int descuentos, Double impuestos, Double precioBase) {
        SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ");
        String fechaFormatted = dateFormatter.format(fecha);
        Document factura = new Document("factura", idPedido.toString())
                .append("client", nombreCliente)
                .append("fecha", fechaFormatted)
                .append("productos", productos)
                .append("importe_parcial", importeParcial)
                .append("importe_final", importeFinal)
                .append("descuentos", descuentos)
                .append("impuestos", impuestos)
                .append("precioBase", precioBase);
        facturasCollection.insertOne(factura);
    }

    public Document obtenerPedido(ObjectId idPedido) {
        Document query = new Document("_id", idPedido);
        Document pedido = pedidosCollection.find(query).first();
        return pedido;
    }

}
