/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package curriculum;

import java.util.List;
import java.io.*;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;
/**
 *
 * @author Antonio
 */
public class Event {
    private static final AtomicInteger count = new AtomicInteger(0); 
    private int eventId;
    private String event;
    private int media;
    private int curriculumId;
    
    
    public Event(){
    }
    
    public Event(String event, int curriculumId, int eventId, int media){
        this.curriculumId = curriculumId;
        this.media = media;
        this.event = event;
        this.eventId = eventId;
    }

    public int getEventId() {
        return eventId;
    }

    public void setEventId(int eventId) {
        this.eventId = eventId;
    }

    public int getMedia() {
        return media;
    }

    /**
    This function is going to read from file txt and output for the JScroolPanel.
     * Steps:
     *  1. Identify if file is created otherwise create one!
     *  2. Scan the file and inject to the panel! 
     * @param scrollpanel
     * @return 
     */
    
    
    
    public void setMedia(int media) {    
        this.media = media;
    }

    /**
     * @return the curriculumId
     */
    public int getCurriculumId() {
        return curriculumId;
    }

    /**
     * @param curriculumId the curriculumId to set
     */
    public void setCurriculumId(int curriculumId) {
        this.curriculumId = curriculumId;
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
