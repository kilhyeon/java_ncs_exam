package java_ncs_exam.ui.exception;

@SuppressWarnings("serial")
public class InvalidCheckException extends RuntimeException {

	public InvalidCheckException() {
		super("형식이 맞지 않습니다.");
	}

}
