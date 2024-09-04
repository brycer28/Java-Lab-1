//may have to change value instead of adding keys.
//ex. instead of adding duplicate keys to map, change the count
import java.util.*;

public class Purse {
    private static Map<Register.Denomination, Integer> cash = new HashMap<>();

    public static void addToPurse (Register.Denomination d, int count) {
        //add individual denominations to purse
        //if no pair, create new with count as val
        //if pair already exists, add count to val

        Integer i = (Integer) count;
        if (!cash.containsKey(d)) {
            cash.put(d, i);
        } else if (cash.get(d) != null) {
            cash.replace(d, cash.get(d) + i );
        }
    }

    public Map<Register.Denomination, Integer> getDenoms() {
        return cash;
    }

    public static double getValue(){
        //returns the total value of all cash in purse
        double total = 0;
        for (Map.Entry<Register.Denomination, Integer> entry : cash.entrySet()) {
            double billAmt = entry.getKey().amt();
            total = total + (billAmt * entry.getValue());
        }
        return total;
    }

    public static double remove (Register.Denomination name, int count) {
        //remove from the purse and return new total
        cash.remove(name, count);
        //may have to re-write the getValue to show new total
        //inquire about calling methods in methods
        return 0;
    }

    public static String purseToString() {
        String str = "";

        for (Map.Entry<Register.Denomination, Integer> entry : cash.entrySet()) {
            if (entry.getValue() != null) {
                for (int i=0; i < entry.getValue().intValue(); i++) {
                    str += entry.getKey().name() + "\n";
                }
            }
        }
        return str;
    }
}
