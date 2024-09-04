enum Form {bill, coin}
public record Denomination(String name, double amt, Form form, String img){
    public static Denomination Hundred = new Denomination ("Hundred", 100.00, Form.bill, "images/hundred_note.png");
    public static Denomination Fifty = new Denomination("Fifty", 50.00, Form.bill, "images/fifty_note.png");
    public static Denomination Twenty= new Denomination("Twenty", 20.00, Form.bill, "images/twenty_note.png");
    public static Denomination Ten = new Denomination("Ten", 10.00, Form.bill, "images/ten_note.png");
    public static Denomination Five = new Denomination("Five", 5.0, Form.bill, "images/five_note.png");
    public static Denomination One = new Denomination("One", 1.0, Form.bill, "images/one_note.png");
    public static Denomination Quarter = new Denomination("Quarter", 0.25, Form.coin, "images/quarter.png");
    public static Denomination Dime = new Denomination("Dime", 0.1, Form.coin, "images/dime.png");
    public static Denomination Nickel = new Denomination("Nickel", 0.05, Form.coin, "images/nickel.png");
    public static Denomination Penny = new Denomination("Penny", 0.01, Form.coin, "images/penny.png");
}
