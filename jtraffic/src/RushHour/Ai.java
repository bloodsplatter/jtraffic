/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.System.out.println
 */
package RushHour;

import TrafficSwing.views.LevelView;

/**
 *
 * @author chris
 */
public class Ai implements Runnable {

    private Level lvl;
    private int MaxStack = 36;
    private int Thisstack = 0;
    private int MaxLoops = 36;
    private AiMove rootvrt[] = new AiMove[MaxStack];
    private AiMove movesvrt[] = new AiMove[40];
    private int movesrichtig[] = new int[40];
    private int move = 0;
    private LevelView gameview;

    /**
     * Constructor
     * @param lvl de level die opgelost moet worden
     * @param gameview 
     */
    public Ai(LevelView gameview) {
        this.lvl = gameview.getLevel();
        this.gameview = gameview;
    }

    /**
     *
     */



    public void run() {
        Voertuig mainvt;
        Voertuig tmpvt;
        int loops = 0;
        mainvt = lvl.voertuigOpPlaats(0);

        //wacht even...
        UpdateOutput();
        UpdateOutput();

        while ((mainvt.getX() + mainvt.getGrootte() <= lvl.getVeld().getBreedte() - 1) && (loops < MaxLoops)) {
            tmpvt = lvl.voertuigOpPositie((mainvt.getX() + mainvt.getGrootte()), mainvt.getY());
            if (tmpvt != null) {
                rootvrt[0] = new AiMove(mainvt,2);
                try{
                setProbleem(tmpvt, mainvt.getX() + mainvt.getGrootte(), mainvt.getY(), 0);
                }catch(Exception e){
                    
                }
                
            } else {
                movesvrt[move++] = new AiMove(mainvt,2);
                mainvt.NaarRechts();
                UpdateOutput();
                //System.out.println(lvl.toString());
            }
        }
        // Gewonnen
        System.out.println("Done!");



    }

