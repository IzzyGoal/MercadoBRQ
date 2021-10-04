package com.mercadobrq.www.MercadoBRQ.entrypoint.Controller;

import com.mercadobrq.www.MercadoBRQ.entrypoint.mapper.request.ProdutoEntrypointMapperRequest;
import com.mercadobrq.www.MercadoBRQ.entrypoint.mapper.response.ProdutoEntrypointMapperResponse;
import com.mercadobrq.www.MercadoBRQ.entrypoint.model.request.ProdutoModelRequest;
import com.mercadobrq.www.MercadoBRQ.entrypoint.model.response.ProdutoModelResponse;
import com.mercadobrq.www.MercadoBRQ.usecase.domain.request.ProdutoDomainRequest;
import com.mercadobrq.www.MercadoBRQ.usecase.domain.response.ProdutoDomainResponse;
import com.mercadobrq.www.MercadoBRQ.usecase.gateway.ProdutoUseCase;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Classe central responsavel por conter todos os recursos a ser requisitado pelo consumidor da aplicação.
 *
 * @author Gabriel Silva Lima
 * @since 04/10/2021.
 */
@AllArgsConstructor
@RestController
@RequestMapping(value="/produtos")
public class ProdutoController {

     private ProdutoUseCase produtoUseCase;

    @PostMapping
    public ResponseEntity<ProdutoModelResponse> addProduct(@RequestBody ProdutoModelRequest product) {
        ProdutoDomainRequest produtoDomainRequest = ProdutoEntrypointMapperRequest.toDomain(product);
        ProdutoDomainResponse produtoDomainResponse = produtoUseCase.addProduct(produtoDomainRequest);
        ProdutoModelResponse produtoModelResponse = ProdutoEntrypointMapperResponse.toModel(produtoDomainResponse);

        return ResponseEntity.status(HttpStatus.CREATED).body(produtoModelResponse);
    }

    @GetMapping
    public ResponseEntity<List<ProdutoModelResponse>> searchProduct() {
        List<ProdutoDomainResponse> product = produtoUseCase.searchAll();
        List<ProdutoModelResponse> produtoModelResponses = ProdutoEntrypointMapperResponse.toCollectionModel(product);

        return ResponseEntity.ok(produtoModelResponses);
    }
}
