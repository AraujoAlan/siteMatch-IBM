package Service;

import java.sql.ResultSet;
import java.sql.SQLException;
import Model.Cursos;
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

@Path("/curso")
public class CursoService {
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public static Response InserirCurso(Cursos c, @Context UriInfo uriInfo) throws SQLException {
        String query = "select max(ID_CURSOS) as id from TB_CURSOS";
        int id = 0;
        ResultSet rs = Dao.SelectCommand(query);
        while (rs.next()) {
            id = rs.getInt("id");
        }
        id++;

        query = String.format(
                "insert into TB_CURSOS(ID_CURSOS, NM_CURSOS, NM_SITUCAO_CURSO, DT_INICIO_CURSO, DT_ABERTO_CURSO, DT_FIM_CURSO) values (%s,'%s', '%s',%s,%s,%s)",
                id, c.getIdCursos(), c.getCursos(), c.getSituacaoEscolaridade(), c.getDataInicio(), c.getDataAberto(),
                c.getDataFinalizacao());
        Dao.InsertUpdateDeleteCommand(query);

        UriBuilder builder = uriInfo.getAbsolutePathBuilder();
        builder.path(Integer.toString(c.getIdCursos()));
        return Response.created(builder.build()).build();
    }

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public static void AtualizarCurso(@PathParam("id") Cursos c) {
        String query = String.format(
                "update ID_CURSOS set cursos = '%s', nome curso = '%s', situacao curso = '%s', data inicio = %s, data aberto = %s, data fim = %s where id = %s",
                c.getIdCursos(), c.getCursos(), c.getSituacaoEscolaridade(), c.getDataInicio(), c.getDataAberto(),
                c.getDataFinalizacao());
        Dao.InsertUpdateDeleteCommand(query);
    }

    public static void ExcluirCurso(@PathParam("id") int id) {
        int ID_CURSOS = -1;

        String query = String.format("select * from TB_CURSOS where id = %s", id);
        ResultSet rs = Dao.SelectCommand(query);

        try {
            while (rs.next()) {
                ID_CURSOS = rs.getInt("ID_CURSOS");
            }
        } catch (Exception e) {
            System.out.println(e);
        }

        CursoService ds = new CursoService();
        ds.ExcluirCurso(ID_CURSOS);
    }

    public static void ExibirCurso(@PathParam("id") int id) {
        String query = String.format("select * from TB_CURSOS where id = %s", id);
        ResultSet rs = Dao.SelectCommand(query);

        try {
            while (rs.next()) {
                System.out.println(rs.getString("id"));
                System.out.println(rs.getString("cursos"));
                System.out.println(rs.getString("situacao curso"));
                System.out.println(rs.getString("data inicio"));
                System.out.println(rs.getString("data aberto"));
                System.out.println(rs.getString("data fim"));

                int ID_CURSOS = rs.getInt("ID_CURSOS");
                CursoService ds = new CursoService();
                ds.ExibirCurso(ID_CURSOS);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

}