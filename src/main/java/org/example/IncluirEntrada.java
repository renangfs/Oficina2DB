package org.example;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class IncluirEntrada extends Login{
    Login login;
    JPanel painelIncluirEntrada;

    JTextField campoIDFornecedor;
    JTextField campoNomeProduto;
    JTextField campoQuantidade;
    JTextField campoValor;
    JTextField campoIdProduto;
    JTextField campoData;

    public IncluirEntrada(Login login) {
        this.login = login;

        painelIncluirEntrada = new JPanel(new GridBagLayout());
        painelIncluirEntrada.setBackground(Color.WHITE);


        JLabel textoIDFornecedor = new JLabel("ID do fornecedor:");
        textoIDFornecedor.setForeground(new Color(118, 118, 118));
        textoIDFornecedor.setFont(new Font("Roboto", Font.BOLD, 12));
        campoIDFornecedor = new JTextField();
        campoIDFornecedor.setPreferredSize(new Dimension(200, 25));

        JLabel textoNomeProduto = new JLabel("Nome do produto:");
        textoNomeProduto.setForeground(new Color(118, 118, 118));
        textoNomeProduto.setFont(new Font("Roboto", Font.BOLD, 12));
        campoNomeProduto = new JTextField();
        campoNomeProduto.setPreferredSize(new Dimension(200, 25));

        JLabel textoQuantidade = new JLabel("Quantidade do produto:");
        textoQuantidade.setForeground(new Color(118, 118, 118));
        textoQuantidade.setFont(new Font("Roboto", Font.BOLD, 12));
        campoQuantidade = new JTextField();
        campoQuantidade.setPreferredSize(new Dimension(200, 25));

        JLabel textoValor = new JLabel("Valor:");
        textoValor.setForeground(new Color(118, 118, 118));
        textoValor.setFont(new Font("Roboto", Font.BOLD, 12));
        campoValor = new JTextField();
        campoValor.setPreferredSize(new Dimension(200, 25));

        JLabel textoIdProduto = new JLabel("Código do produto:");
        textoIdProduto.setForeground(new Color(118, 118, 118));
        textoIdProduto.setFont(new Font("Roboto", Font.BOLD, 12));
        campoIdProduto = new JTextField();
        campoIdProduto.setPreferredSize(new Dimension(200, 25));

        JLabel textoData = new JLabel("Data do produto:");
        textoData.setForeground(new Color(118, 118, 118));
        textoData.setFont(new Font("Roboto", Font.BOLD, 12));
        campoData = new JTextField();
        campoData.setPreferredSize(new Dimension(200, 25));

        JButton botaoIncluirProduto = new JButton("Incluir Produto");
        botaoIncluirProduto.setPreferredSize(new Dimension(120, 30));
        botaoIncluirProduto.setBorder(new LineBorder(new Color(193, 193, 193)));
        botaoIncluirProduto.setBackground(new Color(255, 255, 255));
        botaoIncluirProduto.setForeground(new Color(200, 200, 200));
        botaoIncluirProduto.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        GridBagConstraints gbc = new GridBagConstraints(); // ajuda na posição dos componentes
        gbc.anchor = GridBagConstraints.FIRST_LINE_START;
        gbc.insets = new Insets(2, 2, 2, 2);
        gbc.gridy = 0;
        gbc.gridx = 0;
        painelIncluirEntrada.add(textoIDFornecedor, gbc);
        gbc.gridy = 1;
        gbc.gridx = 0;
        painelIncluirEntrada.add(campoIDFornecedor, gbc);
        gbc.gridy = 2;
        gbc.gridx = 0;
        painelIncluirEntrada.add(textoNomeProduto, gbc);
        gbc.gridy = 3;
        gbc.gridx = 0;
        painelIncluirEntrada.add(campoNomeProduto, gbc);
        gbc.gridy = 4;
        gbc.gridx = 0;
        painelIncluirEntrada.add(textoQuantidade, gbc);
        gbc.gridy = 5;
        gbc.gridx = 0;
        painelIncluirEntrada.add(campoQuantidade, gbc);
        gbc.gridy = 6;
        gbc.gridx = 0;
        painelIncluirEntrada.add(textoValor, gbc);
        gbc.gridy = 7;
        gbc.gridx = 0;
        painelIncluirEntrada.add(campoValor, gbc);
        gbc.insets = new Insets(20, 80, 2, 2);
        gbc.gridy = 8;
        gbc.gridx = 0;
        painelIncluirEntrada.add(botaoIncluirProduto, gbc);

        add(painelIncluirEntrada);
        botaoIncluirProduto.addActionListener(this::IncluirProduto);
    }

    private void IncluirProduto(ActionEvent actionEvent) {
        System.out.println("Produto Incluido");
        try (Connection connection = ConnectionFactory.recuperarConexao()) {
            String sql = "INSERT INTO PRODUTO (IDFORNECEDOR, NOME_PRODUTO, PRECO, QTD) VALUES (?,?,?,?);";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, Integer.parseInt(campoIDFornecedor.getText())); // IDFORNECEDOR é um inteiro
            statement.setString(2, campoNomeProduto.getText());
            statement.setDouble(3, Double.parseDouble(campoValor.getText())); // PRECO é um double
            statement.setInt(4, Integer.parseInt(campoQuantidade.getText())); // QTD é um inteiro
            int rowsAffected = statement.executeUpdate(); // Execute a query
            if (rowsAffected > 0) {
                JOptionPane.showMessageDialog(null, "Produto inserido!");
            } else {
                JOptionPane.showMessageDialog(null, "Erro ao inserir o produto.");
            }
        } catch (SQLException | NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao cadastrar produto: " + ex.getMessage());
        }
    }
    public JPanel getPainelIncluirEntrada() {
        return painelIncluirEntrada;
    }
}
