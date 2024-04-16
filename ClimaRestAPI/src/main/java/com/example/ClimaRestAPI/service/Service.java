package com.example.ClimaRestAPI.service;

import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class Service {

    public String preverTempo() {
        String dadosMetereologicos = "";
        String apiUrl = "https://apiadvisor.climatempo.com.br/api/v1/anl/synoptic/locale/BR?token=9fe25332679ebce952fdd9f7f9a83c3e";

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> responseEntity = restTemplate.getForEntity(apiUrl, String.class);

        if (responseEntity.getStatusCode().is2xxSuccessful()) { //2xx = 200(certo), tem tb 500(erro interno) e 404(pg n encontrada)
            dadosMetereologicos = responseEntity.getBody();
        } else{
            dadosMetereologicos = "falha ao obter dados. cod de status: " + responseEntity.getStatusCode();

        }
        return dadosMetereologicos;
    }
}
