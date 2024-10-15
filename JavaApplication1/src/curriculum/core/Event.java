/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package curriculum.core;

import blockchain.utils.SecurityUtils;
import java.util.List;
import java.io.*;
import java.security.PrivateKey;
import java.util.ArrayList;
import java.util.Base64;
import java.util.concurrent.atomic.AtomicInteger;
/**
 * Caso seja aquele utilizador a assinar então pertence ao curriculo dele.
 * @author Antonio
 */
public class Event {
    private static final AtomicInteger count = new AtomicInteger(0); 
    private String event;
    private String personName;
    private String personPub;
    private String signature;
    
    
    public Event(){
    }
    
    public Event(String event){
        this.event = event;
    }
    
    public Event(Person u, String event) throws Exception{
        this.personName = u.getNome();
        this.personPub = Base64.getEncoder().encodeToString(u.getPubKey().getEncoded());
        this.event = event;
        sign(u.getPrivKey());
    }
   
    
    /***
     * Sign data to insert in blockchain.
     * @param priv
     * @throws Exception 
     */
    public void sign(PrivateKey priv) throws Exception {
        byte[] dataSign = SecurityUtils.sign(
                (personPub + event).getBytes(),
                priv);
        this.signature = Base64.getEncoder().encodeToString(dataSign);
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

    @Override
    public String toString() {
        return "Event{" + "event=" + event + ", signature=" + signature + '}';
    }
    
    
    
   
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
    }
             

    public static class fileExists{
            public boolean fileExists(String path){
                File f = new File(path);
                return f.exists();
        }
    }
    
    public void Write(String path, String string) throws IOException{
        
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
    }
    
    
    
}
