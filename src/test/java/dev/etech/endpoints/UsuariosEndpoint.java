package dev.etech.endpoints;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import dev.etech.config.RestConfig;
import dev.etech.pojo.EnderecoPojo;
import dev.etech.pojo.UsuariosPOJO;
import dev.etech.utils.TestDataGenerator;
import io.restassured.http.Method;
import io.restassured.response.Response;

import static org.hamcrest.Matchers.*;

public class UsuariosEndpoint extends RestConfig {
    private UsuariosPOJO usuariosPOJO= new UsuariosPOJO();
    private EnderecoPojo enderecoPojo= new EnderecoPojo();
    private ObjectMapper objectMapper= new ObjectMapper();
  //  private TestDataGenerator testDataGenerator= new TestDataGenerator();
    public String carregaPayloadNovoUsuario() throws JsonProcessingException {

        usuariosPOJO.setNome(TestDataGenerator.gerarNomeAleatorio());
        usuariosPOJO.setApelido("Marcos QA");
        usuariosPOJO.setTelefone("11999911112");
        usuariosPOJO.setDataNascimento("2020-12-12T00:00:00.000Z");
        usuariosPOJO.setEmail(TestDataGenerator.gerarEmailAleatorio());
        usuariosPOJO.setSenha("Teste@123");

        enderecoPojo.setCep("07120000");
        enderecoPojo.setRua("Rua Teste");
        enderecoPojo.setBairro("Bairro Teste");
        enderecoPojo.setCidade("Guarulhos");
        enderecoPojo.setEstado("SP");

        usuariosPOJO.setEndereco(enderecoPojo);

        usuariosPOJO.setGoogleId("sadrwsdfasdgvasdfasdc");

        return objectMapper.writeValueAsString(usuariosPOJO);
    }

    public Response createNewUser (String payload){
        response =request
                .body(payload)
                .when()
                .request(Method.POST,"/usuarios");

        return response;
    }

    public int obterStatusCode(){
        return response.getStatusCode();
    }
    public void validaCadastroSucesso(Response responseData){
          responseData.then()
                  .statusCode(201)
                  .body("mensagem",equalTo("Usuário criado com sucesso."));

    }

}
