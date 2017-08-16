package modelo;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Autorizar {
    private int codigo;
    private String paciente, funcionario, acompanhante, motivo, refeicao;
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

    public String getPaciente() {
        return paciente;
    }

    public void setPaciente(String paciente) {
        this.paciente = paciente;
    }

    public String getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(String funcionario) {
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
