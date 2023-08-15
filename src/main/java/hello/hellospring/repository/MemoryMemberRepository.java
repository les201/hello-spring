package hello.hellospring.repository;

import hello.hellospring.domain.Member;

import java.util.*;

public class MemoryMemberRepository implements MemberRepository{

    private static Map<Long, Member> store = new HashMap<>(); //저장할 메모리
    private static long sequence = 0L; //키값 생성

    @Override
    public Member save(Member member) { // domain패키지>Member 클래스에서 name만 넘어온 상태
        member.setId(++sequence); //시스템에서 세팅
        store.put(member.getId(), member); //store에 저장 (map에 저장이 되어있음)
        return member; //저장된 결과 반환
    }

    @Override
    public Optional<Member> findId(Long id) {
        return Optional.ofNullable(store.get(id));// null이 나올 수 있으면 Optional.ofNullable로 감쌈
    }

    @Override
    public Optional<Member> findName(String name) {
        return store.values().stream() //람다: 루프로 돌리는 것
                .filter(member -> member.getName().equals(name)) //파라미터로 넘어온 name이랑 같은지 확인
                .findAny();//하나 찾아주면 바로 반환, 없으면 optional에 반환

    }

    @Override
    public List<Member> findAll() {
        return new ArrayList<>(store.values());// member들 쭉 반환
    }
}
