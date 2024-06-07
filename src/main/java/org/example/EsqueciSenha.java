package org.example;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Objects;

public class EsqueciSenha {
    JButton botaoCancelar;
    JButton botaoAlterarSenha;
    JPanel painelEsqueciSenha;
    Login login;

    JTextField campoChave;
    JTextField campoID;
    JTextField campoNovaSenha;
    JTextField campoConfirmarSenha;

    JLabel textoChave;

    JButton botaoAplicar;

    JTable table;
    public EsqueciSenha(Login login) {
        this.login = login;

        // Criando modelo de tabela com colunas de ID, Nome e Email
        String[] colunas = {"ID", "Login", "Nome"};
        DefaultTableModel model = new DefaultTableModel(colunas, 0);

        try (Connection connection = ConnectionFactory.recuperarConexao()) {
            String sql = "SELECT IDFUNCIONARIO, LOGIN, NOME FROM FUNCIONARIO";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {//Coloca o SQL no terminal do Banco de dados
                try (ResultSet resultSet = statement.executeQuery()) {//executa o SQL e captura o resultado
                    while (resultSet.next()) {//percorre cada tupla do resultado
                        String idFuncionario = resultSet.getString("IDFUNCIONARIO");
                        String nome = resultSet.getString("LOGIN");
                        String email = resultSet.getString("NOME");

                        // Criar uma linha de dados
                        Object[] linha = {idFuncionario, nome, email};
                        // Adicionar a linha ao modelo de tabela
                        model.addRow(linha);

                        System.out.println("ID: " + idFuncionario + ", Nome: " + nome + ", Email: " + email);//executa a saida no terminal
                    }
                }
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao executar consulta: " + ex.getMessage());
        }


        // Criando a tabela com o modelo criado
        table = new JTable(model);
        table.setEnabled(false);//bloqueia a tabela
        table.setVisible(false);//Tabela invisivel

        // Adicionando a tabela a um painel de rolagem para permitir a rolagem caso a tabela seja muito grande
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setPreferredSize(new Dimension(400, 250));

        // Adicionando o painel de rolagem à janela
        painelEsqueciSenha = new JPanel(new GridBagLayout());
        painelEsqueciSenha.setBackground(Color.white);


        textoChave = new JLabel("Chave de atualização de senha:");
        textoChave.setForeground(new Color(118, 118, 118));
        textoChave.setFont(new Font("Roboto", Font.BOLD, 12));
        JLabel textoID = new JLabel("ID:");
        textoID.setForeground(new Color(118, 118, 118));
        textoID.setFont(new Font("Roboto", Font.PLAIN, 12));

        JLabel textoNovaSenha = new JLabel("Nova senha:");
        textoNovaSenha.setForeground(new Color(118, 118, 118));
        textoNovaSenha.setFont(new Font("Roboto", Font.PLAIN, 12));

        JLabel textoConfirmarSenha = new JLabel("Confirme a senha:");
        textoConfirmarSenha.setForeground(new Color(118, 118, 118));
        textoConfirmarSenha.setFont(new Font("Roboto", Font.PLAIN, 12));

        campoChave = new JTextField();
        campoChave.setPreferredSize(new Dimension(250, 25));

        botaoAplicar = new JButton("Aplicar");
        botaoAplicar.setBounds(50, 50, 100, 30); // (x, y, largura, altura)
        botaoAplicar.setBackground(new Color(0, 30, 253));
        botaoAplicar.setForeground(new Color(255, 255, 255));
        botaoAplicar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));


        campoID = new JTextField();
        campoID.setPreferredSize(new Dimension(220, 25));
        campoID.setEnabled(false);


        campoNovaSenha = new JTextField();
        campoNovaSenha.setPreferredSize(new Dimension(220, 25));
        campoNovaSenha.setEnabled(false);


        campoConfirmarSenha = new JTextField();
        campoConfirmarSenha.setPreferredSize(new Dimension(220, 25));
        campoConfirmarSenha.setEnabled(false);

