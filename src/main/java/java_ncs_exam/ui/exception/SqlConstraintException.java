package java_ncs_exam.ui.exception;

@SuppressWarnings("serial")
public class SqlConstraintException extends RuntimeException {

	public SqlConstraintException() {
		super("�����ϴ� ���ڵ尡 �����մϴ�.");
	}

	public SqlConstraintException(String message) {
		super(message);
	}

	public SqlConstraintException(Throwable cause) {
		super("�����ϴ� ���ڵ尡 �����մϴ�.", cause);
	}

	public SqlConstraintException(String message, Throwable cause) {
		super(message, cause);
	}

}
