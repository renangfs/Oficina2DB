package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Objects;

public class Cadastro{
    Login login;
    JButton botaoCancelar;
    JButton botaoCadastrar;
    JPanel painelCadastro;

    JTextField campoChave;
    JTextField campoNome;
    JTextField campoCPF;
    JTextField campoTelefone;
    JTextField campoEmail;
    JTextField campoSenha;
    JTextField campoLogin;

    JLabel textoChave;

    JButton botaoAplicar;

    public Cadastro(Login login) {
        this.login = login;
        painelCadastro = new JPanel(new GridBagLayout());
        painelCadastro.setBackground(Color.white);//muda a cor do painel

        textoChave = new JLabel("Chave de cadastro:");
        textoChave.setForeground(new Color(118, 118, 118));
        textoChave.setFont(new Font("Roboto", Font.BOLD, 12));
        JLabel textoNome = new JLabel("Nome:");
        textoNome.setForeground(new Color(170, 170, 170));
        textoNome.setFont(new Font("Roboto", Font.PLAIN, 12));
        JLabel textoCpf = new JLabel("CPF:");
        textoCpf.setForeground(new Color(170, 170, 170));
        textoCpf.setFont(new Font("Roboto", Font.PLAIN, 12));
        JLabel textoTelefone = new JLabel("Telefone:");
        textoTelefone.setForeground(new Color(170, 170, 170));
        textoTelefone.setFont(new Font("Roboto", Font.PLAIN, 12));
        JLabel textoEmail = new JLabel("Email:");
        textoEmail.setForeground(new Color(170, 170, 170));
        textoEmail.setFont(new Font("Roboto", Font.PLAIN, 12));
        JLabel textoLogin = new JLabel("Login:");
        textoLogin.setForeground(new Color(170, 170, 170));
        textoLogin.setFont(new Font("Roboto", Font.PLAIN, 12));
        JLabel textoSenha = new JLabel("Senha:");
        textoSenha.setForeground(new Color(170, 170, 170));
        textoSenha.setFont(new Font("Roboto", Font.PLAIN, 12));


        JLabel textoDadosPessoais = new JLabel("Dados Pessoais");
        textoDadosPessoais.setForeground(new Color(140, 140, 140));
        textoDadosPessoais.setFont(new Font("Roboto", Font.BOLD, 15));
        JLabel textoDadosDeAcesso = new JLabel("Dados de acesso");
        textoDadosDeAcesso.setForeground(new Color(140, 140, 140));
        textoDadosDeAcesso.setFont(new Font("Roboto", Font.BOLD, 15));
        JLabel textoCadastro = new JLabel("Cadastro");
        textoCadastro.setForeground(new Color(50, 50, 50));
        textoCadastro.setFont(new Font("Roboto", Font.BOLD, 25));


        campoChave = new JTextField();
        campoChave.setPreferredSize(new Dimension(250, 25));

        botaoAplicar = new JButton("Aplicar");
        botaoAplicar.setBounds(50, 50, 100, 30); // (x, y, largura, altura)
        botaoAplicar.setBackground(new Color(0, 30, 253));
        botaoAplicar.setForeground(new Color(255, 255, 255));
        botaoAplicar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));


        campoNome = new JTextField();
        campoNome.setPreferredSize(new Dimension(300, 25));
        campoNome.setEnabled(false);

        campoCPF = new JTextField();
        campoCPF.setPreferredSize(new Dimension(200, 25));
        campoCPF.setEnabled(false);

        campoTelefone = new JTextField();
        campoTelefone.setPreferredSize(new Dimension(200, 25));
        campoTelefone.setEnabled(false);

        campoEmail = new JTextField();
        campoEmail.setPreferredSize(new Dimension(300, 25));
        campoEmail.setEnabled(false);

        campoSenha = new JTextField();
        campoSenha.setPreferredSize(new Dimension(200, 25));
        campoSenha.setEnabled(false);

        campoLogin = new JTextField();
        campoLogin.setPreferredSize(new Dimension(200, 25));
        campoLogin.setEnabled(false);

        botaoCancelar = new JButton("Cancelar");
        botaoCancelar.setBounds(50, 50, 100, 30); // (x, y, largura, altura)
        botaoCancelar.setForeground(new Color (118, 118, 118));
        botaoCancelar.setBackground(new Color (255, 255, 255));
        botaoCancelar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        botaoCadastrar = new JButton("Cadastrar");
        botaoCadastrar.setBounds(50, 50, 100, 30); // (x, y, largura, altura)
        botaoCadastrar.setForeground(new Color (230, 230, 230));
        botaoCadastrar.setBackground(new Color (255, 255, 255));
        botaoCadastrar.setEnabled(false);
        botaoCadastrar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));


        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridwidth = 2;
        // y = Baixo  x = Direita

        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(5, 5, 5, 140);
        gbc.gridy = 0;
        gbc.gridx =1;
        painelCadastro.add(textoChave, gbc);
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.gridy = 1;
        painelCadastro.add(campoChave, gbc);
        gbc.gridx = 2;
        gbc.gridy = 1;
        gbc.insets = new Insets(5, 40, 5, 5);
        painelCadastro.add(botaoAplicar, gbc);


        gbc.anchor = GridBagConstraints.FIRST_LINE_START;
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.insets = new Insets(20, 10, 2, 2);
        painelCadastro.add(textoCadastro, gbc);
        gbc.insets = new Insets(10, 10, 2, 2);
        gbc.gridy = 3;
        painelCadastro.add(textoDadosPessoais, gbc);
        gbc.insets = new Insets(2, 10, 2, 2);
        gbc.gridx = 0;
        gbc.gridy = 4;
        painelCadastro.add(textoNome, gbc);
        gbc.gridx = 0;
        gbc.gridy = 5;
        painelCadastro.add(campoNome, gbc);
        gbc.gridx = 2;
        gbc.gridy = 4;
        painelCadastro.add(textoCpf, gbc);
        gbc.gridx = 2;
        gbc.gridy = 5;
        painelCadastro.add(campoCPF, gbc);
        gbc.gridx = 0;
        gbc.gridy = 6;
        painelCadastro.add(textoEmail, gbc);
        gbc.gridx = 0;
        gbc.gridy = 7;
        painelCadastro.add(campoEmail, gbc);
        gbc.gridx = 2;
        gbc.gridy = 6;
        painelCadastro.add(textoTelefone, gbc);
        gbc.gridx = 2;
        gbc.gridy = 7;
        painelCadastro.add(campoTelefone, gbc);

        gbc.gridx = 0;
        gbc.gridy = 8;
        gbc.insets = new Insets(20, 10, 2, 2);
        painelCadastro.add(textoDadosDeAcesso, gbc);
        gbc.insets = new Insets(2, 10, 2, 2);
        gbc.gridx = 0;
        gbc.gridy = 9;
        painelCadastro.add(textoLogin, gbc);
        gbc.gridx = 0;
        gbc.gridy = 10;
        painelCadastro.add(campoLogin, gbc);
        gbc.insets = new Insets(2, 220, 2, 2);
        gbc.gridx = 1;
        gbc.gridy = 9;
        painelCadastro.add(textoSenha, gbc);
        gbc.gridx = 1;
        gbc.gridy = 10;
        painelCadastro.add(campoSenha, gbc);


        gbc.insets = new Insets(20, 330, 2, 2);
        gbc.gridy = 11;
        painelCadastro.add(botaoCancelar, gbc);
        gbc.insets = new Insets(20, 430, 2, 2);
        gbc.gridy = 11;
        painelCadastro.add(botaoCadastrar, gbc);

        botaoAplicar.addActionListener(this::Aplicar);
        botaoCancelar.addActionListener(this::Cancelar);
        botaoCadastrar.addActionListener(this::Cadastrar);
    }

    public JPanel getPainelCadastro() {
        return painelCadastro;
    }


    public void Cancelar(ActionEvent e) {
        login.VoltarLogin();
    }
    public void Aplicar(ActionEvent e) {
        if (Objects.equals(campoChave.getText(), "123")) {

            botaoAplicar.setForeground(new Color (184, 207, 229));
            botaoAplicar.setBackground(new Color (255, 255, 255));

            botaoCadastrar.setBackground(new Color(0, 30, 253));
            botaoCadastrar.setForeground(new Color(255, 255, 255));

            botaoAplicar.setEnabled(false);
            campoChave.setEnabled(false);
            botaoCadastrar.setEnabled(true);
            campoNome.setEnabled(true);
            campoCPF.setEnabled(true);
            campoTelefone.setEnabled(true);
            campoEmail.setEnabled(true);
            campoLogin.setEnabled(true);
            campoSenha.setEnabled(true);

            JOptionPane.showMessageDialog(null, "Chave aplicada com sucesso!");
        }else{
            JOptionPane.showMessageDialog(null, "Chave incorreta", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    public void Cadastrar(ActionEvent e) {
        try (Connection connection = ConnectionFactory.recuperarConexao()) {
            String sql = "INSERT INTO FUNCIONARIO (`NOME`, `CPF`, `EMAIL`, `TELEFONE`, `LOGIN`, `SENHA`) VALUES (?,?,?,?,?,?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, campoNome.getText());
            statement.setString(2, campoCPF.getText());
            statement.setString(3, campoEmail.getText());
            statement.setString(4, campoTelefone.getText());
            statement.setString(5, campoLogin.getText());
            statement.setString(6, campoSenha.getText());
            statement.executeUpdate();
            JOptionPane.showMessageDialog(null, "Funcionário cadastrado com sucesso!");
            login.VoltarLogin(); // Voltar para a tela de login após cadastrar
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao cadastrar usuário: " + ex.getMessage());
        }
    }
}