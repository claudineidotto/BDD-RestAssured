package dev.etech.endpoints;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import dev.etech.config.RestConfig;
import dev.etech.pojo.EnderecoPojo;
import dev.etech.pojo.UsuariosPOJO;
import io.restassured.http.Method;
import io.restassured.response.Response;

public class UsuariosEndpoint extends RestConfig {
    private UsuariosPOJO usuariosPOJO= new UsuariosPOJO();
    private EnderecoPojo enderecoPojo= new EnderecoPojo();
    private ObjectMapper objectMapper= new ObjectMapper();
    public String carregaPayloadNovoUsuario() throws JsonProcessingException {

        usuariosPOJO.setNome("marcos barbosa");
        usuariosPOJO.setApelido("Marcos QA");
        usuariosPOJO.setTelefone("11999911111");
        usuariosPOJO.setDataNascimento("2020-12-12T00:00:00.000Z");
        usuariosPOJO.setEmail("teste@teste.com");
        usuariosPOJO.setSenha("Teste@123");

        enderecoPojo.setCep("07125000");
        enderecoPojo.setRua("Rua Teste");
        enderecoPojo.setBairro("Bairro Teste");
        enderecoPojo.setCidade("Guarulhos");
        enderecoPojo.setEstado("São Paulo");

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

    }

}
