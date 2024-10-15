/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package curriculum.core;

import blockchain.utils.Block;
import blockchain.utils.BlockChain;
import blockchain.utils.ObjectUtils;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

/**
 *Temos de ter um arraylist de eventos que será o nosso ledger
 * A nossa blockchain
 * A nossa dificuldade
 * @author afonsorgcosta
 */
public class CurriculumVitae {
    private static final AtomicInteger count = new AtomicInteger(0);
    private ArrayList<Event> ledger;
    blockchain.utils.BlockChain bc ;
    public static int DIFICULTY = 4;
    
    /**
     * We have to initialize our ledger and blockchain...?
     */
    public CurriculumVitae() {
         ledger = new ArrayList<>();
         bc = new BlockChain();
    }

    public ArrayList<Event> getLedger() {
        return ledger;
    }

    public void setLedger(ArrayList<Event> ledger) {
        this.ledger = ledger;
    }

    public BlockChain getBc() {
        return bc;
    }

    public void setBc(BlockChain bc) {
        this.bc = bc;
    }

    @Override
    public String toString() {
        StringBuilder txt = new StringBuilder();
         for( Block b : bc.getChain()){
              Event t = (Event) ObjectUtils.convertBase64ToObject(b.getData());
               txt.append(b.getPreviousHash() + " " +
                    t.toString() + " "
                    + b.getNonce() +" "
                    + b.getCurrentHash()
                    +"\n"
                            );
         }
         
        return "CurriculumVitae{" + "ledger=" + ledger + ", bc=" + bc + '}';
    }
    
    
}
