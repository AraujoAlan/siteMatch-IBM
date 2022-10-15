package Service;

import java.sql.ResultSet;
import java.sql.SQLException;
import Model.Usuario;
import Dao.Dao;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import javax.ws.rs.core.UriInfo;

@Path("/user")
public class UsuarioService {
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public static Response InserirUsuario(Usuario u, @Context UriInfo uriInfo) throws SQLException {
        String query = "select max(ID_USUARIO) as id from TB_USUARIO";
        int id = 0;
        ResultSet rs = Dao.SelectCommand(query);
        while (rs.next()) {
            id = rs.getInt("id");
        }
        id++;

        query = String.format(
                "insert into TB_USUARIO(ID_USUARIO, ID_LOGIN, ID_FORMACAO, ID_CURSOS, ID_IDIOMAS, ID_EXPERIENCIA, ID_EMAIL, ID_ENDERECO, ID_CONTATO, NM_NOME) values (%s,%s,%s,%s,%s,%s,%s,%s,%s,'%s')",
                id, u.getId(), u.getLogin().getIdLogin(), u.getFormacoes().getIdFormacao(), +u.getCurso().getIdCursos(),
                u.getIdioma().getIdIdioma(), u.getExperiencia().getIdExperiencia(), u.getEmail().getIdEmail(),
                u.getEnderecos().getIdEndereco(), u.getContatos().getIdContato(), u.getNome());
        Dao.InsertUpdateDeleteCommand(query);

        UriBuilder builder = uriInfo.getAbsolutePathBuilder();
        builder.path(Integer.toString(u.getId()));
        return Response.created(builder.build()).build();
    }

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public static void AtualizarUsuario(@PathParam("id") Usuario u) {
        String query = String.format("update ID_USUARIO set nome = '%s', telefone = %s, endereco = '%s' where id = %s",
                u.getNome(), u.getContatos().getTelefone(), u.getEnderecos().getEndereco(), u.getId());
        Dao.InsertUpdateDeleteCommand(query);
    }

    public static void ExcluirUsuario(@PathParam("id") int id) {
        int ID_USUARIO = -1;

        String query = String.format("select * from TB_USUARIO where id = %s", id);
        ResultSet rs = Dao.SelectCommand(query);

        try {
            while (rs.next()) {
                ID_USUARIO = rs.getInt("ID_USUARIO");
            }
        } catch (Exception e) {
            System.out.println(e);
        }

        UsuarioService ds = new UsuarioService();
        ds.ExcluirUsuario(ID_USUARIO);
    }

    public static void ExibirUsuario(@PathParam("id") int id) {
        String query = String.format("select * from TB_USUARIO where id = %s", id);
        ResultSet rs = Dao.SelectCommand(query);

        try {
            while (rs.next()) {
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
        } catch (Exception e) {
            System.out.println(e);
        }
    }

}