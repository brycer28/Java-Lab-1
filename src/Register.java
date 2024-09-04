import java.util.*;

public class Register {
    public static void main(String[] args){
        var in = new Scanner(System.in);
//        System.out.print("Welcome to the Register Suite! Would you like to make change?\n(0-NO 1-YES)");
//        boolean choice = in.nextBoolean();
//
//        if(!choice){
//            //re prompt or close?
//        }
        Register r = new Register();
        System.out.println("How much money do you have with you?");
        double amt = in.nextDouble();
        System.out.println("Great! I'll get started making your change!");
        Purse purse = makeChange(amt);
        System.out.println(purse.purseToString());
    }


    public static Purse makeChange(double amt) {
        //takes in amount and returns reference to purse with individual denominations
        //smallest denominations

        //1 - create all denominations
        //2 - make an empty purse
        //3 - 'make change' algorithm (add denominations)
        //4 - return full purse

        //2
        Purse p = new Purse();
        double amtRem = amt;

        //3
        //if purse is empty
        if (amt < .01) {
            return null;
        }
        while (amtRem > 0) {
            if (amtRem >= 100.00) {
                p.addToPurse(new Denomination("One Dollar Bill", 1, "B", "resized/one.png"), 1);
                amtRem -= 100.00;
            } else if (amtRem >= 20.00) {
                p.addToPurse(new Denomination("Twenty Dollar Bill", 1, "B", "resized/one.png"), 1);
                amtRem -= 20.00;
            } else if (amtRem >= 10.00) {
                p.addToPurse(new Denomination("Ten Dollar Bill", 1, "B", "resized/one.png"), 1);
                amtRem -= 10.00;
            } else if (amtRem >= 5.00) {
                p.addToPurse(new Denomination("Five Dollar Bill", 1, "B", "resized/one.png"),1 );
                amtRem -= 5.00;
            } else if (amtRem >= 1.00) {
                p.addToPurse(new Denomination("One Dollar Bill", 1, "B", "resized/one.png"),1 );
                amtRem -= 1.00;
            } else if (amtRem >= .25) {
                p.addToPurse(new Denomination("Quarter", 0.25, "C", "resized/quarter.png"),1 );
                amtRem -= .25;
            } else if (amtRem >= .10) {
                p.addToPurse(new Denomination("Dime", 0.10, "C", "resized/dime.png"),1);
                amtRem -= .10;
            } else if (amtRem >= .05) {
                p.addToPurse(new Denomination("Nickel", .05, "C", "resized/nickel.png"), 1);
                amtRem -= .05;
            } else {
                p.addToPurse(new Denomination("Penny", 0.01, "C", "resized/penny.png"),1 );
                amtRem -= .01;
            }
        }
        //4
        return p;
    }

    public record Denomination(
            String name, //name of the bill - "__ Dollar Bill", "Quarter", etc
            double amt,  //100, 20, 10, 5, 1, .25, .10, .5, .1
            String form, //"B" for Bill OR "C" for coin
            String img   //file path of each denomination
    ) {}
    List<Denomination> register = new ArrayList<Denomination>();
    Denomination hundredBill = new Denomination("One Hundred Dollar Bill", 100, "B", "resized/hundred.png");
    Denomination twentyBill = new Denomination("Twenty Dollar Bill", 20, "B", "resized/twenty.png");
    Denomination tenBill = new Denomination("Ten Dollar Bill", 10, "B", "resized/ten.png");
    Denomination fiveBill = new Denomination("Five Dollar Bill", 5, "B", "resized/five.png");
    Denomination oneBill = new Denomination("One Dollar Bill", 1, "B", "resized/one.png");
    Denomination quarter = new Denomination("Quarter", 0.25, "C", "resized/quarter.png");
    Denomination dime = new Denomination("Dime", 0.10, "C", "resized/dime.png");
    Denomination nickel = new Denomination("Nickel", 0.05, "C", "resized/nickel.png");
    Denomination penny = new Denomination("Penny", 0.01, "C", "resized/penny.png");
}

