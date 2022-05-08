public class Hotel {
    private String name;
    private int classification;
    private int[][] prices;

    public Hotel(String name, int classification, int[][] prices) {
        this.name = name;
        this.classification = classification;
        this.prices = prices;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getClassification() {
        return classification;
    }

    public void setClassification(int classification) {
        this.classification = classification;
    }

    public int[][] getPrices() {
        return prices;
    }

    public void setPrices(int[][] prices) {
        this.prices = prices;
    }
}