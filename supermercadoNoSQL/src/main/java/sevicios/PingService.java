package sevicios;

import com.mongodb.*;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.exceptions.JedisConnectionException;

public class PingService {

    private final URLService urlService = new URLService();

    public void PingMongoDB() {
        ServerApi serverApi = ServerApi.builder()
                .version(ServerApiVersion.V1)
                .build();
        MongoClientSettings settings = MongoClientSettings.builder()
                .applyConnectionString(new ConnectionString(urlService.getConnectionStringMongoDB()))
                .serverApi(serverApi)
                .build();
        // Create a new client and connect to the server
        try (MongoClient mongoClient = MongoClients.create(settings)) {
            try {
                // Send a ping to confirm a successful connection
                MongoDatabase database = mongoClient.getDatabase(urlService.getDbPerfilesMongoDB());
                database.runCommand(new Document("ping", 1));
                System.out.println("Pinged your deployment. You successfully connected to MongoDB!");
            } catch (MongoException e) {
                e.printStackTrace();
            }
        }
    }

     public void PingRedis() {

         Jedis jedis = new Jedis(urlService.getRedisHost(), urlService.getRedisPort());

         try {
             jedis.auth(urlService.getRedisPassword());
             String response = jedis.ping();
             System.out.println("Ping response: " + response);
         } catch (JedisConnectionException e) {
             System.err.println("Error de conexión a Redis: " + e.getMessage());
             e.printStackTrace();
         } finally {
             if (jedis != null) {
                 jedis.close();
             }
         }
    }
}