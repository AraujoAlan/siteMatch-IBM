package Service;

import java.sql.ResultSet;
import java.sql.SQLException;
import Model.Email;
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

@Path("/email")
public class EmailService {
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public static Response InserirEmail(Email em, @Context UriInfo uriInfo) throws SQLException {
        String query = "select max(ID_EMAIL) as id from TB_EMAIL_USUARIO";
        int id = 0;
        ResultSet rs = Dao.SelectCommand(query);
        while (rs.next()) {
            id = rs.getInt("id");
        }
        id++;

        query = String.format(
                "insert into TB_EMAIL_USUARIO(ID_EMAIL, NM_SENHA, NM_RECUPERACAO_SENHA) values (%s,'%s', '%s')", id,
                em.getIdEmail(), em.getSenha(), em.getRecuperacaoSenha());
        Dao.InsertUpdateDeleteCommand(query);

        UriBuilder builder = uriInfo.getAbsolutePathBuilder();
        builder.path(Integer.toString(em.getIdEmail()));
        return Response.created(builder.build()).build();
    }

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public static void AtualizarEmail(@PathParam("id") Email em) {
        String query = String.format(
                "update ID_EMAIL set email = '%s', senha = '%s', recuperacao senha = '%s' where id = %s",
                em.getIdEmail(), em.getSenha(), em.getRecuperacaoSenha());
        Dao.InsertUpdateDeleteCommand(query);
    }

    public static void ExcluirEmail(@PathParam("id") int id) {
        int ID_EMAIL = -1;

        String query = String.format("select * from TB_EMAIL_USUARIO where id = %s", id);
        ResultSet rs = Dao.SelectCommand(query);

        try {
            while (rs.next()) {
                ID_EMAIL = rs.getInt("ID_EMAIL");
            }
        } catch (Exception e) {
            System.out.println(e);
        }

        EmailService ds = new EmailService();
        ds.ExcluirEmail(ID_EMAIL);
    }

    public static void ExibirEmail(@PathParam("id") int id) {
        String query = String.format("select * from TB_EMAIL_USUARIO where id = %s", id);
        ResultSet rs = Dao.SelectCommand(query);

        try {
            while (rs.next()) {
                System.out.println(rs.getString("id"));
                System.out.println(rs.getString("senha"));
                System.out.println(rs.getString("recuperacao senha"));

                int ID_EMAIL = rs.getInt("ID_EMAIL");
                EmailService ds = new EmailService();
                ds.ExibirEmail(ID_EMAIL);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

}