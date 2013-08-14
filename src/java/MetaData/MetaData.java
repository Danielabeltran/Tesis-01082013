package MetaData;

import java.sql.ResultSet;


public class MetaData 
{
    private String nombre;
    private String tabla;
    private String tipo;
    private String campos;
   

  public void setNombre(String nombre) 
    {
        this.nombre = nombre;
    }
    
  public String getNombre() 
    {
         return nombre;
    }  

  public void setTabla(String tabla) 
    {
        this.tabla = tabla;
    }
    
  public String getTabla() 
    {
        return tabla;
    }
    
  public void setTipo(String tipo) 
    {
        this.tipo = tipo;
    }    
    
  public String getTipo() 
    {
        return tipo;
    }
    
  public void setCampos(String campos) 
    {
        this.campos = campos;
    }
    
  public String getCampos() 
    {
        return campos;
    } 

    public void setFkcolumnname(ResultSet resultado) {
        throw new UnsupportedOperationException("Not yet implemented");
    }
}
