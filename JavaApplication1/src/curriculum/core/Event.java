/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package curriculum;

import blockchain.utils.SecurityUtils;
import java.util.List;
import java.io.*;
import java.security.PrivateKey;
import java.util.ArrayList;
import java.util.Base64;
/**
 *
 * @author afonsorgcosta
 */
public class Event {
    private String event;
    private String signature;
    private String pubKey;
    private String fromPub;
    private String toPub;
    
    public Event(){
    }
    
    public Event(String event){
        this.event = event;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    public String getPubKey() {
        return pubKey;
    }

    public void setPubKey(String pubKey) {
        this.pubKey = pubKey;
    }
    
    public void sign(PrivateKey priv) throws Exception {
        byte[] dataSign = SecurityUtils.sign((fromPub + event).getBytes(),
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
    
   
    public Event Read(String path) throws Exception, ClassNotFoundException{
        try ( ObjectInputStream in = new ObjectInputStream(
                new FileInputStream(path))) {
            return (Event) in.readObject();
        }
    }
             

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
