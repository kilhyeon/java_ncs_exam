package java_ncs_exam.ui.exception;

@SuppressWarnings("serial")
public class EmptyTfException extends RuntimeException {
	public EmptyTfException() {
		super("������ �����մϴ�.");
	}

	public EmptyTfException(String message) {
		super(message);
	}

	public EmptyTfException(Throwable cause) {
		super("������ �����մϴ�.", cause);
	}
}
