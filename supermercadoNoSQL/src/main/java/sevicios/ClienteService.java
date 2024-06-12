package sevicios;
import com.mongodb.client.*;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;
import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.UpdateResult;
import org.bson.Document;
import org.bson.conversions.Bson;
import org.bson.types.ObjectId;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ClienteService {

    private URLService urlService = new URLService();
    private MongoCollection<Document> collectionCliente;
    private MongoCollection<Document> collectionProductos;
    private MongoCollection<Document> pedidosCollection;

    public ClienteService() {
        MongoClient mongoClient = MongoClients.create(urlService.getConnectionStringMongoDB());
        MongoDatabase databasePerfiles = mongoClient.getDatabase(urlService.getDbPerfilesMongoDB());
        this.collectionCliente = databasePerfiles.getCollection(urlService.getClientesCollectionMongoDB());
        MongoDatabase databaseProductos = mongoClient.getDatabase(urlService.getDbSupermercadoMongoDB());
        this.collectionProductos = databaseProductos.getCollection(urlService.getProductsCollectionMongoDB());
        MongoDatabase databasePedidos = mongoClient.getDatabase(urlService.getDbComprasMongoDB());
        this.pedidosCollection = databasePedidos.getCollection(urlService.getPedidosCollectionMongoDB());
    }

    public String crearCliente(String nombre, String direccion, String documentoIdentidad) {
        Document nuevoCliente = new Document("nombre", nombre)
                .append("direccion", direccion)
                .append("documento_identidad", documentoIdentidad)
                .append("categoria", "")
                .append("ultimo_cierre_de_sesion", "");
        collectionCliente.insertOne(nuevoCliente);
        return nuevoCliente.getObjectId("_id").toString();
    }

    public List<Document> obtenerTodosLosClientes() {
        List<Document> clientes = new ArrayList<>();
        for (Document doc : collectionCliente.find()) {
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
        DeleteResult result = collectionCliente.deleteMany(new Document());
        return result.getDeletedCount();
    }

    public boolean iniciarSesion(String nombre, String documentoIdentidad) {
        Document query = new Document("nombre", nombre).append("documento_identidad", documentoIdentidad);
        Document cliente = collectionCliente.find(query).first();
        return cliente != null;
    }

    public Document obtenerCliente(String nombre, String documentoIdentidad) {
        Document query = new Document("nombre", nombre)
                .append("documento_identidad", documentoIdentidad);
        return collectionCliente.find(query).first();
    }

    public void registrarActividad(String nombre, String documentoIdentidad, SimpleDateFormat formatoFecha, Date ultimoInicioDeSesion) {

        Date cierreDeSesion = new Date();
        long tiempoConectado = getDifferenceInSeconds(ultimoInicioDeSesion, cierreDeSesion);
        String categoria;

        if (tiempoConectado < 120) {
            categoria = "LOW";
        } else if (tiempoConectado < 240) {
            categoria = "MEDIUM";
        } else {
            categoria = "TOP";
        }

        String cierreDeSesionFormatted = formatoFecha.format(cierreDeSesion);

        Bson filter = Filters.and(Filters.eq("nombre", nombre), Filters.eq("documento_identidad", documentoIdentidad));
        Bson updates = Updates.combine(Updates.set("categoria", categoria),  Updates.set("ultimo_cierre_de_sesion", cierreDeSesionFormatted));

        collectionCliente.updateOne(filter, updates);

    }

    private long getDifferenceInSeconds(Date date1, Date date2) {
        long diffInMillis = date2.getTime() - date1.getTime();
        return diffInMillis / 1000;
    }

    public List<Document> obtenerTodosLosProductos() {
        List<Document> productos = new ArrayList<>();
        FindIterable<Document> iterador = collectionProductos.find();
        for (Document doc : iterador) {
            productos.add(doc);
        }
        return productos;
    }

    public Document obtenerProductoPorNombre(String nombreProducto) {
        Document query = new Document("nombre", nombreProducto);
        Document producto = collectionProductos.find(query).first();
        return producto;
    }

    public List<String> obtenerIdsDePedidosPorCliente(String cliente) {
        List<String> idsDePedidos = new ArrayList<>();
        Document query = new Document("client", cliente);
        for (Document doc : pedidosCollection.find(query)) {
            ObjectId id = doc.getObjectId("_id");
            idsDePedidos.add(id.toHexString());
        }
        return idsDePedidos;
    }

}

