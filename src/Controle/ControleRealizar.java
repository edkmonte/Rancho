package Controle;

import Excessao.RealizarInexistenteException;
import interfac.IControleRealizar;
import java.util.ArrayList;
import java.util.Date;
import jdbc.CRUDRealizar;
import modelo.Funcionario;
import modelo.Paciente;
import modelo.Realizar;

public class ControleRealizar implements IControleRealizar{
    private CRUDRealizar realiza;
    
    public ControleRealizar(){
        realiza = new CRUDRealizar();
    }
    @Override
    public void realizar(String refeicao, String paciente, String funcinario, Date dtRealizacao){
        Realizar realizacao = new Realizar();
        realizacao.setRefeicao(refeicao);
        realizacao.setPaciente(paciente);
        realizacao.setFuncionario(funcinario);
        realizacao.setDtRealizacao(dtRealizacao);
        realiza.realizar(realizacao);
    }
    public Paciente buscarPaciente(String nome)throws RealizarInexistenteException  {
        Paciente pac = realiza.buscarPaciente(nome);
        if(pac != null){
            return pac;
        }
        throw new RealizarInexistenteException();
    }
    
    public Funcionario buscarFuncionario(String nome)throws RealizarInexistenteException  {
        Funcionario fun = realiza.buscarFuncionario(nome);
        if(fun != null){
            return fun;
        }
        throw new RealizarInexistenteException();
    }
    
    
    @Override
    public String[] listarRefeicoes(){
        ArrayList<String> refeicoes = realiza.listarRefeicoes();
        String[] refs = new String[refeicoes.size()+1];
        int i=1;
        refs[0] ="";
        for(String ref: refeicoes){
            refs[i++] = ref;
        }
        return refs;
    }
}