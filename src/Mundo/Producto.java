    
package Mundo;

public class Producto {
    
    private String nombre;
    private String descripcion;
    private Double precio;
    private Tipo tipo;
    private Integer cantidadVendida=0;
    
    public Producto(){}
    
    public Producto(String nombre,String descripcion,Double precio,Tipo tipo){
    this.nombre=nombre;
    this.descripcion=descripcion;
    this.precio=precio;
    this.tipo=tipo;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }
        
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public Integer getCantidadVendida() {
        return cantidadVendida;
    }

    public void setCantidadVendida(Integer cantidadVendida) {
        this.cantidadVendida = cantidadVendida;
    }
    
    public void incrementarCant(Integer c){
        this.cantidadVendida+=c;
    }
    
}
