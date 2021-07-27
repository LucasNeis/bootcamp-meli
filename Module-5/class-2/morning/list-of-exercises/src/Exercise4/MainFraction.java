package Exercise4;

public class MainFraction {
    public static void main(String[] args) {
        Fraction f = new Fraction(2, 4);
        Fraction s = new Fraction(6, 9);
        Fraction p = Fraction.valueOf(3.1415);
        System.out.println(" (equiv val): " + p + " = " + p.doubleValue());
        System.out.println("    (add op): " + f + " + " + f + " = " + f.add(f));
        System.out.println("(subtrac op): " + s + " - " + s + " = " + s.subtract(s));
        System.out.println(" (divide op): " + f + " ÷ " + s + " = " + f.divide(s));
        System.out.println("(multipl op): " + s + " × " + f + " = " + s.multiply(f));
        System.out.println("  (long  op): " + p + " + " + "999,999,999,999,999" + " = " + p.add(999999999999999L) + " = " +
                p.add(999999999999999L).doubleValue());
        System.out.println("(integer op): " + p + " - " + "3" + " = " + p.subtract(3) + " = " + p.subtract(3).doubleValue());
        System.out.println(" (double op): " + p + " ÷ " + "e" + " = " + p.divide(Math.E) + " = " + p.divide(Math.E).doubleValue());
        System.out.println("  (float op): " + p + " × " + "0.1" + " = " + p.multiply(0.1f) + " = " + p.multiply(0.1f).doubleValue());
    }
}
