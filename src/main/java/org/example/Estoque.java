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

public class Estoque extends Login {
    Login login;
    JButton botaoVoltar;
    JButton botaoIncluirEntrada;
    JButton botaoIncluirSaida;

    JPanel painelSuperiorEstoque;
    JPanel painelTabelaEstoque;

    JLabel textoEstoque;

    JTable table;

    public Estoque(Login login) {
        this.login = login;

        // Criando modelo de tabela com colunas de ID, Nome e Email
        String[] colunas = {"Código produto", "Produto", "Quantidade", "Valor médio", "Valor total", "Status"};
        DefaultTableModel model = new DefaultTableModel(colunas, 0);

        try (Connection connection = ConnectionFactory.recuperarConexao()) {
            String sql = "SELECT " +
                    "    PRODUTO.IDPRODUTO AS 'Código Produto'," +
                    "    PRODUTO.NOME_PRODUTO AS 'Produto'," +
                    "    PRODUTO.QTD AS 'Quantidade'," +
                    "    ROUND(PRODUTO.PRECO, 2) AS 'Valor'," +
                    "    ROUND((PRODUTO.QTD * PRODUTO.PRECO), 2) AS 'Valor Total'" +
                    " FROM " +
                    "    PRODUTO;";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                try (ResultSet resultSet = statement.executeQuery()) {
                    while (resultSet.next()) {
                        String idProduto = resultSet.getString("Código Produto");
                        String nomeProduto = resultSet.getString("Produto");
                        int quantidade = resultSet.getInt("Quantidade");
                        String preco = resultSet.getString("Valor");
                        String valorTotal = resultSet.getString("Valor Total");

                        String status;
                        // Verifica a quantidade e define o status do estoque
                        if (quantidade < 30) {//Estoque Crítico
                            status = "<html><span style='font-size: 30px; color: #DB4437;'>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp &bull;</span></html>";
                        } else if (quantidade >= 30 && quantidade < 80) {//Estoque Moderado
                            status = "<html><span style='font-size: 30px; color: #F4B400;'>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp &bull;</span></html>";
                        } else {//Estoque Cheio
                            status = "<html><span style='font-size: 30px; color: #0F9D58;'>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp &bull;</span></html>";
                        }


                        // Criar uma linha de dados
                        Object[] linha = {idProduto, nomeProduto, quantidade, preco, valorTotal, status};
                        // Adicionar a linha ao modelo de tabela
                        model.addRow(linha);

                        System.out.println("IDPRODUTO: " + idProduto + ", Produto: " + nomeProduto + ", Quantidade: " + quantidade + ", Preço: " + preco + ", Valor Total: " + valorTotal + "Status: " + status);
                    }
                }
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao executar consulta: " + ex.getMessage());
        }

        // Criando a tabela com o modelo criado
        table = new JTable(model);
        table.setEnabled(false);
        table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        table.setVisible(true);

        // Adicionando a tabela a um painel de rolagem para permitir a rolagem caso a tabela seja muito grande
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setPreferredSize(new Dimension(1000, 420));

        // Adicionando o painel de rolagem à janela
        painelTabelaEstoque = new JPanel(new GridBagLayout());
        painelTabelaEstoque.setBackground(Color.white);

        painelSuperiorEstoque = new JPanel(new GridBagLayout());
        painelSuperiorEstoque.setBackground(Color.WHITE);

        textoEstoque = new JLabel("Estoque");
        textoEstoque.setForeground(new Color(0, 0, 0));
        textoEstoque.setFont(new Font("Roboto", Font.BOLD, 30));

        botaoIncluirEntrada = new JButton("Incluir entrada  + ");
        botaoIncluirEntrada.setPreferredSize(new Dimension(120, 30));
        botaoIncluirEntrada.setBorder(new LineBorder(new Color(49, 66, 216)));
        botaoIncluirEntrada.setBackground(new Color(255, 255, 255));
        botaoIncluirEntrada.setForeground(new Color(49, 66, 216));
        botaoIncluirEntrada.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        botaoIncluirSaida = new JButton("Incluir Saída   - ");
        botaoIncluirSaida.setPreferredSize(new Dimension(120, 30));
        botaoIncluirSaida.setBorder(new LineBorder(new Color(49, 66, 216)));
        botaoIncluirSaida.setBackground(new Color(255, 255, 255));
        botaoIncluirSaida.setForeground(new Color(49, 66, 216));
        botaoIncluirSaida.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        botaoVoltar = new JButton("<html><u>Voltar</u></html>");
        botaoVoltar.setPreferredSize(new Dimension(40, 30));
        botaoVoltar.setBorder(new LineBorder(new Color(250, 255, 255)));
        botaoVoltar.setBackground(new Color(255, 255, 255));
        botaoVoltar.setForeground(new Color(180, 180, 180));
        botaoVoltar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridy = 0;
        gbc.gridx = 0;
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.anchor = GridBagConstraints.LAST_LINE_START;
        painelSuperiorEstoque.add(botaoVoltar, gbc);
        gbc.gridy = 1;
        gbc.gridx = 0;
        painelSuperiorEstoque.add(botaoIncluirEntrada, gbc);
        gbc.gridy = 1;
        gbc.gridx = 1;
        painelSuperiorEstoque.add(botaoIncluirSaida, gbc);
        gbc.gridy = 0;
        gbc.gridx = 2;
        gbc.insets = new Insets(5, 200, 5, 5);
        painelSuperiorEstoque.add(textoEstoque, gbc);
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.gridy = 3;
        gbc.gridx = 0;
        gbc.gridwidth = 3;
        painelSuperiorEstoque.add(scrollPane, gbc);

        add(painelSuperiorEstoque);

        botaoVoltar.addActionListener(this::Voltar);
        botaoIncluirEntrada.addActionListener(this::IncluirEntrada);
        botaoIncluirSaida.addActionListener(this::IncluirSaida);
    }

    public JPanel getPainelEstoque() {
        return painelSuperiorEstoque;
    }

    public void IncluirEntrada(ActionEvent e) {
        System.out.println("Clicou em incluir entrada");
        login.IncluirEntrada();
    }

    public void IncluirSaida(ActionEvent e) {
        System.out.println("Clicou em incluir Saida");
        login.IncluirSaida();
    }

    public void Voltar(ActionEvent actionEvent) {
        login.VoltarMenuConsulta();
    }
}
