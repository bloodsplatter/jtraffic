package RushHour;

/**
 * Een record uit de high score tabel
 * @author bloodsplatter
 * @version 2009.03.03
 */
public class HighScoreRecord {
    private int stappen;
    private String levelnaam;
    private String spelernaam;

    /**
     * Constructor
     * @param levelnaam de naam van de level waar de score is behaald
     * @param spelernaam de naam van de speler die de score behaalde
     */
    public HighScoreRecord(String levelnaam, String spelernaam) {
        this.levelnaam = levelnaam;
        this.spelernaam = spelernaam;
        this.stappen = 0;
    }

    /**
     * Constructor
     * @param steps het aantal stappen dat nodig was om de level te doorlopen
     * @param levelnaam de naam van de level waar de score is behaald
     * @param spelernaam de naam van de speler die de score behaalde
     */
    public HighScoreRecord(int steps, String levelnaam, String spelernaam) {
        this.stappen = steps;
        this.levelnaam = levelnaam;
        this.spelernaam = spelernaam;
    }

    /**
     * Geeft de naam van de level waar de score is behaald
     * @return de naam van de level waar de score is behaald
     */
    public String getLevelnaam() {
        return levelnaam;
    }

    /**
     * stel de naam in van de level waar de score is behaald
     * @param levelnaam de naam van de level
     */
    public void setLevelnaam(String levelnaam) {
        this.levelnaam = levelnaam;
    }

    /**
     * Stel de naam van de speler in
     * @return de naam van de speler
     */
    public String getSpelernaam() {
        return spelernaam;
    }

    /**
     * Stel de naam in van de speler
     * @param spelernaam de naam van de speler
     */
    public void setSpelernaam(String spelernaam) {
        this.spelernaam = spelernaam;
    }

    /**
     * Vraag het aantal stappen op dat nodig was om de level op te lossen
     * @return het aantal stappen
     */
    public int getSteps() {
        return stappen;
    }

    /**
     * Stel het aantal stappen in dat nodig was om de level op te lossen
     * @param steps het aantal benodigde stappen
     */
    public void setSteps(int steps) {
        this.stappen = steps;
    }

    @Override
    public String toString() {
        return String.format("|%1$4d|%2$s|%3$s|",stappen,levelnaam,spelernaam);
    }

}
