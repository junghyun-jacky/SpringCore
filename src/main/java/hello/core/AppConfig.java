package hello.core;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.MemberRepository;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.member.MemoryMemberRepository;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;

// 애플리케이션 환경 설정에 대한걸 모두 결정해줌
public class AppConfig {

    /**
     *  [생성자 주입] -> DIP
     * 1. memberService()를 만들어줌
     * 2. MemberServiceImpl 에서 직접 선택하는 부분을 지우고(선언은 지우지 않음), 생성자를 만듬.
     * 3. memberService를 부름 -> 구현체(MemberServiceImpl) 생성 -> 이때 MemoryMemberRepository가 할당됨
     */
    public MemberService memberService() {    // 역할
        return new MemberServiceImpl(memberRepository());
    }

    private static MemberRepository memberRepository() {    // 구현
        return new MemoryMemberRepository();
    }

    public OrderService orderService() {    // 역할
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

    public DiscountPolicy discountPolicy() {    // 구현
//        return new FixDiscountPolicy();
        return new RateDiscountPolicy();    // 정률법으로 할인정책 변경
    }

}
