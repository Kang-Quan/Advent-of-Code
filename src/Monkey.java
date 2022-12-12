import java.util.List;

public class Monkey {
    private List<Double> items;
    private Boolean isAdd;
    private int operationValue;
    private int testValue;
    private int trueMonkey;
    private int falseMonkey;
    private int monkeyNumber;

    Monkey(List<Double> items, Boolean isAdd, int operationValue
        , int testValue, int trueMonkey, int falseMonkey) {

        this.items = items;
        this.isAdd = isAdd;
        this.operationValue = operationValue;
        this.testValue = testValue;
        this.trueMonkey = trueMonkey;
        this.falseMonkey = falseMonkey;
        this.monkeyNumber = 0;
    }

    public List<Double> getItems() {
        return this.items;
    }

    public int getOperationValue() {
        return this.operationValue;
    }

    public int getTestValue() {
        return this.testValue;
    }

    public int getTrueMonkey() {
        return this.trueMonkey;
    }

    public int getFalseMonkey() {
        return this.falseMonkey;
    }

    public int getMonkeyNumber() {
        return this.monkeyNumber;
    }

    public Boolean getIsAdd() {
        return this.isAdd;
    }

    public void updateNumber() {
        this.monkeyNumber += 1;
    }
}
