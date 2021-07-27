package Exercise4;

public class Fraction extends Number implements Comparable<Fraction> {
    private Long dividend;
    private Long divisor;

    public Fraction() {
        this.dividend = 0L;
        this.divisor = 1L;
        this.simplify();
    }

    public Fraction(Integer dividend, Integer divisor) {
        this.dividend = dividend.longValue();
        if (divisor == 0L) {
            throw new ArithmeticException("Dividing by zero");
        }
        this.divisor = divisor.longValue();
        this.simplify();
    }

    public Fraction(Integer dividend) {
        this.dividend = dividend.longValue();
        this.divisor = 1L;
        this.simplify();
    }

    public Fraction(Long dividend, Long divisor) {
        this.dividend = dividend;
        if (divisor == 0L) {
            throw new ArithmeticException("Dividing by zero");
        }
        this.divisor = divisor;
        this.simplify();
    }

    public Fraction(Long dividend) {
        this.dividend = dividend;
        this.divisor = 1L;
        this.simplify();
    }

    public Fraction(Fraction original) {
        this.copy(original);
    }

    public static Fraction valueOf(Number number) {
        if (number instanceof Fraction) {
            return (Fraction) number;
        }
        if (number instanceof Long) {
            return new Fraction((long) number);
        }
        if (number instanceof Integer) {
            return new Fraction((int) number);
        }
        if (number instanceof Double) {
            return valueOf((double) number);
        }
        if (number instanceof Float) {
            return valueOf((float) number);
        }
        if (number instanceof Byte) {
            return valueOf((byte) number);
        }
        throw new RuntimeException("Number type not supported.");
    }

    public Fraction add(Number o) {
        Fraction other = Fraction.valueOf(o);
        Tuple<Long, Long> t = findGreaterAndSmaller(this.divisor, other.divisor);
        Long copyGreater = t.first;
        Long copySmaller = t.second;
        Long nDivisor = this.findLCM(copyGreater, copySmaller);
        Long nDividend = this.dividend * (nDivisor / this.divisor) + other.dividend * (nDivisor / other.divisor);
        return new Fraction(nDividend, nDivisor);
    }

    public Fraction subtract(Number other) {
        Fraction o = Fraction.valueOf(other);
        return this.add(o.flipSignal());
    }

    public Fraction multiply(Number o) {
        Fraction other = valueOf(o);
        return new Fraction(this.dividend * other.dividend, this.divisor * other.divisor);
    }

    public Fraction divide(Number o) {
        Fraction other = valueOf(o);
        return new Fraction(this.dividend * other.divisor, this.divisor * other.dividend);
    }

    @Override
    public String toString() {
        return this.divisor == 1 ? this.dividend.toString() : this.dividend + "/" + this.divisor;
    }

    @Override
    public int intValue() {
        return Double.valueOf(((double) this.dividend) / ((double) this.divisor)).intValue();
    }

    @Override
    public long longValue() {
        return Double.valueOf(((double) this.dividend) / ((double) this.divisor)).longValue();
    }

    @Override
    public float floatValue() {
        return Double.valueOf(((double) this.dividend) / ((double) this.divisor)).floatValue();
    }

    @Override
    public double doubleValue() {
        return ((double) this.dividend) / ((double) this.divisor);
    }

    protected void copy(Fraction other) {
        this.dividend = other.dividend;
        this.divisor = other.divisor;
        this.simplify();
    }

    public static Fraction valueOf(Double real) {
        return valueOf(real.toString());
    }

    public static Fraction valueOf(Float real) {
        return valueOf(real.toString());
    }

    public static Fraction valueOf(Long inter) {
        return new Fraction(inter);
    }

    public static Fraction valueOf(Integer inter) {
        return new Fraction(inter);
    }

    public static Fraction valueOf(Byte mbit) {
        return new Fraction(mbit.longValue());
    }

    public static Fraction valueOf(String value) {
        int index = value.indexOf(".");
        Long headValue;
        if (index == -1) {
            headValue = 0L;
            index = 0;
        } else {
            headValue = Long.valueOf(value.substring(0, index));
            index++;
        }
        value = value.substring(index);
        if (value.length() > 18) {
            value = value.substring(0, 18);
        }
        Fraction result = new Fraction();
        result.divisor = Double.valueOf(Math.pow(10, value.length())).longValue();
        result.dividend = Long.valueOf(value);
        result = result.add(new Fraction(headValue));
        result.simplify();
        return result;
    }

    private Fraction flipSignal() {
        return new Fraction(-this.dividend, this.divisor);
    }

    private Long findGDC(Long a, Long b) {
        Long t;
        while (b != 0) {
            t = b;
            b = a % b;
            a = t;
        }
        return a;
    }

    private Long findLCM(Long a, Long b) {
        return (a / this.findGDC(Math.abs(a), Math.abs(b))) * b;
    }

    private Tuple<Long, Long> findGreaterAndSmaller() {
        return this.findGreaterAndSmaller(this.divisor, this.dividend);
    }

    private Tuple<Long, Long> findGreaterAndSmaller(Long a, Long b) {
        Long greater;
        Long smaller;
        if (a > b) {
            greater = Long.valueOf(a);
            smaller = Long.valueOf(b);
        } else {
            greater = Long.valueOf(b);
            smaller = Long.valueOf(a);
        }
        return new Tuple<>(greater, smaller);
    }

    private void simplify() {
        Tuple<Long, Long> t = findGreaterAndSmaller();
        Long copyGreater = t.first;
        Long copySmaller = t.second;
        Long gcd;
        while ((gcd = findGDC(Math.abs(copyGreater), Math.abs(copySmaller))) > 1) {
            this.dividend /= gcd;
            this.divisor /= gcd;
            t = findGreaterAndSmaller();
            copyGreater = t.first;
            copySmaller = t.second;
        }
        if (this.divisor < 0) {
            if (this.dividend < 0) {
                this.divisor = -this.divisor;
            }
            this.dividend = -this.dividend;
        }
    }

    @Override
    public int compareTo(Fraction o) {
        Double result = this.subtract(o).doubleValue();
        return result < 0 ? -1 : (result > 0 ? 1 : 0);
    }
}
