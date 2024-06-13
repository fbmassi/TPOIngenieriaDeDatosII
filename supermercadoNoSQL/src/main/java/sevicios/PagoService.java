package sevicios;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;
import controladores.Cliente;
import negocios.Pago;
import org.bson.Document;
import org.bson.types.ObjectId;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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

    public void pagarEnEfectivo(List<ObjectId> pedidosPendientes, String medio, Date fecha, String nombreCliente , Double monto) {
        SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ");
        String fechaFormatted = dateFormatter.format(fecha);
        Document documentoFinal = new Document("cliente", nombreCliente)
                .append("fecha", fechaFormatted);
        List<Document> pedidosAGuardar = new ArrayList<Document>();
        int n_pedido = 1;
        for (ObjectId id: pedidosPendientes) {
            Document query = new Document("_id", id);
            Document datosPedido = pedidosCollection.find(query).first();
            if (datosPedido != null) {
                Document detalles = new Document("fecha", fechaFormatted)
                        .append("importe_parcial", datosPedido.getDouble("importe_parcial"))
                        .append("descuentos", datosPedido.getInteger("descuentos"))
                        .append("importe_final", datosPedido.getDouble("importe_final"))
                        .append("impuestos", datosPedido.getDouble("impuestos"))
                        .append("precioBase", datosPedido.getDouble("precio_base"));
                Document pedido = new Document("Pedido Número " + n_pedido  + " ID de pedido: " + id, detalles);
                n_pedido++;
                pedidosAGuardar.add(pedido);
                pedidosCollection.updateOne(Filters.eq("_id", id), Updates.set("estado", "PAGADO"));
            }
        }
        documentoFinal.append("pedidos", pedidosAGuardar);
        documentoFinal.append("medio", medio);
        documentoFinal.append("monto_total", monto);
        pagosCollection.insertOne(documentoFinal);
    }

    public void pagarConTarjeta(List<ObjectId> pedidosPendientes, String medio, String operador, String numeroTarjeta, String codigo, Date fecha, String nombreCliente, Double monto) {
        SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ");
        String fechaFormatted = dateFormatter.format(fecha);
        Document documentoFinal = new Document("cliente", nombreCliente)
                .append("fecha", fechaFormatted);
        List<Document> pedidosAGuardar = new ArrayList<Document>();
        int n_pedido = 1;
        for (ObjectId id: pedidosPendientes) {
            Document query = new Document("_id", id);
            Document datosPedido = pedidosCollection.find(query).first();
            if (datosPedido != null) {
                Document detalles = new Document("fecha", fechaFormatted)
                        .append("importe_parcial", datosPedido.getDouble("importe_parcial"))
                        .append("descuentos", datosPedido.getInteger("descuentos"))
                        .append("importe_final", datosPedido.getDouble("importe_final"))
                        .append("impuestos", datosPedido.getDouble("impuestos"))
                        .append("precioBase", datosPedido.getDouble("precio_base"));
                Document pedido = new Document("Pedido Número " + n_pedido  + " ID de pedido: " + id, detalles);
                n_pedido++;
                pedidosAGuardar.add(pedido);
                pedidosCollection.updateOne(Filters.eq("_id", id), Updates.set("estado", "PAGADO"));
            }
        }
        documentoFinal.append("pedidos", pedidosAGuardar);
        documentoFinal.append("medio", medio);
        documentoFinal.append("operador", operador);
        documentoFinal.append("numero de tarjeta", numeroTarjeta);
        documentoFinal.append("codigo de seguridad", codigo);
        documentoFinal.append("monto_total", monto);
        pagosCollection.insertOne(documentoFinal);
    }

    public List<Double> obtenerMontosDePedidos(List<ObjectId> idsDePedidos) {
        List<Double> montos = new ArrayList<>();
        for (ObjectId id : idsDePedidos) {
            Document query = new Document("_id", id);
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
