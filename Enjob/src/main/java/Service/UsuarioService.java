package Service;
 
import java.sql.ResultSet;
import java.sql.SQLException;
import Model.Usuario;
import Dao.Dao;
 

public class UsuarioService {
    public static void InserirUsuario(Usuario u) throws SQLException {  
    	String query = "select max(ID_USUARIO) as id from TB_USUARIO";
    	int id = 0;
    	ResultSet rs = Dao.SelectCommand(query);
    	while(rs.next()){
        	id = rs.getInt("id");
         }
        id++;
    	
        query = String.format("insert into TB_USUARIO(ID_USUARIO, ID_LOGIN, ID_FORMACAO, ID_CURSOS, ID_IDIOMAS, ID_EXPERIENCIA, ID_EMAIL, ID_ENDERECO, ID_CONTATO, NM_NOME) values (%s,%s,%s,%s,%s,%s,%s,%s,%s,'%s')", id, u.getId(), u.getLogin().getIdLogin(), u.getFormacoes().getIdFormacao(),+ 
        		u.getCurso().getIdCursos(), u.getIdioma().getIdIdioma(), u.getExperiencia().getIdExperiencia(), u.getEmail().getIdEmail(), u.getEnderecos().getIdEndereco(), u.getContatos().getIdContato(), u.getNome());
        Dao.InsertUpdateDeleteCommand(query);
    }
   
    public static void AtualizarUsuario(Usuario u) {
        String query = String.format("update ID_USUARIO set nome = '%s', telefone = %s, endereco = '%s' where id = %s",u.getNome(), u.getContatos().getTelefone(), u.getEnderecos().getEndereco(),u.getId());
        Dao.InsertUpdateDeleteCommand(query);
    }
   
    public static void ExcluirUsuario(int id) {
    	int ID_USUARIO = -1;
    	
    	String query = String.format("select * from TB_USUARIO where id = %s", id);
        ResultSet rs = Dao.SelectCommand(query);
       
        try {
            while(rs.next()){
            	ID_USUARIO = rs.getInt("ID_USUARIO");
            }
        }
        catch (Exception e){
                System.out.println(e);
        }

    	
        UsuarioService ds = new UsuarioService();
        ds.ExcluirUsuario(ID_USUARIO);
    }
   
    public static void ExibirUsuario(int id) {
        String query = String.format("select * from TB_USUARIO where id = %s", id);
        ResultSet rs = Dao.SelectCommand(query);
       
        try {
            while(rs.next()){
            	 System.out.println(rs.getString("id"));
                 System.out.println(rs.getString("nome"));
                 System.out.println(rs.getString("email"));
                 System.out.println(rs.getString("idioma"));
                 System.out.println(rs.getString("telefone"));
                 System.out.println(rs.getString("idade"));
                 
                 int ID_USUARIO = rs.getInt("ID_USUARIO");
                 UsuarioService ds = new UsuarioService();
                 ds.ExibirUsuario(ID_USUARIO);
            }
        }
        catch (Exception e){
                System.out.println(e);
        }
    }
 
}