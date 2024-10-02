import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class atv01 extends JFrame implements ActionListener, ItemListener {
    private JLabel nameLabel, outputLabel, statusLabel;
    private JTextField nameField;
    private JButton submitButton;
    private JCheckBox emailCheckBox;
    private JComboBox<String> statusComboBox;
    private JPanel painel;
    public atv01() {
        setTitle("formulario");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        painel = new JPanel();
        painel.setLayout(new GridLayout(6, 1)); 

        nameLabel = new JLabel("nome:");
        nameField = new JTextField(15);
        submitButton = new JButton("enviar");
        emailCheckBox = new JCheckBox("aceito receber emails");
        statusComboBox = new JComboBox<>(new String[]{"aluno", "professor", "outros"});
        outputLabel = new JLabel("");
        statusLabel = new JLabel("escolha o status:");

        nameField.addActionListener(this);
        submitButton.addActionListener(this);
        statusComboBox.addItemListener(this);
        //
        painel.add(nameLabel);
        painel.add(nameField);
        painel.add(emailCheckBox);
        painel.add(statusLabel);
        painel.add(statusComboBox);
        painel.add(submitButton);
        painel.add(outputLabel);

        add(painel);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == submitButton) {
            String name = nameField.getText();
            boolean isEmailChecked = emailCheckBox.isSelected();
            String status = (String) statusComboBox.getSelectedItem();

            if (name.isEmpty()) {
                outputLabel.setText("o nome não pode estar vazio.");
            } else if (!isEmailChecked) {
                outputLabel.setText("você precisa aceitar o recebimento de emails.");
            } else {
                outputLabel.setText("Boa noite" + name + ", o seu status é: " + status);
            }
        }

        if (e.getSource() == nameField) {
            outputLabel.setText("nome escrito: " + nameField.getText());
        }
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        if (e.getSource() == statusComboBox) {
            String selectedStatus = (String) statusComboBox.getSelectedItem();
            outputLabel.setText("status escolhido: " + selectedStatus);
        }
    }

    public static void main(String[] args) {
        new Atv01_3Bim();
    }
}
