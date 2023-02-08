package hello.core.order;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService{

    // 주문을 가공하기 위해서 MemberRepository, DiscountPolicy 필요
    private final MemberRepository memberRepository = new MemoryMemberRepository();
//    private final DiscountPolicy discountPolicy = new FixDiscountPolicy();
    // 추상화 뿐만 아니라 구체화 또한 의존하고 있기 때문에 DIP 위반
    // 방침 변경으로 인한 정률법 적용 -> OrderServiceImpl의 코드를 변경했으므로 OCP를 위반하는 문제 발생
//    private final DiscountPolicy discountPolicy = new RateDiscountPolicy();
    // DIP를 위반하지 않도록 인터페이스에만 의존하도록 의존관계를 변경

    // private final DiscountPolicy discountPolicy;

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {

        // OrderService는 discount에 관여하지 않고 discountPolicy 가 알아서 하도록 설계되어있음. 단일책임원칙을 잘 지킴. (좋은 설계)
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }
}
