package Controle;

import Excessao.AutorizarInexistenteException;
import interfac.IControleAutorizacao;
import java.util.ArrayList;
import java.util.Date;
import jdbc.CRUDAutorizar;
import modelo.Autorizar;
import modelo.Funcionario;
import modelo.Paciente;

public class ControleAutorizar implements IControleAutorizacao{
    private CRUDAutorizar autoriza;
    
    public ControleAutorizar (){
        autoriza = new CRUDAutorizar();
    }
    @Override
    public void autorizar(String refeicao, String paciente, String funcionario, Date dtAutorizacao, String motivo){
        Autorizar autorizar = new Autorizar();
        autorizar.setRefeicao(refeicao);
        autorizar.setPaciente(paciente);
        autorizar.setFuncionario(funcionario);
        autorizar.setDtAutorizacao(dtAutorizacao);
        autorizar.setMotivo(motivo);
        autoriza.autorizar(autorizar);
    }
    
    public Paciente buscarPaciente(String nome)throws AutorizarInexistenteException  {
        Paciente pac = autoriza.buscarPaciente(nome);
        if(pac != null){
            return pac;
        }
        throw new AutorizarInexistenteException();
    }
    
    public Funcionario buscarFuncionario(String nome)throws AutorizarInexistenteException  {
        Funcionario fun = autoriza.buscarFuncionario(nome);
        if(fun != null){
            return fun;
        }
        throw new AutorizarInexistenteException();
    }
    
    @Override
    public String[] listarRefeicoes(){
        ArrayList<String> refeicoes = autoriza.listarRefeicoes();
        String[] refs = new String[refeicoes.size()+1];
        int i=1;
        refs[0] ="";
        for(String ref: refeicoes){
            refs[i++] = ref;
        }
        return refs;
    }
}