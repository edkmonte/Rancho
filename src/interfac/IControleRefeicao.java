package interfac;

import Excessao.RefeicaoInexistenteException;
import modelo.Refeicao;

public interface IControleRefeicao {
    public void cadastrar(String tipo, String horario)throws RefeicaoInexistenteException;
    public Refeicao buscar(String tipo) throws RefeicaoInexistenteException;
    public void excluir(int codigo) throws RefeicaoInexistenteException;
    public void editar(int codigo, String tipo, String horario) throws RefeicaoInexistenteException;
}