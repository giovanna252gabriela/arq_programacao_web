package com.example.FipeRestApi.controller;


import com.example.FipeRestApi.service.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
    Service service = new Service();

    @GetMapping("/marcas")
    public String consultarMarcas(){
        return service.consultarMarcas();
    }
    @GetMapping("/modelos/{marca}")
    public String consultarModelos(@PathVariable int marca){ //pathvariable = parametros do método, ele vai extrair o valores e passar para esses parametros
        return service.consultarModelos(marca);
    }
    @GetMapping("/anos/{marca}/{modelo}")
    public String consultarAnos(@PathVariable int marca, @PathVariable int modelo){
        return service.consultarAnos(marca, modelo);
    }
    @GetMapping("/valor/{marca}/{modelo}/{ano}")
    public String consultarValor(@PathVariable int marca, @PathVariable int modelo, @PathVariable String ano){
        return service.consultarValor(marca, modelo, ano);
    }
}
