package curriculum;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Antonio
 */
public class Person {
    
    private int personId;
    private String nome;
    private String publicKey;
    
    //public key
    
    /***
     * Builds a person
     * @param personId
     * @param age
     * @param nome 
     */
    public Person(int personId, int age, String nome){
        this.personId = personId;
        this.nome = nome;
    }
    
    
    /***
    * Builds an empty person
    */
    public Person(){
    }
    

    /**
     * @return the personId
     */
    public int getPersonId() {
        return personId;
    }

    /**
     * @param personId the personId to set
     */
    public void setPersonId(int personId) {
        this.personId = personId;
    }

    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return the publicKey
     */
    public String getPublicKey() {
        return publicKey;
    }

    /**
     * @param publicKey the publicKey to set
     */
    public void setPublicKey(String publicKey) {
        this.publicKey = publicKey;
    }
    
    /***
     * Read from id and name from Users file, in the future will read the public key.
     * @param path
     * @return
     * @throws FileNotFoundException
     * @throws IOException 
     */
    public List<String> ReadUsers(String path) throws FileNotFoundException, IOException{
        Event.fileExists f = new Event.fileExists();
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
    
    /***
     * Checks if file exists
     */
    public static class fileExists{
            public boolean fileExists(String path){
                File f = new File(path);
                return f.exists();
        }
    }
    
    /***
     * Register user in file 
     * @param path
     * @param string
     * @throws IOException 
     */
    public void SaveUser(String path, String string) throws IOException{
        
        ArrayList<String> teste = (ArrayList<String>) ReadUsers(path);
        Event.fileExists f = new Event.fileExists();
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

    @Override
    public String toString() {
        return getPersonId() + " " + getNome();
    }
    
    
    
    
}
