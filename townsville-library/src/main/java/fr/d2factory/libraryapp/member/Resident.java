package fr.d2factory.libraryapp.member;

/**
 * The Class Resident.
 *
 * @author Kais Belhareth
 */
public class Resident extends Member{

	/** The Constant daysBeforeLateResident. */
	private static final int daysBeforeLateResident = 60;
	
	/** The Constant bookChargeBeforeLateResident. */
	private static final float bookChargeBeforeLateResident = 0.10f;
	
	/** The Constant SixtydaysBookCharge. */
	private static final float SixtydaysBookCharge = 6.0f;
	
	/** The Constant bookChargeAfterLateResident. */
	private static final float bookChargeAfterLateResident = 0.20f;
	
    /**
     * Instantiates a new resident.
     */
    public Resident() {
		super();		
	}
    
	/**
	 * Instantiates a new resident.
	 *
	 * @param id the id
	 * @param firstName the first name
	 * @param lastName the last name
	 * @param wallet the wallet
	 * @param isLate the is late
	 */
	public Resident(String id, String firstName, String lastName, float wallet, boolean isLate) {
		super(id, firstName, lastName, wallet, isLate);	
	}
	
	/**
	 * Instantiates a new resident.
	 *
	 * @param id the id
	 * @param firstName the first name
	 * @param lastName the last name
	 */
	public Resident(String id, String firstName, String lastName) {
		super(id, firstName, lastName);
	}

	/* (non-Javadoc)
	 * @see fr.d2factory.libraryapp.member.Member#payBook(int)
	 */
	@Override
	public void payBook(int numberOfDays) {
		float amount = 0;
		if (numberOfDays <= daysBeforeLateResident) {
			for (int i = 1; i <= numberOfDays; i++) {
				amount += bookChargeBeforeLateResident;
			}
		} else {
				amount = SixtydaysBookCharge;
			for (int i = 1; i <= (numberOfDays - daysBeforeLateResident); i++) {
				amount += bookChargeAfterLateResident;
			}			
		}
		if (this.getWallet() > amount) {
			this.setWallet(this.getWallet() - amount);
		}		
	}
}
