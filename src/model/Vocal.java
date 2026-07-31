package model;

public class Vocal {

    private String vocal ;
    private boolean used = false;

    public Vocal(String vocal){
        this.vocal=vocal;
    }

    public String getVocal() {
        return vocal;
    }

    public void setVocal(String vocal) {
        this.vocal = vocal;
    }

    public boolean isUsed() {
        return used;
    }



    public void setUsed() {
        this.used=true;
    }
}
