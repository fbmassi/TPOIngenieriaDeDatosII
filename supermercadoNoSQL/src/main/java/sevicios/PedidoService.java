package sevicios;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import negocios.ItemCarrito;
import org.bson.Document;

import javax.print.Doc;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Dictionary;
import java.util.List;

public class PedidoService {
    private URLService urlService;
    private MongoCollection<Document> pedidosCollection;
    private MongoCollection<Document> desdescuentosCollection;

    public PedidoService() {
        urlService = new URLService();
        MongoClient mongoClient = MongoClients.create(urlService.getConnectionStringMongoDB());
        MongoDatabase database = mongoClient.getDatabase(urlService.getDbComprasMongoDB());
        this.pedidosCollection = database.getCollection(urlService.getPedidosCollectionMongoDB());
        this.desdescuentosCollection = database.getCollection(urlService.getDescuentosCollectionMongoDB());
    }

    public void crearPedido(String cliente, String DNI, String direccion,
                            Date fecha, List<ItemCarrito> productos, Double importeParcial, Double importeFinal,
                            int descuentos, Double impuestos, Double precioBase, String estado) {

        SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ");
        String fechaFormatted = dateFormatter.format(fecha);

        List<Document> compras = new ArrayList<Document>();
        for (ItemCarrito itemCarrito: productos) {
            Document compra = new Document();
            compra.append("producto", itemCarrito.getProducto().getNombreProducto());
            compra.append("precio", itemCarrito.getProducto().getPrecio());
            compra.append("cantidad", itemCarrito.getCantidad());
            compras.add(compra);
        }

        Document nuevoPedido = new Document("client", cliente)
                .append("DNI", DNI)
                .append("direccion", direccion)
                .append("fecha", fechaFormatted)
                .append("productos", compras)
                .append("importe_parcial", importeParcial)
                .append("importe_final", importeFinal)
                .append("descuentos", descuentos)
                .append("impuestos", impuestos)
                .append("precioBase", precioBase)
                .append("estado", estado);
        pedidosCollection.insertOne(nuevoPedido);
    }

    public void insertarCodigoDeDescuento(String codigo, int descuento) {
        Document codigoDeDescuento = new Document();
        codigoDeDescuento.append("codigo", codigo).append("descuento", descuento);
        if (!existeCodigo(codigo)) {
            desdescuentosCollection.insertOne(codigoDeDescuento);
        }
    }

    public int obtenerDescuento(String codigo) {
        Document query = new Document();
        query.append("codigo", codigo);
        Document descuento = desdescuentosCollection.find(query).first();
        return descuento.getInteger("descuento");
    }

    public boolean codigoValido(String codigoDeDescuento) {
        Document query = new Document();
        query.append("codigo", codigoDeDescuento);
        Document descuento = desdescuentosCollection.find(query).first();
        return descuento != null;
    }

    private boolean existeCodigo(String codigoDeDescuento) {
        Document query = new Document();
        query.append("codigo", codigoDeDescuento);
        Document descuento = desdescuentosCollection.find(query).first();
        return descuento != null;
    }
    
}
