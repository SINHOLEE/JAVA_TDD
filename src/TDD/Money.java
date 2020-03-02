class Money implements Expression {
	protected int amount;
	protected String currency;
	
	public Money (int amount, String currency) {
		this.amount = amount;
		this.currency = currency;
	}
	
	static Money dollar(int amount) {
		return new Money(amount, "USD");
	}
	
	static Money franc(int amount) {
		return new Money(amount, "CHF");
	}
	
	public boolean equals(Object object) { // public 의 쓰임새 1. 인스턴스에서 쓰고 싶은 메소드는 public 선언 한다.
		Money money = (Money) object;
		return amount == money.amount && currency.equals(money.currency);
	}
	
	public Money reduce(Bank bank, String to) {
//		여기서 환전? 환율계산을 해야하지 않나 싶어요.//
		int rate = bank.rate(currency, to);
		return new Money(amount / rate, to);
	}
	
//	public Money plus(Money addedAmount) {
	public Expression plus(Expression addend) {
		return new Sum(this, addend);
	}
	
	public Expression times(int multiplier) {
		return new Money(amount * multiplier, currency); 
	}
	
	public String toString() {
		return amount + " " + currency;
	}

	String currency() {
		return this.currency; 
	}

}
