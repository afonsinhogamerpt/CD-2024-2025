/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package blockchain;

/**
 *
 * @author afonsorgcosta
 */

/*
1. o miner é que gera o nonce
2. a dificuldade corresponde ao numero de zeros
3. calcular a hash
4. verificar se a hash tem um determinado sufixo (neste caso, a string que tem a quantidade de zeros)
*/
public class Miner {
    public static int MAX_NONCE = (int)1E9;
    
    public static int getNonce(String data, int difficulty){
        String string = difficulty + "";
        int nonce = 0;
        while (nonce < MAX_NONCE){
            String hash = Hash.hash(nonce + data);
            
            if (hash.endsWith(string)){
                return nonce;
            }
            nonce++;
        }
        return nonce;
    }
    
}
