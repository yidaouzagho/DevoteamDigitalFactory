package fr.d2factory.libraryapp.member;

/**
 * The Class Student.
 *
 * @author Kais Belhareth
 */
public class Student extends Member{

	/** The Constant daysBeforeLateStudent. */
	private static final int daysBeforeLateStudent = 30;
	
	/** The Constant bookChargeBeforeLateStudent. */
	private static final float bookChargeBeforeLateStudent = 0.10f;
	
	/** The Constant ThirtydaysBookCharge. */
	private static final float ThirtydaysBookCharge = 3.0f;
	
	/** The Constant bookChargeAfterLateStudent. */
	private static final float bookChargeAfterLateStudent = 0.15f;
	
    /**
     * Instantiates a new student.
     */
    public Student() {
		super();		
	}
    
	/**
	 * Instantiates a new student.
	 *
	 * @param id the id
	 * @param firstName the first name
	 * @param lastName the last name
	 * @param wallet the wallet
	 * @param isLate the is late
	 */
	public Student(String id, String firstName, String lastName, float wallet, boolean isLate) {
		super(id, firstName, lastName, wallet, isLate);	
	}
	
	/**
	 * Instantiates a new student.
	 *
	 * @param id the id
	 * @param firstName the first name
	 * @param lastName the last name
	 */
	public Student(String id, String firstName, String lastName) {
		super(id, firstName, lastName);	
	}

	/* (non-Javadoc)
	 * @see fr.d2factory.libraryapp.member.Member#payBook(int)
	 */
	@Override
	public void payBook(int numberOfDays) {
		float amount = 0;
		if (numberOfDays <= daysBeforeLateStudent) {
			for (int i = 1; i <= numberOfDays; i++) {
				amount += bookChargeBeforeLateStudent;
			}
		} else {
			amount += ThirtydaysBookCharge;
			for (int i = 1; i <= (numberOfDays - daysBeforeLateStudent); i++) {
				amount += bookChargeAfterLateStudent;
			}
		}
		if (this.getWallet() > amount) {
			this.setWallet(this.getWallet() - amount);
		}
	}
}
