package sevicios;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class LogService {

    private URLService urlService;
    private Jedis jedis;
    private SimpleDateFormat dateFormatter;
    private JedisPool jedisPool;

    class LogComparator implements Comparator<String> {
        private SimpleDateFormat dateFormatter;

        public LogComparator() {
            dateFormatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        }

        @Override
        public int compare(String log1, String log2) {
            try {
                String fechaStr1 = obtenerFecha(log1);
                String fechaStr2 = obtenerFecha(log2);
                Date fecha1 = dateFormatter.parse(fechaStr1);
                Date fecha2 = dateFormatter.parse(fechaStr2);
                return fecha2.compareTo(fecha1); // Orden descendente
            } catch (ParseException e) {
                e.printStackTrace();
                return 0;
            }
        }

        private String obtenerFecha(String log) {
            int indiceInicio = log.indexOf("Fecha: ") + 7;
            int indiceFin = log.length();
            return log.substring(indiceInicio, indiceFin);
        }
    }

    public LogService() {
        this.urlService = new URLService();
        JedisPoolConfig poolConfig = new JedisPoolConfig();
        this.jedisPool = new JedisPool(poolConfig, urlService.getRedisHost(), urlService.getRedisPort(), 2000, urlService.getRedisPassword());
        this.dateFormatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        jedis = jedisPool.getResource();
    }

    public void registrarCreacion(String productoId, String nombreProducto, String operador) {
        String logKey = "log:producto:" + productoId;
        String fecha = dateFormatter.format(new Date());
        String logEntry = String.format("Operación: Creación, Nombre: %s, Operador: %s, Fecha: %s",
                nombreProducto, operador, fecha);
        jedis.lpush(logKey, logEntry);
    }

    public void registrarCambio(String productoId, String nombreProducto, String campo, String valorAnterior, String nuevoValor, String operador) {
        String logKey = "log:producto:" + productoId;
        String fecha = dateFormatter.format(new Date());
        String logEntry = String.format("Operación: Modificación, Nombre: %s ,Campo: %s, Valor Anterior: %s, Nuevo Valor: %s, Operador: %s, Fecha: %s",
                nombreProducto, campo, valorAnterior, nuevoValor, operador, fecha);
        jedis.lpush(logKey, logEntry);
    }

    public void registrarEliminacion(String productoId, String nombreProducto, String operador) {
        String logKey = "log:producto:" + productoId;
        String fecha = dateFormatter.format(new Date());
        String logEntry = String.format("Operación: Eliminación, Nombre: %s , Operador: %s, Fecha: %s",
                nombreProducto, operador, fecha);
        jedis.lpush(logKey, logEntry);
    }


    public List<String> obtenerTodosLosLogs() {
        try (Jedis jedis = jedisPool.getResource()) {
            Set<String> logKeys = jedis.keys("log:producto:*");
            List<String> todosLosLogs = new ArrayList<>();
            for (String logKey : logKeys) {
                List<String> logs = jedis.lrange(logKey, 0, -1);
                for (String log : logs) {
                    todosLosLogs.add(log);
                }
            }
            todosLosLogs.sort(new LogComparator());
            return todosLosLogs;
        }
    }

}
