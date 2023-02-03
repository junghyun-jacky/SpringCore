package hello.core.member;

import java.util.HashMap;
import java.util.Map;

// 실제 DB 확정되기 전까지 테스트용 저장소
// MemoryMemberRepository와 MemberRepository의 패키지를 구분하는게 좋으나 예제이기 때문에 동일한 패키지에서 진행.
public class MemoryMemberRepository implements MemberRepository{

    // 저장소이므로 Map 등이 필요
    // 실무에서는 동시성 문제 때문에 HashMap이 아닌 ConcurrentHashMap을 사용해야 함(예제라서 HashMap으로)
    private static Map<Long, Member> store = new HashMap<>();

    @Override
    public void save(Member member) {
        store.put(member.getId(), member);
    }

    @Override
    public Member findById(Long memberId) {
        return store.get(memberId);
    }
}