        botaoCancelar = new JButton("Cancelar");
        botaoCancelar.setBounds(50, 50, 100, 30); // (x, y, largura, altura)
        botaoCancelar.setForeground(new Color(118, 118, 118));
        botaoCancelar.setBackground(new Color(255, 255, 255));
        botaoCancelar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        botaoAlterarSenha = new JButton("Alterar senha");
        botaoAlterarSenha.setBounds(50, 50, 100, 30); // (x, y, largura, altura)
        botaoAlterarSenha.setForeground(new Color(230, 230, 230));
        botaoAlterarSenha.setBackground(new Color(255, 255, 255));
        botaoAlterarSenha.setEnabled(false);
        botaoAlterarSenha.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));


        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridy = 0;
        gbc.gridx = 0;

        gbc.gridwidth = 2;

        // y = Baixo  x = Direita
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(0, 140, 5, 235);
        painelEsqueciSenha.add(textoChave, gbc);

        gbc.insets = new Insets(0, 60, 40, 100);
        gbc.gridy = 1;
        painelEsqueciSenha.add(campoChave, gbc);
        gbc.gridx = 1;
        gbc.insets = new Insets(0, 350, 40, 5);
        painelEsqueciSenha.add(botaoAplicar, gbc);

        gbc.insets = new Insets(0, 5, 40, 290);
        gbc.gridy = 2;
        gbc.gridx = 0;
        painelEsqueciSenha.add(scrollPane, gbc);

        gbc.insets = new Insets(0, 430, 3, 5);
        gbc.anchor = GridBagConstraints.FIRST_LINE_START;
        gbc.gridwidth = 2;
        gbc.gridx = 1;
        gbc.gridy = 2;
        painelEsqueciSenha.add(textoID, gbc);
        gbc.gridy = 2;
        gbc.insets = new Insets(20, 430, 10, 5);
        painelEsqueciSenha.add(campoID, gbc);

        gbc.gridwidth = 1;
        gbc.insets = new Insets(60, 430, 3, 5);
        gbc.gridy = 2;
        gbc.gridx = 1;
        painelEsqueciSenha.add(textoNovaSenha, gbc);
        gbc.insets = new Insets(80, 430, 10, 5);
        gbc.gridy = 2;
        gbc.gridx = 1;
        painelEsqueciSenha.add(campoNovaSenha, gbc);
        gbc.insets = new Insets(120, 430, 3, 5);
        gbc.gridy = 2;
        gbc.gridx = 1;
        painelEsqueciSenha.add(textoConfirmarSenha, gbc);
        gbc.insets = new Insets(140, 430, 3, 5);
        gbc.gridy = 2;
        gbc.gridx = 1;
        painelEsqueciSenha.add(campoConfirmarSenha, gbc);

        gbc.insets = new Insets(225, 430, 5, 5);
        gbc.gridy = 2;
        gbc.gridx = 1;
        painelEsqueciSenha.add(botaoCancelar, gbc);
        gbc.insets = new Insets(225, 540, 5, 5);
        painelEsqueciSenha.add(botaoAlterarSenha, gbc);


        botaoAplicar.addActionListener(this::Aplicar);
        botaoCancelar.addActionListener(this::Cancelar);
        botaoAlterarSenha.addActionListener(this::AlterarSenha);
    }

    public JPanel getPainelEsqueciSenha() {
        return painelEsqueciSenha;
    }

    public void Cancelar(ActionEvent e) {
        login.VoltarLogin();
        System.out.println("Cancelar");
    }

    public void Aplicar(ActionEvent e) {
        if (Objects.equals(campoChave.getText(), "123")) {

            botaoAplicar.setForeground(new Color(184, 207, 229));
            botaoAplicar.setBackground(new Color(255, 255, 255));

            botaoAlterarSenha.setBackground(new Color(0, 30, 253));
            botaoAlterarSenha.setForeground(new Color(255, 255, 255));

            botaoAplicar.setEnabled(false);
            campoChave.setEnabled(false);
            botaoAlterarSenha.setEnabled(true);
            campoID.setEnabled(true);

            campoNovaSenha.setEnabled(true);
            campoConfirmarSenha.setEnabled(true);
            table.setVisible(true);//Tabela invisivel

            JOptionPane.showMessageDialog(null, "Chave aplicada com sucesso!");
        } else {
            JOptionPane.showMessageDialog(null, "Chave incorreta", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void AlterarSenha(ActionEvent e) {
        try (Connection connection = ConnectionFactory.recuperarConexao()) {
            String sql = "UPDATE `funcionario` SET `SENHA`=(?) WHERE `IDFUNCIONARIO`=(?);";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, campoConfirmarSenha.getText());
            statement.setString(2, campoID.getText());
            if (Objects.equals(campoNovaSenha.getText(),campoConfirmarSenha.getText())){
                statement.executeUpdate();
                JOptionPane.showMessageDialog(null, "Senha alterada com sucesso!");
                login.VoltarLogin(); // Voltar para a tela de login após cadastrar
            }else{
                JOptionPane.showMessageDialog(null, "Senhas divergentes", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao cadastrar usuário" + ex.getMessage());
        }
    }
}
// SELECT IDFUNCIONARIO,NOME,EMAIL FROM `funcionario` ;
//UPDATE `funcionario` SET `SENHA`='1234567' WHERE `IDFUNCIONARIO`='1';