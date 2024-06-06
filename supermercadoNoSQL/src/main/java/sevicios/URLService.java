package sevicios;

public class URLService {

    //Atributos MongoDB
    private String connectionStringMongoDB = "mongodb+srv://francomassi1:0kxEh0h6OkY4Wdba" +
            "@cluster0.cvnmxkx.mongodb.net/?retryWrites=true&w=majority&appName=Cluster0";
    private String dbPerfilesMongoDB = "perfiles";
    private String dbSupermercadoMongoDB = "supermercado";
    private String clientesCollectionMongoDB = "clientes";
    private String administradoresCollectionMongoDB = "administradores";
    private String productsCollectionMongoDB = "productos";

    //Metodos MongoDB
    public String getConnectionStringMongoDB() { return connectionStringMongoDB; }
    public String getDbPerfilesMongoDB() { return dbPerfilesMongoDB; }
    public String getDbSupermercadoMongoDB() { return dbSupermercadoMongoDB; }
    public String getClientesCollectionMongoDB() { return clientesCollectionMongoDB; }
    public String getAdministradoresCollectionMongoDB() { return administradoresCollectionMongoDB; }

    public String getProductsCollectionMongoDB() {
        return productsCollectionMongoDB;
    }

    public void setProductsCollectionMongoDB(String productsCollectionMongoDB) {
        this.productsCollectionMongoDB = productsCollectionMongoDB;
    }
}
