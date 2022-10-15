package Service;
 
import java.sql.ResultSet;
import java.sql.SQLException;
import Model.Autenticacao;
import Dao.Dao;
 

public class AutentificacaoService {
    public static void InserirAutenticacao(Autenticacao a) throws SQLException {  
    	String query = "select max(ID_AUTENTICACAO) as id from TB_AUTENTICACAO_LOGIN";
    	int id = 0;
    	ResultSet rs = Dao.SelectCommand(query);
    	while(rs.next()){
        	id = rs.getInt("id");
         }
        id++;
    	
        query = String.format("insert into TB_AUTENTICACAO_LOGIN(ID_AUTENTICACAO, NR_TOKEN) values (%s,'%s')", id, a.getIdAutenticacao(), a.getToken());
        Dao.InsertUpdateDeleteCommand(query);
    }
   
    public static void AtualizarAutenticacao(Autenticacao a) {
        String query = String.format("update ID_AUTENTICACAO set autenticacao = '%s', ddi = '%s', ddd = %s, telefone = %s",a.getIdAutenticacao(), a.getToken());
        Dao.InsertUpdateDeleteCommand(query);
    }
   
    public static void ExcluirAutenticacao(int id) {
    	int ID_AUTENTICACAO = -1;
    	
    	String query = String.format("select * from TB_AUTENTICACAO_LOGIN where id = %s", id);
        ResultSet rs = Dao.SelectCommand(query);
       
        try {
            while(rs.next()){
            	ID_AUTENTICACAO = rs.getInt("ID_AUTENTICACAO");
            }
        }
        catch (Exception e){
                System.out.println(e);
        }

    	
        AutentificacaoService ds = new AutentificacaoService();
        ds.ExcluirAutenticacao(ID_AUTENTICACAO);
    }
   
    public static void ExibirAutenticacao(int id) {
        String query = String.format("select * from TB_AUTENTICACAO_LOGIN where id = %s", id);
        ResultSet rs = Dao.SelectCommand(query);
       
        try {
            while(rs.next()){
            	 System.out.println(rs.getString("id"));
                 System.out.println(rs.getString("token"));
            
                 int ID_AUTENTICACAO = rs.getInt("ID_AUTENTICACAO");
                 AutentificacaoService ds = new AutentificacaoService();
                 ds.ExibirAutenticacao(ID_AUTENTICACAO);
            }
        }
        catch (Exception e){
                System.out.println(e);
        }
    }
 
}