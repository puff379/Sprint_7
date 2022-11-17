import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Courier {
    String login;
    String password;
    String firstName;
}
