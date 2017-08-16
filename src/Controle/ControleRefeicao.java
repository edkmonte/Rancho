package Controle;

import interfac.IControleRefeicao;
import jdbc.CRUDRefeicao;
import modelo.Refeicao;
import Excessao.RefeicaoInexistenteException;


public class ControleRefeicao implements IControleRefeicao{
    private CRUDRefeicao refeicao;
    
    public ControleRefeicao()    {
        refeicao = new CRUDRefeicao();
    }
    
    @Override
    public void cadastrar(String tipo, String horario) throws RefeicaoInexistenteException{
        Refeicao refeicoes = new Refeicao();
        refeicoes.setTipo(tipo);
        refeicoes.setHorario(horario);
        refeicao.cadastrar(refeicoes);
    }
    
    @Override
    public Refeicao buscar(String tipo) throws RefeicaoInexistenteException {
        Refeicao cont = refeicao.buscar(tipo);
        if(cont != null){
            return cont;
        }
        throw new RefeicaoInexistenteException();
    }

    @Override
    public void excluir(int codigo) throws RefeicaoInexistenteException {
        refeicao.excluir(codigo);
    }

    @Override
    public void editar(int codigo, String tipo, String horario) throws RefeicaoInexistenteException {
        Refeicao contato = new Refeicao();
        contato.setCodigo(codigo);
        contato.setTipo(tipo);
        contato.setHorario(horario);
        refeicao.editar(contato);
    }
}