package sevicios;

import redis.clients.jedis.Jedis;

import java.text.SimpleDateFormat;
import java.util.*;

public class LogService {

    private URLService urlService;
    private Jedis jedis;
    SimpleDateFormat dateFormatter;

    public LogService() {
        this.urlService = new URLService();
        jedis = new Jedis(urlService.getRedisHost(), urlService.getRedisPort());
        jedis.auth(urlService.getRedisPassword());
        this.dateFormatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
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

    public List<String> obtenerLogPorNombreProducto(String nombreProducto) {
        Set<String> logKeys = jedis.keys("log:producto:*");
        List<String> logsProducto = new ArrayList<>();
        for (String logKey : logKeys) {
            List<String> logs = jedis.lrange(logKey, 0, -1);
            for (String log : logs) {
                if (log.contains("Nombre: " + nombreProducto)) {
                    logsProducto.add(log);
                }
            }
        }
        return logsProducto;
    }

    public List<String> obtenerTodosLosLogs() {
        Set<String> logKeys = jedis.keys("log:producto:*");
        List<String> todosLosLogs = new ArrayList<>();
        for (String logKey : logKeys) {
            List<String> logs = jedis.lrange(logKey, 0, -1);
            todosLosLogs.addAll(logs);
        }
        return todosLosLogs;
    }
}
