


import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.sun.org.apache.bcel.internal.generic.NEW;
import com.sun.org.apache.xml.internal.resolver.helpers.PublicId;

class testMultiplication {

	@Test
	public void testDollarMultiplication() {
		Money five = Money.dollar(5);	
		assertEquals(Money.dollar(10), five.times(2));
		assertEquals(Money.dollar(15), five.times(3));
	}
	
	@Test
	public void testEquality() {
		assertTrue(Money.dollar(5).equals(Money.dollar(5)));
		assertFalse(Money.dollar(5).equals(Money.dollar(6)));
		assertFalse(Money.dollar(5).equals(Money.franc(5)));
	}
	
	@Test
	public void testFancMultiplication() {
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
	
	@Test
	public void testSimpleAddition() {
//		assertEquals(Money.dollar(5).plus(Money.dollar(5)), Money.dollar(10));
		Money five = Money.dollar(5);
		Expression sum = five.plus(five);
		Bank bank = new Bank();
		Money reduced = bank.reduce(sum, "USD");
		assertEquals(Money.dollar(10), reduced);
	}
	
	@Test
	public void testPlusReturnsSum() {
		Money fiveMoney = Money.dollar(5);
		Expression result = fiveMoney.plus(fiveMoney);
		Sum sum = (Sum) result;
		assertEquals(fiveMoney, sum.augend); // 연산 중 첫번째 인수(피가산수)
		assertEquals(fiveMoney, sum.addend); // 연산 중 두번째 인수(가산수)
	}
	
	@Test
	public void testReduceMoney() {
		Money dollar = Money.dollar(1);
		Bank bank = new Bank();
		Money reduced = bank.reduce(Money.dollar(1), "USD");
		assertEquals(dollar, reduced);
	}
	
	@Test
	public void testReduceMoneyDifferentCurrency() {
		Bank bank = new Bank();
		bank.addRate("CHF", "USD", 2);
		Money result = bank.reduce(Money.franc(2), "USD");
		assertEquals(Money.dollar(1), result);
	}
	
	@Test
	public void testArrayEquals() {
		assertArrayEquals(new Object[] {"abc"}, new Object[] {"abc"} );
	}
}
