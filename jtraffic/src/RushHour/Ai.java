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
    private int MaxStack = 6;
    private int Thisstack = 0;

    public Ai(Level lvl) {
        this.lvl = lvl;
    }

    public void run() {
        Voertuig mainvt;
        Voertuig tmpvt;

        mainvt = lvl.voertuigOpPlaats(0);
        //while(mainvt.getX() > 0){
        tmpvt = lvl.voertuigOpPositie((mainvt.getX() - 1), mainvt.getY());
        if (tmpvt != null) {
            setProbleem(tmpvt, mainvt.getX() - 1, mainvt.getY(), mainvt);
        } else {
            mainvt.NaarLinks();
        }
        //}
        // Gewonnen
        System.out.println("Done!");



    }

    private Boolean setProbleem(Voertuig tmpvt, int FreeposX, int FreeposY, Voertuig rootvt) {
        // Chek this stack & max stack
        if (Thisstack < MaxStack) {
            Thisstack++;
            // 2 mogelijkheden normaal / links rechts // up / down
            Voertuig nwvrt;
            Boolean isOpgelost = false;
            if (tmpvt.getOrientatie() == Orientatie.Verticaal) {
                // chek up/down

                //Chek of oplossing mogelijk is
                if ((FreeposY - tmpvt.getGrootte()) >= 0) {
                    // Oplosing naar boven is mogelijk haalbaar...
                    while (lvl.voertuigOpPositie(FreeposX, FreeposY) != null) {

                        nwvrt = lvl.voertuigOpPositie(tmpvt.getX(), tmpvt.getY() - 1);
                        if (nwvrt != null) {
                            if (rootvt.hashCode() == nwvrt.hashCode()) {
                                break;
                            }
                            if (setProbleem(nwvrt, tmpvt.getX(), tmpvt.getY() - 1, tmpvt) == false) {
                                break;
                            }
                        } else {
                            tmpvt.NaarBoven();
                        }
                    }

                    // Controleer nu of het is opgelost of hij is terug
                    // geroepen door de Maxstack
                    if (lvl.voertuigOpPositie(FreeposX, FreeposY) == null) {
                        isOpgelost = true;
                    }

                }
                if ((FreeposY + tmpvt.getGrootte() <= lvl.getVeld().getHoogte()) && isOpgelost == false) {
                    // Oplossing naar onder is mogelijk haalbaar...
                    while (lvl.voertuigOpPositie(FreeposX, FreeposY) != null) {

                        nwvrt = lvl.voertuigOpPositie(tmpvt.getX(), tmpvt.getY() + tmpvt.getGrootte());
                        if (nwvrt != null) {
                            if (rootvt.hashCode() == nwvrt.hashCode()) {
                                break;
                            }
                            if (setProbleem(nwvrt, tmpvt.getX(), tmpvt.getY() + tmpvt.getGrootte(), tmpvt) == false) {
                                break;
                            }
                        } else {
                            tmpvt.NaarBeneden();
                        }
                    }

                }
            }
            if (tmpvt.getOrientatie() == Orientatie.Horizontaal) {
                // chek up/down

                //Chek of oplossing mogelijk is
                if ((FreeposX - tmpvt.getGrootte()) >= 0) {
                    // Oplosing naar boven is mogelijk haalbaar...
                    while (lvl.voertuigOpPositie(FreeposX, FreeposY) != null) {

                        nwvrt = lvl.voertuigOpPositie(tmpvt.getX() - 1, tmpvt.getY());
                        if (nwvrt != null) {
                            if (rootvt.hashCode() == nwvrt.hashCode()) {
                                break;
                            }
                            if (setProbleem(nwvrt, tmpvt.getX() - 1, tmpvt.getY(), tmpvt) == false) {
                                break;
                            }
                        } else {
                            tmpvt.NaarLinks();
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
                            if (rootvt.hashCode() == nwvrt.hashCode()) {
                                break;
                            }
                            if (setProbleem(nwvrt, tmpvt.getX() + tmpvt.getGrootte(), tmpvt.getY(), tmpvt) == false) {
                                break;
                            }
                        } else {
                            tmpvt.NaarRechts();
                        }
                    }

                }
            }
            Thisstack--;
            return true;
        } else {
            return false;
        }

    }

    private void ControleBeweging(Voertuig tmpvt) {
    }
}
