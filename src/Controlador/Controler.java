
package Controlador;


import Mundo.Factura;
import Mundo.Producto;
import Mundo.Servicio;
import Mundo.Tipo;
import Vista.VistaAgregarProducto;
import Vista.cuenta;
import com.sun.media.sound.SoftAbstractResampler;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Boris M
 */
public class Controler implements ActionListener{
        
    private cuenta vista=new cuenta();
    private Factura factura=new Factura();
    private Servicio s=new Servicio();
    private VistaAgregarProducto vistaAgg=new VistaAgregarProducto();
    public ArrayList<Producto> cantProductos= new ArrayList<>();
    private Double total=0.0;
    private Double totalAseo=0.0;
    private Integer contCant=0;
    
    public Controler() {
        ActionListener(this);
        vista.setVisible(true);
        s.leer("productos.txt");
        mostrar();
   
        vista.listaBoris.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {   }

            @Override
            public void keyPressed(KeyEvent e) {
         
                if(e.getKeyCode()==KeyEvent.VK_ENTER){
                    try {
                           int i=vista.listaBoris.getSelectedIndex();
                           agregarFactura(i);
                           contCant=0;
                    } catch (Exception ex) {}
                }
                
                if(e.getKeyCode()==KeyEvent.VK_RIGHT){
                    try {
                        contCant++;
                           vista.cantidad.setValue(contCant);
                           
                    } catch (Exception ex) {}
                }
                
                if(e.getKeyCode()==KeyEvent.VK_LEFT){
                    try {
                        contCant--;
                           vista.cantidad.setValue(contCant);
                           
                    } catch (Exception ex) {}
                }
                
                if(e.getKeyCode()==KeyEvent.VK_DOWN || e.getKeyCode()==KeyEvent.VK_UP){
                    try {
                        contCant=1;
                           vista.cantidad.setValue(contCant);
                           
                    } catch (Exception ex) {}
                }
                
                        // funcionamiento de tecla "0" para sacar total
                if(e.getKeyCode()==KeyEvent.VK_0){
                    try {
                        resume();
                    } catch (Exception ex) {}
                
                }
                
                if(e.getKeyCode()==KeyEvent.VK_1){
                    try {
                        siguient();
                    } catch (Exception ex) {}
                
                }
                
            }

            @Override
            public void keyReleased(KeyEvent e) {    }
        });
        
        
            
        vista.listaMama.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {   }

            @Override
            public void keyPressed(KeyEvent e) {
         
                if(e.getKeyCode()==KeyEvent.VK_ENTER){
                    try {
                           int i=vista.modeloLista.size();
                            i+=vista.listaMama.getSelectedIndex();
                           agregarFactura(i);
                           contCant=0;
                    } catch (Exception ex) {}
                }
                
                if(e.getKeyCode()==KeyEvent.VK_RIGHT){
                    try {
                        contCant++;
                           vista.cantidad.setValue(contCant);
                           
                    } catch (Exception ex) {}
                }
                
                if(e.getKeyCode()==KeyEvent.VK_LEFT){
                    try {
                        contCant--;
                           vista.cantidad.setValue(contCant);
                           
                    } catch (Exception ex) {}
                }
                
                if(e.getKeyCode()==KeyEvent.VK_DOWN || e.getKeyCode()==KeyEvent.VK_UP){
                    try {
                        contCant=1;
                           vista.cantidad.setValue(contCant);
                           
                    } catch (Exception ex) {}
                }
                
                // funcionamiento de tecla "0" para sacar total
                if(e.getKeyCode()==KeyEvent.VK_0){
                    try {
                        resume();
                    } catch (Exception ex) {}
                
                }
                
                if(e.getKeyCode()==KeyEvent.VK_1){
                    try {
                        siguient();
                    } catch (Exception ex) {}
                
                }
                
            }

            @Override
            public void keyReleased(KeyEvent e) {    }
        });
        
        
        vista.otrosTotal.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
             
            }

            @Override
            public void keyPressed(KeyEvent e) {
                
                if(e.getKeyCode()==KeyEvent.VK_ENTER){
                    try {
                           ingresar();
                    } catch (Exception ex) {}
                } 
            }

            @Override
            public void keyReleased(KeyEvent e) {
         
            }
        });
        
    }
    
    private void mostrar(){
    
        for(Producto p:s.productos){
            if(p.getTipo().equals(Tipo.mecato))
           vista.modeloLista.addElement(p.getNombre()+"           "+"$"+p.getPrecio());
            else
         vista.modeloLista3.addElement(p.getNombre()+"           "+"$"+p.getPrecio());   
            
        }       
    }
    
       
    private void ActionListener(ActionListener c) {
    vista.ingresar.addActionListener(c);
    vista.siguiente.addActionListener(c);
    vista.eliminar.addActionListener(c);
    vista.AggProducto.addActionListener(c);
    vistaAgg.agregar.addActionListener(c);
    vista.Resumen.addActionListener(c);
    }
    
    
    public void actionPerformed(ActionEvent e) {
    
        if (e.getSource().equals(vistaAgg.agregar)) {
        
        String n=vistaAgg.nombre.getText();
        String des=vistaAgg.descripcion.getText();
        Double precio=Double.parseDouble(vistaAgg.lblPrecio.getText());
        Tipo t= Tipo.valueOf(vistaAgg.tipo.getSelectedItem().toString());
        
        Producto p=new Producto(n, des, precio,t);
        
        s.productos.add(p);
        s.escribir("productos.txt");
        vista.modeloLista.addElement(p.getNombre()+"              "+"$"+p.getPrecio());
   
        limpiartext();
        JOptionPane.showMessageDialog(null,"Producto agregado");
        vistaAgg.dispose(); //esconde la ventana
        }
               
        if(e.getSource().equals(vista.siguiente)){
            siguient();
        }
        
        if(e.getSource().equals(vista.eliminar)){
            int i=vista.listafactura.getSelectedIndex();
            factura.productos.remove(i);
            factura.cantidades.remove(i);
            vista.modeloLista2.remove(i);   
            
        }
        
               
        if(e.getSource().equals(vista.AggProducto)){
            System.out.println("vista nueva");
            vistaAgg.setVisible(true);
        }
        
        if(e.getSource().equals(vista.Resumen)){
            
          resume();
    }
        
    }
    
    private void resume(){
        
      System.out.println("*****************************");
            System.out.println("*****************************");
            for(Producto p:cantProductos){
            System.out.println(p.getNombre()+"  :"+"     "+p.getCantidadVendida());   
            }
            System.out.println("Total Factura:"+"  $"+total);
            System.out.println("Total De Aseo"+"    $"+totalAseo);
        }   
        
    
    private void siguient(){
        
       String n=vista.nombre.getText();
            if(n.equals(""))
                JOptionPane.showMessageDialog(null,"ingrese un nombre");
            else{
            this.total+=factura.calcularTotal();
            this.totalAseo+=factura.getTotalAseo();
            
            factura.setNombre(n);
            mostrarFactura(n);
            
            
            vista.modeloLista2.removeAllElements();
            sumarProductos();
            
            factura.productos.clear();
            factura.cantidades.clear();
            factura.setTotal(0.0);
            factura.setTotalAseo(0.0);
            
            } 
        
    }
    
   
    
    public void mostrarFactura(String n){
        
        System.out.println(factura.getNombre().toUpperCase());
        
        System.out.println("cant"+"  |   "+"Producto"+"   | "+"Precio Und.");
        
        for (int i = 0; i < factura.productos.size(); i++) {
            Integer c=factura.cantidades.get(i);
            String nom=factura.productos.get(i).getNombre();
            Double pre=factura.productos.get(i).getPrecio();
            System.out.println(c+"       "+nom+"   $"+pre);
        }
        
        factura.setNombre("");
        vista.nombre.setText("");
        System.out.println("----------------------");
        System.out.println("----------------------");
            
    }
    
    //suma la cantidad de productos totales vendidos
    private void sumarProductos(){
    
        for (int i = 0; i < factura.productos.size(); i++) {
            Producto p=factura.productos.get(i);
            Integer c=factura.cantidades.get(i);
        
            
            Producto x=buscar(p);
            if(x!=null)
                x.incrementarCant(c);
            else{
                p.incrementarCant(c);
                cantProductos.add(p);
            }
            
        }
        
    }
    
    private Producto buscar(Producto p){
    
        for (Producto pro:cantProductos) {
            if(p.equals(pro))
                return pro;
        }
        return null;
    }
    
    private void agregarFactura(int i){         
            Producto p=s.productos.get(i);
            Integer cant=(Integer)vista.cantidad.getValue();
            factura.agregarProducto(p,cant);
            vista.modeloLista2.addElement(p.getNombre()+"   "+cant.toString());
            vista.cantidad.setValue(1);
    }
    
    private void ingresar() throws Exception{
        
        String des=vista.otrosDescr.getText();
        Double prec=Double.parseDouble(vista.otrosTotal.getText());
        Tipo t= Tipo.valueOf(vista.tipo.getSelectedItem().toString());
        
        Producto p=new Producto(des,"", prec,t);
        
        factura.agregarProducto(p,1);
        vista.modeloLista2.addElement(p.getNombre());
        
        vista.otrosDescr.setText("");
        vista.otrosTotal.setText("");
        
        throw new Exception("ingrese todos los datos");
    }
    
    
    private void limpiartext(){
    vistaAgg.nombre.setText("");
    vistaAgg.descripcion.setText("");
    vistaAgg.lblPrecio.setText("");
    }
    
    
    public static void main(String[] args) {
        Controler c=new Controler();
        
    }
    
}
