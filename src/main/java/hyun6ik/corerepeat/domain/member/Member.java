package hyun6ik.corerepeat.domain.member;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Member {

    private Long id;
    private String name;
    private Grade Grade;

    public enum Grade{
        BASIC,
        VIP
    }

    public Member(Long id, String name, Member.Grade grade) {
        this.id = id;
        this.name = name;
        Grade = grade;
    }

    public static Member of(Long id, String name, Member.Grade grade) {
        return new Member(id, name, grade);
    }
}
