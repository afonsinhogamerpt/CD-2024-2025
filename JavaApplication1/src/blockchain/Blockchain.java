/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package blockchain;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author afonsorgcosta
 */


/*
1. metodos para guardar e ler do ficheiro
2. metodo para ir buscar a hash do bloco anterior
3. metodo para adicionar um novo bloco à blockchain
4. metodo para fazer a validacao novamente do bloco mas dentro da blockchain
*/
public class Blockchain {
    private final ArrayList<Block> chain = new ArrayList<>();

    public Blockchain() {
    }
    
    public String getLastBlockHash(){
        if (chain.isEmpty()){
            return "0";
        }
        return chain.get(chain.size()-1).currentHash;
    }
    
    public void add(String data, int difficulty){
        String prevHash = getLastBlockHash();
        int nonce = Miner.getNonce(data, difficulty);
        Block bl1 = new Block(prevHash, data , nonce);
        chain.add(bl1);
    }
    
    public Block get(int index){
        return chain.get(index);
    }
    
    public List<Block> getChain(){
        return chain;
    }
    
    public boolean isValid(){
        for(Block block:chain){
            if(!block.isValid())
                return false;
        }
        
        for(int i = 0;i < chain.size() -1;i++)
            if (!chain.get(i).previousHash.equals(chain.get(i-1).currentHash))
                return false;
        return true;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Tamanho da blockchain: " + chain.size() + "\n");
        for (Block block: chain){
            sb.append(block.toString());
        }
        return sb.toString();
    }
    
    
    
}
