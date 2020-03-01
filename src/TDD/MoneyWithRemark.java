// 23. 머니를 만들어 놓고 일단 달러를 기준으로 바꿔본다.
abstract class MoneyForRemark {
	protected int amount;
	protected String currency;
	
	public MoneyForRemark (int amount, String currency) {
		this.amount = amount;
		this.currency = currency;
	}
	
	abstract Money times(int multiplier);
	
	String currency() {
		return this.currency; 
	}
	
	static DollarWithRemark dollar(int amount) {
		return new DollarWithRemark(amount, "USD");
	}
	
	static FrancWithRemark franc(int amount) {
		return new FrancWithRemark(amount, "CHF");
	}
	
//	28. Dollar에서 수정한 equals 메소드를 붙인다. 또한 Franc에 있는 equals 메소드도 동시에 지운다.
	public boolean equals(Object object) { // public 의 쓰임새 1. 인스턴스에서 쓰고 싶은 메소드는 public 선언 한다.
		Money money = (Money) object;
//		31. amount가 같으면서 class가 같을때만 트루라고 반환하라.
//		32. times 메소드 역시 money에 이식할 수 있을 것 같다. Dollar로 가서 times를 수정해 Money 클래스에 이식해보자.
		return amount == money.amount && getClass().equals(money.getClass());
	}
}
