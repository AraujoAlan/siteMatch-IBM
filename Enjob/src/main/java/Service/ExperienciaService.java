package Service;

import java.sql.ResultSet;
import java.sql.SQLException;
import Model.Experiencia;
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

@Path("/exp")
public class ExperienciaService {
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public static Response InserirExperiencia(Experiencia e, @Context UriInfo uriInfo) throws SQLException {
        String query = "select max(ID_EXPERIENCIA) as id from TB_EXPERIENCIA";
        int id = 0;
        ResultSet rs = Dao.SelectCommand(query);
        while (rs.next()) {
            id = rs.getInt("id");
        }
        id++;

        query = String.format(
                "insert into TB_EXPERIENCIA(ID_EXPERIENCIA, NM_EMPRESA, NM_COMENTARIOS_EXPERIENCIA, DT_PERIODO_INICIO, DT_PERIODO_ABERTO, DT_PERIODO_FIM) values (%s,'%s', '%s', %s, %s, %s)",
                id, e.getIdExperiencia(), e.getNomeEmpresa(), e.getComentariosExperiencia(), e.getPeriodoAberto(),
                e.getPeriodoAberto(), e.getPeriodoFim());
        Dao.InsertUpdateDeleteCommand(query);

        UriBuilder builder = uriInfo.getAbsolutePathBuilder();
        builder.path(Integer.toString(e.getIdExperiencia()));
        return Response.created(builder.build()).build();
    }

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public static void AtualizarExperiencia(@PathParam("id") Experiencia e) {
        String query = String.format(
                "update ID_EXPERIENCIA set experiencia = '%s', nome empresa = '%s', comentarios experiencia = '%s', data periodo inicio = %s, data periodo aberto = %s, data periodo fim = %s where id = %s",
                e.getIdExperiencia(), e.getNomeEmpresa(), e.getComentariosExperiencia(), e.getPeriodoAberto(),
                e.getPeriodoAberto(), e.getPeriodoFim());
        Dao.InsertUpdateDeleteCommand(query);
    }

    public static void ExcluirExperiencia(@PathParam("id") int id) {
        int ID_EXPERIENCIA = -1;

        String query = String.format("select * from TB_EXPERIENCIA where id = %s", id);
        ResultSet rs = Dao.SelectCommand(query);

        try {
            while (rs.next()) {
                ID_EXPERIENCIA = rs.getInt("ID_EXPERIENCIA");
            }
        } catch (Exception e) {
            System.out.println(e);
        }

        ExperienciaService ds = new ExperienciaService();
        ds.ExcluirExperiencia(ID_EXPERIENCIA);
    }

    public static void ExibirExperiencia(@PathParam("id") int id) {
        String query = String.format("select * from TB_EXPERIENCIA where id = %s", id);
        ResultSet rs = Dao.SelectCommand(query);

        try {
            while (rs.next()) {
                System.out.println(rs.getString("id"));
                System.out.println(rs.getString("nome empresa"));
                System.out.println(rs.getString("comentarios experiencias"));
                System.out.println(rs.getString("data inicio periodo"));
                System.out.println(rs.getString("data aberto periodo"));
                System.out.println(rs.getString("data fim periodo"));

                int ID_EXPERIENCIA = rs.getInt("ID_EXPERIENCIA");
                ExperienciaService ds = new ExperienciaService();
                ds.ExibirExperiencia(ID_EXPERIENCIA);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

}