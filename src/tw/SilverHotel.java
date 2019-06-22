package tw;

public class SilverHotel implements Hotel {

	private Player owner;
	
	private int upgradePrice = 100;

	@Override
	public int getRent() {
		return 50;
	}

	@Override
	public int getValue() {
		return 200;
	}

	@Override
	public void setOwner(Player player) {
		this.owner = player;
	}

	@Override
	public Player getOwner() {
		return owner;
	}
	
	@Override
	public void operation(Player player, Bank bank) {
		if(getOwner() == null) {
			setOwner(player);
			player.deductMoney(getValue());
			bank.addMoney(getValue());
			player.setAssetAmount(player.getAssetAmount() + getValue());
			player.setHotel(this);
		}else if(getOwner().getName().equalsIgnoreCase(player.getName())) {
			player.deductMoney(upgradePrice);
			bank.addMoney(upgradePrice);
			player.setAssetAmount(player.getAssetAmount() + upgradePrice);
			player.setHotelUpgraded(true);
		}else {
			this.owner.addMoney(getRent());
			player.deductMoney(getRent());
		}
	}

}
