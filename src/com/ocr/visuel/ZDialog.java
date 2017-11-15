package com.ocr.visuel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;


import javax.swing.JButton;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import javax.swing.JTextField;

public class ZDialog extends JDialog {


	private static final long serialVersionUID = -7582641496096117258L;
	private ZDialogInfo zInfo = new ZDialogInfo();
	private boolean sendData;
	private JLabel nomLabel;

	private JTextField nom;

	public ZDialog(JFrame parent, String title, boolean modal){
		super(parent, title, modal);
		this.setSize(550, 270);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
		this.initComponent();
	}

	public ZDialogInfo showZDialog(){
		this.sendData = false;
		this.setVisible(true);      
		return this.zInfo;      
	}

	private void initComponent(){
		/*Icône
    icon = new JLabel(new ImageIcon("images/icone.jpg"));
    JPanel panIcon = new JPanel();
    panIcon.setBackground(Color.white);
    panIcon.setLayout(new BorderLayout());
    panIcon.add(icon);
		 */
		//Le nom
		JPanel panNom = new JPanel();
		panNom.setBackground(Color.white);
		panNom.setPreferredSize(new Dimension(220, 60));
		nom = new JTextField();
		nom.setPreferredSize(new Dimension(100, 25));
		panNom.setBorder(BorderFactory.createTitledBorder("Nom du personnage"));
		nomLabel = new JLabel("Saisir un nom :");
		panNom.add(nomLabel);
		panNom.add(nom);



		JPanel content = new JPanel();
		content.setBackground(Color.white);
		content.add(panNom);

		JPanel control = new JPanel();
		JButton okBouton = new JButton("OK");

		okBouton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {        
				zInfo = new ZDialogInfo(nom.getText());
				setVisible(false);
			}
		});

		JButton cancelBouton = new JButton("Annuler");
		cancelBouton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
			}      
		});

		control.add(okBouton);
		control.add(cancelBouton);

		// this.getContentPane().add(panIcon, BorderLayout.WEST);
		this.getContentPane().add(content, BorderLayout.CENTER);
		this.getContentPane().add(control, BorderLayout.SOUTH);
	}  
}