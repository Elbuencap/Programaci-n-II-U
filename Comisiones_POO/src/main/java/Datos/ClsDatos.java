
package Datos;

import Modelos.ModVendedor;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class ClsDatos {
    
    public List<ModVendedor> lista=new ArrayList<ModVendedor>();
    public final int NUMVENDEDORES=5;
    private int nom=0;
    private Scanner entrada=new Scanner(System.in); 
    private String s;
    
    public void UltimoMsj(){
        System.out.println("\n\nSi desea regresar al Menú, ingrese la palabra 'M' : ");    
        String palabra=entrada.nextLine();
        palabra=entrada.nextLine();
        
        if(palabra.contains("M")){             
            Menu();            
        }
    }
    
    public void MostrarDatos(){
        System.out.println("NOMBRE\t\tENERO\t\tFEBRERO\t\tMARZO\t\tABRIL\t\tTOTAL VENTAS\t\tCOMISION\t\tVENTAS MAS COMISION\t\tISR\t\tTOTAL");
        for(ModVendedor e:lista){
            System.out.print(e.nombre+"\t\tQ."+e.enero+"\t\tQ."+e.febrero+"\t\tQ."+e.marzo+"\t\tQ."+e.abril+"\t\tQ."+e.totalVentas+"\t\tQ."+e.comision+"\t\tQ."+e.totalMasComision+"\t\tQ."+e.isr+"\t\tQ."+e.granTotal);
            System.out.print("\n");         
        }        
                
    }
       
    
    public void IngresoDatos(){
        ModVendedor vendedor= new ModVendedor();

        System.out.println("VALIDO SOLO 5 VENDEDORES");
        System.out.println("¿Cuantos datos desea ingresar?");
        int opcion=entrada.nextInt();
        
        if (opcion <= NUMVENDEDORES) {
            for (int i = 0; i < opcion; i++) {            
               System.out.println("Ingrese nombre "+(++nom)+":");
               s=entrada.nextLine();
               vendedor.nombre=entrada.nextLine();
               System.out.println("Ingrese Enero: ");
               vendedor.enero=entrada.nextDouble();
               System.out.println("Ingrese Febrero: ");
               vendedor.febrero=entrada.nextDouble();
               System.out.println("Ingrese Marzo: ");
               vendedor.marzo=entrada.nextDouble();
               System.out.println("Ingrese Abril: ");
               vendedor.abril=entrada.nextDouble();
               System.out.println("Ingrese Mayo: ");
               vendedor.mayo=entrada.nextDouble();
               System.out.println("Ingrese Junio: ");
               vendedor.junio=entrada.nextDouble();
               System.out.println("Ingrese Julio: ");
               vendedor.julio=entrada.nextDouble();
               System.out.println("Ingrese Agosto: ");
               vendedor.agosto=entrada.nextDouble();
               System.out.println("Ingrese Septiembre: ");
               vendedor.septiembre=entrada.nextDouble();
               System.out.println("Ingrese Octubre: ");
               vendedor.octubre=entrada.nextDouble();
               System.out.println("Ingrese Noviembre: ");
               vendedor.noviembre=entrada.nextDouble();
               System.out.println("Ingrese Diciembre: ");
               vendedor.diciembre=entrada.nextDouble();
               vendedor.totalVentas=vendedor.enero+vendedor.febrero+vendedor.marzo+vendedor.abril+vendedor.mayo+vendedor.junio+vendedor.julio+vendedor.agosto+vendedor.septiembre+vendedor.octubre+vendedor.noviembre+vendedor.diciembre;
               if(vendedor.totalVentas <= 2000){
                   vendedor.comision=vendedor.totalVentas * 0.2;
               }else{
                   vendedor.comision=vendedor.totalVentas * 0.35;
               }
               vendedor.totalMasComision = vendedor.totalVentas + vendedor.comision;
               vendedor.isr = vendedor.totalMasComision * 0.05;
               vendedor.granTotal = vendedor.totalMasComision - vendedor.isr;
               lista.add(vendedor); 
               vendedor=new ModVendedor();
           }   
        }else {
            System.out.println("La cantidad no es valida");
        }                                              
    }
    
    public void NumMax(){
        double mayor=0;
        double num=0;        
        double total=0;
        String vendedor = "";
        
        
        for(ModVendedor e: lista){           
            total=e.granTotal;        
            if (total > num )
            {
                mayor=total; 
                vendedor = e.nombre;
            }
            num=mayor;
            
            
        }       
        
        System.out.println("EL VENDEDOR QUE RECIBIO MAS FUE: "+ vendedor+" Y LA CANTIDAD FUE DE: Q."+mayor+".00\n\n");
        
    }
   
    public void NumMin(){
        double num=0;
        double menor=0;
        double total=0;
        String nombre = "";        
        
        for (ModVendedor e: lista) {            
            menor=e.granTotal;
            for (ModVendedor x: lista) {            
                num=x.granTotal;
                if(num<menor){
                    menor=num;
                    nombre = x.nombre;
                }

            }           

        }            

        System.out.println("EL VENDEDOR QUE RECIBIO MENOS FUE: "+ nombre+" Y LA CANTIDAD FUE DE: Q."+menor+".00\n\n");
        
    }
    
   
    public void Menu(){               
        System.out.print("\n\t\t\t\tSelecciona una Opcion");
        System.out.println("\n\t\t1. INGRESAR DATOS ");
        System.out.println("\n\t\t2. VENTA MAXIMA");
        System.out.println("\n\t\t3. VENTA MINIMA");
        System.out.println("\n\t\t4. MOSTRAR DATOS");
        int op=entrada.nextInt();

        try{                        
            
            switch(op){
            case 1:
                IngresoDatos();                
                UltimoMsj();
                break;          
            case 2:
                NumMax();
                UltimoMsj();
                break;
            case 3:
                NumMin();
                UltimoMsj();
                break;                                           
            case 4:
                MostrarDatos();
                UltimoMsj();
                break;
        }
        }catch (Exception e){
            System.out.println(""+e);
        }
               

    }

    
}
