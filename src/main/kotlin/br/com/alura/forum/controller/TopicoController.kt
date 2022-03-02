package br.com.alura.forum.controller

import br.com.alura.forum.dto.NovoTopicoForm
import br.com.alura.forum.dto.TopicoView
import br.com.alura.forum.service.TopicoService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import javax.validation.Valid

@RestController //para receber dados e devolver dados
@RequestMapping ("/topicos") //para usar URI, qualquer requisição que chegar barra tópicos  é pra essa classe tratar
class TopicoController(private val service: TopicoService){ //spring jka sabe q quando iniciar o controler, ele depende do topoco service

    @GetMapping //se a requisição for do tipo GET, cai nesse método
    fun listar(): List<TopicoView> { //o metodo devolve um list de topicos
       return service.Listar()
    }

    @GetMapping("/{id}")//quando a uri for barra topicos barra id
    fun buscarPorId(@PathVariable id: Long): TopicoView { //PathVariable dizendo q o id do path é esse id
        return service.buscarPorId(id)
    }


    @PostMapping
    fun cadastrar(@RequestBody @Valid dto: NovoTopicoForm) { //pesquisa o topico no corpo da requisição
        service.cadastrar(dto)
    }
}