package Service;

import java.sql.ResultSet;
import java.sql.SQLException;
import Model.Endereco;
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

@Path("/end")
public class EnderecoService {
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public static Response InserirEndereco(Endereco en, @Context UriInfo uriInfo) throws SQLException {
        String query = "select max(ID_ENDERECO) as id from TB_USUARIO_ENDERECO";
        int id = 0;
        ResultSet rs = Dao.SelectCommand(query);
        while (rs.next()) {
            id = rs.getInt("id");
        }
        id++;

        query = String.format(
                "insert into TB_USUARIO_ENDERECO(ID_ENDERECO, NR_CEP, NM_LOGRADOURO, NR_NUMERO, NM_COMPLEMENTO, NM_PONTO_REFERENCIA) values (%s,'%s', %s, '%s', '%s', '%s')",
                id, en.getIdEndereco(), en.getCep(), en.getLogradouro(), en.getNumero(), en.getComplemento(),
                en.getPontoReferencia());
        Dao.InsertUpdateDeleteCommand(query);

        UriBuilder builder = uriInfo.getAbsolutePathBuilder();
        builder.path(en.getIdEndereco());
        return Response.created(builder.build()).build();
    }

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public static void AtualizarEndereco(@PathParam("id") Endereco en) {
        String query = String.format(
                "update ID_ENDERECO set endereco = '%s', cep = %s, logradouro = '%s', numero = %s, complemento = '%s', ponto referencia = '%s' where id = %s",
                en.getIdEndereco(), en.getCep(), en.getLogradouro(), en.getNumero(), en.getComplemento(),
                en.getPontoReferencia());
        Dao.InsertUpdateDeleteCommand(query);
    }

    public static void ExcluirEndereco(@PathParam("id") int id) {
        int ID_ENDERECO = -1;

        String query = String.format("select * from TB_USUARIO_ENDERECO where id = %s", id);
        ResultSet rs = Dao.SelectCommand(query);

        try {
            while (rs.next()) {
                ID_ENDERECO = rs.getInt("ID_ENDERECO");
            }
        } catch (Exception e) {
            System.out.println(e);
        }

        EnderecoService ds = new EnderecoService();
        ds.ExcluirEndereco(ID_ENDERECO);
    }

    public static void ExibirEndereco(@PathParam("id") int id) {
        String query = String.format("select * from TB_USUARIO_ENDERECO where id = %s", id);
        ResultSet rs = Dao.SelectCommand(query);

        try {
            while (rs.next()) {
                System.out.println(rs.getString("id"));
                System.out.println(rs.getString("endereco"));
                System.out.println(rs.getString("cep"));
                System.out.println(rs.getString("logradouro"));
                System.out.println(rs.getString("numero"));
                System.out.println(rs.getString("complemento"));
                System.out.println(rs.getString("ponto referencia"));

                int ID_ENDERECO = rs.getInt("ID_ENDERECO");
                EnderecoService ds = new EnderecoService();
                ds.ExibirEndereco(ID_ENDERECO);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

}