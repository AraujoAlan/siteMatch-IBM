package Service;

import java.sql.ResultSet;
import java.sql.SQLException;
import Model.Certificacao;
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

@Path("/cert")
public class CertificacaoService {
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public static Response InserirContatos(Certificacao ce, @Context UriInfo uriInfo) throws SQLException {
        String query = "select max(ID_CONTATO) as id from TB_CONTATO";
        int id = 0;
        ResultSet rs = Dao.SelectCommand(query);
        while (rs.next()) {
            id = rs.getInt("id");
        }
        id++;

        query = String.format("insert into TB_CONTATO(ID_CONTATO, NR_DDI, NR_DDD, NR_TELEFONE) values (%s,'%s',%s,%s)",
                id, ce.getIdCertificado());
        Dao.InsertUpdateDeleteCommand(query);

        UriBuilder builder = uriInfo.getAbsolutePathBuilder();
        builder.path(Integer.toString(ce.getIdCertificado()));
        return Response.created(builder.build()).build();
    }

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public static void AtualizarContatos(@PathParam("id") Certificacao ce) {
        String query = String.format("update ID_CONTATO set contatos = '%s', ddi = '%s', ddd = %s, telefone = %s",
                ce.getIdCertificado());
        Dao.InsertUpdateDeleteCommand(query);
    }

    public static void ExcluirContatos(@PathParam("id") int id) {
        int ID_CONTATO = -1;

        String query = String.format("select * from TB_CONTATO where id = %s", id);
        ResultSet rs = Dao.SelectCommand(query);

        try {
            while (rs.next()) {
                ID_CONTATO = rs.getInt("ID_CONTATO");
            }
        } catch (Exception e) {
            System.out.println(e);
        }

        CertificacaoService ds = new CertificacaoService();
        ds.ExcluirContatos(ID_CONTATO);
    }

    public static void ExibirContatos(@PathParam("id") int id) {
        String query = String.format("select * from TB_CONTATO where id = %s", id);
        ResultSet rs = Dao.SelectCommand(query);

        try {
            while (rs.next()) {
                System.out.println(rs.getString("id"));
                System.out.println(rs.getString("ddi"));
                System.out.println(rs.getString("ddd"));
                System.out.println(rs.getString("telefone"));

                int ID_CONTATO = rs.getInt("ID_CONTATO");
                CertificacaoService ds = new CertificacaoService();
                ds.ExibirContatos(ID_CONTATO);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

}