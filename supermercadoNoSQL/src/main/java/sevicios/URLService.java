package sevicios;

public class URLService {

    //Atributos MongoDB
    private String connectionStringMongoDB = "mongodb+srv://francomassi1:0kxEh0h6OkY4Wdba" +
            "@cluster0.cvnmxkx.mongodb.net/?retryWrites=true&w=majority&appName=Cluster0";
    private String dbPerfilesMongoDB = "perfiles";
    private String dbSupermercadoMongoDB = "supermercado";
    private String dbComprasMongoDB = "compras";
    private String clientesCollectionMongoDB = "clientes";
    private String administradoresCollectionMongoDB = "administradores";
    private String productsCollectionMongoDB = "productos";
    private String pedidosCollectionMongoDB = "pedidos";

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

    //Atributos Redis
    private String redisHost = "redis-17084.c308.sa-east-1-1.ec2.redns.redis-cloud.com";
    private int redisPort = 17084;
    private String redisPassword = "hDdLN1uyUp6FruxMqtal5VWsnr4gqlKo";

    //Metodos Redis
    public String getRedisHost() {return redisHost;}
    public void setRedisHost(String redisHost) {this.redisHost = redisHost;}
    public int getRedisPort() {return redisPort;}
    public void setRedisPort(int redisPort) {this.redisPort = redisPort;}
    public String getRedisPassword() {return redisPassword;}
    public void setRedisPassword(String redisPassword) {this.redisPassword = redisPassword;}
}
