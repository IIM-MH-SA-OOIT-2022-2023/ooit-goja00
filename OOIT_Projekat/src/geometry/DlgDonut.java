package geometry;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
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

public class DlgDonut extends JDialog {

	private final JPanel contentPanel = new JPanel();
	protected JTextField textFieldRadius;
	protected JTextField textFieldInnerRadius;
	protected boolean check=false;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DlgDonut dialog = new DlgDonut();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DlgDonut() {
		setBounds(100, 100, 355, 233);
		setModal(true);
		setTitle("Unos dimenzija");
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		GridBagLayout gbl_contentPanel = new GridBagLayout();
		gbl_contentPanel.columnWidths = new int[]{0, 0, 0};
		gbl_contentPanel.rowHeights = new int[]{0, 0, 0};
		gbl_contentPanel.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_contentPanel.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		contentPanel.setLayout(gbl_contentPanel);
		{
			JLabel lblNewLabel = new JLabel("Outer Radius:");
			GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
			gbc_lblNewLabel.anchor = GridBagConstraints.EAST;
			gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
			gbc_lblNewLabel.gridx = 0;
			gbc_lblNewLabel.gridy = 0;
			contentPanel.add(lblNewLabel, gbc_lblNewLabel);
		}
		{
			textFieldRadius = new JTextField();
			GridBagConstraints gbc_textFieldRadius = new GridBagConstraints();
			gbc_textFieldRadius.insets = new Insets(0, 0, 5, 0);
			gbc_textFieldRadius.fill = GridBagConstraints.HORIZONTAL;
			gbc_textFieldRadius.gridx = 1;
			gbc_textFieldRadius.gridy = 0;
			contentPanel.add(textFieldRadius, gbc_textFieldRadius);
			textFieldRadius.setColumns(10);
		}
		{
			JLabel lblNewLabel_1 = new JLabel("Inner radius:");
			GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
			gbc_lblNewLabel_1.anchor = GridBagConstraints.EAST;
			gbc_lblNewLabel_1.insets = new Insets(0, 0, 0, 5);
			gbc_lblNewLabel_1.gridx = 0;
			gbc_lblNewLabel_1.gridy = 1;
			contentPanel.add(lblNewLabel_1, gbc_lblNewLabel_1);
		}
		{
			textFieldInnerRadius = new JTextField();
			GridBagConstraints gbc_textFieldInnerRadius = new GridBagConstraints();
			gbc_textFieldInnerRadius.fill = GridBagConstraints.HORIZONTAL;
			gbc_textFieldInnerRadius.gridx = 1;
			gbc_textFieldInnerRadius.gridy = 1;
			contentPanel.add(textFieldInnerRadius, gbc_textFieldInnerRadius);
			textFieldInnerRadius.setColumns(10);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						
						if(textFieldRadius.getText().isEmpty()|| (textFieldRadius.getText().matches("^[1-9]\\d*$")==false) 
								|| textFieldInnerRadius.getText().isEmpty()|| (textFieldInnerRadius.getText().matches("^[1-9]\\d*$")==false)) 
						{
							JOptionPane.showMessageDialog(null, "Unesite pozitivan broj!", "Pogresan unos", JOptionPane.ERROR_MESSAGE);
						}
						else if(Integer.parseInt(textFieldRadius.getText())<Integer.parseInt(textFieldInnerRadius.getText()))
						{
							JOptionPane.showMessageDialog(null, "Unutrasnji radius mora biti manji od spoljasnjeg!", "Pogresan unos", JOptionPane.ERROR_MESSAGE);
						}
						else {
							check = true;
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

}
