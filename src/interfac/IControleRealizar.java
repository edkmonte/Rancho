package interfac;

import Excessao.RealizarInexistenteException;
import java.util.Date;
import modelo.Funcionario;
import modelo.Paciente;

public interface IControleRealizar {
    
    public void realizar(Paciente paciente1, Funcionario funcinario1, String refeicao, Date dtRealizacao) throws RealizarInexistenteException;
    public String[] listarRefeicoes()throws RealizarInexistenteException; 
    
}
