package mockito;

public class Validator {

	public void validate(Email email) {
		if (email.getAddressee() == null) {
			throw new IllegalArgumentException();
		}
	}

}