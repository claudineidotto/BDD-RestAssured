package dev.etech.endpoints;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import dev.etech.config.RestConfig;
import dev.etech.pojo.usuarios.Endereco;
import dev.etech.pojo.usuarios.UsuarioResponse;
import dev.etech.pojo.usuarios.UsuariosRequest;
import dev.etech.utils.TestDataGenerator;
import io.restassured.http.Method;
import io.restassured.response.Response;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class UsuariosEndpoint extends RestConfig {
    private UsuariosRequest usuariosRequest = new UsuariosRequest();
    private Endereco endereco = new Endereco();
    private ObjectMapper objectMapper = new ObjectMapper();

    //  private TestDataGenerator testDataGenerator= new TestDataGenerator();
    public String carregaPayloadNovoUsuario() throws JsonProcessingException {

        usuariosRequest.setNome(TestDataGenerator.gerarNomeAleatorio());
        usuariosRequest.setApelido("Marcos QA");
        usuariosRequest.setTelefone("11999911112");
        usuariosRequest.setDataNascimento("2020-12-12T00:00:00.000Z");
        usuariosRequest.setEmail(TestDataGenerator.gerarEmailAleatorio());
        usuariosRequest.setSenha("Teste@123");

        endereco.setCep("07120000");
        endereco.setRua("Rua Teste");
        endereco.setBairro("Bairro Teste");
        endereco.setCidade("Guarulhos");
        endereco.setEstado("SP");

        usuariosRequest.setEndereco(endereco);

        usuariosRequest.setGoogleId("sadrwsdfasdgvasdfasdc");

        return objectMapper.writeValueAsString(usuariosRequest);
    }
    public String carregaPayloadUsuarioExistente() throws JsonProcessingException {

        usuariosRequest.setNome(TestDataGenerator.gerarNomeAleatorio());
        usuariosRequest.setApelido("Marcos QA");
        usuariosRequest.setTelefone("11999911112");
        usuariosRequest.setDataNascimento("2020-12-12T00:00:00.000Z");
        usuariosRequest.setEmail("teste@teste12321.com.br");
        usuariosRequest.setSenha("Teste@123");

        endereco.setCep("07120000");
        endereco.setRua("Rua Teste");
        endereco.setBairro("Bairro Teste");
        endereco.setCidade("Guarulhos");
        endereco.setEstado("SP");

        usuariosRequest.setEndereco(endereco);

        usuariosRequest.setGoogleId("sadrwsdfasdgvasdfasdc");

        return objectMapper.writeValueAsString(usuariosRequest);
    }

    public Response createNewUser(String payload) {
        response = request
                .body(payload)
                .when()
                .request(Method.POST, "/usuarios");

        return response;
    }

    public int obterStatusCode() {
        return response.getStatusCode();
    }

//    public void validaCadastroSucesso(Response responseData){
//          responseData.then()
//                  .log().all()
//                  .statusCode(201)
//                  .body("mensagem",equalTo("Usuário criado com sucesso."))
//                  .body("dados.nome",equalTo(usuariosRequest.getNome()))
//                  .body("timestamp",is(notNullValue()))
//                  .body("dados._id",is(notNullValue()))
//                  .body("dados.email",equalTo(usuariosRequest.getEmail()));
//
//    }

    public void validaCadastroSucesso(UsuarioResponse responseData) {
        assertThat(responseData.getMensagem(), equalTo("Usuário criado com sucesso."));
        assertThat(responseData.getDados().getNome(), equalTo(usuariosRequest.getNome()));
        assertThat(responseData.getDados().getApelido(), equalTo(usuariosRequest.getApelido()));

    }

    public void validaMensagemUsuarioExistente(String mensagemAtual,String mensagemEsperada){
        assertThat(mensagemAtual,is(mensagemEsperada));
    }
}