package gui;

import Controle.ControleRefeicao;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import modelo.Refeicao;
import Excessao.RefeicaoInexistenteException;

public class GuiRefeicao extends JPanel{
    
    private JLabel lbCodigo, lbTipo, lbHorario;
    private JTextField tfCodigo, tfTipo, tfHorario;
    private JButton btCadastrar, btExcluir, btEditar, btBuscar;
    private ControleRefeicao controle;
    
    public GuiRefeicao(){
        controle = new ControleRefeicao();
        inicializarComponentes();
        definirEventos();
    }

    private void inicializarComponentes() {
        setLayout(null);
        lbCodigo = new JLabel("Código:");
        lbTipo = new JLabel("Tipo:");
        lbHorario = new JLabel("Horário:");
        tfCodigo = new JTextField();
        tfTipo = new JTextField();
        tfHorario = new JTextField();
        btCadastrar = new JButton("Cadastrar");
        btBuscar = new JButton("Buscar");
        btExcluir = new JButton("Excluir");
        btEditar = new JButton("Editar");
        tfCodigo.setEditable(false);
        lbCodigo.setBounds(20,20,80,25);
        lbTipo.setBounds(20,55,80,25);
        lbHorario.setBounds(20,90,80,25);
        tfCodigo.setBounds(110,20,255,25);
        tfTipo.setBounds(110,55,255,25);
        tfHorario.setBounds(110,90,255,25);
        btCadastrar.setBounds(20,195,100,25);
        btBuscar.setBounds(125,195,80,25);
        btEditar.setBounds(210,195,70,25);
        btExcluir.setBounds(285,195,80,25);
        add(lbCodigo);
        add(lbTipo);
        add(lbHorario);
        add(tfCodigo);
        add(tfTipo);
        add(tfHorario);
        add(btCadastrar);
        add(btBuscar);
        add(btEditar);
        add(btExcluir);
    }

    private void definirEventos() {
        btCadastrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String tipo = tfTipo.getText();
                String horario = tfHorario.getText();
                if(tipo.equals("")||horario.equals("")){
                    JOptionPane.showMessageDialog(null, "Preencha todos os campos!");
                }else{
                    try {
                        controle.cadastrar(tipo, horario);
                        limpar();
                    } catch (RefeicaoInexistenteException ex) {
                        JOptionPane.showMessageDialog(null, ex.getMessage());
                    }
                }
            }
        });
        btBuscar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String tipo = tfTipo.getText();
                if(tipo.equals("")){
                    JOptionPane.showMessageDialog(null, "Preencha o campo Tipo!");
                }else{
                    Refeicao refeicao;
                    try {
                        refeicao = controle.buscar(tipo);
                        tfCodigo.setText(String.valueOf(refeicao.getCodigo()));
                        tfTipo.setText(refeicao.getTipo());
                        tfHorario.setText(refeicao.getHorario());
                    } catch (RefeicaoInexistenteException ex) {
                        JOptionPane.showMessageDialog(null, ex.getMessage());
                    }
                }
            }
        });
        btExcluir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String cod = tfCodigo.getText();
                if(cod.equals("")){
                    JOptionPane.showMessageDialog(null, "É necessário buscar uma refeição!");
                }else{
                    try {
                        controle.excluir(Integer.parseInt(cod));
                        limpar();
                    } catch (RefeicaoInexistenteException ex) {
                        JOptionPane.showMessageDialog(null, ex.getMessage());
                    }
                }
            }
        });
        btEditar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String cod = tfCodigo.getText();
                String tipo = tfTipo.getText();
                String horario = tfHorario.getText();
                if(cod.equals("")){
                    JOptionPane.showMessageDialog(null, "É necessário buscar uma refeição!");
                }else{
                    try {
                        controle.editar(Integer.parseInt(cod), tipo, horario);
                        limpar();
                    } catch (RefeicaoInexistenteException ex) {
                        JOptionPane.showMessageDialog(null, ex.getMessage());
                    }
                }
            }
        });
    }

    private void limpar() {
        tfCodigo.setText("");
        tfTipo.setText("");
        tfHorario.setText("");
        tfTipo.requestFocus();
    }
}