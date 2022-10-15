package Service;
 
import java.sql.ResultSet;
import java.sql.SQLException;
import Model.Email;
import Dao.Dao;
 

public class EmailService {
    public static void InserirEmail(Email em) throws SQLException {  
    	String query = "select max(ID_EMAIL) as id from TB_EMAIL_USUARIO";
    	int id = 0;
    	ResultSet rs = Dao.SelectCommand(query);
    	while(rs.next()){
        	id = rs.getInt("id");
         }
        id++;
    	
        query = String.format("insert into TB_EMAIL_USUARIO(ID_EMAIL, NM_SENHA, NM_RECUPERACAO_SENHA) values (%s,'%s', '%s')", id, em.getIdEmail(), em.getSenha(), em.getRecuperacaoSenha());
        Dao.InsertUpdateDeleteCommand(query);
    }
   
    public static void AtualizarEmail(Email em) {
        String query = String.format("update ID_EMAIL set email = '%s', senha = '%s', recuperacao senha = '%s' where id = %s",em.getIdEmail(), em.getSenha(), em.getRecuperacaoSenha());
        Dao.InsertUpdateDeleteCommand(query);
    }
   
    public static void ExcluirEmail(int id) {
    	int ID_EMAIL = -1;
    	
    	String query = String.format("select * from TB_EMAIL_USUARIO where id = %s", id);
        ResultSet rs = Dao.SelectCommand(query);
       
        try {
            while(rs.next()){
            	ID_EMAIL = rs.getInt("ID_EMAIL");
            }
        }
        catch (Exception e){
                System.out.println(e);
        }

    	
        EmailService ds = new EmailService();
        ds.ExcluirEmail(ID_EMAIL);
    }
   
    public static void ExibirEmail(int id) {
        String query = String.format("select * from TB_EMAIL_USUARIO where id = %s", id);
        ResultSet rs = Dao.SelectCommand(query);
       
        try {
            while(rs.next()){
            	 System.out.println(rs.getString("id"));
                 System.out.println(rs.getString("senha"));
                 System.out.println(rs.getString("recuperacao senha"));
                 
                 int ID_EMAIL = rs.getInt("ID_EMAIL");
                 EmailService ds = new EmailService();
                 ds.ExibirEmail(ID_EMAIL);
            }
        }
        catch (Exception e){
                System.out.println(e);
        }
    }
 
}