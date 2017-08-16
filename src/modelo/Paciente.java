package modelo;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Paciente extends Pessoa{
    private String leito, quarto;
    private Date dtEntrada;
    private SimpleDateFormat sdf;
    
    public Paciente(){
        sdf = new SimpleDateFormat("dd/MM/yyyy");
    }

    public String getLeito() {
        return leito;
    }

    public void setLeito(String leito) {
        this.leito = leito;
    }

    public String getQuarto() {
        return quarto;
    }

    public void setQuarto(String quarto) {
        this.quarto = quarto;
    }

    public Date getDtEntrada() {
        return dtEntrada;
    }

    public void setDtEntrada(Date dtEntrada) {
        this.dtEntrada = dtEntrada;
    }
}