package br.com.javainsider.parteum;

public class exNumber2 {
    public static void main(String[] args) {
        var n1 = Number2.newNumber(10);

        System.out.println(n1.getNumber());

        var n2 = Number2.newNumber(5);
        var n3 = Number2.add(n1, n2);
        System.out.println(n3.getNumber());

        System.out.println(Number2.getInstances());
    }
}
