package jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import modelo.Refeicao;

public class CRUDRefeicao {
    
    private Conectar conectar;
    private Connection connection;
    private PreparedStatement st;
    private ResultSet result;
    private String sql, resultado;
    
    public CRUDRefeicao(){

        conectar = new Conectar();
        connection = conectar.getConnection();
    }
    
    public void cadastrar(Refeicao refeicao){
        try{
            sql = "insert into tb_refeicoes (ref_tipo, ref_horario) values (?,?)";
            st = connection.prepareStatement(sql);
            st.setString(1, refeicao.getTipo());
            st.setString(2, refeicao.getHorario());
            st.executeUpdate();
        }catch(SQLException e){
            resultado = "Erro!";
        }
    }
    public Refeicao buscar(String tipo){
        try{
            Refeicao refeicao = null;
            sql = "select * from tb_refeicoes where ref_tipo = ?;";
            st = connection.prepareStatement(sql);
            st.setString(1, tipo);
            result = st.executeQuery();
            while(result.next()){
                refeicao = new Refeicao();
                refeicao.setCodigo(result.getInt(1));
                refeicao.setTipo(result.getString(2));
                refeicao.setHorario(result.getString(3));
            }
            return refeicao;
        }catch(SQLException e){
            resultado = "Erro!";
            return null;
        }
    }
    public void editar(Refeicao refeicao){
        try{
            sql = "update tb_refeicao set ref_tipo=?, "
                    + "ref_tipo=?, ref_horario=?,"
                    + " WHERE ref_codigo=?;";
            st = connection.prepareStatement(sql);
            st.setString(1, refeicao.getTipo());
            st.setString(2, refeicao.getHorario());
            st.setInt(3, refeicao.getCodigo());
            st.executeUpdate();
        }catch(SQLException e){
            resultado = "Erro!";
        }
    }
    public void excluir(int codigo){
        try{
            sql = "delete from tb_refeicoes where ref_codigo = ?;";
            st = connection.prepareStatement(sql);
            st.setInt(1, codigo);
            st.executeUpdate();
        }catch(SQLException e){
            resultado = "Erro!";
        }
    }
}