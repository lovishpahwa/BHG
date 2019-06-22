package tw;

public class PlatinumHotel implements Hotel {

	private Player owner;

	@Override
	public int getRent() {
		return 300;
	}

	@Override
	public int getValue() {
		return 500;
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
		}else if(!getOwner().getName().equalsIgnoreCase(player.getName())) {
			this.owner.addMoney(getRent());
			player.deductMoney(getRent());
		}
	}

}
