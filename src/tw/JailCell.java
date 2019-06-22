package tw;

public class JailCell implements Cell {

	private int fine = 150;
	
	@Override
	public void operation(Player player, Bank bank) {
		player.deductMoney(fine);
		bank.addMoney(fine);
	}
	
}
