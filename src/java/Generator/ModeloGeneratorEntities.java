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

public class ModeloGeneratorEntities 
{
    public static String nombreClase;
    public static String tablaClase;
    public static String columnasClase;
    public static String tipocolumnasClase;
    public static String concTypeCampo;
    public static String Change = "";
    public static String columnasClaseMay;
    
    public static ArrayList nombreArray = new ArrayList();
    public static ArrayList tablaArray = new ArrayList();
    public static ArrayList columnasArray = new ArrayList();
    public static ArrayList tipocolumnasArray = new ArrayList();
    public static ArrayList typeANDCampoArray = new ArrayList();

      public static void generarCodigo(Modelo m) throws IOException, SQLException 
      {
           
           
           ArrayList ArrEjem = new ArrayList();
           ArrayList ArrConc2 = new ArrayList();
           
            for (MetaData e1: m.getMetadata())
            {

                    VelocityContext contexto = new VelocityContext();
                    Velocity.init();//inicializa el motor velocity    
                    
                    nombreClase = e1.getNombre().substring(0, 1).toUpperCase() + e1.getNombre().substring(1);
                    tablaClase = e1.getTabla();
                    columnasClase = e1.getCampos();
                    columnasClaseMay = e1.getCampos().substring(0, 1).toUpperCase() + e1.getCampos().substring(1);
                    tipocolumnasClase = e1.getTipo();
                    

                    String myfolder = "Salida1/";
                    Functions g = new Functions();
                    
                    m.getNombre();
                    m.getTabla();
                    m.getCampo();
                    m.getTipo();
                    
                    File f = new File(myfolder + nombreClase);
                    f.mkdir();
        
     

                    contexto.put("Ttypecampo", typeANDCampoArray); 
                    contexto.put("Concatenado1", ArrEjem); 
                    contexto.put("Concatenado2", ArrConc2); 
                    contexto.put("Tabla", tablaClase);
                    contexto.put("Campo", columnasClase);

                    String R1;//mirar Buena practica ???????
                    String R2;//mirar Buena practica ???????
                    String concComillas;//mirar Buena practica ???????

//----------Lo que esta arriba no se modifica para la generacion de ninguna Capa-------------------------//
                                     
                    Template ModeloGeneratorEntitites = null;
                    
                    try {
                         ModeloGeneratorEntitites=Velocity.getTemplate("TemplatesMVC/TemplatesMVC/TEntities.vsl");
                    }
                    catch (Exception e){
                        System.out.println("Error creating template");
                    }
        
                    if(ModeloGeneratorEntitites != null){
                        try {
                            BufferedWriter escritor = new BufferedWriter(new FileWriter(myfolder + nombreClase + "/src/java/USBBOGEDUEntities/" + tablaClase +  ".java"));
                            ModeloGeneratorEntitites.merge(contexto, escritor);
                            escritor.flush();
                            escritor.close();
                        }
                        catch (IOException ex){
                                System.out.println("Plantillas entities no creadas");
                            }
                    }   
                   
                    if("int".equals(tipocolumnasClase)){
                         Change = "0";
                    }
                        else 
                            if("String".equals(tipocolumnasClase)){
                            Change = "\"\"";
                            }
                    concComillas  = tipocolumnasClase.concat(" ");
                    
                    R1 = columnasClaseMay + "(" + tipocolumnasClase + " " + columnasClase + ")" + "{" + g.NL() + g.TB() + "this." + columnasClase + " = " + columnasClase + ";" + g.NL() + "}" + g.NL() + g.NL() + "public " + tipocolumnasClase + " get_" + columnasClaseMay + "(){" + g.NL() + g.TB() + "return " + columnasClase + ";" + g.NL() + "}";
                    R2 = g.NL() + "this." + columnasClase + "=" + Change ; 
                    
                    concTypeCampo = concComillas.concat(columnasClase);
                    
                    String Tcampo = columnasClase ;
                    nombreArray.add(Tcampo);
                    
                    String Ttype = tipocolumnasClase;
                    tipocolumnasArray.add(Ttype);
                    
                    typeANDCampoArray.add(concTypeCampo);

                    ArrEjem.add(R1);
                    ArrConc2.add(R2);
                    
                            
                   //System.out.println(typeANDCampoArray);      
             }
                   
                    
    }
      

       

}