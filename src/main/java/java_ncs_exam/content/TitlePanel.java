package java_ncs_exam.content;

import java.awt.GridLayout;
import java.util.regex.Pattern;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;

import java_ncs_exam.dto.Title;
import java_ncs_exam.ui.exception.EmptyTfException;
import java_ncs_exam.ui.exception.InvalidCheckException;

@SuppressWarnings("serial")
public class TitlePanel extends AbstractContentPanel<Title> {
	private JTextField tfNo;
	private JTextField tfName;

	public TitlePanel() {
		initialize();
	}

	private void initialize() {
		setBorder(new TitledBorder(null, "Á÷Ã¥Á¤º¸", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		setLayout(new GridLayout(0, 2, 10, 0));

		JLabel lblNo = new JLabel("Á÷Ã¥¹øÈ£");
		lblNo.setHorizontalAlignment(SwingConstants.RIGHT);
		add(lblNo);

		tfNo = new JTextField();
		add(tfNo);
		tfNo.setColumns(10);

		JLabel lblName = new JLabel("ÀèÃ¥¸í");
		lblName.setHorizontalAlignment(SwingConstants.RIGHT);
		add(lblName);

		tfName = new JTextField();
		add(tfName);
		tfName.setColumns(10);
	}

	@Override
	public void setItem(Title item) {
		tfNo.setText(String.valueOf(item.gettNo()));
		tfName.setText(item.gettName());
		tfNo.setEditable(false);
	}

	@Override
	public Title getItem() {
		int tNo = Integer.parseInt(tfNo.getText().trim());
		String tName = tfName.getText().trim();
		return new Title(tNo, tName);
	}

	@Override
	public void validChek() {
		if (tfNo.getText().contentEquals("") || tfName.getText().equals("")) {
			throw new EmptyTfException();
		}
	}

	public void checktNo() {
		if(!((Integer.parseInt(tfNo.getText()) > 0)) && (Integer.parseInt(tfNo.getText()) < 1000)) {
			throw new InvalidCheckException();
		}
	}
	
	public void checkType() {
		if(!(Pattern.matches("^[0~9]*$", tfNo.getText()) || Pattern.matches("^[°¡-ÆR]*$", tfName.getText()))) {
			throw new InvalidCheckException();
		}
	}
	
	@Override
	public void clearTf() {
		tfNo.setText("");
		tfName.setText("");

		if (!tfNo.isEditable()) {
			tfNo.setEditable(true);
		}
	}
}
