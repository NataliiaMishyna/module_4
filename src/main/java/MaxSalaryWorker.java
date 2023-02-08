public class MaxSalaryWorker {
    private String name;
    private int maxSalaryworker;

    public void setName(String name) {
        this.name = name;
    }

    public void setMaxSalaryworker(int maxSalaryworker) {
        this.maxSalaryworker = maxSalaryworker;
    }

    @Override
    public String toString() {
        return "MaxSalaryWorker{" +
                "name='" + name + '\'' +
                ", maxSalaryworker=" + maxSalaryworker +
                '}';
    }
}
