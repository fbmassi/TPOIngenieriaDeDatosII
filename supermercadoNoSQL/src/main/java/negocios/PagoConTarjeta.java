package negocios;

import java.util.List;


public class PagoConTarjeta extends Pago {

    public PagoConTarjeta(List<String> pedidos, String operador, String numeroDeTarjeta, String codigoDeSeguridad) {
        super(pedidos);
        this.operador = operador;
        this.numeroDeTarjeta = numeroDeTarjeta;
        this.codigoDeSeguridad = codigoDeSeguridad;
        setMedio("TARJETA");
    }

    private String operador;
    private String numeroDeTarjeta;
    private String codigoDeSeguridad;

}