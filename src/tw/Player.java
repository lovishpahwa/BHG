package tw;

public class Player {

	private int balance = 1000;
	private String name;
	private int cellPosition = 0;
	private Hotel hotel;
	private boolean isHotelUpgraded;
	private int assetAmount = 0;

	Player(String name) {
		this.name = name;
	}

	public int getBalance() {
		return this.balance;
	}

	public String getName() {
		return this.name;
	}

	public void addMoney(int amount) {
		this.balance += amount;
	}

	public void deductMoney(int amount) {
		this.balance -= amount;
	}

	public int getCellPosition() {
		return cellPosition;
	}

	public void setCellPosition(int cellPosition) {
		this.cellPosition = cellPosition;
	}

	public Hotel getHotel() {
		return hotel;
	}

	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
	}

	public boolean isHotelUpgraded() {
		return isHotelUpgraded;
	}

	public void setHotelUpgraded(boolean isHotelUpgraded) {
		this.isHotelUpgraded = isHotelUpgraded;
	}

	public int getAssetAmount() {
		return assetAmount;
	}

	public void setAssetAmount(int assetAmount) {
		this.assetAmount = assetAmount;
	}

}
