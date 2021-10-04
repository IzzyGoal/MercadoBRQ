package com.mercadobrq.www.MercadoBRQ.entrypoint.Controller;

import com.mercadobrq.www.MercadoBRQ.entrypoint.mapper.response.CategoriaEntryopintMapperResponse;
import com.mercadobrq.www.MercadoBRQ.entrypoint.mapper.request.CategoriaEntrypointMapperRequest;
import com.mercadobrq.www.MercadoBRQ.entrypoint.model.request.CategoriaModelRequest;
import com.mercadobrq.www.MercadoBRQ.entrypoint.model.response.CategoriaModelResponse;
import com.mercadobrq.www.MercadoBRQ.usecase.CategoriaUseCase;
import com.mercadobrq.www.MercadoBRQ.usecase.domain.request.CategoriaDomainRequest;
import com.mercadobrq.www.MercadoBRQ.usecase.domain.response.CategoriaDomainResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

/**
 * Classe central responsavel por conter todos os recursos a ser requisitado pelo consumidor da aplicação.
 *
 * @author Gabriel Silva Lima
 * @since 30/09/2021.
 */
@AllArgsConstructor
@RestController
@RequestMapping(value="/categorias")
public class MercadoControler {

    private final CategoriaUseCase categoriaUseCase;

    /**
     *  Recurso para adicionar uma categoria.
     * @param categoriaModelRequest {@code CategoriaModelRequest} -
     * @return ResponseEntity - devolve Http 200 após a criação
     */
    @PostMapping
    public ResponseEntity<CategoriaModelResponse> add(@RequestBody CategoriaModelRequest categoriaModelRequest) {
       CategoriaDomainRequest categoriaDomainRequest = CategoriaEntrypointMapperRequest.toDomain(categoriaModelRequest);
       CategoriaDomainResponse categoriaDomainResponse = categoriaUseCase.cadastrarCategoria(categoriaDomainRequest);
       CategoriaModelResponse categoriaModelResponse = CategoriaEntryopintMapperResponse.toModel(categoriaDomainResponse);

       return ResponseEntity.status(HttpStatus.CREATED).body(categoriaModelResponse);
    }

    /**
     * Recurso para procurar uma categoria.
     * @return ResponseEntity - retorna a lista de categorias disponiveis
     */
    @GetMapping
    public ResponseEntity<List<CategoriaModelResponse>> search() {
        List<CategoriaDomainResponse> categoria = categoriaUseCase.buscarCategoria();
        List<CategoriaModelResponse> categoriaModel = CategoriaEntryopintMapperResponse.toCollectionModel(categoria);

        return ResponseEntity.ok(categoriaModel);
    }

    /**
     * Recurso para procurar uma categoria pelo seu ID.
     * @param idCategoria {@code Long} -
     * @return ResponseEntity - retorna a categoria correspondente.
     */
    @GetMapping("/{id}")
    public ResponseEntity<CategoriaModelResponse> findWithID(@PathVariable("id") Long idCategoria) {
        CategoriaDomainResponse categoriaDomainResponse =  categoriaUseCase.buscarCategoriaPorID(idCategoria);
        CategoriaModelResponse categoriaModelResponse = CategoriaEntryopintMapperResponse.toModel(categoriaDomainResponse);

        return ResponseEntity.ok(categoriaModelResponse);
    }

    /**
     * Recurso para adicionar as informações de uma categoria.
     * @param idCategoria {@code Long} -
     * @param categoriaModelRequest {@code CategoriaModelRequest} -
     * @return ResponseEntity - retorna 200 apos a atualização da categoria.
     */
    @PutMapping("/{id}")
    public ResponseEntity<CategoriaModelResponse> update(@PathVariable("id") Long idCategoria,
                                                         @RequestBody CategoriaModelRequest categoriaModelRequest) {
        CategoriaDomainRequest categoriaDomainnew = CategoriaEntrypointMapperRequest.toDomain(categoriaModelRequest);
        CategoriaDomainResponse categoriaDomainResponse = categoriaUseCase.atualizarCategoria(idCategoria,categoriaDomainnew);
        CategoriaModelResponse categoriaModelResponse = CategoriaEntryopintMapperResponse.toModel(categoriaDomainResponse);

        return ResponseEntity.ok(categoriaModelResponse);
    }

    /**
     * Rceurso para deletar uma categoria
     * @param idCategoria {@code Long} -
     * @return ResponseEntity apos a deleção retorna um obejto vazio VOID.
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCategory(@PathVariable("id") Long idCategoria) {
        categoriaUseCase.removerCategoriaPorID(idCategoria);

        return ResponseEntity.ok().build();
    }
}
