package hello.hellospring.repository;

import hello.hellospring.domain.Member;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {
    Member save(Member member); //저장소에 저장
    Optional<Member> findId(Long id); //저장소에서 찾아오기
    Optional<Member> findName(String name); //저장소에서 찾아오기
    List<Member> findAll();//저장소에 저장된 모든 리스트 반환


}
