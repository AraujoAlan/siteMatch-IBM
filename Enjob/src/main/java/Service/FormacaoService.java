package Service;
 
import java.sql.ResultSet;
import java.sql.SQLException;
import Model.Formacao;
import Dao.Dao;
 

public class FormacaoService {
    public static void InserirFormacao(Formacao f) throws SQLException {  
    	String query = "select max(ID_FORMACAO) as id from TB_FORMACAO";
    	int id = 0;
    	ResultSet rs = Dao.SelectCommand(query);
    	while(rs.next()){
        	id = rs.getInt("id");
         }
        id++;
    	
        query = String.format("insert into TB_FORMACAO(ID_FORMACAO, NM_FORMACAO_ESCOLARIDADE, NM_SITUCAO_FORMACAO, DT_INICIO_FORMACAO, DT_ABERTO_FORMACAO, DT_FIM_FORMACAO) values (%s,'%s', '%s', %s, %s, %s)", id, f.getIdFormacao(), f.getFormacaoAcademica(), f.getSituacaoEscolaridade(), f.getDataInicio(), f.getDataAberto(), f.getDataFinalizacao());
        Dao.InsertUpdateDeleteCommand(query);
    }
   
    public static void AtualizarFormacao(Formacao f) {
        String query = String.format("update ID_FORMACAO set formacao = '%s', data inicio formacao = %s, data aberto formacao = %s, data fim formacao = %s where id = %s",f.getIdFormacao(), f.getDataInicio(), f.getDataAberto(), f.getDataFinalizacao());
        Dao.InsertUpdateDeleteCommand(query);
    }
   
    public static void ExcluirFormacao(int id) {
    	int ID_FORMACAO = -1;
    	
    	String query = String.format("select * from TB_FORMACAO where id = %s", id);
        ResultSet rs = Dao.SelectCommand(query);
       
        try {
            while(rs.next()){
            	ID_FORMACAO = rs.getInt("ID_FORMACAO");
            }
        }
        catch (Exception e){
                System.out.println(e);
        }

    	
        FormacaoService ds = new FormacaoService();
        ds.ExcluirFormacao(ID_FORMACAO);
    }
   
    public static void ExibirFormacao(int id) {
        String query = String.format("select * from TB_FORMACAO where id = %s", id);
        ResultSet rs = Dao.SelectCommand(query);
       
        try {
            while(rs.next()){
            	 System.out.println(rs.getString("id"));
                 System.out.println(rs.getString("nome formacao escolaridade"));
                 System.out.println(rs.getString("nome situacao escolaridade"));
                 System.out.println(rs.getString("data inicio formacao"));
                 System.out.println(rs.getString("data aberto formacao"));
                 System.out.println(rs.getString("data fim formacao"));
                 
                 int ID_FORMACAO = rs.getInt("ID_FORMACAO");
                 FormacaoService ds = new FormacaoService();
                 ds.ExibirFormacao(ID_FORMACAO);
            }
        }
        catch (Exception e){
                System.out.println(e);
        }
    }
 
}