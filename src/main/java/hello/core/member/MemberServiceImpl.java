package hello.core.member;

public class MemberServiceImpl implements MemberService {

    // 가입하고 회원을 조회하기 위해서는 MemberRepository가 필요
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
