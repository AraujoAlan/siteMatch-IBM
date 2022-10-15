package Service;
 
import java.sql.ResultSet;
import java.sql.SQLException;
import Model.Endereco;
import Dao.Dao;
 

public class EnderecoService {
    public static void InserirEndereco(Endereco en) throws SQLException {  
    	String query = "select max(ID_ENDERECO) as id from TB_USUARIO_ENDERECO";
    	int id = 0;
    	ResultSet rs = Dao.SelectCommand(query);
    	while(rs.next()){
        	id = rs.getInt("id");
         }
        id++;
    	
        query = String.format("insert into TB_USUARIO_ENDERECO(ID_ENDERECO, NR_CEP, NM_LOGRADOURO, NR_NUMERO, NM_COMPLEMENTO, NM_PONTO_REFERENCIA) values (%s,'%s', %s, '%s', '%s', '%s')", id, en.getIdEndereco(), en.getCep(), en.getLogradouro(), en.getNumero(), en.getComplemento(), en.getPontoReferencia());
        Dao.InsertUpdateDeleteCommand(query);
    }
   
    public static void AtualizarEndereco(Endereco en) {
        String query = String.format("update ID_ENDERECO set endereco = '%s', cep = %s, logradouro = '%s', numero = %s, complemento = '%s', ponto referencia = '%s' where id = %s",en.getIdEndereco(), en.getCep(), en.getLogradouro(), en.getNumero(), en.getComplemento(), en.getPontoReferencia());
        Dao.InsertUpdateDeleteCommand(query);
    }
   
    public static void ExcluirEndereco(int id) {
    	int ID_ENDERECO = -1;
    	
    	String query = String.format("select * from TB_USUARIO_ENDERECO where id = %s", id);
        ResultSet rs = Dao.SelectCommand(query);
       
        try {
            while(rs.next()){
            	ID_ENDERECO = rs.getInt("ID_ENDERECO");
            }
        }
        catch (Exception e){
                System.out.println(e);
        }

    	
        EnderecoService ds = new EnderecoService();
        ds.ExcluirEndereco(ID_ENDERECO);
    }
   
    public static void ExibirEndereco(int id) {
        String query = String.format("select * from TB_USUARIO_ENDERECO where id = %s", id);
        ResultSet rs = Dao.SelectCommand(query);
       
        try {
            while(rs.next()){
            	 System.out.println(rs.getString("id"));
                 System.out.println(rs.getString("endereco"));
                 System.out.println(rs.getString("cep"));
                 System.out.println(rs.getString("logradouro"));
                 System.out.println(rs.getString("numero"));
                 System.out.println(rs.getString("complemento"));
                 System.out.println(rs.getString("ponto referencia"));
                 
                 int ID_ENDERECO = rs.getInt("ID_ENDERECO");
                 EnderecoService ds = new EnderecoService();
                 ds.ExibirEndereco(ID_ENDERECO);
            }
        }
        catch (Exception e){
                System.out.println(e);
        }
    }
 
}