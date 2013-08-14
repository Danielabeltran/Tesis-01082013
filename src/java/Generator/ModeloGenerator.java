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
import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.Velocity;

public class ModeloGenerator 
{
      public static void generarCodigo(Modelo m) throws IOException, SQLException 
      {
            for (MetaData e1: m.getMetadata())
            {
                    VelocityContext contexto = new VelocityContext();
                    Velocity.init();//inicializa el motor velocity
        
                    String nombreClase = e1.getNombre().substring(0, 1).toUpperCase() + e1.getNombre().substring(1);
                    String NameDB = nombreClase;
                    String myfolder = "Salida1/";
                    
                    
                    contexto.put("nombreClase", nombreClase);
                    contexto.put("Name_DB", NameDB);
                    
                    m.getNombre();
                    
                    
                    Functions g = new Functions();
                    File f = new File(myfolder + NameDB);
                    //File destinof = new File(myfolder + myfolderdestino);
                    f.mkdir();
                    //destinof.mkdir();
        
                    for (int i=1; i<=2; i++)
                    {

                        g.ldir ( f + "/nbproject");    
                        g.ldir ( f + "/nbproject/private");    
                        g.ldir ( f + "/src");
                        g.ldir ( f + "/src/conf");
                        g.ldir ( f + "/src/java");
                        g.ldir ( f + "/src/java/USBBOGEDUData");
                        g.ldir ( f + "/src/java/USBBOGEDUEntities");
                        g.ldir ( f + "/src/java/USBBOGEDUBusiness");
                        g.ldir ( f + "/web");
                        g.ldir ( f + "/web/WEB-INF");
                    }
        
                        Template build = null;
                        Template index = null;
                        Template ant_deploy = null;
                        Template build_impl = null;
                        Template genfiles_properties = null;
                        Template project = null;
                        Template project_properties = null;
                        Template private_properties = null;
                        Template MANIFEST = null;
                        Template ConexionDB = null;
                        

                    try 
                    {
                        build = Velocity.getTemplate("Templates/Tbuild.vsl");
                        index = Velocity.getTemplate("Templates/Tindex.vsl");
                        ant_deploy = Velocity.getTemplate("Templates/Tant_deploy.vsl"); // nota: Java no permite declarar variables con (-) se reemplaza por (_)
                        build_impl = Velocity.getTemplate("Templates/Tbuild_impl.vsl");
                        genfiles_properties = Velocity.getTemplate("Templates/Tgenfiles_properties.vsl");
                        project = Velocity.getTemplate("Templates/Tproject.vsl");
                        project_properties = Velocity.getTemplate("Templates/Tproject_properties.vsl");
                        private_properties = Velocity.getTemplate("Templates/Tprivate_properties.vsl");
                        MANIFEST = Velocity.getTemplate("Templates/TMANIFEST.vsl");
                        ConexionDB = Velocity.getTemplate("Templates/TConection.vsl");
                        
                        
                    }
                    catch (Exception e) 
                    {
                    System.out.println("Error creating template");
                    }
        
                   

             
                    if (build != null)
                    {
                            try 
                            {
                                BufferedWriter escritor = new BufferedWriter(new FileWriter(myfolder + NameDB + "/build.xml"));
                                build.merge(contexto, escritor);
                                    escritor.flush();
                                    escritor.close();
                                //System.out.println("Plantilla build.xml creada");  
                            } 
                            catch (IOException ex) 
                            {
                                //System.out.println("Plantilla build.xml no creada");
                            }
                    }
                    if (index != null)
                    {
                            try 
                            {
                                BufferedWriter escritor = new BufferedWriter(new FileWriter(myfolder + NameDB + "/web/index.jsp"));

                                index.merge(contexto, escritor);
                                    escritor.flush();
                                    escritor.close();
                                //System.out.println("Plantilla index.jsp creada");  
                            } 
                            catch (IOException ex) 
                            {
                                System.out.println("Plantilla index.jsp no creada");
                            }
                    }
                    if (ant_deploy!= null)
                    {
                            try 
                            {
                                BufferedWriter escritor = new BufferedWriter(new FileWriter(myfolder + NameDB + "/nbproject/ant-deploy.xml"));

                                ant_deploy.merge(contexto, escritor);
                                    escritor.flush();
                                    escritor.close();
                                //System.out.println("Plantilla ant-deploy.xml creada");  
                            } 
                            catch (IOException ex) 
                            {
                                //System.out.println("Plantilla ant-deploy.xml no creada");
                            }
                    }
                    if (build_impl!= null)
                    {
                            try 
                            {
                                BufferedWriter escritor = new BufferedWriter(new FileWriter(myfolder + NameDB + "/nbproject/build-impl.xml"));

                                build_impl.merge(contexto, escritor);
                                    escritor.flush();
                                    escritor.close();
                                //System.out.println("Plantilla build-impl.xml creada");  
                            } 
                            catch (IOException ex) 
                            {
                                System.out.println("Plantilla build-impl.xml no creada");
                            }
                    }
                    if (genfiles_properties!= null)
                    {
                            try 
                            {
                                BufferedWriter escritor = new BufferedWriter(new FileWriter(myfolder + NameDB + "/nbproject/genfiles.properties"));

                                genfiles_properties.merge(contexto, escritor);
                                    escritor.flush();
                                    escritor.close();
                                //System.out.println("Plantilla genfiles.properties creada");  
                            } 
                            catch (IOException ex) 
                            {
                                System.out.println("Plantilla genfiles.properties no creada");
                            }
                    }
                    if (project!= null)
                    {
                            try 
                            {
                                BufferedWriter escritor = new BufferedWriter(new FileWriter(myfolder + NameDB + "/nbproject/project.xml"));

                                project.merge(contexto, escritor);
                                    escritor.flush();
                                    escritor.close();
                               // System.out.println("Plantilla project.xml creada");  
                            } 
                            catch (IOException ex) 
                            {
                                System.out.println("Plantilla project.xml no creada");
                            }
                    }
                    if (project_properties!= null)
                    {
                            try 
                            {
                                BufferedWriter escritor = new BufferedWriter(new FileWriter(myfolder + NameDB + "/nbproject/project.properties"));

                                project_properties.merge(contexto, escritor);
                                    escritor.flush();
                                    escritor.close();
                               // System.out.println("Plantilla project.properties creada");  
                            } 
                            catch (IOException ex) 
                            {
                                System.out.println("Plantilla project.properties no creada");
                            }
                    }
                    if (private_properties!= null)
                    {
                            try 
                            {
                                BufferedWriter escritor = new BufferedWriter(new FileWriter(myfolder + NameDB + "/nbproject/private/private.properties"));

                                private_properties.merge(contexto, escritor);
                                    escritor.flush();
                                    escritor.close();
                               // System.out.println("Plantilla private.properties creada");  
                            } 
                            catch (IOException ex) 
                            {
                                System.out.println("Plantilla private.properties no creada");
                            }
                    }
                    if (MANIFEST!= null)
                    {
                            try 
                            {
                                BufferedWriter escritor = new BufferedWriter(new FileWriter(myfolder + NameDB + "/src/conf/MANIFEST.MF"));

                                MANIFEST.merge(contexto, escritor);
                                    escritor.flush();
                                    escritor.close();
                                //System.out.println("Plantilla MANIFEST.MF creada");  
                            } 
                            catch (IOException ex) 
                            {
                                //System.out.println("Plantilla MANIFEST.MF no creada");
                            }
                    }
                    if (ConexionDB != null)
                    {
                            try 
                            {
                                BufferedWriter escritor = new BufferedWriter(new FileWriter(myfolder + NameDB + "/src/java/USBBOGEDUData/"  +  "ConexionDB.java"));
                                ConexionDB.merge(contexto, escritor);
                                    escritor.flush();
                                    escritor.close();
                                //System.out.println("Plantilla ConexionDB.xml creada");  
                            } 
                            catch (IOException ex) 
                            {
                                //System.out.println("Plantilla ConexionDB.xml no creada");
                            }
                    }
                    
                   //copyFolder(f,destinof);
            }
         
    }
      public static void copyFolder(File scr, File dest)
    	throws IOException
         {
             System.out.println("directorio copiado");
         }
}