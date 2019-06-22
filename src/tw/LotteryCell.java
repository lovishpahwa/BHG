package tw;

public class LotteryCell implements Cell {

	private int value = 200;
	
	@Override
	public void operation(Player player, Bank bank) {
		player.addMoney(value);
		bank.deductMoney(value);
	}
}
