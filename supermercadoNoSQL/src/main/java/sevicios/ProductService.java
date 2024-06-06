package sevicios;

import com.mongodb.client.*;
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

    public Document obtenerProductoPorNombre(String nombreProducto) {
        Document query = new Document("nombre", nombreProducto);
        return collection.find(query).first();
    }

    public boolean eliminarProducto(String nombreProducto) {
        DeleteResult result = collection.deleteOne(new Document("nombre", nombreProducto));
        return result.getDeletedCount() > 0;
    }

    public boolean actualizarPrecioProducto(String nombreProducto, double nuevoPrecio) {
        Document query = new Document("nombre", nombreProducto);
        Document update = new Document("$set", new Document("precio", nuevoPrecio));
        UpdateResult result = collection.updateOne(query, update);
        return result.getModifiedCount() > 0;
    }


}
