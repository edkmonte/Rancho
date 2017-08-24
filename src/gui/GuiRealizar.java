package gui;

import Controle.ControleRealizar;
import Excessao.RealizarInexistenteException;
import Excessao.RefeicaoInexistenteException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import modelo.Funcionario;
import modelo.Paciente;
import modelo.Refeicao;

public class GuiRealizar extends JPanel{
    private SimpleDateFormat sdf;
    private JLabel lbCodigo, lbPaciente, lbDataEntrada, lbCpf, lbLeito, lbQuarto, lbRefeicoes, lbFuncionario, lbMatricula, lbDtRealizacao, lbTitulo, lbCodigoFun;
    private JTextField tfCodigo, tfPaciente, tfDataEntrada, tfCpf, tfLeito, tfQuarto, tfFuncionario, tfMatricula, tfDtRealizarcao, tfCodigoFun;
    private JComboBox cbRefeicao;
    private JButton btConfirmar, btPesquisar,btCancelar, btPesquisarFun;
    private ControleRealizar contRealizar;
    private Funcionario funcionario;
    private Paciente paciente;
    private Refeicao refeicao;
    
    
    public GuiRealizar() throws RefeicaoInexistenteException{
        sdf = new SimpleDateFormat("dd/MM/yyyy");
        contRealizar = new ControleRealizar();
        inicializarComponentes();
        definirEventos();
    }
    
    public void inicializarComponentes() throws RefeicaoInexistenteException{
        setLayout(null);
        String[] refeicoes = listarRefeicoes();
        lbTitulo = new JLabel("TELA DE REALIZAR REFEIÇÕES");
        lbCodigo = new JLabel ("Código: ");
        lbPaciente = new JLabel ("Paciente: ");
        lbDataEntrada = new JLabel ("Dt Entrada: ");
        lbCpf = new JLabel ("CPF: ");
        lbLeito = new JLabel ("Leito: ");
        lbQuarto = new JLabel ("Quarto: ");
        lbRefeicoes = new JLabel("Refeições: ");
        lbCodigoFun = new JLabel("Código Funcionário: ");
        lbFuncionario = new JLabel ("Funcionário:");
        lbMatricula = new JLabel("Matrícula:");
        lbDtRealizacao = new JLabel("Dt Realização:");
        tfCodigo  = new JTextField();
        tfPaciente  = new JTextField();
        tfDataEntrada  = new JTextField();
        tfCpf  = new JTextField();
        tfLeito  = new JTextField();
        tfQuarto  = new JTextField();
        tfCodigoFun = new JTextField();
        tfFuncionario = new JTextField();
        tfMatricula = new JTextField();
        tfDtRealizarcao = new JTextField();
        cbRefeicao = new JComboBox(refeicoes);
        btConfirmar = new JButton("Confirmar");
        btCancelar = new JButton("Cancelar");
        btPesquisar = new JButton("Pesquisar Pacientes");
        btPesquisarFun = new JButton("Pesquisar Funcionários");
       tfCodigo.setEditable(false);
        tfCpf.setEditable(false);
        tfDataEntrada.setEditable(false);
        tfLeito.setEditable(false);
        tfQuarto.setEditable(false);
        tfMatricula.setEditable(false);
        tfCodigoFun.setEditable(false);
        lbTitulo.setBounds(20, 5, 300, 30);
        lbCodigo.setBounds(20, 40, 80, 25);
        lbPaciente.setBounds(20, 75, 80, 25);
        lbDataEntrada.setBounds(20, 110, 80, 25);
        lbCpf.setBounds(20, 145, 80, 25);
        lbLeito.setBounds(20, 180, 80, 25);
        lbQuarto.setBounds(20, 215, 80, 25);
        lbRefeicoes.setBounds(20, 250, 80, 25);
        lbCodigoFun.setBounds(20, 285, 80, 25);
        lbFuncionario.setBounds(20, 320, 80, 25);
        lbMatricula.setBounds(20, 355, 80, 25);
        lbDtRealizacao.setBounds(20, 390, 80, 25);
        tfCodigo.setBounds(110, 40, 255, 25);
        tfPaciente.setBounds(110, 75, 400, 25);
        tfDataEntrada.setBounds(110, 110, 255, 25);
        tfCpf.setBounds(110, 145, 255, 25);
        tfLeito.setBounds(110, 180, 255, 25);
        tfQuarto.setBounds(110, 215, 255, 25);
        cbRefeicao.setBounds(110, 250, 255, 25);
        tfCodigoFun.setBounds(110, 285, 255, 25);
        tfFuncionario.setBounds(110, 320, 400, 25);
        tfMatricula.setBounds(110, 355, 255, 25);
        tfDtRealizarcao.setBounds(110, 385, 255, 25);
        btConfirmar.setBounds(160, 490, 100, 25);
        btCancelar.setBounds(360, 490, 100, 25);
        btPesquisar.setBounds(520, 75, 180, 25);
        btPesquisarFun.setBounds(520, 320, 180, 25);
        add(lbTitulo);
        add(tfCodigo);
        add(lbCodigo);
        add(lbPaciente);
        add(lbDataEntrada);
        add(lbCpf);
        add(lbLeito);
        add(lbQuarto);
        add(lbRefeicoes);
        add(lbCodigoFun);
        add(lbFuncionario);
        add(lbMatricula);
        add(lbDtRealizacao);
        add(tfCodigo);
        add(tfPaciente);
        add(tfDataEntrada);
        add(tfCpf);
        add(tfLeito);
        add(tfQuarto);
        add(tfCodigoFun);
        add(tfFuncionario);
        add(tfMatricula);
        add(tfDtRealizarcao);
        add(cbRefeicao);
        add(btConfirmar);
        add(btCancelar);
        add(btPesquisar);
        add(btPesquisarFun);
    }
    
