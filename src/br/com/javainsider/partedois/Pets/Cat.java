package br.com.javainsider.partedois.Pets;

public class Cat extends EarthPets {
    private String catName;

    public Cat (String catColor, String catVoice, boolean isCatWalking, String customCatName) {
        super(catColor, catVoice, isCatWalking);
        catName = customCatName;
    }

    public void Moaning() {
        setVoice("miau, miau");
    }

    public void catWalking() {
        setWalkOn(true);
    }

    public String getCatName() {
        return catName;
    }

    public void setCatName(String catName) {
        this.catName = catName;
    }
}
