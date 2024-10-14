package curriculum.core;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.security.Key;
import java.security.KeyPair;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.util.ArrayList;
import java.util.List;
import blockchain.SecurityUtils;
import java.nio.file.Files;
import java.nio.file.Path;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Antonio
 */
public class Person {
    
    private String name;
    private PublicKey pub;
    private PrivateKey priv;
    private Key sim;
    
    //public key
    
    /***
     * Builds a person with a costum name
     * @param personId
     * @param age
     * @param nome 
     */
    public Person(String nome){
        this.name = name;
        this.pub = null;
        this.priv = null;
        this.sim = null;
    }
    
    
    /***
    * Builds an empty person with the default name!
    */
    public Person(){
        this.name = "noName";
        this.pub = null;
        this.priv = null;
        this.sim = null;
    }
    
    
    /**
     * Genereate simetric key with AES Algorithm and private and public keys for signature porpuses.
     * @throws Exception 
     */
    public void generateKeys() throws Exception {
        this.sim = SecurityUtils.generateAESKey(256) ;
        KeyPair kp = SecurityUtils.generateECKeyPair(256);
        this.pub = kp.getPublic();
        this.priv = kp.getPrivate();
    }
    
    
     /***
     * Register user with encryptition for private, public and public key to files.
     * @param password
     * @throws IOException 
     */
    public void SaveUser(String password) throws IOException, Exception{
      //Encrypt private key and simetric key to save in file
      byte[] secret = SecurityUtils.encrypt(priv.getEncoded(), password);
      Files.write(Path.of(this.name + ".priv"), secret);
      
      byte[] simData = SecurityUtils.encrypt(sim.getEncoded(), password);
      Files.write(Path.of(this.name + ".sim"), simData);
      
      // Save in plain text because its public...
      Files.write(Path.of(this.name + ".pub"), pub.getEncoded());
    }
    
    
    /***
     * Login of User in App.
     * @param password
     * @throws IOException
     * @throws Exception 
     */
    public void load(String password) throws IOException, Exception{
        //Desyncript private and symetric key
        byte[] privData = Files.readAllBytes(Path.of(this.name + ".priv"));
        privData = SecurityUtils.decrypt(privData, password);
        
         byte[] simData = Files.readAllBytes(Path.of(this.name + ".sim"));
        simData = SecurityUtils.decrypt(simData, password);
        
        //ler a publica
        byte[] pubData = Files.readAllBytes(Path.of(this.name + ".pub"));
        this.priv = SecurityUtils.getPrivateKey(privData);
        this.pub = SecurityUtils.getPublicKey(pubData);
        this.sim = SecurityUtils.getAESKey(simData);
    }
    
    
    public void loadPublic() throws Exception{
         //ler a publica
        byte[] pubData = Files.readAllBytes(Path.of(this.name + ".pub"));
        this.pub = SecurityUtils.getPublicKey(pubData);
    }

    /**
     * @return the nome
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the nome to set
     */
    public void setNome(String name) {
        this.name = name;
    }

    public PublicKey getPub() {
        return pub;
    }

    public void setPub(PublicKey pub) {
        this.pub = pub;
    }

    public PrivateKey getPriv() {
        return priv;
    }

    public void setPriv(PrivateKey priv) {
        this.priv = priv;
    }

    public Key getSim() {
        return sim;
    }

    public void setSim(Key sim) {
        this.sim = sim;
    }
    
}
