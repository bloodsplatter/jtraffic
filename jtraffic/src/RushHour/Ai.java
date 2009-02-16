/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package RushHour;

/**
 *
 * @author chris
 */

public class Ai {
   private Level lvl;
   
   public Ai(Level lvl){
       this.lvl = lvl;
   }

   public void run(){
       Voertuig tmpvt;

       tmpvt = lvl.voertuigOpPlaats(0);
       if(tmpvt.getX() > 0){
           tmpvt.MoveLeft();
       }else{
        // Gewonnen
           System.out.println("Done!");
       }
       

   }
   

}
