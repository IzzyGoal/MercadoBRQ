package com.mercadobrq.www.MercadoBRQ.entrypoint.Controller;

import com.mercadobrq.www.MercadoBRQ.entrypoint.mapper.request.ProdutoEntrypointMapperRequest;
import com.mercadobrq.www.MercadoBRQ.entrypoint.mapper.response.ProdutoEntrypointMapperResponse;
import com.mercadobrq.www.MercadoBRQ.entrypoint.model.request.ProdutoModelRequest;
import com.mercadobrq.www.MercadoBRQ.entrypoint.model.response.ProdutoModelResponse;
import com.mercadobrq.www.MercadoBRQ.usecase.ProdutoUseCase;
import com.mercadobrq.www.MercadoBRQ.usecase.domain.request.ProdutoDomainRequest;
import com.mercadobrq.www.MercadoBRQ.usecase.domain.response.ProdutoDomainResponse;
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

     private final ProdutoUseCase produtoUseCase;

    /**
     * Recurso para adicionar uma categoria.
     * @param product {@code ProdutoModelRequest} -
     * @return ResponseEntity(produtoModelResponse)
     */
    @PostMapping
    public ResponseEntity<ProdutoModelResponse> addProduct(@RequestBody ProdutoModelRequest product) {
        ProdutoDomainRequest produtoDomainRequest = ProdutoEntrypointMapperRequest.toDomain(product);
        ProdutoDomainResponse produtoDomainResponse = produtoUseCase.addProduct(produtoDomainRequest);
        ProdutoModelResponse produtoModelResponse = ProdutoEntrypointMapperResponse.toModel(produtoDomainResponse);

        return ResponseEntity.status(HttpStatus.CREATED).body(produtoModelResponse);
    }

    /**
     * Recurso para pesquisar todos os produtos cadastrados
     * @return ResponseEntity(produtoModelResponses)
     */
    @GetMapping
    public ResponseEntity<List<ProdutoModelResponse>> searchProduct() {
        List<ProdutoDomainResponse> product = produtoUseCase.searchAll();
        List<ProdutoModelResponse> produtoModelResponses = ProdutoEntrypointMapperResponse.toCollectionModel(product);

        return ResponseEntity.ok(produtoModelResponses);
    }

    /**
     * Recurso para procurar um produto pelo seu ID.
     * @param idProduct {@code Long}-
     * @return ResponseEntity(ProdutoModelResponse).
     */
    @GetMapping("/{id}")
    public ResponseEntity<ProdutoModelResponse> findWithId(@PathVariable("id") Long idProduct) {
        ProdutoDomainResponse produtoDomainResponse = produtoUseCase.findProductWithId(idProduct);
        ProdutoModelResponse product = ProdutoEntrypointMapperResponse.toModel(produtoDomainResponse);

        return ResponseEntity.ok(product);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProdutoModelResponse> update(@PathVariable("id") Long idProduct,
                                                        @RequestBody ProdutoModelRequest productModel) {
        ProdutoDomainRequest productdomain = ProdutoEntrypointMapperRequest.toDomain(productModel);
        ProdutoDomainResponse productResponse = produtoUseCase.updateProduct(idProduct,productdomain);
        ProdutoModelResponse produtoModelResponse = ProdutoEntrypointMapperResponse.toModel(productResponse);

        return ResponseEntity.ok(produtoModelResponse);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable("id") Long idProduct) {
        produtoUseCase.deleteProduct(idProduct);

        return ResponseEntity.ok().build();
    }
}
