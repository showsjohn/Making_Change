import java.math.BigDecimal;
import java.util.LinkedHashMap;

public class Purse
{
    private final LinkedHashMap<Denomination, Integer> cash;

    public Purse()
    {
        cash = new LinkedHashMap<>();
    }

    public void add(Denomination type, int num)
    {
        cash.put(type, num);
    }

    public double remove(Denomination type, int num)
    {
        cash.put(type, cash.get(type) - num);
        return cash.get(type);
    }

    public LinkedHashMap<Denomination, Integer> getContents()
    {
        return new LinkedHashMap<>(cash);
    }

    public double getValue()
    {
        BigDecimal total = new BigDecimal(0);

        for (var item: cash.keySet())
        {
            total = total.add(BigDecimal.valueOf(item.amt() * cash.get(item)));
        }

        return total.doubleValue();
    }

    public String toString()
    {
        StringBuilder contents = new StringBuilder("\n$$ Purse Contents $$\n");
        for (var item: cash.keySet())
        {
            contents.append(String.format("%s: %d\n", item.name(), cash.get(item)));
        }
        contents.append("----------------------\n");
        contents.append(String.format("Total: $ %.2f",  this.getValue()));
        return contents.toString();
    }


}