    private Boolean setProbleem(Voertuig tmpvt, int FreeposX, int FreeposY, int choise) throws InterruptedException {
        // Chek this stack & max stack

        if (Thisstack < (MaxStack - 1)) {
            Thisstack++;
            // 2 mogelijkheden normaal / links rechts // up / down
            Voertuig nwvrt;
            Boolean isOpgelost = false;

            if (tmpvt.getOrientatie() == Orientatie.Verticaal) {
                // check up/down

                // Chek of hij move's aan het reversen is,
                // zoja, voer de ai uit met omgekeerde choise prioriteit
                // Door deze opnieuw op te gooien maar dan met voorkeur voor choise 1
                int movmnt = CheckMoveLoop();
                if (movmnt != 0) {
                    if(!ChekRootTree(tmpvt)){
                    
                        if(movmnt == 4 || movmnt == 1){
                            rootvrt[Thisstack] =  new AiMove(tmpvt,3);
                            setProbleem(tmpvt, FreeposX, FreeposY, 1);
                        }
                    }
                }

                //Chek of oplossing mogelijk is
                if ((FreeposY - tmpvt.getGrootte()) >= 0 && (choise == 0)) {
                    // Oplosing naar boven is mogelijk haalbaar...
                    while (lvl.voertuigOpPositie(FreeposX, FreeposY) != null) {

                        nwvrt = lvl.voertuigOpPositie(tmpvt.getX(), tmpvt.getY() - 1);
                        if (nwvrt != null) {
                            if (ChekRootTree(nwvrt)) {
                                Thisstack--;
                                rootvrt[Thisstack] = null;
                                return false;
                            }
                            int movmnttmp = ChekEndlessLoop(nwvrt);
                            if (movmnttmp != 0) {
                                if(movmnt == 4 || movmnt == 1){
                                rootvrt[Thisstack] =  new AiMove(tmpvt,1);;
                                    if (setProbleem(nwvrt, tmpvt.getX(), tmpvt.getY() - 1, 1) == false) {
                                        break;
                                    }
                                }
                            } else {
                                rootvrt[Thisstack] =  new AiMove(tmpvt,1);;
                                if (setProbleem(nwvrt, tmpvt.getX(), tmpvt.getY() - 1, 0) == false) {
                                    break;
                                }
                            }
                        } else {
                            movesvrt[move++] = new AiMove(tmpvt,1);
                            tmpvt.NaarBoven();
                            UpdateOutput();
                        }
                    }

                    // Controleer nu of het is opgelost of hij is terug
                    // geroepen door de Maxstack
                    if (lvl.voertuigOpPositie(FreeposX, FreeposY) == null) {
                        isOpgelost = true;
                    }

                }
                if ((FreeposY + tmpvt.getGrootte() < lvl.getVeld().getHoogte()) && isOpgelost == false) {
                    // Oplossing naar onder is mogelijk haalbaar...
                    while (lvl.voertuigOpPositie(FreeposX, FreeposY) != null) {

                        nwvrt = lvl.voertuigOpPositie(tmpvt.getX(), tmpvt.getY() + tmpvt.getGrootte());
                        if (nwvrt != null) {
                            if (ChekRootTree(nwvrt)) {
                                Thisstack--;
                                rootvrt[Thisstack] = null;
                                return false;
                            }
                            int movmnttmp = ChekEndlessLoop(nwvrt);
                            if (movmnttmp != 0) {
                                if(movmnt == 4 || movmnt == 1){
                                    rootvrt[Thisstack] = new AiMove(tmpvt,3);
                                    if (setProbleem(nwvrt, tmpvt.getX(), tmpvt.getY() + tmpvt.getGrootte(), 1) == false) {
                                        break;
                                    }
                                }
                            } else {
                                rootvrt[Thisstack] = new AiMove(tmpvt,3);
                                if (setProbleem(nwvrt, tmpvt.getX(), tmpvt.getY() + tmpvt.getGrootte(), 0) == false) {
                                    break;
                                }
                            }
                        } else {
                            movesvrt[move++] = new AiMove(tmpvt,3);
                            tmpvt.NaarBeneden();
                            UpdateOutput();
                        }
                    }

                }
            }
            if (tmpvt.getOrientatie() == Orientatie.Horizontaal) {
                // chek up/down

                // Chek of hij move's aan het reversen is,
                // zoja, voer de ai uit met omgekeerde choise prioriteit
                // Door deze opnieuw op te gooien maar dan met voorkeur voor choise 1
                int movmnt = CheckMoveLoop();
                if (movmnt != 0) {
                    if(!ChekRootTree(tmpvt)){
                    
                        if(movmnt == 4 || movmnt == 1){
                            rootvrt[Thisstack] = new AiMove(tmpvt,2);
                            setProbleem(tmpvt, FreeposX, FreeposY, 1);
                        }
                    }
                }

                //Check of oplossing mogelijk is
                if ((FreeposX - tmpvt.getGrootte()) >= 0 && (choise == 0)) {
                    // Oplosing naar boven is mogelijk haalbaar...
                    while (lvl.voertuigOpPositie(FreeposX, FreeposY) != null) {

                        nwvrt = lvl.voertuigOpPositie(tmpvt.getX() - 1, tmpvt.getY());
                        if (nwvrt != null) {
                            if (ChekRootTree(nwvrt)) {
                                Thisstack--;
                                rootvrt[Thisstack] = null;
                                return false;
                            }
                            int movmnttmp = ChekEndlessLoop(nwvrt);
                            if (movmnttmp != 0) {
                                if(movmnt == 4 || movmnt == 1){
                                    rootvrt[Thisstack] = new AiMove(tmpvt,4);
                                    if (setProbleem(nwvrt, tmpvt.getX() - 1, tmpvt.getY(), 1) == false) {
                                        break;
                                    }
                                }
                            } else {
                                rootvrt[Thisstack] = new AiMove(tmpvt,4);
                                if (setProbleem(nwvrt, tmpvt.getX() - 1, tmpvt.getY(), 0) == false) {
                                    break;
                                }
                            }
                        } else {
                            movesvrt[move++] = new AiMove(tmpvt,4);
                            tmpvt.NaarLinks();
                            UpdateOutput();
                        }
                    }
                    // Controleer nu of het is opgelost of hij is terug
                    // geroepen door de Maxstack
                    if (lvl.voertuigOpPositie(FreeposX, FreeposY) == null) {
                        isOpgelost = true;
                    }
                }
                if (((FreeposX + tmpvt.getGrootte()) < lvl.getVeld().getBreedte()) && isOpgelost == false) {
                    // Oplossing naar onder is mogelijk haalbaar...
                    while (lvl.voertuigOpPositie(FreeposX, FreeposY) != null) {

                        nwvrt = lvl.voertuigOpPositie(tmpvt.getX() + tmpvt.getGrootte(), tmpvt.getY());
                        if (nwvrt != null) {
                            if (ChekRootTree(nwvrt)) {
                                Thisstack--;
                                rootvrt[Thisstack] = null;
                                return false;
                            }
                            int movmnttmp = ChekEndlessLoop(nwvrt);
                            if (movmnttmp != 0) {
                                if(movmnt == 4 || movmnt == 1){
                                    rootvrt[Thisstack] = new AiMove(tmpvt,2);
                                    if (setProbleem(nwvrt, tmpvt.getX() + tmpvt.getGrootte(), tmpvt.getY(), 1) == false) {
                                        break;
                                    }
                                }
                            } else {
                                rootvrt[Thisstack] = new AiMove(tmpvt,2);
                                if (setProbleem(nwvrt, tmpvt.getX() + tmpvt.getGrootte(), tmpvt.getY(), 0) == false) {
                                    break;
                                }
                            }
                        } else {
                            movesvrt[move++] = new AiMove(tmpvt,2);
                            tmpvt.NaarRechts();
                            UpdateOutput();
                        }
                    }

                }
            }
            Thisstack--;
            rootvrt[Thisstack] = null;
            return true;
        } else {
            rootvrt[Thisstack] = null;
            return false;
        }

    }

