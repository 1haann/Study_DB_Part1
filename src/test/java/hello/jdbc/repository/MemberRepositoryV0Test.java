package hello.jdbc.repository;

import hello.jdbc.domain.Member;
import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

@Slf4j
class MemberRepositoryV0Test {

    MemberRepositoryV0 repository = new MemberRepositoryV0();

    @Test
    void crud() throws SQLException {
        //save
        Member member = new Member("memberV5", 10000);
        repository.save(member);

        //findById
        Member findMember = repository.findById(member.getMemberId());
        log.info("findMember={}", findMember);
        assertThat(findMember).isEqualTo(member);
        // NOTE findById 메소드에서 새로운 인스턴스를 생성하여 반환하기에
        //  findMember와 member는 다른 인스턴스이다. 그럼에도 true가 나오는 이유는
        //  @Data 어노테이션이 EqualsAndHashCode를 자동으로 만들어주기 때문이다.
    }
}