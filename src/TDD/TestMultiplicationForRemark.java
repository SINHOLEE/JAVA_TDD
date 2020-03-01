


import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.sun.org.apache.bcel.internal.generic.NEW;

class TestMultiplicationForRemark {

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
	public void testDollarMultiplication() {
		Money five = Money.dollar(5);
//		System.out.println(five.amount);
//		3. product라는 변수를 생성하려면 times의 return값을 설정해야 한다.(4.는 Dollar.java)
//		Dollar product = five.times(2);
//		System.out.println(five.amount);

//		14. 지금까지의 비교방식은 인스턴스에 할당된 변수와 직접 비교했었다. 하지만 이제는 인스턴스간의 비교를 위해 주석처리하자.
//		assertEquals(10, product.amount);
//		product = five.times(3);
//		assertEquals(15, product.amount);
		
//		15. 이제 우리는 Dollar라는 인스턴스와 product라는 인스턴스를 직접 비교할 수 있게 되었다.
//		16. 이게 중요!!! 이제야 비로소 amount라는 변수를 사용하는 코드는 Dollar자기 자신밖에 없다.
//		        그렇기 때문에 비로소 amount를 private로 선언할 수 있게 된다. 
//		    -> Dollar class로
		
//		32. 우리는 이 두 상황을 비교할 때, new Dollar(10)은 클라이언트 단에 공개하고 싶지 않다. 왜? 왜 숨기고싶지? 이것에 대한 질문을.... Factory method 패턴에서 알 수 잇는가?
//		assertEquals(new Dollar(10), five.times(2));	
		assertEquals(Money.dollar(10), five.times(2));
		assertEquals(Money.dollar(15), five.times(3));
	}
	@Test
//	10. 우리는 five라는 인스턴스는 Dollar five1 = new Dollar(5);와 같다고 판단하고 싶다. 하지만 현재 그러지 못한다.
//	11. 그래서 새로운 인스턴스를 만들 때, 이미 같은 value를 지니고 있는 인스턴스가 있다면, 같은 레퍼런스를 key값으로 가지고 있는 hash table에 매칭한다면?
//		-> Dollar class로
	public void testEquality() {
//		Dollar a = new Dollar(5);
//		Dollar b = new Dollar(5);
//		System.out.println(a);
//		System.out.println(b);
		
//		33. 이제 Dollar나 Franc 인스턴스를 생성하지 않고, Money.화폐로 사용할 것이다... 왜???왜???
		assertTrue(Money.dollar(5).equals(Money.dollar(5)));
		assertFalse(Money.dollar(5).equals(Money.dollar(6)));
		assertTrue(Money.franc(5).equals(Money.franc(5)));
		assertFalse(Money.franc(5).equals(Money.franc(6)));
		assertFalse(Money.dollar(5).equals(Money.franc(5)));
		
		
//		assertTrue(new Dollar(5).equals(new Dollar(5)));
//		assertFalse(new Dollar(5).equals(new Dollar(6)));
//		assertTrue(new Franc(5).equals(new Franc(5)));
//		assertFalse(new Franc(5).equals(new Franc(6)));
//		
////		30. 그렇다면 달러와 프랑을 비교했을 때 달라야 한다. 하지만 진짜일까?
////			같다고 나타난다. 이를 해결해보자.
////			-> Money 클래서에서 같은 클래스의 인스턴스끼리만 비교가능하도록 임시 조작 해보자...(이게 완벽한 해결은 아니다)
//
//		assertFalse(new Franc(5).equals(new Dollar(5)));

	}
	@Test
//	19. 프랑 테스트케이스를 만든 뒤, 컴파일을 할 수 있도록 프랑이라는 클래스를 구현하도록 하자.
//	-> Franc class로
	public void testFancMultiplication() {
//		Franc five = new Franc(5);
//		assertEquals(new Franc(10), five.times(2));	
//		assertEquals(new Franc(15), five.times(3));
		
//		34. 프랑 역시 추상 클래스인 money를 직접적으로 이용하는 방식으로 데스트 코드로 사용해보자.
		Money fiveMoney = Money.franc(5);
		assertEquals(Money.franc(10), fiveMoney.times(2));
		assertEquals(Money.franc(15), fiveMoney.times(3));
	}
//	35. 화폐개념을 추가해 보자. (flyweight factories 패턴을 쓸 수도 있지만 일단 스트링으로 구현해 본다.)
	@Test
	public void testCurrency() {
		assertEquals("USD", Money.dollar(1).currency());
		assertEquals("CHF", Money.franc(1).currency());
	}

}
