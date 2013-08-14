/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Generator;


import MetaData.MetaData;
import MetaData.Modelo;
import Utilities.Functions;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.Velocity;

/**
 *
 * @author jeysonvargasmartinez
 */
public class ModeloGeneratorBusiness {
    
//se declaran Variables Globales 
    public static String nombreClase;
    public static String tablaClase;
    public static String columnasClase;
    public static String tipocolumnasClase;
    public static String tipocolumnasClaseMay;
    public static String columnasClaseMay;
    public static String concTypeCampo;
    
    
    public static ArrayList nombreArray = new ArrayList();
    public static ArrayList tablaArray = new ArrayList();
    public static ArrayList columnasArray = new ArrayList();
    public static ArrayList tipocolumnasArray = new ArrayList();


     
    public static void generarCodigo(Modelo m) throws IOException, SQLException 
      {
            
            for (MetaData e1: m.getMetadata())
            {

                    VelocityContext contexto = new VelocityContext();
                    Velocity.init();//inicializa el motor velocity    
                    
                    nombreClase = e1.getNombre().substring(0, 1).toUpperCase() + e1.getNombre().substring(1);
                    tablaClase = e1.getTabla();
                    columnasClase = e1.getCampos();
                    columnasClaseMay = e1.getCampos().substring(0, 1).toUpperCase() + e1.getCampos().substring(1);
                    tipocolumnasClase = e1.getTipo();
                    tipocolumnasClaseMay = e1.getTipo().substring(0, 1).toUpperCase() + e1.getTipo().substring(1);
                    
                   
                    String myfolder = "Salida1/";
                    Functions g = new Functions();

                    
                    m.getNombre();
                    m.getTabla();
                    m.getCampo();
                    m.getTipo();
              
                    File f = new File(myfolder + nombreClase);
                    f.mkdir();
                    
                    contexto.put("nombre", nombreClase);  //nombre al que responde velocity   
                    contexto.put("tabla", tablaClase);     
                    contexto.put("campo", columnasClase); 
                    contexto.put("campoMay", columnasClaseMay); 
                    contexto.put("type", tipocolumnasClase); 
                    contexto.put("Anombre", nombreArray); 
                    contexto.put("Atabla", tablaArray); 
                    contexto.put("Acolumnas", columnasArray); 
                    contexto.put("Atipocolumnas", tipocolumnasArray); 

//----------Lo que esta arriba no se modifica para la generacion de ninguna Capa-------------------------//

                    Template ModeloGeneratorBusiness = null;//crea un template en java

                    try 
                    {
                         ModeloGeneratorBusiness=Velocity.getTemplate("TemplatesMVC/TemplatesMVC/TBusiness.vsl");
                          
                    }
                    catch (Exception e) 
                    {
                        System.out.println("Error creating template");
                    }
        
                   
                    if(ModeloGeneratorBusiness != null)
                    {
                        try 
                        {
                             BufferedWriter escritor = new BufferedWriter(new FileWriter(myfolder + nombreClase + "/src/java/USBBOGEDUBusiness/" + tablaClase +  "BO.java"));
                
                            ModeloGeneratorBusiness.merge(contexto, escritor);
                
                            escritor.flush();
                            escritor.close();
                        }
                        catch (IOException ex) 
                            {
                                System.out.println("Plantillas Business no creadas");
                            }
                    }


                    nombreArray.add(nombreClase); 
                    tablaArray.add(tablaClase); 
                    columnasArray.add(columnasClase);
                    tipocolumnasArray.add(tipocolumnasClase); 
                     
             }

                  //System.out.println(tablaArray );   
                  //System.out.println(columnasArray );   
                  //System.out.println(tipocolumnasArray );   
    }
      
}