package fr.d2factory.libraryapp.book;

/**
 * The Class ISBN.
 */
public class ISBN {
    
    /** The isbn code. */
    private long isbnCode;

    /**
     * Instantiates a new isbn.
     *
     * @param isbnCode the isbn code
     */
    public ISBN(long isbnCode) {
        this.isbnCode = isbnCode;
    }

	/**
	 * Gets the isbn code.
	 *
	 * @return the isbn code
	 */
	public long getIsbnCode() {
		return isbnCode;
	}

	/**
	 * Sets the isbn code.
	 *
	 * @param isbnCode the new isbn code
	 */
	public void setIsbnCode(long isbnCode) {
		this.isbnCode = isbnCode;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "ISBN [isbnCode=" + isbnCode + "]";
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (isbnCode ^ (isbnCode >>> 32));
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ISBN other = (ISBN) obj;
		if (isbnCode != other.isbnCode)
			return false;
		return true;
	}
}
