package mieszko.projekt.game;


import mieszko.projekt.game.ItemType;

public class Game {

	private String title;
	private ItemType type;
	private String company;
	private boolean available;
	private float price;

	public Game(String title, ItemType type, String company, float price) {
		super();
		this.title = title;
		this.type = type;
		this.company = company;
		this.available = true; // gra po utworzeniu jest ZAWSZE dostepna
		this.price = price;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public ItemType getType() {
		return type;
	}

	public void setType(ItemType type) {
		this.type = type;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public boolean isAvailable() {
		return available;
	}

	public void setAvailable(boolean available) {
		this.available = available;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public float getPrice() {
		return price;
	}

	@Override
	public String toString() {
		return "Film [tytul=" + title + ", nosnik=" + type + ", company="
				+ company + ", dostepność=" + available + ", cena=" + price
				+ "]";
	}

	

}
