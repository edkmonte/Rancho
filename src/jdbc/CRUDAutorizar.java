package jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import modelo.Funcionario;
import modelo.Paciente;
import modelo.Autorizar;

public class CRUDAutorizar {
    private Conectar conectar;
    private Connection connection;
    private PreparedStatement st;
    private ResultSet result;
    private String sql, resultado;
    private ArrayList<String> refeicoes;
    private ArrayList<String> pacientes;
    private ArrayList<String> funcionarios;
    
    public CRUDAutorizar(){
        refeicoes = new ArrayList<String>();
        pacientes = new ArrayList<String>();
        funcionarios = new ArrayList<String>();
        conectar = new Conectar();
        connection = conectar.getConnection();
    }
    
    
    public Paciente buscarPaciente(String nome){
        try{
            Paciente paciente = null;
            sql = "select * from tb_pacientes where pac_nome =?;";
            st = connection.prepareStatement(sql);
            st.setString(1, nome);
            result = st.executeQuery();
            while(result.next()){
                paciente = new Paciente();
                paciente.setCodigo(result.getInt(1));
                paciente.setNome(result.getString(2));
                paciente.setCpf(result.getString(3));
                paciente.setDtEntrada(result.getDate(4));
                paciente.setLeito(result.getString(5));
                paciente.setQuarto(result.getString(6));
            }
            return paciente;
        }catch(SQLException e){
            resultado = "Erro!";
            return null;
        }
    }
    
    public Funcionario buscarFuncionario(String nome){
        try{
            Funcionario funcionario = null;
            sql = "select * from tb_funcionarios where fun_nome =?;";
            st = connection.prepareStatement(sql);
            st.setString(1, nome);
            result = st.executeQuery();
            while(result.next()){
                funcionario = new Funcionario();
                funcionario.setCodigo(result.getInt(1));
                funcionario.setMatricula(result.getString(2));
                funcionario.setNome(result.getString(3));
                
            }
            return funcionario;
        }catch(SQLException e){
            resultado = "Erro!";
            return null;
        }
    }
    
    public void autorizar(Autorizar autorizar){
        java.util.Date data = autorizar.getDtAutorizacao();
        java.sql.Date dataSql = new java.sql.Date(data.getTime());
        int codPac = buscarCodigoPaciente(autorizar.getPaciente());
        int codFun = buscarCodigoFuncionario(autorizar.getFuncionario());
        int codRef = buscarCodigoRefeicao(autorizar.getRefeicao());
        try{
            sql = "insert into tb_autorizacoes (aut_pac_codigo, aut_fun_codigo, aut_ref_codigo, aut_dtAutorizado, aut_motivo) values (?, ?, ?, ?, ?);";
            st = connection.prepareStatement(sql);
            st.setInt(1, codPac);
            st.setInt(2, codFun);
            st.setInt(3, codRef);
            st.setDate(4, dataSql);
            st.setString(5, autorizar.getMotivo());
            st.executeUpdate();
            JOptionPane.showMessageDialog(null, "inserido no sucesso BANCO");
        }catch(SQLException e){
            resultado = "Erro!";
        }
    }
    
    public ArrayList<String> listarRefeicoes(){
        try{
            refeicoes.clear();
            sql = "select ref_tipo from tb_refeicoes order by ref_tipo;";
            st = connection.prepareStatement(sql);
            result = st.executeQuery();
            while(result.next()){
                refeicoes.add(result.getString(1));
            }
            return refeicoes;
        }catch(SQLException e){
            resultado = "Erro!";
            return null;
        }
    }
    
    public ArrayList<String> listarFuncionarios(){
        try{
            funcionarios.clear();
            sql = "select fun_nome from tb_funcionarios order by fun_nome;";
            st = connection.prepareStatement(sql);
            result = st.executeQuery();
            while(result.next()){
                funcionarios.add(result.getString(1));
            }
            return funcionarios;
        }catch(SQLException e){
            resultado = "Erro!";
            return null;
        }
    }
    
    public ArrayList<String> listarPacientes(){
        try{
            pacientes.clear();
            sql = "select pac_nome from tb_pacientes order by pac_nome;";
            st = connection.prepareStatement(sql);
            result = st.executeQuery();
            while(result.next()){
                pacientes.add(result.getString(1));
            }
            return pacientes;
        }catch(SQLException e){
            resultado = "Erro!";
            return null;
        }
    }
    
    private int buscarCodigoRefeicao(String refeicao) {
        try{
            int codRefeicao=0;
            sql = "select ref_codigo from tb_refeicao where ref_tipo = ?;";
            st = connection.prepareStatement(sql);
            st.setString(1, refeicao);
            result = st.executeQuery();
            while(result.next()){
                codRefeicao = result.getInt(1);
            }
            return codRefeicao;
        }catch(SQLException e){
            resultado = "Erro!";
            return 0;
        }
    }
    
    private String buscarTipoRefeicao(int codRefeicao) {
        try{
            String tipoRefeicao="";
            sql = "select ref_tipo FROM tb_refeicoes where ref_codigo = ?;";
            st = connection.prepareStatement(sql);
            st.setInt(1, codRefeicao);
            result = st.executeQuery();
            while(result.next()){
                tipoRefeicao = result.getString(1);
            }
            return tipoRefeicao;
        }catch(SQLException e){
            resultado = "Erro!";
            return "";
        }
    }
    
    private int buscarCodigoPaciente(String paciente) {
        try{
            int codPaciente=0;
            sql = "select pac_codigo from tb_pacientes where pac_nome = ?;";
            st = connection.prepareStatement(sql);
            st.setString(1, paciente);
            result = st.executeQuery();
            while(result.next()){
                codPaciente = result.getInt(1);
            }
            return codPaciente;
        }catch(SQLException e){
            resultado = "Erro!";
            return 0;
        }
    }
    
    private String buscarNomePaciente(int codPaciente) {
        try{
            String nomePaciente="";
            sql = "select pac_nome from tb_pacientes where pac_codigo = ?;";
            st = connection.prepareStatement(sql);
            st.setInt(1, codPaciente);
            result = st.executeQuery();
            while(result.next()){
                nomePaciente = result.getString(1);
            }
            return nomePaciente;
        }catch(SQLException e){
            resultado = "Erro!";
            return "";
        }
    }
     
    private int buscarCodigoFuncionario(String funcionario) {
        try{
            int codFuncionario=0;
            sql = "select fun_codigo from tb_funcionarios where fun_nome = ?;";
            st = connection.prepareStatement(sql);
            st.setString(1, funcionario);
            result = st.executeQuery();
            while(result.next()){
                codFuncionario = result.getInt(1);
            }
            return codFuncionario;
        }catch(SQLException e){
            resultado = "Erro!";
            return 0;
        }
    }
    
    private String buscarNomeFuncionario(int codFuncionario) {
        try{
            String nomeFuncionario="";
            sql = "select fun_nome from tb_funcionarios where fun_codigo = ?;";
            st = connection.prepareStatement(sql);
            st.setInt(1, codFuncionario);
            result = st.executeQuery();
            while(result.next()){
                nomeFuncionario = result.getString(1);
            }
            return nomeFuncionario;
        }catch(SQLException e){
            resultado = "Erro!";
            return "";
        }
    }
}