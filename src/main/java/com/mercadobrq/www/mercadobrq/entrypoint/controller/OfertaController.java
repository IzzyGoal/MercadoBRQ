package com.mercadobrq.www.mercadobrq.entrypoint.controller;

import com.mercadobrq.www.mercadobrq.entrypoint.mapper.response.OfertaEntrypointMapperResponse;
import com.mercadobrq.www.mercadobrq.entrypoint.model.response.ProdutoModelResponseShort;
import com.mercadobrq.www.mercadobrq.usecase.OfertaUseCase;
import com.mercadobrq.www.mercadobrq.usecase.domain.response.ProdutoDomainResponse;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping(value = "/ofertas")
public class OfertaController {
    private final OfertaUseCase ofertaUseCase;

    @GetMapping
    public ResponseEntity<Page<ProdutoModelResponseShort>> findAllOff(Pageable pageable){
        Page<ProdutoDomainResponse> produtoDomainResponses = ofertaUseCase.findAllOffers(pageable);
        Page<ProdutoModelResponseShort> produtoModelResponseShortPage = OfertaEntrypointMapperResponse.toCollection(produtoDomainResponses);

        return ResponseEntity.ok(produtoModelResponseShortPage);
    }
}
