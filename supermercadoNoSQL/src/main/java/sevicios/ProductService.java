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
            String descripcion = doc.getString("descripcion");
            Object precioObj = doc.get("precio"); // Obtiene el precio como un Object

            // Verifica el tipo de dato del precio
            if (precioObj instanceof Double) {
                Double precio = (Double) precioObj;
                productos.add(nombre + " - " + descripcion + " - $" + precio);
            } else if (precioObj instanceof String) {
                try {
                    Double precio = Double.parseDouble((String) precioObj);
                    productos.add(nombre + " - " + descripcion + " - $" + precio);
                } catch (NumberFormatException e) {
                    // Maneja el error si no se puede convertir a Double
                    System.err.println("Error: No se puede convertir el precio a Double para el producto: " + nombre);
                }
            } else {
                // Maneja otros tipos de datos para el precio si es necesario
                System.err.println("Error: Tipo de dato no soportado para el precio para el producto: " + nombre);
            }
        }
        return productos;
    }

    public long borrarTodosLosProductos() {
        DeleteResult result = collection.deleteMany(new Document());
        return result.getDeletedCount();
    }

    public Document obtenerProductoPorNombre(String nombreProducto) {
        Document query = new Document("nombre", nombreProducto);
        Document producto = collection.find(query).first();
        return producto;
    }


    public boolean eliminarProducto(String nombreProducto) {
        DeleteResult result = collection.deleteOne(new Document("nombre", nombreProducto));
        return result.getDeletedCount() > 0;
    }

    public boolean modificarPrecioProducto(String nombreProducto, Double nuevoPrecio) {
        UpdateResult result = collection.updateOne(Filters.eq("nombre", nombreProducto), Updates.set("precio", nuevoPrecio));
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
