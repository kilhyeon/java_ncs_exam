package java_ncs_exam.ui.exception;

@SuppressWarnings("serial")
public class InvalidCheckException extends RuntimeException {

	public InvalidCheckException() {
		super("������ �����մϴ�.");
	}

	public InvalidCheckException(String message) {
		super(message);
	}

	public InvalidCheckException(Throwable cause) {
		super("������ �����մϴ�.", cause);
	}
	
	
}
