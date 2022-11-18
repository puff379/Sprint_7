package courier;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Creds {
    String login;
    String password;


    public static Creds from(Courier courier){
        return Creds.builder().login(courier.getLogin()).password(courier.getPassword()).build();
    }
    public static Creds noLogin(Courier courier){
        return Creds.builder().password(courier.getPassword()).build();
    }
    public static Creds noPassword(Courier courier){
        return Creds.builder().login(courier.getLogin()).password("").build();
    }
}