    /**
     *
     */
    public void CleanupMoves() {

    }

    /**
     *
     */
    public void ShowMoves() {
        int teller = 0;
        while (teller < (move)){
            switch (movesvrt[teller].getRichting()){
                case 1:
                    movesvrt[teller].getVoertuig().NaarBoven();
                    break;
                case 2:
                    movesvrt[teller].getVoertuig().NaarRechts();
                    break;
                case 3:
                    movesvrt[teller].getVoertuig().NaarBeneden();
                    break;
                case 4:
                    movesvrt[teller].getVoertuig().NaarLinks();
                    break;
                }
                UpdateOutput();
            teller++;
        }
    }

    private boolean ChekRootTree(Voertuig tmpvrt) {
        if (move > 0) {
            if (rootvrt[Thisstack - 1].hashCode() == tmpvrt.hashCode()) {
                return true;

            } else {
                return false;

            }
        } else {
            return false;
        }
    }
    private int CheckMoveLoop() {
        boolean IsTree = false;
        int movment = 0;
        if (move > 0) {
            int teller = move - 1;
            int tellerp = 0;

            boolean FoundX = false;
            while (teller > 0 && (movesvrt[teller].getVoertuig().hashCode() != rootvrt[tellerp].hashCode())) {
                teller--;
            }
            if (movesvrt[teller].getVoertuig().hashCode() == rootvrt[tellerp].hashCode()) {
                    if (tellerp == 0 && FoundX == false) {
                        IsTree = true;
                        movment = movesvrt[teller].getRichting();
                    }
                    while (tellerp < (Thisstack) && teller < (move - 1)){
                        if (movesvrt[teller].getVoertuig().hashCode() == rootvrt[tellerp].hashCode()) {
                            if (movesvrt[teller + 1].getVoertuig().hashCode() != rootvrt[tellerp].hashCode()) {
                                tellerp++;
                            }
                        }else{
                            IsTree = false;
                        }
                        teller++;
                    }
            }
            if(tellerp == 0){
                IsTree = false;
            }

        }
        if(IsTree){
            return movment;
        }else{
                return 0;
        }
    }

    private int ChekEndlessLoop(Voertuig tmpvrt) {
        int teller = 0;
        while (teller < Thisstack) {
            //tmpvrt
            if (rootvrt[teller].hashCode() == tmpvrt.hashCode()) {
                return rootvrt[teller].getRichting();
            } else {
                teller++;
            }
        }

        return 0;
    }
    
    private void UpdateOutput(){
        gameview.updateUI();
        try {
            Thread.sleep(1500);
        } catch (InterruptedException ex) {
            // Rotzooi
        }
    }



}
