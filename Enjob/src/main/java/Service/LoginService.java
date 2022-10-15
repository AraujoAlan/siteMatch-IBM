package Service;

import java.sql.ResultSet;
import java.sql.SQLException;
import Model.Login;
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

@Path("/log")
public class LoginService {
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public static Response InserirLogin(Login l, @Context UriInfo uriInfo) throws SQLException {
        String query = "select max(ID_LOGIN) as id from TB_LOGIN";
        int id = 0;
        ResultSet rs = Dao.SelectCommand(query);
        while (rs.next()) {
            id = rs.getInt("id");
        }
        id++;

        query = String.format("insert into TB_LOGIN(ID_LOGIN, NM_EMAIL, NM_SENHA) values (%s,'%s', '%s')", id,
                l.getIdLogin(), l.getEmail(), l.getSenha());
        Dao.InsertUpdateDeleteCommand(query);

        UriBuilder builder = uriInfo.getAbsolutePathBuilder();
        builder.path(Integer.toString(l.getIdLogin()));
        return Response.created(builder.build()).build();
    }

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public static void AtualizarLogin(@PathParam("id") Login l) {
        String query = String.format("update ID_LOGIN set email = '%s', senha = '%s' where id = %s", l.getEmail(),
                l.getSenha());
        Dao.InsertUpdateDeleteCommand(query);
    }

    public static void ExcluirLogin(@PathParam("id") int id) {
        int ID_LOGIN = -1;

        String query = String.format("select * from TB_LOGIN where id = %s", id);
        ResultSet rs = Dao.SelectCommand(query);

        try {
            while (rs.next()) {
                ID_LOGIN = rs.getInt("ID_LOGIN");
            }
        } catch (Exception e) {
            System.out.println(e);
        }

        LoginService ds = new LoginService();
        ds.ExcluirLogin(ID_LOGIN);
    }

    public static void ExibirLogin(@PathParam("id") int id) {
        String query = String.format("select * from TB_LOGIN where id = %s", id);
        ResultSet rs = Dao.SelectCommand(query);

        try {
            while (rs.next()) {
                System.out.println(rs.getString("id"));
                System.out.println(rs.getString("email"));
                System.out.println(rs.getString("senha"));

                int ID_LOGIN = rs.getInt("ID_LOGIN");
                LoginService ds = new LoginService();
                ds.ExibirLogin(ID_LOGIN);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

}