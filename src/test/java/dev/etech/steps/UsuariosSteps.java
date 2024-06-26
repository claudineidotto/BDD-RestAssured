package dev.etech.steps;

import com.fasterxml.jackson.core.JsonProcessingException;
import dev.etech.endpoints.UsuariosEndpoint;
import dev.etech.pojo.usuarios.UsuarioResponse;
import io.cucumber.java.es.Dado;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;
import io.restassured.response.Response;

public class UsuariosSteps {
    private UsuariosEndpoint usuariosEndpoint = new UsuariosEndpoint();
    String jsonPayload;
    private Response responseData;
    @Dado("que o payload possua dados de um novo usuário")
    public void que_o_payload_possua_dados_de_um_usuario() throws JsonProcessingException {
        jsonPayload = usuariosEndpoint.carregaPayloadNovoUsuario();
    }

    @Quando("realizar a criação de um novo usuário")
    public void realizarACriaçãoDeUmNovoUsuário() {
        responseData = usuariosEndpoint.createNewUser(jsonPayload);

    }

    @Então("deve validar  o status code {string}")
    public void deveValidarOStatusCode(String arg0) {
    }

    @Então("deve criar o usuario com sucesso")
    public void deveCriarOUsuarioComSucesso() {
        usuariosEndpoint.validaCadastroSucesso(responseData.getBody().as(UsuarioResponse.class));
    }

    @Dado("que o payload possua dados de um novo usuário com email existente")
    public void queOPayloadPossuaDadosDeUmNovoUsuárioComEmailExistente() throws JsonProcessingException {
        jsonPayload = usuariosEndpoint.carregaPayloadUsuarioExistente();
    }

    @Então("deve visualizar a mensagem {string}")
    public void deveVisualizarAMensagem(String mensagemEsperada) {
        usuariosEndpoint.validaMensagemUsuarioExistente(
                responseData.getBody().as(UsuarioResponse.class).getMensagem(),mensagemEsperada);
    }
}


