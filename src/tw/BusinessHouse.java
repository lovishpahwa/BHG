package tw;

import java.util.ArrayList;

public class BusinessHouse {

	static char[] cellsInput = { 'J', 'H', 'L', 'H', 'E', 'L', 'H', 'L', 'H', 'J' };
	static int[] diceOutputs = { 2, 2, 1, 4, 4, 2, 4, 4, 2, 2, 2, 1, 4, 4, 2, 4, 4, 2, 2, 2, 1 };

	static ArrayList<Cell> cells = new ArrayList<>();
	static ArrayList<Player> players = new ArrayList<>();

	public static void main(String[] args) {

		Bank centralBank = new Bank();
		players.add(new Player("John")); // player 1
		players.add(new Player("David")); // player 2
		players.add(new Player("Brad")); // player 3

		cells.add(new EmptyCell()); // starting point at 0 index
		for (char c : cellsInput) {
			switch (c) {
			case 'J':
				cells.add(new JailCell());
			case 'H':
				cells.add(new SilverHotel());
			case 'L':
				cells.add(new LotteryCell());
			case 'E':
				cells.add(new EmptyCell());
			}
		}

		for (int diceValue : diceOutputs) {
			for (Player player : players) {

				int currentCellIndex = player.getCellPosition();
				int newCellIndex = 0;
				player.setCellPosition(currentCellIndex + diceValue);
				int q = player.getCellPosition() / 10;
				if (q > 0) {
					newCellIndex = player.getCellPosition() - (10 * q);
				} else {
					newCellIndex = player.getCellPosition();
				}

				Cell cell = cells.get(newCellIndex);
				cell.operation(player, centralBank);
				if (player.isHotelUpgraded()) {
					cells.set(newCellIndex, player.getHotel());
					player.setHotelUpgraded(false);
				}
			}
		}

		for (Player player : players) {
			System.out.println(player.getName() + " has total money " + player.getBalance() + " and assets of amount "
					+ player.getAssetAmount());
		}
		System.out.println("Balance at bank is " + centralBank.getBalance());

	}

}
