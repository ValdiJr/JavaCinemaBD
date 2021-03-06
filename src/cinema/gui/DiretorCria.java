package cinema.gui;


import cinema.controllers.*;

import javax.swing.JOptionPane;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.ImageIcon;

@SuppressWarnings("serial")
public class DiretorCria {

	private JTextField codigoField;
	private JTextField nomeField;
	private JTextField nacionalidadeField;
	

	public DiretorCria() {
		setLayout(null);
		
		JLabel lblCadastrarDiretor = new JLabel("Cadastrar Diretor");
		lblCadastrarDiretor.setFont(new Font("Arial", Font.BOLD, 18));
		lblCadastrarDiretor.setBounds(338, 64, 152, 27);
		add(lblCadastrarDiretor);
		
		JLabel label = new JLabel("Codigo");
		label.setBounds(253, 105, 46, 14);
		add(label);
		
		codigoField = new JTextField();
		codigoField.setColumns(10);
		codigoField.setBounds(338, 105, 46, 17);
		add(codigoField);
		
		nomeField = new JTextField();
		nomeField.setColumns(10);
		nomeField.setBounds(338, 129, 266, 20);
		add(nomeField);
		
		nacionalidadeField = new JTextField();
		nacionalidadeField.setColumns(10);
		nacionalidadeField.setBounds(338, 154, 97, 20);
		add(nacionalidadeField);
		
		JLabel label_1 = new JLabel("Nacionalidade");
		label_1.setBounds(253, 157, 87, 14);
		add(label_1);
		
		JLabel label_2 = new JLabel("Nome");
		label_2.setBounds(253, 132, 46, 14);
		add(label_2);
		
		JButton btnCriar = new JButton("Cadastrar");
		btnCriar.setIcon(new ImageIcon("img/register.png"));
		btnCriar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DiretorController.create(codigoField.getText(), nomeField.getText(), nacionalidadeField.getText());
				JOptionPane.showMessageDialog(null, "Diretor cadastrado com sucesso.", "Confirmação", JOptionPane.INFORMATION_MESSAGE);
			}
		});
		btnCriar.setBounds(338, 185, 97, 23);
		add(btnCriar);
		btnCriar.setBorder(new RoundedBorder(5));
		
		
		
	}

}
