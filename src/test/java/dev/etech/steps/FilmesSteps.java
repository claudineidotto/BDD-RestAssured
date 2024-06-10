package dev.etech.steps;

import dev.etech.endpoints.FilmesEndpoint;
import dev.etech.pojo.usuarios.UsuarioResponse;
import io.cucumber.java.es.Dado;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;
import io.restassured.response.Response;

import java.io.IOException;

public class FilmesSteps {
    private FilmesEndpoint filmesEndpoint= new FilmesEndpoint();
    private String payload;
    private Response response;
    @Dado("que o payload foi criado com dados validos de um filme")
    public void queOpayloadFoiCriadoComDadosValidosDeUmFilme() throws IOException {
        payload = filmesEndpoint.carregaPayloadFilmesSucesso();
    }

    @Quando("envia a requisição para criar o filme")
    public void enviaARequisiçãoParaCriarOFilme() {
        response=filmesEndpoint.realizaInsercaoFilme(payload);
    }


    @Então("deve visualizar a mensagem de sucesso na criação do filme")
    public void deveVisualizarAMensagemDeSucessoNaCriaçãoDoFilme() {
         filmesEndpoint.validaSucessoInsercaoFilmes(response.getBody().as(UsuarioResponse.class));
    }
}
