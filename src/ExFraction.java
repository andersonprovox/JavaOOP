public class ExFraction {
    public static void main(String[] args) {
        Fraction f1 = new Fraction();
        f1.set(2, 4);

        Fraction f2 = new Fraction();
        f2.set(3, 6);

        Fraction f3 = f1.multiply(f2);
        f3.show();
    }
}
