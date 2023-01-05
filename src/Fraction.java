public class Fraction {

    int numerator;
    int denominator;

    void set (int n, int d){
        this.numerator = n;
        this.denominator = d;
    }
    Fraction multiply(Fraction f) {
        Fraction r = new Fraction();
        r.numerator = numerator * f.numerator;
        r.denominator = denominator * f.denominator;

        return r;
    }

    void show() {
        System.out.println(numerator + " / " + denominator);
    }
}
