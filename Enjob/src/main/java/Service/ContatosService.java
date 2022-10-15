package Service;
 
import java.sql.ResultSet;
import java.sql.SQLException;
import Model.Contatos;
import Dao.Dao;
 

public class ContatosService {
    public static void InserirContatos(Contatos co) throws SQLException {  
    	String query = "select max(ID_CONTATO) as id from TB_CONTATO";
    	int id = 0;
    	ResultSet rs = Dao.SelectCommand(query);
    	while(rs.next()){
        	id = rs.getInt("id");
         }
        id++;
    	
        query = String.format("insert into TB_CONTATO(ID_CONTATO, NR_DDI, NR_DDD, NR_TELEFONE) values (%s,'%s',%s,%s)", id, co.getIdContato(), co.getDdi(), co.getDdd(), co.getTelefone());
        Dao.InsertUpdateDeleteCommand(query);
    }
   
    public static void AtualizarContatos(Contatos co) {
        String query = String.format("update ID_CONTATO set contatos = '%s', ddi = '%s', ddd = %s, telefone = %s",co.getIdContato(), co.getDdi(), co.getDdd(), co.getTelefone());
        Dao.InsertUpdateDeleteCommand(query);
    }
   
    public static void ExcluirContatos(int id) {
    	int ID_CONTATO = -1;
    	
    	String query = String.format("select * from TB_CONTATO where id = %s", id);
        ResultSet rs = Dao.SelectCommand(query);
       
        try {
            while(rs.next()){
            	ID_CONTATO = rs.getInt("ID_CONTATO");
            }
        }
        catch (Exception e){
                System.out.println(e);
        }

    	
        ContatosService ds = new ContatosService();
        ds.ExcluirContatos(ID_CONTATO);
    }
   
    public static void ExibirContatos(int id) {
        String query = String.format("select * from TB_CONTATO where id = %s", id);
        ResultSet rs = Dao.SelectCommand(query);
       
        try {
            while(rs.next()){
            	 System.out.println(rs.getString("id"));
                 System.out.println(rs.getString("ddi"));
                 System.out.println(rs.getString("ddd"));
                 System.out.println(rs.getString("telefone"));
            
                 int ID_CONTATO = rs.getInt("ID_CONTATO");
                 ContatosService ds = new ContatosService();
                 ds.ExibirContatos(ID_CONTATO);
            }
        }
        catch (Exception e){
                System.out.println(e);
        }
    }
 
}