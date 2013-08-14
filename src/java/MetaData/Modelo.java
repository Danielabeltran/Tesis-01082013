package MetaData;

import java.util.ArrayList;
import java.util.List;

public class Modelo 
{ 
    private List<MetaData> metadata;
    private String nombre;
    private String tabla;
    private String tipo;
    private String campo;
     

 public Modelo()
    {
        this.metadata = new ArrayList<MetaData>();
        this.nombre = "";
        this.tabla = "";
        this.tipo = "";
        this.campo = "";
    }

 
      public List<MetaData> getMetadata() 
         {
             return metadata;
         }

      public void setMetadata(List<MetaData> entidades) 
         {
             this.metadata = entidades;
         }

     public String getNombre() 
        {
            return nombre;
        }

     public void setNombre(String nombre) 
        {
            this.nombre = nombre;
        }

     public String getTabla() 
        {
            return tabla;
        }

     public void setTabla(String tabla) 
        {
            this.tabla = tabla;
        }
     public String getTipo() 
       {
           return tipo;
       }

     public void setTipo(String tipo) 
       {
           this.tipo = tipo;
       }
  
     public String getCampo() 
       {
        return campo;
       }

  
    public void setCampo(String campo) 
        {
            this.campo = campo;
        }


    

        
    

    
}
