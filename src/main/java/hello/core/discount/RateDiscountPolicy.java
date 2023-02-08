package hello.core.discount;

import hello.core.member.Grade;
import hello.core.member.Member;

/**
 * 새로운 할인 정책 적용시 문제점: DIP, OCP 를 지킬 수 없음
 * 다양한 방식으로 문제를 해결하면서, 결국 스프링 컨테이너가 왜 탄생하였는지 알 수 있음
 * 마지막으로, 지금까지 만든 자바 코드를 스프링 컨테이너에서 동작하도록 전환할 것
 */
public class RateDiscountPolicy implements DiscountPolicy{

    private int discountPercent = 10;
    @Override
    public int discount(Member member, int price) {
        if(member.getGrade() == Grade.VIP) {
            return price * discountPercent / 100;
        } else {
            return 0;
        }
    }
}
