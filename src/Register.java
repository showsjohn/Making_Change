public class Register {

    public Purse makeChange(double amt)
    {
        Purse purse = new Purse();

        if (amt < 0)
            return purse;

        amt = Math.round(amt * 100.0);
        int amount = (int) amt;
        int hundreds, fifties, twenties, tens, fives, ones, quarters, dimes, nickels, pennies;

        hundreds = amount / 10000;
        amount = amount % 10000;
        if(hundreds > 0)
            purse.add(Denomination.Hundred, hundreds);

        fifties = amount / 5000;
        amount = amount % 5000;
        if(fifties > 0)
            purse.add(Denomination.Fifty, fifties);

        twenties = amount / 2000;
        amount = amount % 2000;
        if(twenties > 0)
            purse.add(Denomination.Twenty, twenties);

        tens = amount / 1000;
        amount = amount % 1000;
        if(tens > 0)
            purse.add(Denomination.Ten, tens);

        fives = amount / 500;
        amount = amount % 500;
        if(fives > 0)
            purse.add(Denomination.Five, fives);

        ones = amount / 100;
        amount = amount % 100;
        if(ones > 0)
            purse.add(Denomination.One, ones);

        quarters = amount / 25;
        amount = amount % 25;
        if(quarters > 0)
            purse.add(Denomination.Quarter, quarters);

        dimes = amount / 10;
        amount = amount % 10;
        if(dimes > 0)
            purse.add(Denomination.Dime, dimes);

        nickels = amount / 5;
        amount = amount % 5;
        if(nickels > 0)
            purse.add(Denomination.Nickel, nickels);

        pennies = amount;
        if(pennies > 0)
            purse.add(Denomination.Penny, pennies);



        return purse;
    }

    public static void main(String[] args) {


    }


}
