public class Register {
    public static Purse makeChange(double amt)
    {
        amt = Math.round(amt * 100.0);
        int amount = (int) amt;
        int tens, fives, ones, quarters, dimes, nickels, pennies;

        tens = amount / 1000;
        amount = amount % 1000;

        fives = amount / 500;
        amount = amount % 500;

        ones = amount / 100;
        amount = amount % 100;

        quarters = amount / 25;
        amount = amount % 25;

        dimes = amount / 10;
        amount = amount % 10;

        nickels = amount / 5;
        amount = amount % 5;

        pennies = amount;

        Purse purse = new Purse();

        purse.add(new Denomination("Ten", 10.00, Form.bill, ""), tens);
        purse.add(new Denomination("Five", 5.0, Form.bill, ""), fives);
        purse.add(new Denomination("One", 1.0, Form.bill, ""), ones);
        purse.add(new Denomination("Quarter", 0.25, Form.coin, ""), quarters);
        purse.add(new Denomination("Dime", 0.1, Form.coin, ""), dimes);
        purse.add(new Denomination("Nickel", 0.05, Form.coin, ""), nickels);
        purse.add(new Denomination("Penny", 0.01, Form.coin, ""), pennies);

        return purse;
    }

    public static void main(String[] args) {

        Purse purse = makeChange(13.92);

        System.out.print(purse.toString());

    }


}
