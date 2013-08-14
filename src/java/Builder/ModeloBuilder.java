
package Builder;

import MetaData.MetaData;
import MetaData.Modelo;
import Utilities.Conexion_BD;
import java.io.IOException;
import java.sql.*;

public class ModeloBuilder 
{
        public static String nameBD; 
        public static String vtablas;
        public static String vcampos;
        public static String vtipo;
        public static String vprimary;
        public static String vforeign;
        
    //Metodo carga modelo
    public static Modelo cargarModelo() throws IOException, SQLException
    {
        Conexion_BD database = new Conexion_BD();
        database.makeConnection();
        Modelo m = new Modelo();
        try 
        {
                    
            //Método para traer columnas, campos, tipo del campo, tablas etc        
            DatabaseMetaData metadata = database.connection.getMetaData(); //Método general de java para extraer metadata de la base de datos
            ResultSet resultSet2 = metadata.getColumns(null, null, null, null);//Método para obtener las columnas de los metadatos obtenidos
            //resultSet2 = metadata.getCrossReference(null, null, null, null, null, vtablas);
            while (resultSet2.next()) 
            {
                nameBD = resultSet2.getString("TABLE_CAT");// retorna el nombre de la BD
                vtablas = resultSet2.getString("TABLE_NAME");//retorna el nombre de todas las tablas de la BD
                vcampos = resultSet2.getString("COLUMN_NAME");// retorna los campos de todas las tablas de la BD
                vtipo = resultSet2.getString("TYPE_NAME");// retorna el tipo de datos de los campos
                //vforeign = resultSet2.getString("FKTABLE_NAME");// retorna el tipo de datos de los campos
                //System.out.println(vforeign);
                MetaData e = new MetaData();
                String vstring = "String";
                String vint = "int";
                String vdouble  = "double";
 

                if(vtipo.equals("VARCHAR")){
                       vtipo = vstring;
                }
                else
                    if(vtipo.equals("INT")){
                        vtipo = vint;
                    }
                    else
                        if(vtipo.equals("DOUBLE")){
                               vtipo = vdouble;
                        }
                
                               
                String[] nombreBD = {nameBD};
                String[] tablas = {vtablas};
                String[] campos = {vcampos};
                String[] tipo = {vtipo}; 
                
                for (String nombrebase : nombreBD){
                     e.setNombre(nombrebase);

                for (String tabla : tablas){
                     e.setTabla(tabla);

                for (String campo : campos){
                     e.setCampos(campo);

                for (String tipod : tipo){
                     e.setTipo(tipod);
                     m.getMetadata().add(e);
                    }
                   }
                 }
                }
                    
                }

        }
        
        catch(Exception e){  
        }
        return m;
        
        
    }
    
     

}


