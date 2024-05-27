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

public class Saida extends Login {
    Login login;
    JButton botaoVoltar;

    JPanel painelSuperiorSaida;
    JPanel painelTabelaSaida;

    JLabel textoRegistroSaida;
    JTable table;

    public Saida(Login login) {
        this.login = login;

        // Criando modelo de tabela com colunas de ID, Nome do Produto, Nome do Funcionário, Valor, Quantidade, Valor Total e Data da Saída
        String[] colunas = {"Código da saída", "Nome Produto", "Nome Funcionario", "Valor", "Quantidade", "Valor Total", "Data da saída"};
        DefaultTableModel model = new DefaultTableModel(colunas, 0);

        try (Connection connection = ConnectionFactory.recuperarConexao()) {
            String sql = "SELECT " +
                    "    S.IDSAIDA, " +
                    "    P.NOME_PRODUTO, " +
                    "    F.NOME AS NOME_FUNCIONARIO, " +
                    "    ROUND(S.VALOR,2) AS VALOR, " +
                    "    S.QTDSAIDA, " +
                    "    ROUND((S.VALOR * S.QTDSAIDA),2) AS TOTAL_DA_SAIDA, " +
                    "    S.DATASAIDA " +
                    "FROM " +
                    "    SAIDA S " +
                    "JOIN " +
                    "    PRODUTO P ON S.IDPRODUTO = P.IDPRODUTO " +
                    "JOIN " +
                    "    FUNCIONARIO F ON S.IDFUNCIONARIO = F.IDFUNCIONARIO;";

            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                try (ResultSet resultSet = statement.executeQuery()) {
                    while (resultSet.next()) {
                        String idSaida = resultSet.getString("IDSAIDA");
                        String nomeProduto = resultSet.getString("NOME_PRODUTO");
                        String nomeFuncionario = resultSet.getString("NOME_FUNCIONARIO");
                        String valor = resultSet.getString("VALOR");
                        String quantidade = resultSet.getString("QTDSAIDA");
                        String valorTotal = resultSet.getString("TOTAL_DA_SAIDA");
                        String dataSaida = resultSet.getString("DATASAIDA");

                        // Criar uma linha de dados
                        Object[] linha = {idSaida, nomeProduto, nomeFuncionario, valor, quantidade, valorTotal, dataSaida};
                        // Adicionar a linha ao modelo de tabela
                        model.addRow(linha);

                        System.out.println("Código saída: " + idSaida + ", Nome produto: " + nomeProduto + ", Nome Funcionário: " + nomeFuncionario + ", valor: " + valor + ", Quantidade: " + quantidade + ", valor total: " + valorTotal + ", Data saída: " + dataSaida);
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
        scrollPane.setPreferredSize(new Dimension(1000, 450));

        // Adicionando o painel de rolagem à janela
        painelTabelaSaida = new JPanel(new GridBagLayout());
        painelTabelaSaida.setBackground(Color.white);

        painelSuperiorSaida = new JPanel(new GridBagLayout());
        painelSuperiorSaida.setBackground(Color.WHITE);

        textoRegistroSaida = new JLabel("Registro de saídas");
        textoRegistroSaida.setForeground(new Color(0, 0, 0));
        textoRegistroSaida.setFont(new Font("Roboto", Font.BOLD, 30));


        botaoVoltar = new JButton("<html><u>Voltar</u></html>");
        botaoVoltar.setPreferredSize(new Dimension(40, 30));
        botaoVoltar.setBorder(new LineBorder(new Color(250, 255, 255)));
        botaoVoltar.setBackground(new Color(255, 255, 255));
        botaoVoltar.setForeground(new Color(180, 180, 180));
        botaoVoltar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridy = 0;
        gbc.gridx = 0;
        gbc.insets = new Insets(5, 5, 20, 5);
        gbc.anchor = GridBagConstraints.LAST_LINE_START;
        painelSuperiorSaida.add(botaoVoltar, gbc);
        gbc.gridy = 0;
        gbc.gridx = 1;
        gbc.insets = new Insets(5, 300, 20, 5);
        painelSuperiorSaida.add(textoRegistroSaida, gbc);
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.gridy = 3;
        gbc.gridx = 0;
        gbc.gridwidth = 3;
        painelSuperiorSaida.add(scrollPane, gbc);

        add(painelSuperiorSaida);

        botaoVoltar.addActionListener(this::Voltar);

    }

    public JPanel getPainelSuperiorSaida() {
        return painelSuperiorSaida;
    }


    public void Voltar(ActionEvent actionEvent) {
       login.VoltarMenuConsulta();
    }
}

