package dev.etech.steps;

import com.fasterxml.jackson.core.JsonProcessingException;
import dev.etech.endpoints.AuthEndpoint;
import dev.etech.pojo.usuarios.UsuarioResponse;
import io.cucumber.java.es.Dado;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import io.restassured.response.Response;

import java.io.IOException;

public class LoginSteps {
    private AuthEndpoint authEndpoint= new AuthEndpoint();
    private String payload;
    private Response response;
    @Dado("que o payload foi criado com dados validos de login")
    public void que_o_payload_foi_criado_com_dados_validos_de_login() throws IOException {
        payload=authEndpoint.carregaPayloadLoginSucesso();
    }

    @Quando("realizar a chamada de login")
    public void realizarAChamadaDeLogin() {
        response = authEndpoint.realizLogin(payload);
    }

    @Entao("deve visualizar a mensagem de login {string}")
    public void deveVisualizarAMensagemDeLogin(String mensagem) {
        authEndpoint.validaLoginSucesso(response.getBody().as(UsuarioResponse.class),mensagem);
    }

    @Dado("que o payload foi criado com dados invalidos de login")
    public void queOPayloadFoiCriadoComDadosInvalidosDeLogin() throws IOException {
        payload=authEndpoint.carregaPayloadLoginFalha();
    }

    @Dado("que o payload foi criado com dados somente do email")
    public void queOPayloadFoiCriadoComDadosSomenteDoEmail() throws IOException {
        payload=authEndpoint.carregaPayloadLoginSemSenha();
    }
}
