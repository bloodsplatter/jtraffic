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
        if (mainvt.getX() > 0) {
            tmpvt = lvl.voertuigOpPositie(mainvt.getX(), mainvt.getY());
            if (tmpvt != null) {
                setProbleem(tmpvt, mainvt.getX() - 1, mainvt.getY());
            } else {
                mainvt.NaarLinks();
            }
        } else {
            // Gewonnen
            System.out.println("Done!");
        }


    }

    private Boolean setProbleem(Voertuig tmpvt, int FreeposX, int FreeposY) {
        // Chek this stack & max stack
        if (Thisstack < MaxStack) {
            Thisstack++;
            // 2 mogelijkheden normaal / links rechts // up / down
            Voertuig nwvrt;
            Boolean isOpgelost = false;
            if (tmpvt.getOrientatie() == Orientatie.Verticaal) {
                // chek up/down

                //Chek of oplossing mogelijk is
                if ((FreeposY - Convertor.GrootteNaarInt(tmpvt.getGrootte())) >= 0) {
                    // Oplosing naar boven is mogelijk haalbaar...
                    while (lvl.voertuigOpPositie(FreeposX, FreeposY) != null) {

                        nwvrt = lvl.voertuigOpPositie(tmpvt.getX(), tmpvt.getY() - 1);
                        if (nwvrt != null) {
                            if(setProbleem(tmpvt, tmpvt.getX(), tmpvt.getY() - 1) == false){
                                break;
                            }
                        } else {
                            tmpvt.NaarBoven();
                        }

                    }
                    isOpgelost = true;
                }
                if (((FreeposY + Convertor.GrootteNaarInt(tmpvt.getGrootte())) < lvl.getVeld().getHoogte()) && isOpgelost == false) {
                    // Oplossing naar onder is mogelijk haalbaar...
                    nwvrt = lvl.voertuigOpPositie(tmpvt.getX(), tmpvt.getY() + 1);
                    if (nwvrt != null) {
                        setProbleem(tmpvt, tmpvt.getX(), tmpvt.getY() + 1);
                    } else {
                        tmpvt.NaarBeneden();
                    }

                }
            }
            if (tmpvt.getOrientatie() == Orientatie.Horizontaal) {
                // chek up/down

                //Chek of oplossing mogelijk is
                if ((FreeposX - Convertor.GrootteNaarInt(tmpvt.getGrootte())) >= 0) {
                    // Oplosing naar boven is mogelijk haalbaar...
                    nwvrt = lvl.voertuigOpPositie(tmpvt.getX() - 1, tmpvt.getY());
                    if (nwvrt != null) {
                        setProbleem(tmpvt, tmpvt.getX() - 1, tmpvt.getY());
                    } else {
                        tmpvt.NaarLinks();
                    }
                    isOpgelost = true;
                }
                if (((FreeposX + Convertor.GrootteNaarInt(tmpvt.getGrootte())) < lvl.getVeld().getHoogte()) && isOpgelost == false) {
                    // Oplossing naar onder is mogelijk haalbaar...
                    nwvrt = lvl.voertuigOpPositie(tmpvt.getX() + 1, tmpvt.getY());
                    if (nwvrt != null) {
                        setProbleem(tmpvt, tmpvt.getX() + 1, tmpvt.getY());
                    } else {
                        tmpvt.NaarRechts();
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
