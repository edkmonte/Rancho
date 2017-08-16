package interfac;

import Excessao.AutorizarInexistenteException;
import java.util.Date;

public interface IControleAutorizacao {
    public void autorizar(String refeicao, String paciente, String funcionario, Date dtAutorizacao, String motivo) throws AutorizarInexistenteException;
    public String[] listarRefeicoes()throws AutorizarInexistenteException; 
    
}
