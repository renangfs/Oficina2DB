package org.example;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public class IncluirEntrada extends Login {
    Login login;
    JPanel painelIncluirEntrada;

    JComboBox<String> campoIDFornecedor;
    JComboBox<String> campoIDProduto;
    JTextField campoQuantidade;
    JTextField campoValor;
    JTextField campoData;
    int campoNomeparaID;

    public IncluirEntrada(Login login) {
        this.login = login;

        painelIncluirEntrada = new JPanel(new GridBagLayout());
        painelIncluirEntrada.setBackground(Color.WHITE);

        JLabel textoIDFornecedor = new JLabel("ID do fornecedor:");
        textoIDFornecedor.setForeground(new Color(118, 118, 118));
        textoIDFornecedor.setFont(new Font("Roboto", Font.BOLD, 12));
        // Cria um Dropdown
        String[] opCampoIDFuncionario = {"1", "2", "3", "4", "5"};
        campoIDFornecedor = new JComboBox<>(opCampoIDFuncionario);
        campoIDFornecedor.setPreferredSize(new Dimension(200, 25));

        JLabel textoNomeProduto = new JLabel("Nome do produto:");
        textoNomeProduto.setForeground(new Color(118, 118, 118));
        textoNomeProduto.setFont(new Font("Roboto", Font.BOLD, 12));
        // Cria um Dropdown
        String[] opCampoIDProduto = {"Produto A", "Produto B", "Produto C", "Produto D", "Produto E"};
        campoIDProduto = new JComboBox<>(opCampoIDProduto);
        campoIDProduto.setPreferredSize(new Dimension(200, 25));

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

        JLabel textoData = new JLabel("Data de entrada:");
        textoData.setForeground(new Color(118, 118, 118));
        textoData.setFont(new Font("Roboto", Font.BOLD, 12));

        // Obter a data atual e formatá-la
        LocalDate today = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String formattedDate = today.format(formatter);

        // Criar um campo de texto e definir a data atual
        campoData = new JTextField(10);
        campoData.setPreferredSize(new Dimension(200, 25));
        campoData.setText(formattedDate);

        JButton botaoIncluirProduto = new JButton("Incluir Produto");
        botaoIncluirProduto.setPreferredSize(new Dimension(120, 30));
        botaoIncluirProduto.setBorder(new LineBorder(new Color(0, 30, 253)));
        botaoIncluirProduto.setBackground(new Color(0, 30, 253));
        botaoIncluirProduto.setForeground(new Color(255, 255, 255));
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
        painelIncluirEntrada.add(campoIDProduto, gbc);
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
        gbc.gridy = 8;
        gbc.gridx = 0;
        painelIncluirEntrada.add(textoData, gbc);
        gbc.gridy = 9;
        gbc.gridx = 0;
        painelIncluirEntrada.add(campoData, gbc);
        gbc.gridy = 10;
        gbc.gridx = 0;
        gbc.insets = new Insets(20, 80, 2, 2);
        painelIncluirEntrada.add(botaoIncluirProduto, gbc);

        add(painelIncluirEntrada);
        botaoIncluirProduto.addActionListener(this::IncluirProduto);
    }

    private void IncluirProduto(ActionEvent actionEvent) {
        System.out.println("Produto Incluido");
        if(Objects.equals(campoIDProduto.getSelectedItem(),"Produto A")){
            campoNomeparaID = 1;
        }if(Objects.equals(campoIDProduto.getSelectedItem(),"Produto B")){
            campoNomeparaID = 2;
        }if(Objects.equals(campoIDProduto.getSelectedItem(),"Produto C")){
            campoNomeparaID = 3;
        }if(Objects.equals(campoIDProduto.getSelectedItem(),"Produto D")){
            campoNomeparaID = 4;
        }if(Objects.equals(campoIDProduto.getSelectedItem(),"Produto E")){
            campoNomeparaID = 5;
        }

        try (Connection connection = ConnectionFactory.recuperarConexao()) {
            // Primeiro PreparedStatement para inserir dados na tabela ENTRADA
            String sqlInserirEntrada = "INSERT INTO ENTRADA (IDFUNCIONARIO, IDFORNECEDOR, IDPRODUTO, DATAENTRADA, VALORTOTAL,PRECOENTRADA,QTDENTRADA) VALUES (?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement statementInserirEntrada = connection.prepareStatement(sqlInserirEntrada);
            System.out.println( login.getidLogado() + " teste ID do Funcionario ");//Chat gpt quando eu tento pegar o idLogado ele da sempre 0 que tem de errado com meu código
            statementInserirEntrada.setInt(1, login.getidLogado()); // IDFORNECEDOR é um inteiro
            statementInserirEntrada.setInt(2, Integer.parseInt((String)campoIDFornecedor.getSelectedItem())); // IDFORNECEDOR é um inteiro
            statementInserirEntrada.setInt(3, campoNomeparaID); // ID produto
            statementInserirEntrada.setString(4, campoData.getText()); // data entrada
            // Calcula o valor total
            double valorTotal = Double.parseDouble(campoValor.getText()) * Double.parseDouble(campoQuantidade.getText());
            statementInserirEntrada.setDouble(5, valorTotal); // VALORTOTAL
            statementInserirEntrada.setDouble(6, Double.parseDouble(campoValor.getText()));
            statementInserirEntrada.setInt(7, Integer.parseInt(campoQuantidade.getText()));
            int linhasAfetadasInserirEntrada = statementInserirEntrada.executeUpdate(); // Executa a primeira instrução SQL

            // Segundo PreparedStatement para atualizar dados na tabela PRODUTO
            String sqlAtualizarProduto = "UPDATE PRODUTO SET QTD = QTD + ?, PRECO = (PRECO * (QTD - ?) + ?) / QTD WHERE IDPRODUTO = ?";
            PreparedStatement statementAtualizarProduto = connection.prepareStatement(sqlAtualizarProduto);
            int quantidade = Integer.parseInt(campoQuantidade.getText());
            statementAtualizarProduto.setInt(1, quantidade); // QTD
            statementAtualizarProduto.setInt(2, quantidade); // QTD again for the subtraction
            statementAtualizarProduto.setDouble(3, valorTotal); // Total value for recalculating average price
            statementAtualizarProduto.setInt(4, campoNomeparaID); // ID produto
            int linhasAfetadasAtualizarProduto = statementAtualizarProduto.executeUpdate(); // Executa a segunda instrução SQL

            // Verifica se ambas as instruções foram executadas com sucesso
            if (linhasAfetadasInserirEntrada > 0 && linhasAfetadasAtualizarProduto > 0) {
                JOptionPane.showMessageDialog(null, "Produto inserido!");
                login.Estoque(); // indo para a classe login...para ir para classe estoque
                campoIDFornecedor.setSelectedIndex(0);
                campoIDProduto.setSelectedIndex(0);
                campoValor.setText("");
                campoQuantidade.setText("");
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
