package sevicios;

public class URLService {

    //Atributos MongoDB
    private String connectionStringMongoDB = "**************";
    private String dbPerfilesMongoDB = "perfiles";
    private String dbSupermercadoMongoDB = "supermercado";
    private String dbComprasMongoDB = "compras";
    private String clientesCollectionMongoDB = "clientes";
    private String administradoresCollectionMongoDB = "administradores";
    private String productsCollectionMongoDB = "productos";
    private String pedidosCollectionMongoDB = "pedidos";
    private String descuentosCollectionMongoDB = "codigosDeDescuento";
    private String pagosCollectionMongoDB = "pagos";
    private String facturasCollectionMongoDB = "facturas";


    //Metodos MongoDB
    public String getConnectionStringMongoDB() { return connectionStringMongoDB; }
    public String getDbPerfilesMongoDB() { return dbPerfilesMongoDB; }
    public String getDbSupermercadoMongoDB() { return dbSupermercadoMongoDB; }
    public String getClientesCollectionMongoDB() { return clientesCollectionMongoDB; }
    public String getAdministradoresCollectionMongoDB() { return administradoresCollectionMongoDB; }
    public String getProductsCollectionMongoDB() {
        return productsCollectionMongoDB;
    }
    public void setProductsCollectionMongoDB(String productsCollectionMongoDB) {this.productsCollectionMongoDB = productsCollectionMongoDB;}
    public String getPedidosCollectionMongoDB() {
        return pedidosCollectionMongoDB;
    }
    public void setPedidosCollectionMongoDB(String pedidosCollectionMongoDB) {this.pedidosCollectionMongoDB = pedidosCollectionMongoDB;}
    public String getDbComprasMongoDB() {
        return dbComprasMongoDB;
    }
    public void setDbComprasMongoDB(String dbComprasMongoDB) {
        this.dbComprasMongoDB = dbComprasMongoDB;
    }
    public String getDescuentosCollectionMongoDB() { return descuentosCollectionMongoDB; }
    public String getPagosCollectionMongoDB() { return pagosCollectionMongoDB; }
    public void setPagosCollectionMongoDB(String pagosCollectionMongoDB) { this.pagosCollectionMongoDB = pagosCollectionMongoDB; }
    public String getFacturasCollectionMongoDB() { return facturasCollectionMongoDB; }
    public void setFacturasCollectionMongoDB(String facturasCollectionMongoDB) { this.facturasCollectionMongoDB = facturasCollectionMongoDB; }

    //Atributos Redis
    private String redisHost = "************";
    private int redisPort = 17084;
    private String redisPassword = "**************";

    //Metodos Redis
    public String getRedisHost() {return redisHost;}
    public void setRedisHost(String redisHost) {this.redisHost = redisHost;}
    public int getRedisPort() {return redisPort;}
    public void setRedisPort(int redisPort) {this.redisPort = redisPort;}
    public String getRedisPassword() {return redisPassword;}
    public void setRedisPassword(String redisPassword) {this.redisPassword = redisPassword;}
}
