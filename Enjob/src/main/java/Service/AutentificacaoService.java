package Service;

import java.sql.ResultSet;
import java.sql.SQLException;
import Model.Autenticacao;
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

@Path("/auth")
public class AutentificacaoService {
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public static Response InserirAutenticacao(Autenticacao a, @Context UriInfo uriInfo) throws SQLException {
        String query = "select max(ID_AUTENTICACAO) as id from TB_AUTENTICACAO_LOGIN";
        int id = 0;
        ResultSet rs = Dao.SelectCommand(query);
        while (rs.next()) {
            id = rs.getInt("id");
        }
        id++;

        query = String.format("insert into TB_AUTENTICACAO_LOGIN(ID_AUTENTICACAO, NR_TOKEN) values (%s,'%s')", id,
                a.getIdAutenticacao(), a.getToken());
        Dao.InsertUpdateDeleteCommand(query);

        UriBuilder builder = uriInfo.getAbsolutePathBuilder();
        builder.path(Integer.toString(a.getIdAutenticacao()));
        return Response.created(builder.build()).build();
    }

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public static void AtualizarAutenticacao(@PathParam("id") Autenticacao a) {
        String query = String.format(
                "update ID_AUTENTICACAO set autenticacao = '%s', ddi = '%s', ddd = %s, telefone = %s",
                a.getIdAutenticacao(), a.getToken());
        Dao.InsertUpdateDeleteCommand(query);
    }

    @DELETE
    @Path("/{id}")
    public static void ExcluirAutenticacao(@PathParam("id") int id) {
        int ID_AUTENTICACAO = -1;

        String query = String.format("select * from TB_AUTENTICACAO_LOGIN where id = %s", id);
        ResultSet rs = Dao.SelectCommand(query);

        try {
            while (rs.next()) {
                ID_AUTENTICACAO = rs.getInt("ID_AUTENTICACAO");
            }
        } catch (Exception e) {
            System.out.println(e);
        }

        AutentificacaoService ds = new AutentificacaoService();
        ds.ExcluirAutenticacao(ID_AUTENTICACAO);
    }

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public static void ExibirAutenticacao(@PathParam("id") int id) {
        String query = String.format("select * from TB_AUTENTICACAO_LOGIN where id = %s", id);
        ResultSet rs = Dao.SelectCommand(query);

        try {
            while (rs.next()) {
                System.out.println(rs.getString("id"));
                System.out.println(rs.getString("token"));

                int ID_AUTENTICACAO = rs.getInt("ID_AUTENTICACAO");
                AutentificacaoService ds = new AutentificacaoService();
                ds.ExibirAutenticacao(ID_AUTENTICACAO);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

}