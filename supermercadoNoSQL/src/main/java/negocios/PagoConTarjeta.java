package negocios;

import controladores.Cliente;
import org.bson.types.ObjectId;

import java.util.Date;
import java.util.List;


public class PagoConTarjeta extends Pago {

    public PagoConTarjeta(String nombreCliente, List<ObjectId> pedidos, String operador, String numeroDeTarjeta, String codigoDeSeguridad) {
        super(nombreCliente, pedidos);
        setOperador(operador);
        setNumeroDeTarjeta(numeroDeTarjeta);
        setCodigoDeSeguridad(codigoDeSeguridad);
        setMedio("TARJETA");
        pagoService.pagarConTarjeta(pedidos, medio, operador, numeroDeTarjeta, codigoDeSeguridad, fecha, cliente, monto);
    }

    private String operador;
    private String numeroDeTarjeta;
    private String codigoDeSeguridad;

    public String getCodigoDeSeguridad() { return codigoDeSeguridad; }
    public void setCodigoDeSeguridad(String codigoDeSeguridad) { this.codigoDeSeguridad = codigoDeSeguridad; }
    public String getNumeroDeTarjeta() { return numeroDeTarjeta; }
    public void setNumeroDeTarjeta(String numeroDeTarjeta) { this.numeroDeTarjeta = numeroDeTarjeta; }
    public String getOperador() { return operador; }
    public void setOperador(String operador) { this.operador = operador; }
}