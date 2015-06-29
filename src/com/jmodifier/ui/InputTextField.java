package com.jmodifier.ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;

/**
 * The input text field.
 * 
 * @author Desmond Jackson
 */
public class InputTextField extends JTextField implements ActionListener {

	/**
	 * The serial uid.
	 */
	private static final long serialVersionUID = 5992157434215397112L;
	
	/**
	 * Creates the input text field.
	 */
	public InputTextField() {
		super();
		addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String separator = "::";
		String text = getText();
		if (text.contains(separator) && text.length() > separator.length())
			((ModifierFrame) getParent().getParent().getParent().getParent()).getConsole().getHandler()
			.handle(text.split(separator)[0], text.substring(text.indexOf(separator))
					.replace(separator, "").split(" "));
		setText(null);
	}

}
