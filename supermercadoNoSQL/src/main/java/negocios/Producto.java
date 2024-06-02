package negocios;

/**
 * 
 */
public class Producto {

    /**
     * Default constructor
     */
    public Producto(String nombreProducto, String descricpion, double precio) {
        this.nombreProducto = nombreProducto;
        this.descricpion = descricpion;
        this.precio = precio;
    }

    /**
     * 
     */
    private int id;

    /**
     * 
     */
    private String nombreProducto;

    /**
     * 
     */
    private String descricpion;

    /**
     * 
     */
    private double precio;

    /**
     * 
     */
    private String fotos;

    /**
     * 
     */
    private String videos;

    /**
     * 
     */
    private String comentarios;

    /**
     * @param double nuevoPrecio 
     * @return
     */
    public void actualizarPrecio(Double nuevoPrecio) {
        // TODO implement here
    }

    /**
     * @param String comentario 
     * @return
     */
    public void agregarComentario(String comentario) {
        // TODO implement here
    }

    /**
     * @param String foto 
     * @return
     */
    public void agregarFoto(String foto) {
        // TODO implement here
    }

    /**
     * @param String video 
     * @return
     */
    public void agregarVideo(String video) {
        // TODO implement here
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public String getDescricpion() {
        return descricpion;
    }

    public void setDescricpion(String descricpion) {
        this.descricpion = descricpion;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }
}