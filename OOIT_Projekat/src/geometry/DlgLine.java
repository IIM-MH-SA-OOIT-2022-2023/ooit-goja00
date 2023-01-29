package geometry;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DlgLine extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textFieldStartX;
	private JTextField textFieldStartY;
	private JTextField textFieldEndX;
	private JTextField textFieldEndY;
	private JTextField textFieldColor;
	Color c;
	protected boolean check;
	
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DlgLine dialog = new DlgLine();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DlgLine() {
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 452, 274);
		setModal(true);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		GridBagLayout gbl_contentPanel = new GridBagLayout();
		gbl_contentPanel.columnWidths = new int[]{55, 72, 342, 0};
		gbl_contentPanel.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0};
		gbl_contentPanel.columnWeights = new double[]{0.0, 1.0, 1.0, Double.MIN_VALUE};
		gbl_contentPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPanel.setLayout(gbl_contentPanel);
		{
			JLabel lblNewLabel = new JLabel("Start X:");
			GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
			gbc_lblNewLabel.anchor = GridBagConstraints.EAST;
			gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
			gbc_lblNewLabel.gridx = 0;
			gbc_lblNewLabel.gridy = 0;
			contentPanel.add(lblNewLabel, gbc_lblNewLabel);
		}
		{
			textFieldStartX = new JTextField();
			GridBagConstraints gbc_textFieldStartX = new GridBagConstraints();
			gbc_textFieldStartX.insets = new Insets(0, 0, 5, 0);
			gbc_textFieldStartX.fill = GridBagConstraints.HORIZONTAL;
			gbc_textFieldStartX.gridx = 2;
			gbc_textFieldStartX.gridy = 0;
			contentPanel.add(textFieldStartX, gbc_textFieldStartX);
			textFieldStartX.setColumns(10);
		}
		{
			JLabel lblNewLabel_1 = new JLabel("Start Y:");
			GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
			gbc_lblNewLabel_1.anchor = GridBagConstraints.EAST;
			gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
			gbc_lblNewLabel_1.gridx = 0;
			gbc_lblNewLabel_1.gridy = 1;
			contentPanel.add(lblNewLabel_1, gbc_lblNewLabel_1);
		}
		{
			textFieldStartY = new JTextField();
			GridBagConstraints gbc_textFieldStartY = new GridBagConstraints();
			gbc_textFieldStartY.insets = new Insets(0, 0, 5, 0);
			gbc_textFieldStartY.fill = GridBagConstraints.HORIZONTAL;
			gbc_textFieldStartY.gridx = 2;
			gbc_textFieldStartY.gridy = 1;
			contentPanel.add(textFieldStartY, gbc_textFieldStartY);
			textFieldStartY.setColumns(10);
		}
		{
			JLabel lblNewLabel_2 = new JLabel("End X:");
			GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
			gbc_lblNewLabel_2.anchor = GridBagConstraints.EAST;
			gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
			gbc_lblNewLabel_2.gridx = 0;
			gbc_lblNewLabel_2.gridy = 2;
			contentPanel.add(lblNewLabel_2, gbc_lblNewLabel_2);
		}
		{
			textFieldEndX = new JTextField();
			GridBagConstraints gbc_textFieldEndX = new GridBagConstraints();
			gbc_textFieldEndX.insets = new Insets(0, 0, 5, 0);
			gbc_textFieldEndX.fill = GridBagConstraints.HORIZONTAL;
			gbc_textFieldEndX.gridx = 2;
			gbc_textFieldEndX.gridy = 2;
			contentPanel.add(textFieldEndX, gbc_textFieldEndX);
			textFieldEndX.setColumns(10);
		}
		{
			JLabel lblNewLabel_3 = new JLabel("End Y:");
			GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
			gbc_lblNewLabel_3.anchor = GridBagConstraints.EAST;
			gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 5);
			gbc_lblNewLabel_3.gridx = 0;
			gbc_lblNewLabel_3.gridy = 3;
			contentPanel.add(lblNewLabel_3, gbc_lblNewLabel_3);
		}
		{
			textFieldEndY = new JTextField();
			GridBagConstraints gbc_textFieldEndY = new GridBagConstraints();
			gbc_textFieldEndY.insets = new Insets(0, 0, 5, 0);
			gbc_textFieldEndY.fill = GridBagConstraints.HORIZONTAL;
			gbc_textFieldEndY.gridx = 2;
			gbc_textFieldEndY.gridy = 3;
			contentPanel.add(textFieldEndY, gbc_textFieldEndY);
			textFieldEndY.setColumns(10);
		}
		{
			JLabel lblNewLabel_4 = new JLabel("Color");
			GridBagConstraints gbc_lblNewLabel_4 = new GridBagConstraints();
			gbc_lblNewLabel_4.anchor = GridBagConstraints.EAST;
			gbc_lblNewLabel_4.insets = new Insets(0, 0, 5, 5);
			gbc_lblNewLabel_4.gridx = 0;
			gbc_lblNewLabel_4.gridy = 4;
			contentPanel.add(lblNewLabel_4, gbc_lblNewLabel_4);
		}
		{
			textFieldColor = new JTextField();
			GridBagConstraints gbc_textFieldColor = new GridBagConstraints();
			gbc_textFieldColor.insets = new Insets(0, 0, 5, 5);
			gbc_textFieldColor.fill = GridBagConstraints.HORIZONTAL;
			gbc_textFieldColor.gridx = 1;
			gbc_textFieldColor.gridy = 4;
			contentPanel.add(textFieldColor, gbc_textFieldColor);
			textFieldColor.setColumns(10);
		}
		{
			JButton btnColor = new JButton("Choose color");
			btnColor.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					c=JColorChooser.showDialog(null, "Choose color",Color.RED);
					textFieldColor.setBackground(c);
				}
			});
			GridBagConstraints gbc_btnColor = new GridBagConstraints();
			gbc_btnColor.insets = new Insets(0, 0, 5, 0);
			gbc_btnColor.gridx = 2;
			gbc_btnColor.gridy = 4;
			contentPanel.add(btnColor, gbc_btnColor);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						
						if(textFieldStartX.getText().isEmpty() || textFieldStartY.getText().isEmpty() ||textFieldEndX.getText().isEmpty() || textFieldEndY.getText().isEmpty() ||
								(textFieldStartX.getText().matches("^[1-9]\\d*$")==false) || (textFieldStartY.getText().matches("^[1-9]\\d*$")==false)||
								(textFieldEndX.getText().matches("^[1-9]\\d*$")==false) || (textFieldEndY.getText().matches("^[1-9]\\d*$")==false))
								
						{
							JOptionPane.showMessageDialog(null, "Unesite pozitivan broj!", "Pogresan unos", JOptionPane.ERROR_MESSAGE);
						}
						else
						{
							check=true;
							dispose();
						}
						
						
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}

	public JTextField getTextFieldStartX() {
		return textFieldStartX;
	}

	public void setTextFieldStartX(JTextField textFieldStartX) {
		this.textFieldStartX = textFieldStartX;
	}

	public JTextField getTextFieldStartY() {
		return textFieldStartY;
	}

	public void setTextFieldStartY(JTextField textFieldStartY) {
		this.textFieldStartY = textFieldStartY;
	}

	public JTextField getTextFieldEndX() {
		return textFieldEndX;
	}

	public void setTextFieldEndX(JTextField textFieldEndX) {
		this.textFieldEndX = textFieldEndX;
	}

	public JTextField getTextFieldEndY() {
		return textFieldEndY;
	}

	public void setTextFieldEndY(JTextField textFieldEndY) {
		this.textFieldEndY = textFieldEndY;
	}

	public JTextField getTextFieldColor() {
		return textFieldColor;
	}

	public void setTextFieldColor(JTextField textFieldColor) {
		this.textFieldColor = textFieldColor;
	}

}
