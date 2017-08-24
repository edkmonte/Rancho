package modelo;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Realizar {
    private int codigo;
    private String acompanhante;
    private Date dtEntrada, dtSaida, dtRealizacao;
    private SimpleDateFormat sdf;
    private Funcionario funcionario;
    private Paciente paciente;
    private String refeicao;
    
    
    public Realizar(){
        sdf = new SimpleDateFormat("dd/MM/yyyy");
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
    
    public String getRefeicao() {
        return refeicao;
    }

    public void setRefeicao(String refeicao) {
        this.refeicao = refeicao;
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