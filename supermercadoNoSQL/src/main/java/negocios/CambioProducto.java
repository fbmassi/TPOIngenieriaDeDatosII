package negocios;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import sevicios.LogService;
import java.util.*;

public class CambioProducto {

    private static final Logger log = LoggerFactory.getLogger(CambioProducto.class);

    public CambioProducto(Producto producto, String atributoModificado, String valorAnterior, String valorNuevo, String operator) {
        logService = new LogService();
        setProducto(producto);
        setId(producto.getId());
        setAtributoModificado(atributoModificado);
        setValorAnterior(valorAnterior);
        setValorNuevo(valorNuevo.toString());
        setOperador(operator);
    }

    public CambioProducto(Producto producto, String operator) {
        logService = new LogService();
        setProducto(producto);
        setId(producto.getId());
        setOperador(operator);
    }

    private String idProducto;
    private Producto producto;
    private String atributoModificado;
    private String valorAnterior;
    private String valorNuevo;
    private String operador;
    private LogService logService;

    public void registrarCreacionenLog() { logService.registrarCreacion(this.getId(), this.producto.getNombreProducto(), this.getOperador());}
    public void registrarCambioEnLog() { logService.registrarCambio(this.getId(), this.producto.getNombreProducto(), this.getAtributoModificado(), this.getValorAnterior(), this.getValorNuevo(), this.getOperador()); }
    public void registrarEliminaciónEnLog() { logService.registrarEliminacion(this.getId(), this.producto.getNombreProducto(), this.getOperador()); }
    public void setProducto(Producto producto) { this.producto = producto; }
    public String getAtributoModificado() { return atributoModificado; }
    public void setAtributoModificado(String atributoModificado) { this.atributoModificado = atributoModificado; }
    public String getValorAnterior() { return valorAnterior; }
    public void setValorAnterior(String valorAnterior) { this.valorAnterior = valorAnterior; }
    public String getValorNuevo() { return valorNuevo; }
    public void setValorNuevo(String valorNuevo) { this.valorNuevo = valorNuevo; }
    public String getOperador() { return operador;}
    public void setOperador(String operador) { this.operador = operador; }
    public void setId(String id) { this.idProducto = id; }
    public String getId() { return idProducto; }
}