/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package blockchain;

/**
 *
 * @author afonsorgcosta
 */
public class Block {
    String previousHash;
    String data;
    String currentHash;
    int nonce;
    
    public Block() {
    }
    
    public Block(String previousHash, String data,int nonce) {
        this.previousHash = previousHash;
        this.data = data;
        this.currentHash = calculateHash();
        this.nonce = nonce;
    }

    public String getCurrentHash() {
        return currentHash;
    }

    public String calculateHash(){
        return Hash.hash(nonce + previousHash + data);
    }
    
    public boolean isValid(){
        return currentHash.equals(calculateHash());
    }

    @Override
    public String toString() {
        return "Block{" + "previousHash=" + previousHash + ", data=" + data + ", currentHash=" + currentHash + ", nonce=" + nonce + '}';
    } //alterar dados
    
    
    
}
