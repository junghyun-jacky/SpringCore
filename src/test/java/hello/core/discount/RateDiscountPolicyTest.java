package hello.core.discount;

import hello.core.member.Grade;
import hello.core.member.Member;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RateDiscountPolicyTest {

    RateDiscountPolicy discountPolicy = new RateDiscountPolicy();

    @Test
    @DisplayName("VIP는 10% 할인이 적용되어야 한다.")    // junit5는 DisplayName을 이용해 한글로 이름을 쓸 수 있음
    void vip_o() {  // vip에 잘 적용이 되아야 함
        // given
        Member member = new Member(1L, "memberVIP", Grade.VIP);
        // when
        int discount = discountPolicy.discount(member, 10000);
        // then
        assertThat(discount).isEqualTo(1000);    // option + Enter: add static import ~~ -> 코드가 간결해지고 static이 import 됨
    }

    @Test
    @DisplayName("VIP가 아니면 할인이 적용되지 않아야 한다.")   // 실패 테스트 매우 중요!
    void vip_x() {
        // given
        Member member = new Member(2L, "memberBASIC", Grade.BASIC);
        // when
        int discount = discountPolicy.discount(member, 10000);
        // then
        assertThat(discount).isEqualTo(0);   // option + Enter: add static import ~~ -> 코드가 간결해지고 static이 import 됨
    }
}