    public void definirEventos(){
     btPesquisar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nome = tfPaciente.getText();
                if(nome.equals("")){
                    JOptionPane.showMessageDialog(null, "Preencha o campo Paciente!");
                }else{
                    paciente = null;
                    try {
                        paciente = contRealizar.buscarPaciente(nome);
                        tfCodigo.setText(String.valueOf(paciente.getCodigo()));
                        tfPaciente.setText(paciente.getNome());
                        tfCpf.setText(paciente.getCpf());
                        tfLeito.setText(paciente.getLeito());
                        tfQuarto.setText(paciente.getQuarto());
                        tfDataEntrada.setText(String.valueOf(paciente.getDtEntrada()));
                        tfPaciente.setEditable(false);
                    } catch (RealizarInexistenteException ex) {
                        JOptionPane.showMessageDialog(null, ex.getMessage());
                    }
                }
            }
        });
     
      btPesquisarFun.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nome = tfFuncionario.getText();
                if (nome.equals("")) {
                    JOptionPane.showMessageDialog(null, "Preencha o campo Funcionário!");
                } else {
                    funcionario = null;
                    try {
                        funcionario = contRealizar.buscarFuncionario(nome);
                        tfCodigoFun.setText(String.valueOf(funcionario.getCodigo()));
                        tfFuncionario.setText(funcionario.getNome());
                        tfMatricula.setText(funcionario.getMatricula());
                        tfFuncionario.setEditable(false);
                    } catch (RealizarInexistenteException ex) {
                        JOptionPane.showMessageDialog(null, ex.getMessage());
                    }
                }
            }
        });
     
     btConfirmar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Paciente paciente1 = paciente;    
                Funcionario funcionario1 = funcionario;
                String refeicao = String.valueOf(cbRefeicao.getSelectedItem());
                Date dtRealizacao = null;
                try {
                    dtRealizacao = sdf.parse(tfDtRealizarcao.getText());
                    contRealizar.realizar(paciente1, funcionario1, refeicao, dtRealizacao);
                    JOptionPane.showMessageDialog(null, "Refeição Realizada!");
                } catch (ParseException ex) {
                    JOptionPane.showMessageDialog(null, "Erro ao Acessar o Banco de Dados!");
                } catch (RealizarInexistenteException ex) {
                    Logger.getLogger(GuiAutorizacao.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }
    
    private String[] listarRefeicoes() throws RefeicaoInexistenteException {
        return contRealizar.listarRefeicoes();
    }
    
    private void limpar() {
        tfCodigo.setText("");
        tfPaciente.setText("");
        tfCpf.setText("");
        tfDataEntrada.setText("");
        tfLeito.setText("");
        tfQuarto.setText("");
        cbRefeicao.setSelectedIndex(0);
        tfPaciente.requestFocus();
    }
}