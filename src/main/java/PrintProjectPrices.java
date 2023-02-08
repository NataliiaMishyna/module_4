public class PrintProjectPrices {
    private String project;
    private int price;

    public void setProject(String project) {
        this.project = project;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "PrintProjectPrices{" +
                "project='" + project + '\'' +
                ", price=" + price +
                '}';
    }
}
