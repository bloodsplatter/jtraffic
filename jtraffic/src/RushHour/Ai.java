/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.System.out.println
 */
package RushHour;

/**
 *
 * @author chris
 */
public class Ai {

    private Level lvl;
    private int MaxStack = 20;
    private int Thisstack = 0;
    private int MaxLoops = 20;
    private Voertuig rootvrt[] = new Voertuig[MaxStack];
    private AiMove movesvrt[] = new AiMove[40];
    private int movesrichtig[] = new int[40];
    private int move = 0;

    /**
     * Constructor
     * @param lvl de level die opgelost moet worden
     */
    public Ai(Level lvl) {
        this.lvl = lvl;
    }

    /**
     *
     * @throws java.lang.InterruptedException
     */
    public void run() throws InterruptedException {
        Voertuig mainvt;
        Voertuig tmpvt;
        int loops = 0;
        mainvt = lvl.voertuigOpPlaats(0);
        while ((mainvt.getX() + mainvt.getGrootte() <= lvl.getVeld().getBreedte()) && (loops < MaxLoops)) {
            tmpvt = lvl.voertuigOpPositie((mainvt.getX() + mainvt.getGrootte()), mainvt.getY());
            if (tmpvt != null) {
                rootvrt[0] = mainvt;
                setProbleem(tmpvt, mainvt.getX() + mainvt.getGrootte(), mainvt.getY(), 0);
            } else {
                movesvrt[move++] = new AiMove(mainvt,4);
                mainvt.NaarRechts();
                System.out.println(lvl.toString());
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
                if (CheckMoveLoop()) {
                    rootvrt[Thisstack] = tmpvt;
                    setProbleem(tmpvt, FreeposX, FreeposY, 1);
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
                            if (ChekEndlessLoop(nwvrt)) {
                                if (setProbleem(nwvrt, tmpvt.getX(), tmpvt.getY() - 1, 1) == false) {
                                    break;
                                }
                            } else {
                                rootvrt[Thisstack] = tmpvt;
                                if (setProbleem(nwvrt, tmpvt.getX(), tmpvt.getY() - 1, 0) == false) {
                                    break;
                                }
                            }
                        } else {
                            movesvrt[move++] = new AiMove(tmpvt,1);
                            tmpvt.NaarBoven();
                            System.out.println(lvl.toString());
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
                            if (ChekEndlessLoop(nwvrt)) {
                                if (setProbleem(nwvrt, tmpvt.getX(), tmpvt.getY() + tmpvt.getGrootte(), 1) == false) {
                                    break;
                                }
                            } else {
                                rootvrt[Thisstack] = tmpvt;
                                if (setProbleem(nwvrt, tmpvt.getX(), tmpvt.getY() + tmpvt.getGrootte(), 0) == false) {
                                    break;
                                }
                            }
                        } else {
                            movesvrt[move++] = new AiMove(tmpvt,3);
                            tmpvt.NaarBeneden();
                            System.out.println(lvl.toString());
                        }
                    }

                }
            }
            if (tmpvt.getOrientatie() == Orientatie.Horizontaal) {
                // chek up/down

                // Chek of hij move's aan het reversen is,
                // zoja, voer de ai uit met omgekeerde choise prioriteit
                // Door deze opnieuw op te gooien maar dan met voorkeur voor choise 1
                if (CheckMoveLoop()) {
                    rootvrt[Thisstack] = tmpvt;
                    setProbleem(tmpvt, FreeposX, FreeposY, 1);
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
                            if (ChekEndlessLoop(nwvrt)) {
                                if (setProbleem(nwvrt, tmpvt.getX() - 1, tmpvt.getY(), 1) == false) {
                                    break;
                                }
                            } else {
                                rootvrt[Thisstack] = tmpvt;
                                if (setProbleem(nwvrt, tmpvt.getX() - 1, tmpvt.getY(), 0) == false) {
                                    break;
                                }
                            }
                        } else {
                            movesvrt[move++] = new AiMove(tmpvt,4);
                            tmpvt.NaarLinks();
                            System.out.println(lvl.toString());
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
                            if (ChekEndlessLoop(nwvrt)) {
                                if (setProbleem(nwvrt, tmpvt.getX() + tmpvt.getGrootte(), tmpvt.getY(), 1) == false) {
                                    break;
                                }
                            } else {
                                rootvrt[Thisstack] = tmpvt;
                                if (setProbleem(nwvrt, tmpvt.getX() + tmpvt.getGrootte(), tmpvt.getY(), 0) == false) {
                                    break;
                                }
                            }
                        } else {
                            movesvrt[move++] = new AiMove(tmpvt,2);
                            tmpvt.NaarRechts();
                            System.out.println(lvl.toString());
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

    public void CleanupMoves() {

    }

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
                System.out.println(lvl.toString());
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

    private boolean CheckMoveLoop() {
        boolean IsTree = false;
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

        return IsTree;
    }

    private boolean ChekEndlessLoop(Voertuig tmpvrt) {
        int teller = 0;
        while (teller < Thisstack) {
            //tmpvrt
            if (rootvrt[teller].hashCode() == tmpvrt.hashCode()) {
                return true;
            } else {
                teller++;
            }
        }

        return false;
    }
}
