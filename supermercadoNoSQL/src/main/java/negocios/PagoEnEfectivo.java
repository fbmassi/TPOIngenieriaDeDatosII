package negocios;

import java.util.List;

public class PagoEnEfectivo extends Pago {

    public PagoEnEfectivo(List<String> pedidos) {
        super(pedidos);
        setMedio("EFECTIVO");
    }

}