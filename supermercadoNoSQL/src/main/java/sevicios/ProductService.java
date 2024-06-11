package sevicios;

import com.mongodb.client.*;
import com.mongodb.client.model.Updates;
import com.mongodb.client.model.Filters;
import com.mongodb.client.result.UpdateResult;
import org.bson.Document;

import java.util.ArrayList;
import java.util.List;


import com.mongodb.client.result.DeleteResult;

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

    public List<Document> obtenerTodosLosProductos() {
        List<Document> productos = new ArrayList<>();
        FindIterable<Document> iterador = collection.find();
        for (Document doc : iterador) {
            productos.add(doc);
        }
        return productos;
    }

    public List<String> obtenerProductosTexto() {
        List<String> productos = new ArrayList<>();
        FindIterable<Document> iterador = collection.find();
        for (Document doc : iterador) {
            String nombre = doc.getString("nombre");
            String descripción = doc.getString("descripcion");
            Double precio = doc.getDouble("precio");
            productos.add(nombre + " - " + descripción + " - $" + precio);
        }
        return productos;
    }

    public long borrarTodosLosProductos() {
        DeleteResult result = collection.deleteMany(new Document());
        return result.getDeletedCount();
    }

    public Document obtenerProductoPorNombre(String nombreProducto) {
        Document query = new Document("nombre", nombreProducto);
        return collection.find(query).first();
    }

    public boolean eliminarProducto(String nombreProducto) {
        DeleteResult result = collection.deleteOne(new Document("nombre", nombreProducto));
        return result.getDeletedCount() > 0;
    }

    public boolean modificarPrecioProducto(String nombreProducto, String nuevoPrecio) {
        Document query = new Document("nombre", nombreProducto);
        Document update = new Document("$set", new Document("precio", nuevoPrecio));
        UpdateResult result = collection.updateOne(query, update);
        return result.getModifiedCount() > 0;
    }

    public boolean modificarDescripcionProducto(String nombreProducto, String nuevaDescripcion) {
        UpdateResult result = collection.updateOne( Filters.eq("nombre", nombreProducto), Updates.set("descripcion", nuevaDescripcion));
        return result.getModifiedCount() > 0;
    }

    public List<String> obtenerNombresProductos() {
        List<String> nombresProductos = new ArrayList<>();
        FindIterable<Document> iterador = collection.find();
        for (Document doc : iterador) {
            String nombre = doc.getString("nombre");
            if (nombre != null) {
                nombresProductos.add(nombre);
            }
        }
        return nombresProductos;
    }


}
