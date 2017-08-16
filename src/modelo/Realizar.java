package modelo;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Realizar {
    private int codigo;
    private String paciente, funcionario, acompanhante, refeicao;
    private Date dtEntrada, dtSaida, dtRealizacao;
    private SimpleDateFormat sdf;
    
    
    public Realizar(){
        sdf = new SimpleDateFormat("dd/MM/yyyy");
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
    
    public String getRefeicao() {
        return refeicao;
    }

    public void setRefeicao(String refeicao) {
        this.refeicao = refeicao;
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

    public Date getDtEntrada() {
        return dtEntrada;
    }

    public void setDtEntrada(Date dtEntrada) {
        this.dtEntrada = dtEntrada;
    }

    public Date getDtSaida() {
        return dtSaida;
    }

    public void setDtSaida(Date dtSaida) {
        this.dtSaida = dtSaida;
    }
    
    public Date getDtRealizacao() {
        return dtRealizacao;
    }

    public void setDtRealizacao(Date dtRealizacao) {
        this.dtRealizacao = dtRealizacao;
    }
}