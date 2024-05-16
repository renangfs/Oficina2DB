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
import java.util.Objects;


public class Login extends JFrame {
    JButton botaoEntrar;
    JButton botaoCadastrar;
    JButton botaoEsqueciSenha;

    ImageIcon image = new ImageIcon("C:/Users/renan/OneDrive/Área de Trabalho/Oficina2DB/src/main/java/org/example/logo.png");
    JLabel logo = new JLabel(image);

    JPanel painelLogo;
    JPanel painelLogin;

    JTextField campoLogin;
    JTextField campoSenha;


    public Login() {
        setSize(1200, 800); // largura e altura da janela
        setMinimumSize(new Dimension(1200, 800)); // largura e altura minima da janela
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // configurando o encerramento do programa ao fechar
        setLocationRelativeTo(null); // centraliza a janela

        painelLogo = new JPanel(new GridBagLayout());
        painelLogo.setBackground(Color.white);
        painelLogin = new JPanel(new GridBagLayout());
        painelLogin.setBackground(Color.WHITE);




        JLabel textoLogin = new JLabel("Login:");
        textoLogin.setForeground(new Color(118, 118, 118));
        textoLogin.setFont(new Font("Roboto", Font.BOLD, 12));

        JLabel textoSenha = new JLabel("Senha:");
        textoSenha.setForeground(new Color(118, 118, 118));
        textoSenha.setFont(new Font("Roboto", Font.BOLD, 12));

        campoLogin = new JTextField();
        campoLogin.setPreferredSize(new Dimension(300, 25));
        campoSenha = new JTextField();
        campoSenha.setPreferredSize(new Dimension(300, 25));

        botaoEsqueciSenha = new JButton("<html><u>Esqueci minha senha</u></html>");
        botaoEsqueciSenha.setFont(new Font("Roboto", Font.BOLD, 10));
        botaoEsqueciSenha.setPreferredSize(new Dimension(120, 30));
        botaoEsqueciSenha.setBorder(new LineBorder(new Color(255, 255, 255)));
        botaoEsqueciSenha.setBackground(new Color(255, 255, 255));
        botaoEsqueciSenha.setForeground(new Color(118, 118, 118));
        botaoEsqueciSenha.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        botaoEntrar = new JButton("Entrar");
        botaoEntrar.setPreferredSize(new Dimension(300, 30));
        botaoEntrar.setBorder(new LineBorder(new Color(0, 30, 253)));
        botaoEntrar.setBackground(new Color(0, 30, 253));
        botaoEntrar.setForeground(new Color(255, 255, 255));
        botaoEntrar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));


        botaoCadastrar = new JButton("Cadastre-se");
        botaoCadastrar.setPreferredSize(new Dimension(300, 30));
        botaoCadastrar.setForeground(new Color (118, 118, 118));
        botaoCadastrar.setBackground(new Color (255, 255, 255));
        botaoCadastrar.setBorder(new LineBorder(new Color (170, 170, 170)));
        botaoCadastrar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        GridBagConstraints gbc = new GridBagConstraints(); // ajuda na posição dos componentes
        gbc.gridy = 0;
        gbc.gridx = 0;

        // Adicionando o logotipo ao centro superior do painel principal
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(0, 0, 0, 0);
        painelLogo.add(logo, gbc);

        // Configurações para o painel de login
        gbc.gridy = 1;
        gbc.insets = new Insets(0, 0, 0, 0);
        painelLogo.add(painelLogin, gbc);

        gbc.anchor = GridBagConstraints.LINE_START;
        gbc.insets = new Insets(0, 5, 5, 5);
        painelLogin.add(textoLogin, gbc);

        gbc.gridy = 1;
        gbc.insets = new Insets(65, 5, 20, 5);
        painelLogin.add(campoLogin, gbc);

        gbc.gridy = 2;
        gbc.insets = new Insets(0, 5, 5, 5);
        painelLogin.add(textoSenha, gbc);

        gbc.gridy = 3;
        painelLogin.add(campoSenha, gbc);

        gbc.gridy = 4;
        gbc.insets = new Insets(0, 5, 20, 5);
        gbc.anchor = GridBagConstraints.LAST_LINE_END;
        gbc.fill = GridBagConstraints.VERTICAL;
        painelLogin.add(botaoEsqueciSenha, gbc);

        gbc.insets = new Insets(0, 5, 15, 5);
        gbc.gridy = 5;
        gbc.anchor = GridBagConstraints.CENTER;
        painelLogin.add(botaoEntrar, gbc);

        gbc.gridy = 6;
        painelLogin.add(botaoCadastrar, gbc);

        add(painelLogo);
        botaoEsqueciSenha.addActionListener(this::EsqueciSenha);
        botaoCadastrar.addActionListener(this::Cadastrar);
        botaoEntrar.addActionListener(this::Logar);
    }

    public void voltarLogin() {

        getContentPane().removeAll(); // Remove todos os componentes da janela
        GridBagConstraints gbc = new GridBagConstraints(); // ajuda na posição dos componentes

        add(painelLogo);
        gbc.gridy = 1;
        gbc.insets = new Insets(0, 0, 0, 0);
        painelLogo.add(painelLogin, gbc);
        add(painelLogo);

        revalidate(); // Revalida o layout da janela
        repaint(); // Redesenha a janela
    }

    public void EsqueciSenha(ActionEvent e) {
        System.out.println("EsqueciSenha");
        System.out.println("Cliquei em 'Esqueci minha senha'");
        getContentPane().removeAll(); // Remove todos os componentes da janela
        EsqueciSenha esqueciSenha = new EsqueciSenha(this); // Crie uma instância de EsqueciSenha
        JPanel painelEsqueciSenha = esqueciSenha.getPainelEsqueciSenha(); // Obtenha o painel de EsqueciSenha
        add(painelEsqueciSenha, BorderLayout.CENTER); // Adicione o painel de EsqueciSenha ao centro da janela
        revalidate(); // Revalide o layout da janela após adicionar os novos componentes
        repaint(); // Redesenha a janela
    }

    public void Cadastrar(ActionEvent e) {
        getContentPane().removeAll(); // Remove todos os componentes da janela
        // Criar e adicionar os novos componentes à janela
        Cadastro cadastro = new Cadastro(this); // Passa a referência da instância de Login para Cadastro
        JPanel painelCadastro = cadastro.getPanelCadastro(); // Obtém o painel do cadastro
        add(painelCadastro, BorderLayout.CENTER); // Adiciona o painel do cadastro ao centro da janela
        revalidate(); // Revalida o layout da janela após adicionar os novos componentes
    }

    public void Logar(ActionEvent e) {
        boolean continuar = true;
        // Capturando ID,login e Nome no banco de dados
        try (Connection connection = ConnectionFactory.recuperarConexao()) {
            String sql = "SELECT IDFUNCIONARIO, LOGIN, SENHA FROM funcionario";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {//Coloca o SQL no terminal do Banco de dados
                try (ResultSet resultSet = statement.executeQuery()) {//executa o SQL e captura o resultado
                    while (resultSet.next() && continuar) {//percorre cada tupla do resultado
                        String idFuncionario = resultSet.getString("IDFUNCIONARIO");
                        String login = resultSet.getString("LOGIN");
                        String senha = resultSet.getString("SENHA");

                        System.out.println("ID: " + idFuncionario + ", Login: " + login + ", SENHA: " + senha);//executa a saida no terminal

                        System.out.println("Verificando Login: "+campoLogin.getText());
                        System.out.println("Verificando Senha: "+campoSenha.getText());

                        if(Objects.equals(campoLogin.getText(),login)){ // Verifica se o campo login é igual a algum login existente
                            if(Objects.equals(campoSenha.getText(),senha)){

                                System.out.println(login+" entrou no sistema");

                                getContentPane().removeAll(); // Remove todos os componentes da janela
                                MenuConsulta menuConsulta = new MenuConsulta(this); // Passa a referência da instância de Login para Cadastro
                                JPanel painelMenuConsulta = menuConsulta.painelConsulta; // Obtém o painel do cadastro
                                add(painelMenuConsulta, BorderLayout.CENTER); // Adiciona o painel do cadastro ao centro da janela
                                revalidate(); // Revalide o layout da janela após adicionar os novos componentes
                                repaint(); // Redesenha a janela
                                JOptionPane.showMessageDialog(null, "Olá, "+login+"! Bom te ver novamente.");
                                campoLogin.setText("");
                                campoSenha.setText("");
                                continuar = false;
                            }
                        }
                    }
                }
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao executar consulta: " + ex.getMessage());
        }
        if(continuar){
            JOptionPane.showMessageDialog(null, "Erro de autenticação. Certifique-se de que o login e senha estão corretos.", "Error", JOptionPane.ERROR_MESSAGE);
            System.out.println("Erro de autenticação. Certifique-se de que o login e senha estão corretos.");
        }

    }
}

