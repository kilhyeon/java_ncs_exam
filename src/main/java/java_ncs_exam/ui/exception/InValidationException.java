package java_ncs_exam.ui.exception;

@SuppressWarnings("serial")
public class InValidationException extends RuntimeException {

	public InValidationException() {
		super("공백이 존재합니다.");
	}

	public InValidationException(String message, Throwable cause) {
		super(message, cause);
	}

	public InValidationException(String message) {
		super(message);
	}

	public InValidationException(Throwable cause) {
		super("공백이 존재합니다.", cause);
	}

}
