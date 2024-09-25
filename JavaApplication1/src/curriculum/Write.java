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
public class Write {

    public Write(String path, String string) throws IOException{
        
        Read r1 = new Read();
        String teste = r1.Read(path);
        
        fileExists f = new fileExists();
        BufferedWriter bw = new BufferedWriter(new FileWriter(path));
        if (f.fileExists(path)){
            try{
                StringBuilder sb = new StringBuilder();
                sb.append(teste);
                sb.append(string);
                bw.write(sb.toString());
            }finally{
                bw.close();
            }
        }
    }
    
    public static class fileExists{
            public boolean fileExists(String path){
                File f = new File(path);
                return f.exists();
        }
    }
    
}
