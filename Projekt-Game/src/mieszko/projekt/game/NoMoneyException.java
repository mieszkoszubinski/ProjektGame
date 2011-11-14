package mieszko.projekt.game;

public class NoMoneyException extends Exception {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public NoMoneyException() {
		super("Klient nie ma pieniedzy aby zaplacic za gre");
	}

}
