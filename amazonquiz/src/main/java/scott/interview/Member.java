package scott.interview;

import lombok.Data;

import java.util.List;

@Data
public class Member {
    private String name;
    private String email;
    private List<Member> friends;

    @Override
    public String toString() {
        return  "name='" + name + "' email='" + email + "'";
    }
}
