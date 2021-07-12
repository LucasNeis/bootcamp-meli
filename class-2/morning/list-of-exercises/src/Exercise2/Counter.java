package Exercise2;

public class Counter {
    long count;
    public Counter() {
        this.count = 0;
    }

    public Counter(long initialValue) {
        this.count = initialValue;
    }

    public Counter(Counter original) {
        this.count = original.count;
    }

    public void increment() {
        this.count++;
    }

    public void decrement() {
        this.count--;
    }

    public void set(long val) {
        this.count = val;
    }

    public void reset() {
        this.count = 0;
    }

    public long get() {
        return this.count;
    }

    @Override
    public String toString() {
        return String.valueOf(count);
    }
}
