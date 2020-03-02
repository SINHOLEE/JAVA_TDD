class Sum implements Expression{

	Expression augend;
	Expression addend;
	
	public Sum(Expression augend, Expression addend) {
		this.augend = augend;
		this.addend = addend;
				
	}
	
	public Expression plus(Expression addend) {
		return new Sum(this, addend);
	}

	
	public Money reduce(Bank bank, String to) {
//		1. 아예 augend, addend의 객체타입을 Expression으로 바꾸는 방법.
		int amount = augend.reduce(bank, to).amount 
				+ addend.reduce(bank, to).amount;

//		2. 새로운 객체를 만들어서, 객체 타입을 변환하는 방법		
//		Expression a = (Expression) augend;
//		Expression b = (Expression) addend;
//		int amount = a.reduce(bank, to).amount 
//				+ b.reduce(bank, to).amount;
		
//		3. money 객체를 그대로 사용하는 방법
//		int amount = augend.amount + addend.amount;
		return new Money(amount, to);
	}
	
	public Expression times(int multiplier) {
		return new Sum(augend.times(multiplier), addend.times(multiplier));
	}
	
	public String toString() {
		return "(augend= " + augend + "), (addend= " + addend + ")";
	}

}
