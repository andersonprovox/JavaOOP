package br.com.javainsider.parteum;

public class ExRetangle {
    public static void main(String[] args) {
        Rectangle r1 = new Rectangle(5, 6);
        System.out.println(r1.square());

        Rectangle r2 = new Rectangle(7.2);
        System.out.println(r2.square());
    }
}
