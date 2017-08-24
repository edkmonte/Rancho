package modelo;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Autorizar {
    private int codigo;
    private String acompanhante, motivo;
    private Funcionario funcionario;
    private Paciente paciente;
    private String refeicao;
    private Date dtAutorizacao;
    private SimpleDateFormat sdf;
    
    public Autorizar(){
        sdf = new SimpleDateFormat("dd/MM/yyyy");
    }
    
     public String getRefeicao() {
        return refeicao;
    }

    public void setRefeicao(String refeicao) {
        this.refeicao = refeicao;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    public String getAcompanhante() {
        return acompanhante;
    }

    public void setAcompanhante(String acompanhante) {
        this.acompanhante = acompanhante;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public Date getDtAutorizacao() {
        return dtAutorizacao;
    }

    public void setDtAutorizacao(Date dtAutorizacao) {
        this.dtAutorizacao = dtAutorizacao;
    }
    
    
}
