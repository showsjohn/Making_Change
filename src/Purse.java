import java.util.LinkedHashMap;

public class Purse
{
    private final LinkedHashMap<Denomination, Integer> cash;

    public Purse()
    {
        cash = new LinkedHashMap<Denomination, Integer>();
        cash.put(new Denomination("Ten", 10.00, Form.bill, ""), 0);
        cash.put(new Denomination("Five", 5.0, Form.bill, ""), 0);
        cash.put(new Denomination("One", 1.0, Form.bill, ""), 0);
        cash.put(new Denomination("Quarter", 0.25, Form.coin, ""), 0);
        cash.put(new Denomination("Dime", 0.1, Form.coin, ""), 0);
        cash.put(new Denomination("Nickel", 0.05, Form.coin, ""), 0);
        cash.put(new Denomination("Penny", 0.01, Form.coin, ""), 0);

    }

    public void add(Denomination type, int num)
    {
        cash.put(type, cash.get(type) + num);
    }

    public double remove(Denomination type, int num)
    {
        cash.put(type, cash.get(type) - num);
        return cash.get(type);
    }

    public double getValue()
    {
        double total = 0;

        for (var item: cash.keySet())
        {
            total += item.amt() * cash.get(item);
        }

        return total;

    }

    public String toString()
    {
        String contents = "$$ Purse Contents $$\n";
        for (var item: cash.keySet())
        {
            if (cash.get(item) > 0)
            {
                contents += String.format("%s: %d\n",item.name(), cash.get(item));
            }
        }
        contents += "Total: $" + this.getValue();
        return contents;
    }


}
