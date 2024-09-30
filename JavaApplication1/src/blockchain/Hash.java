/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package blockchain;

/**
 *
 * @author afonsorgcosta
 */
public class Hash {
    public static String hexCode(int n){
        return Integer.toHexString(n).toUpperCase();
    }
    
    public static String hash(String data){
        return hexCode(Math.abs(data.hashCode()));
    }
}
