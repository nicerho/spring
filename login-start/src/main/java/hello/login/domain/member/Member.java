package hello.login.domain.member;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class Member {
    private long id;
    @NotEmpty
    private String loginId;
    @NotEmpty
    private String name;
    private String password;
}
