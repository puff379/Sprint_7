import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class Order {
    String firstName;
    String lastName;
    String adress;
    String station;
    String phone;
    int rentTime;
    String deliveryDate;
    String comment;
    String colour;

}
