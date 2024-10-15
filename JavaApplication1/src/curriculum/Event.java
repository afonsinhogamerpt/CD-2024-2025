/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package curriculum;

import java.util.List;
import java.io.*;
import java.util.ArrayList;
/**
 *
 * @author afonsorgcosta
 */
public class Event {
    blockchain.utils.BlockChain bc ;
    public static int DIFICULTY = 4;
    private String event;
    private int media;
    
    
    
    public Event(){
    }
    
    public Event(String event, int media){
        this.media = media;
        this.event = event;
    }

    public int getMedia() {
        return media;
    }
    
    
    public void setMedia(int media) {    
        this.media = media;
    }

    /**
     * @return the event
     */
    public String getEvent() {
        return event;
    }

    /**
     * @param event the event to set
     */
    public void setEvent(String event) {
        this.event = event;
    }
    
    /*
    public List<String> Read(String path) throws FileNotFoundException, IOException{
        fileExists f = new fileExists();
        BufferedReader br = new BufferedReader(new FileReader(path));
        ArrayList<String> ar1 = new ArrayList<>();

        if (f.fileExists(path)){

            try {
                StringBuilder sb = new StringBuilder();
                String line = br.readLine();
                
                while (line != null) {
                    sb.append(line);
                    sb.append(System.lineSeparator());
                    ar1.add(sb.toString());
                    line = br.readLine();
                }
                return ar1;
                
            } finally {
                br.close();
            }
        }
        return null;
    }*/
   
    public Event Read(String path) throws Exception, ClassNotFoundException{
        try ( ObjectInputStream in = new ObjectInputStream(
                new FileInputStream(path))) {
            return (Event) in.readObject();
        }
    }
    
    /*public void Write(String path, String string) throws IOException{
        
        ArrayList<String> teste = (ArrayList<String>) Read(path);
        fileExists f = new fileExists();
        BufferedWriter bw = new BufferedWriter(new FileWriter(path));
        StringBuilder sb = new StringBuilder();   
        if (f.fileExists(path)){
            try{
                for(String item: teste){
                    sb.append(item);
                }
                
                sb.append(string);
                bw.write(sb.toString()+"\n");
            }finally{
                bw.close();
            }
        }
    }*/
             

    public static class fileExists{
            public boolean fileExists(String path){
                File f = new File(path);
                return f.exists();
        }
    }
    
    public void Write(String path) throws IOException{
        
        try ( ObjectOutputStream out = new ObjectOutputStream(
                new FileOutputStream(path))) {
            out.writeObject(this);
        }
        
    }    
}
