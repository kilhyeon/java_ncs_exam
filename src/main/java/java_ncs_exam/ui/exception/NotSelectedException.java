package java_ncs_exam.ui.exception;

@SuppressWarnings("serial")
public class NotSelectedException extends RuntimeException {

	public NotSelectedException() {
		super("����� �����ϼ���.");
	}

	public NotSelectedException(Throwable cause) {
		super("����� �����ϼ���.", cause);
	}

}
