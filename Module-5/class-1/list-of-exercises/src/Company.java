public class Company {
    private double value;
    private float growth;

    public Company(double current_value, float growth) {
        this.value = current_value;
        this.growth = growth;
    }

    public float getGrowth() {
        return growth;
    }

    public double getValue() {
        return value;
    }

    public void reEvaluate() {
        this.value = value*(1+this.growth);
    }
}