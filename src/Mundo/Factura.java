package Mundo;

import java.util.ArrayList;

public class Factura {
    
    public ArrayList<Producto> productos= new ArrayList<>();
    private Double total=0.0;
    public ArrayList<Integer> cantidades= new ArrayList<>();
    private String nombre;
    private Double totalAseo=0.0;
    
    public Factura(){}

    public void agregarProducto(Producto p,Integer cant){
        productos.add(p);
        cantidades.add(cant);  
    }
    
    

    public ArrayList<Integer> getCantidades() {
        return cantidades;
    }

    public void setCantidades(ArrayList<Integer> cantidades) {
        this.cantidades = cantidades;
    }
    
    
    
    public Double calcularTotal(){
        
       for(int i=0;i<productos.size();i++){
           Producto p=productos.get(i);
           Integer c=cantidades.get(i);
           total+=p.getPrecio()*c;
          
            if(p.getTipo().toString()=="aseo")
                totalAseo+=p.getPrecio()*c;
             
       }
       
       
        System.out.println("TOTAL:    "+"$"+total); 
        return total; 
    }
    
    public Double getTotalAseo(){
            return this.totalAseo;
    }
    
    public void setTotalAseo(Double cant){
             this.totalAseo=cant;
    }
    
    public ArrayList<Producto> getProductos() {
        return productos;
    }

    public void setProductos(ArrayList<Producto> productos) {
        this.productos = productos;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    
    
}
