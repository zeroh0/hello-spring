package hello.hellospring.repository;

import hello.hellospring.domain.Member;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {
    Member save(Member member); // 회원 저장
    Optional<Member> findById(Long id); // id로 회원 찾기
    Optional<Member> findByName(String name);
    /* Optional: null 처리하는 방법 중 하나  */
    List<Member> findAll();
}
