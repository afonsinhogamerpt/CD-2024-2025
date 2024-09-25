/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package curriculum;
import java.io.*;

/**
 *
 * @author afonsorgcosta
 */
public class Read {

    public Read() {
        
    }
    
    public String Read(String path) throws FileNotFoundException, IOException{
        fileExists f = new fileExists();
        BufferedReader br = new BufferedReader(new FileReader(path));

        if (f.fileExists(path)){

            try {
                StringBuilder sb = new StringBuilder();
                String line = br.readLine();

                while (line != null) {
                    sb.append(line);
                    sb.append(System.lineSeparator());
                    line = br.readLine();
                }
                String everything = sb.toString();
                return everything;
                
            } finally {
                br.close();
            }
        }
        return null;
    }
             

    public static class fileExists{
            public boolean fileExists(String path){
                File f = new File(path);
                return f.exists();
        }
    }
        
    }
     
    

