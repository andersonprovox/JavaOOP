package br.com.javainsider.partedois.Pets;

public class AppPets {
    public static void main(String[] args) {
        Fish fish = new Fish("Gold", false, "Xuxa");
        System.out.println(fish.print());
        fish.isSwimOn();
        System.out.println(fish.print());
    }
}
