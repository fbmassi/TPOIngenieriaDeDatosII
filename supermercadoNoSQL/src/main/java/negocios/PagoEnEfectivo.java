package negocios;

import controladores.Cliente;
import org.bson.types.ObjectId;

import java.util.List;

public class PagoEnEfectivo extends Pago {
    public PagoEnEfectivo(String nombreCliente, List<ObjectId> pedidos) {
        super(nombreCliente, pedidos);
        setMedio("EFECTIVO");
        pagoService.pagarEnEfectivo(pedidos, medio, fecha, cliente, monto);
    }
}