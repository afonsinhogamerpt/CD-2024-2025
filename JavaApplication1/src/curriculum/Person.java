package curriculum;

import blockchain.utils.SecurityUtils;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.security.Key;
import java.security.KeyPair;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Antonio
 */
public class Person {
    
    private PrivateKey privKey;
    private String nome;
    private PublicKey pubKey;
    private Key simKey;
    
    public Person(){
        this.nome = "noName";
        this.privKey = null;
        this.pubKey = null;
        this.simKey = null;
    }
    
    public Person(String nome){
        this.nome = nome;
        this.privKey = null;
        this.pubKey = null;
        this.simKey = null;
    }
    
    public void generateKeys() throws Exception{
        KeyPair kp = SecurityUtils.generateECKeyPair(256);
        this.simKey = SecurityUtils.generateAESKey(256);
        this.privKey = kp.getPrivate();
        this.pubKey = kp.getPublic();
    }
    
    public void sign(){
    }
    
    public void save(String password) throws Exception{
        //encriptar a chave privada
        byte[] secret = SecurityUtils.encrypt(this.privKey.getEncoded(), password);
        //encriptar a chave simetrica
        byte[] sim = SecurityUtils.encrypt(this.simKey.getEncoded(), password);
        //guardar as keys
        Files.write(Path.of(this.nome + ".sim"), sim);
        Files.write(Path.of(this.nome + ".priv"), secret);
        Files.write(Path.of(this.nome + ".pub"), this.pubKey.getEncoded());
    }
    
    public void loadPub(String password) throws Exception{
        byte []pubData = Files.readAllBytes(Path.of(this.nome + ".pub"));
        this.pubKey = SecurityUtils.getPublicKey(pubData);
    }    
    
    public void load(String password) throws Exception{
        //desencriptar as chaves priv, sim
        byte [] privData = Files.readAllBytes(Path.of(this.nome + ".priv"));
        byte [] simData = Files.readAllBytes(Path.of(this.nome + ".priv"));
        byte [] pubData = Files.readAllBytes(Path.of(this.nome + ".pub"));
        
        privData = SecurityUtils.decrypt(privData, password);
        simData = SecurityUtils.decrypt(simData, password);
        
        this.privKey = SecurityUtils.getPrivateKey(privData);
        this.pubKey = SecurityUtils.getPublicKey(pubData);
        this.privKey = SecurityUtils.getPrivateKey(privData);
    }
    
    public void setPub(PublicKey pub){
        this.pubKey = pub;
    }
    
    public PublicKey getPub(){
        return pubKey;
    }

   /* @Override
    public String toString() {
        return "Person{" + "privKey=" + privKey + ", nome=" + nome + ", pubKey=" + pubKey + ", simKey=" + simKey + '}';
    }*/
    
    
    
    
     
}
