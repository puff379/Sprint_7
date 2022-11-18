package courier;

public class CourierGenerator {
    public static Courier getDefault(){
        return new Courier("Русhkhjhgnmbbnmoн","667","Брат");
    }
    public static Courier getNoLogin(){
        return Courier.builder().password("123").firstName("Вася").build();
    }
    public static Courier getNoPassword(){
        return Courier.builder().login("Vasya").firstName("Вася").build();
    }
    public static Courier getNoName(){
        return Courier.builder().login("Vasya111").password("123").build();
    }
}
