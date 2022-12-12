import java.util.ArrayList;
import java.util.List;

public class MonkeyList {
    private List<Monkey> monkeys;

    MonkeyList(List<Monkey> monkeys) {
        this.monkeys = monkeys;
    }

    public void singleRoutine(Monkey currMonkey) {
        List<Double> itemsToDelete = new ArrayList<>();

        for (int i = 0; i < currMonkey.getItems().size(); i++) {
            Double currentItem = currMonkey.getItems().get(i);

            if (currMonkey.getIsAdd()) {
                currentItem += currMonkey.getOperationValue();
            } else {
                if (currMonkey.getOperationValue() == -1) {
                    currentItem *= currentItem;
                } else {
                    currentItem *= currMonkey.getOperationValue();
                }
            }

            //after they get bored
            currentItem = currentItem / 3;
            currentItem = Math.floor(currentItem);

            if (currentItem % currMonkey.getTestValue() == 0) {
                //add to trueMonkey
                Monkey passingMonkey = monkeys.get(currMonkey.getTrueMonkey());
                passingMonkey.getItems().add(currentItem); 
                itemsToDelete.add(currMonkey.getItems().get(i));
            } else {
                Monkey passingMonkey = monkeys.get(currMonkey.getFalseMonkey());
                passingMonkey.getItems().add(currentItem); 
                itemsToDelete.add(currMonkey.getItems().get(i));
            }

            currMonkey.updateNumber();

        }

        for (int i = 0; i < itemsToDelete.size(); i++) {
            currMonkey.getItems().remove(itemsToDelete.get(i));
        }
    }

    public int FullRoutine() {
        for (int i = 0; i < monkeys.size(); i++) {
            this.singleRoutine(monkeys.get(i));
        }

        List<Integer> number = new ArrayList<>();
        for (int i = 0; i < monkeys.size(); i++) {
            number.add(monkeys.get(i).getMonkeyNumber());
        }

        number.sort(null);

        return number.get(number.size() - 1) * number.get(number.size() - 2);
        
    }

    public void singleRoutine2(Monkey currMonkey, int multiplier) {
        List<Double> itemsToDelete = new ArrayList<>();

        for (int i = 0; i < currMonkey.getItems().size(); i++) {
            Double currentItem = currMonkey.getItems().get(i);

            if (currMonkey.getIsAdd()) {
                currentItem += currMonkey.getOperationValue();
            } else {
                if (currMonkey.getOperationValue() == -1) {
                    currentItem *= currentItem;
                } else {
                    currentItem *= currMonkey.getOperationValue();
                }
            }

            currentItem %= multiplier;
            //after they get bored
            //currentItem = currentItem / 3;

            if (currentItem % currMonkey.getTestValue() == 0) {
                //add to trueMonkey
                Monkey passingMonkey = monkeys.get(currMonkey.getTrueMonkey());
                passingMonkey.getItems().add(currentItem); 
                itemsToDelete.add(currMonkey.getItems().get(i));
            } else {
                Monkey passingMonkey = monkeys.get(currMonkey.getFalseMonkey());
                passingMonkey.getItems().add(currentItem); 
                itemsToDelete.add(currMonkey.getItems().get(i));
            }

            currMonkey.updateNumber();

        }

        for (int i = 0; i < itemsToDelete.size(); i++) {
            currMonkey.getItems().remove(itemsToDelete.get(i));
        }
    }

    public long FullRoutine2(int multiplier) {
        for (int i = 0; i < monkeys.size(); i++) {
            this.singleRoutine2(monkeys.get(i), multiplier);
        }

        List<Integer> number = new ArrayList<>();
        for (int i = 0; i < monkeys.size(); i++) {
            number.add(monkeys.get(i).getMonkeyNumber());
        }

        number.sort(null);
        //System.out.println(number.get(number.size() - 1));
        //System.out.println(number.get(number.size() - 2));
        return (long) number.get(number.size() - 1) * number.get(number.size() - 2);
        
    }

    



}

