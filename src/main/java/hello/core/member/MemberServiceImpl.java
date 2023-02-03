package hello.core.member;

public class MemberServiceImpl implements MemberService {

    // 가입하고 회원을 조회하기 위해서는 MemberRepository가 필요
    // 문제? => MemberRepository는 인터페이스를 의존, 그러나 new MemoryMemberRepository(); 는 구현체를 의존. 추상화/구체화 모두 의존하여 DIP 위반.
    private final MemberRepository memberRepository = new MemoryMemberRepository();

    @Override
    public void join(Member member) {
        memberRepository.save(member);
    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }
}
