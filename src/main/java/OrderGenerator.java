public class OrderGenerator {

    public static Order getDefaultDataWithoutColour() {
        return new Order("Vasya",
                "Pupkin",
                "Qa street",
                "ВДНХ",
                "+79999999999",
                4,
                "2022-11-11",
                "привези скорей!",
                "[]");
    }

    public static Order getBlackBike() {
        Order order = OrderGenerator.getDefaultDataWithoutColour();
        order.setColour("[\"BLACK\"]");
        return order;
    }
    public static Order getGreyBike() {
        Order order = OrderGenerator.getDefaultDataWithoutColour();
        order.setColour("[\"GREY\"]");
        return order;
    }
    public static Order getGreyBlackBike() {
        Order order = OrderGenerator.getDefaultDataWithoutColour();
        order.setColour("[\"GREY\", \"BLACK\"]");
        return order;
    }

}
