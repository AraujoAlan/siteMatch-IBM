package Service;

import java.sql.ResultSet;
import java.sql.SQLException;
import Model.Idiomas;
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

@Path("/idi")
public class IdiomasService {
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public static Response InserirIdiomas(Idiomas i, @Context UriInfo uriInfo) throws SQLException {
        String query = "select max(ID_IDIOMAS) as id from TB_IDIOMAS";
        int id = 0;
        ResultSet rs = Dao.SelectCommand(query);
        while (rs.next()) {
            id = rs.getInt("id");
        }
        id++;

        query = String.format("insert into TB_IDIOMAS(ID_IDIOMAS, NM_IDIOMAS, NM_NIVEL) values (%s,'%s', '%s')", id,
                i.getIdIdioma(), i.getIdiomas(), i.getNivel());
        Dao.InsertUpdateDeleteCommand(query);

        UriBuilder builder = uriInfo.getAbsolutePathBuilder();
        builder.path(Integer.toString(i.getIdIdioma()));
        return Response.created(builder.build()).build();
    }

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public static void AtualizarIdiomas(@PathParam("id") Idiomas i) {
        String query = String.format("update ID_IDIOMAS set idioma = '%s', nivel = '%s' where id = %s", i.getIdiomas(),
                i.getNivel());
        Dao.InsertUpdateDeleteCommand(query);
    }

    public static void ExcluirIdiomas(@PathParam("id") int id) {
        int ID_IDIOMAS = -1;

        String query = String.format("select * from TB_IDIOMAS where id = %s", id);
        ResultSet rs = Dao.SelectCommand(query);

        try {
            while (rs.next()) {
                ID_IDIOMAS = rs.getInt("ID_IDIOMAS");
            }
        } catch (Exception e) {
            System.out.println(e);
        }

        IdiomasService ds = new IdiomasService();
        ds.ExcluirIdiomas(ID_IDIOMAS);
    }

    public static void ExibirIdiomas(@PathParam("id") int id) {
        String query = String.format("select * from TB_IDIOMAS where id = %s", id);
        ResultSet rs = Dao.SelectCommand(query);

        try {
            while (rs.next()) {
                System.out.println(rs.getString("id"));
                System.out.println(rs.getString("idioma"));
                System.out.println(rs.getString("nivel"));

                int ID_IDIOMAS = rs.getInt("ID_IDIOMAS");
                IdiomasService ds = new IdiomasService();
                ds.ExibirIdiomas(ID_IDIOMAS);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

}