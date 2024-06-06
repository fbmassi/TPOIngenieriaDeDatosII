package sevicios;

import redis.clients.jedis.Jedis;

public class LogService {

    private URLService urlService;

    public LogService() {
        this.urlService = new URLService();
        Jedis jedis = new Jedis(urlService.getRedisHost(), urlService.getRedisPort());
        jedis.auth(urlService.getRedisPassword());
    }
}
