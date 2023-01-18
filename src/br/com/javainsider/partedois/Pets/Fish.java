package br.com.javainsider.partedois.Pets;

public class Fish extends WaterPets{

   private String fishName;

   public Fish(String fishColor, boolean isSwiming, String CustomFishName) {
       super(fishColor, isSwiming);
       fishName = CustomFishName;
   }

   public void Swimming() {
       isSwimOn();
   }

   @Override
   public String print() {
       return super.print() +
        " Nome: " + fishName;
   }

    public String getFishName() {
        return fishName;
    }

    public void setFishName(String fishName) {
        this.fishName = fishName;
    }
}
