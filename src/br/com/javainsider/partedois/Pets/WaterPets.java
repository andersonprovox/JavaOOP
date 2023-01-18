package br.com.javainsider.partedois.Pets;

public class WaterPets extends Pets{
    private boolean swimOn;

    public WaterPets(String animalColor, boolean startSwiming) {
        super(animalColor);
        swimOn = startSwiming;
    }

    public boolean isSwimOn() {
        return swimOn = true;
    }

    public String print() {
        return "Está nadando: " +
                swimOn + " Cor: " + getColor();
    }

    public void setSwimOn(boolean swimOn) {
        this.swimOn = swimOn;
    }
}
