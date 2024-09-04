import java.math.BigDecimal;
import java.util.LinkedHashMap;

public class Purse
{
    private final LinkedHashMap<Denomination, Integer> cash;

    public Purse()
    {
        cash = new LinkedHashMap<>();
    }

    /********************************************************
     * Function: add
     * Args: Denomination, int
     * Returns: void
     * Description: Takes a Denomination(k) and integer(v)
     * and adds it to the 'cash' HashMap
     ********************************************************/
    public void add(Denomination type, int num)
    {
        cash.put(type, num);
    }

    /********************************************************
     * Function: remove
     * Args: Denomination, int
     * Returns: double
     * Description: Takes a Denomination(k) and integer(v)
     * and removes it from the 'cash' Hashmap. It returns the
     * new total;
     ********************************************************/
    public double remove(Denomination type, int num)
    {
        cash.put(type, cash.get(type) - num);
        return cash.get(type);
    }

    /********************************************************
     * Function: getContents
     * Args: none
     * Returns: LinkedHashMap<Denomination, Integer>
     * Description: returns a copy of the 'cash' HashMap
     ********************************************************/
    public LinkedHashMap<Denomination, Integer> getContents()
    {
        return new LinkedHashMap<>(cash);
    }

    /********************************************************
     * Function: getValue
     * Args: none
     * Returns: double
     * Description: calculates and returns the cash value of all
     * the denominations in the 'cash' Hashmap
     ********************************************************/
    public double getValue()
    {
        BigDecimal total = new BigDecimal(0);

        for (var item: cash.keySet())
        {
            total = total.add(BigDecimal.valueOf(item.amt() * cash.get(item)));
        }

        return total.doubleValue();
    }

    /********************************************************
     * Function: toString()
     * Args: none
     * Returns: String
     * Description: returns a String representation of the purse
     *  contents
     ********************************************************/
    public String toString()
    {
        StringBuilder contents = new StringBuilder("\n$$ Purse Contents $$\n");
        for (var item: cash.keySet())
        {
            contents.append(String.format("%s: %d\n", item.name(), cash.get(item)));
        }
        contents.append("----------------------\n");
        contents.append(String.format("Total: $%.2f",  this.getValue()));
        return contents.toString();
    }


}
