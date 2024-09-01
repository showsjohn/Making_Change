enum Form {bill, coin}

public record Denomination(String name, double amt, Form form, String img)
{
}
