package gui;

import Excessao.AutorizarInexistenteException;
import Excessao.RefeicaoInexistenteException;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class GuiPrincipal extends JFrame{
    private JMenuBar mbBarra;
    private JMenu mnArquivo, mnOpcoes, mnMovimentacao;
    private JMenuItem mtSair, mtCadastrar, mtRealizar, mtAutorizar;
    private Container container;
    
    public GuiPrincipal(){
        inicializarComponentes();
        definirEventos();
    }

    private void inicializarComponentes() {
        setTitle("Projeto Rancho");
        setBounds(0, 0, 800, 600);
        container = getContentPane();
        mbBarra = new JMenuBar();
        mnArquivo = new JMenu("Arquivo");
        mnOpcoes = new JMenu("Cadastros");
        mnMovimentacao = new JMenu("Movimentação");
        mtSair = new JMenuItem("Sair");
        mtCadastrar = new JMenuItem("Refeição");
        mtRealizar = new JMenuItem("Realizar Refeição");
        mtAutorizar = new JMenuItem("Autorizar Refeição");
        
        mnArquivo.add(mtSair);
        mnOpcoes.add(mtCadastrar);
        mnMovimentacao.add(mtRealizar);
        mnMovimentacao.add(mtAutorizar);
        mbBarra.add(mnArquivo);
        mbBarra.add(mnOpcoes);
        mbBarra.add(mnMovimentacao);
        setJMenuBar(mbBarra);
    }

    private void definirEventos() {
        mtSair.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        mtCadastrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GuiRefeicao cadastrar = new GuiRefeicao();
                container.removeAll();
                container.add(cadastrar);
                container.validate();
            }
        });
        
         mtRealizar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GuiRealizar realizar;
                try {
                    realizar = new GuiRealizar();
                    container.removeAll();
                    container.add(realizar);
                    container.validate();
                } catch (RefeicaoInexistenteException ex) {
                    Logger.getLogger(GuiPrincipal.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            }
        });
         
         mtAutorizar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GuiAutorizacao autorizar = null;
                try {
                    try {
                        autorizar = new GuiAutorizacao();
                    } catch (AutorizarInexistenteException ex) {
                        Logger.getLogger(GuiPrincipal.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    container.removeAll();
                    container.add(autorizar);
                    container.validate();
                } catch (RefeicaoInexistenteException ex) {
                    Logger.getLogger(GuiPrincipal.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            }
        });
    }
    
    public void mainRefeicao(){
        GuiPrincipal frame = new GuiPrincipal();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        Dimension tela = Toolkit.getDefaultToolkit().getScreenSize();
        frame.setLocation((tela.width - frame.getSize().width)/2,
                (tela.height - frame.getSize().height)/2);
        frame.setVisible(true);
    }
}