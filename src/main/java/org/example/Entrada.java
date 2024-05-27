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

public class Entrada extends Login {
    Login login;
    JButton botaoVoltar;

    JPanel painelSuperiorEntrada;
    JPanel painelTabelaEntrada;

    JLabel textoRegistroEntrada;

    JTable table;

    public Entrada(Login login) {
        this.login = login;

        // Criando modelo de tabela com colunas de ID, Nome e Email
        String[] colunas = {"Código da entrada", "Fornecedor", "Nome Funcionário", "Nome Produto", "Quantidade", "Valor", "Valor Total", "Data da entrada"};
        DefaultTableModel model = new DefaultTableModel(colunas, 0);

        try (Connection connection = ConnectionFactory.recuperarConexao()) {
            String sql = "SELECT " +
                    "    E.IDENTRADA," +
                    "    F.RAZAOSOCIAL AS RAZAO_FORNECEDOR," +
                    "    FN.NOME AS NOME_FUNCIONARIO," +
                    "    P.NOME_PRODUTO," +
                    "    E.QTDENTRADA," +
                    "    ROUND(E.PRECOENTRADA, 2) AS PRECO_ENTRADA, " +
                    "    ROUND(E.VALORTOTAL, 2) AS VALOR_TOTAL, " +
                    "    E.DATAENTRADA " +
                    "FROM " +
                    "    ENTRADA E " +
                    "INNER JOIN FORNECEDOR F ON E.IDFORNECEDOR = F.IDFORNECEDOR " +
                    "INNER JOIN FUNCIONARIO FN ON E.IDFUNCIONARIO = FN.IDFUNCIONARIO " +
                    "INNER JOIN PRODUTO P ON E.IDPRODUTO = P.IDPRODUTO;";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                try (ResultSet resultSet = statement.executeQuery()) {
                    while (resultSet.next()) {
                        String idEntrada = resultSet.getString("IDENTRADA");
                        String fornecedor = resultSet.getString("RAZAO_FORNECEDOR");
                        String nomeFuncionario = resultSet.getString("NOME_FUNCIONARIO");
                        String nomeProduto = resultSet.getString("NOME_PRODUTO");
                        String quantidade = resultSet.getString("QTDENTRADA");
                        String valor = resultSet.getString("PRECO_ENTRADA");
                        String valorTotal = resultSet.getString("VALOR_TOTAL");
                        String dataEntrada = resultSet.getString("DATAENTRADA");

                        // Criar uma linha de dados
                        Object[] linha = {idEntrada, fornecedor, nomeFuncionario, nomeProduto, quantidade, valor, valorTotal, dataEntrada};
                        // Adicionar a linha ao modelo de tabela
                        model.addRow(linha);

                        System.out.println("Código entrada: " + idEntrada + ", Fornecedor: " + fornecedor + ", Nome Funcionário: " + nomeFuncionario + ", Nome Produto: " + nomeProduto + ", Quantidade: " + quantidade + ", valor: " + valor + ", Valor total: " + valorTotal + " Data entrada: " + dataEntrada);
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
        painelTabelaEntrada = new JPanel(new GridBagLayout());
        painelTabelaEntrada.setBackground(Color.white);

        painelSuperiorEntrada = new JPanel(new GridBagLayout());
        painelSuperiorEntrada.setBackground(Color.WHITE);

        textoRegistroEntrada = new JLabel("Registro de entradas");
        textoRegistroEntrada.setForeground(new Color(0, 0, 0));
        textoRegistroEntrada.setFont(new Font("Roboto", Font.BOLD, 30));


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
        painelSuperiorEntrada.add(botaoVoltar, gbc);
        gbc.gridy = 0;
        gbc.gridx = 1;
        gbc.insets = new Insets(5, 300, 20, 5);
        painelSuperiorEntrada.add(textoRegistroEntrada, gbc);
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.gridy = 3;
        gbc.gridx = 0;
        gbc.gridwidth = 3;
        painelSuperiorEntrada.add(scrollPane, gbc);

        add(painelSuperiorEntrada);

        botaoVoltar.addActionListener(this::Voltar);

    }

    public JPanel getPainelSuperiorEntrada() {
        return painelSuperiorEntrada;
    }


    public void Voltar(ActionEvent actionEvent) {
       login.VoltarMenuConsulta();
    }
}

