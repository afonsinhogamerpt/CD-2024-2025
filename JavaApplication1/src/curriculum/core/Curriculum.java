/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package curriculum.core;

import blockchain.utils.Block;
import blockchain.utils.MerkleTree;


/**
 *
 * @author afonsorgcosta
 */
public class Curriculum {

    public static void main(String[] args) throws Exception {
        Person p1 = new Person("oi");
        p1.generateKeys();
        p1.save("oi");
        System.out.println("" + p1.toString());
        
    }
}
