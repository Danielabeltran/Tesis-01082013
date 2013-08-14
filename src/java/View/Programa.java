package View;


import Builder.ModeloBuilder;
import MetaData.Modelo;
import Generator.ModeloGenerator;
import Generator.ModeloGeneratorBusiness;
import Generator.ModeloGeneratorData;
import Generator.ModeloGeneratorEntities;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Programa 
{
     public static void main(String[] args) throws IOException, SQLException 
     {
        
        Modelo m;

         try 
         {
            m = ModeloBuilder.cargarModelo();
            ModeloGenerator.generarCodigo(m);
            ModeloGeneratorData.generarCodigo(m);
            ModeloGeneratorEntities.generarCodigo(m);
            ModeloGeneratorBusiness.generarCodigo(m);
         } 
         catch (ClassCastException ex){
         Logger.getLogger(Programa.class.getName()).log(Level.SEVERE, null, ex);
         }
         
        
        
     }
}