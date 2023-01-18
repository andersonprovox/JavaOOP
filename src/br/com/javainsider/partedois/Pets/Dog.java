package br.com.javainsider.partedois.Pets;

public class Dog  extends EarthPets {

    private String dogName;

    public Dog (String dogColor, String dogVoice, boolean dogWalk, String customDogName) {
        super(dogColor, dogVoice, dogWalk);
        dogName = customDogName;
    }

    public void Barking() {
        setVoice("Au, Au!");
    }

    public void dogWalk() {
        setWalkOn(true);
    }
}
