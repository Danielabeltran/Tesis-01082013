/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Utilities;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author JeysonAlveiro
 */
public class Functions {
    public void ldir(String namefile){
        File f = new File(namefile);
        f.mkdir();
    
    }
    public void WriterFile(String contenido, String namefile) throws IOException{
        FileWriter fstream = new FileWriter(namefile);
        BufferedWriter out = new BufferedWriter(fstream);
        out.write(contenido);
        out.close();
     }          
     public char dectochar(int leido){
         return (char)leido;
     }
     public String NL(){
        return "" + (char)13 + (char)10;
     }
     public String TB(){
        return "" + (char)9;
     }
     public String CM(){
        return "" + (char)34;
     }
     
     
     //incluir funciones
     public void CreateIf(String nameFile, String url) throws IOException{
 

        if (nameFile != null)
       {
            try 
            {
                BufferedWriter escritor = new BufferedWriter(new FileWriter(url));
                //nameFile.merge(contexto, escritor);
                    escritor.flush();
                    escritor.close();
                System.out.println("Plantilla build creada");  
            } 
            catch (IOException ex) 
            {
            }
       }
     }   

}
