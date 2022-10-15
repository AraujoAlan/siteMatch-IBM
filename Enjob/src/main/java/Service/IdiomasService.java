package Service;
 
import java.sql.ResultSet;
import java.sql.SQLException;
import Model.Idiomas;
import Dao.Dao;
 

public class IdiomasService {
    public static void InserirIdiomas(Idiomas i) throws SQLException {  
    	String query = "select max(ID_IDIOMAS) as id from TB_IDIOMAS";
    	int id = 0;
    	ResultSet rs = Dao.SelectCommand(query);
    	while(rs.next()){
        	id = rs.getInt("id");
         }
        id++;
    	
        query = String.format("insert into TB_IDIOMAS(ID_IDIOMAS, NM_IDIOMAS, NM_NIVEL) values (%s,'%s', '%s')", id, i.getIdIdioma(), i.getIdiomas(), i.getNivel());
        Dao.InsertUpdateDeleteCommand(query);
    }
   
    public static void AtualizarIdiomas(Idiomas i) {
        String query = String.format("update ID_IDIOMAS set idioma = '%s', nivel = '%s' where id = %s",i.getIdiomas(), i.getNivel());
        Dao.InsertUpdateDeleteCommand(query);
    }
   
    public static void ExcluirIdiomas(int id) {
    	int ID_IDIOMAS = -1;
    	
    	String query = String.format("select * from TB_IDIOMAS where id = %s", id);
        ResultSet rs = Dao.SelectCommand(query);
       
        try {
            while(rs.next()){
            	ID_IDIOMAS = rs.getInt("ID_IDIOMAS");
            }
        }
        catch (Exception e){
                System.out.println(e);
        }

    	
        IdiomasService ds = new IdiomasService();
        ds.ExcluirIdiomas(ID_IDIOMAS);
    }
   
    public static void ExibirIdiomas(int id) {
        String query = String.format("select * from TB_IDIOMAS where id = %s", id);
        ResultSet rs = Dao.SelectCommand(query);
       
        try {
            while(rs.next()){
            	 System.out.println(rs.getString("id"));
                 System.out.println(rs.getString("idioma"));
                 System.out.println(rs.getString("nivel"));
                 
                 int ID_IDIOMAS = rs.getInt("ID_IDIOMAS");
                 IdiomasService ds = new IdiomasService();
                 ds.ExibirIdiomas(ID_IDIOMAS);
            }
        }
        catch (Exception e){
                System.out.println(e);
        }
    }
 
}