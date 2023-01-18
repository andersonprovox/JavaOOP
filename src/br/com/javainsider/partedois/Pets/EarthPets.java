package br.com.javainsider.partedois.Pets;

public class EarthPets extends Pets{

    private String voice;
    private boolean walkOn;

    public EarthPets( String customColor, String soundVoice, boolean startWalk) {
        super(customColor);
        voice = soundVoice;
        walkOn = startWalk;
    }

    public String getVoice() {
        return voice;
    }

    public void setVoice(String voice) {
        this.voice = voice;
    }

    public boolean isWalkOn() {
        return walkOn;
    }

    public void setWalkOn(boolean walkOn) {
        this.walkOn = walkOn;
    }

   public String print() {
        return "Voz do animal: " +
                voice + " Está andando?" +
                walkOn;
   }



}
