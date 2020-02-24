import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class testMultiplication {

//	1. 이렇게 하면 amount가 계산할 때 마다 값이 변함...
//	@Test
//	public void testMultiplicationtest() {
//		Dollar five = new Dollar(5);
//		System.out.println(five.amount);
//		five.times(2);
//		System.out.println(five.amount);
//		assertEquals(10, five.amount);
//		five.times(3);
//		assertEquals(15, five.amount);
//	}
//	2. product라는 새로운 객체를 생성해서 dollar 5를 지키는 방법으로 해보자.
	@Test
	public void testMultiplicationtest() {
		Dollar five = new Dollar(5);
		System.out.println(five.amount);
//		3. product라는 변수를 생성하려면 times의 return값을 설정해야 한다.(4.는 Dollar.java)
		Dollar product = five.times(2);
		System.out.println(five.amount);
		assertEquals(10, product.amount);
		product = five.times(3);
		assertEquals(15, product.amount);
	}

}
