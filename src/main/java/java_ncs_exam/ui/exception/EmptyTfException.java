package java_ncs_exam.ui.exception;

@SuppressWarnings("serial")
public class EmptyTfException extends RuntimeException {
	public EmptyTfException() {
		super("공백이 존재합니다.");
	}

	public EmptyTfException(String message) {
		super(message);
	}

	public EmptyTfException(Throwable cause) {
		super("공백이 존재합니다.", cause);
	}
}
