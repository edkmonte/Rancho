package interfac;

import Excessao.RealizarInexistenteException;
import java.util.Date;

public interface IControleRealizar {
    
    public void realizar(String refeicao, String paciente, String funcinario, Date dtRealizacao) throws RealizarInexistenteException;
    public String[] listarRefeicoes()throws RealizarInexistenteException; 
    
}
