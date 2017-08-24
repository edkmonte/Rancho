package interfac;

import Excessao.AutorizarInexistenteException;
import java.util.Date;
import modelo.Funcionario;
import modelo.Paciente;

public interface IControleAutorizacao {
    public void autorizar(Paciente paciente1, Funcionario funcionario1, String refeicao, Date dtAutorizacao, String motivo) throws AutorizarInexistenteException;
    public String[] listarRefeicoes()throws AutorizarInexistenteException; 
    
}
