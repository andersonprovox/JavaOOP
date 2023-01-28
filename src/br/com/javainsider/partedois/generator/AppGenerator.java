package br.com.javainsider.partedois.generator;

public class AppGenerator {
    public static void main(String[] args) {
        //Generator generator = new RandomGenerator();
        Generator generator = new SequenceGenerator();

        Person p1 = new Person(generator);
        System.out.println(p1.getId());

        Person p2 = new Person(generator);
        System.out.println(p2.getId());

        Person p3 = new Person(generator);
        System.out.println(p3.getId());
    }
}
