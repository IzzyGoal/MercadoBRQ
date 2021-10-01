package com.mercadobrq.www.MercadoBRQ.entrypoint.Controller;

import com.mercadobrq.www.MercadoBRQ.dataprovider.mapper.CategoriaMapperRequest;
import com.mercadobrq.www.MercadoBRQ.dataprovider.mapper.CategoriaMapperResponse;
import com.mercadobrq.www.MercadoBRQ.entrypoint.mapper.CategoriaEntryopintMapperResponse;
import com.mercadobrq.www.MercadoBRQ.entrypoint.mapper.CategoriaEntrypointMapperRequest;
import com.mercadobrq.www.MercadoBRQ.entrypoint.model.CategoriaModelRequest;
import com.mercadobrq.www.MercadoBRQ.entrypoint.model.CategoriaModelResponse;
import com.mercadobrq.www.MercadoBRQ.usecase.domain.CategoriaDomainRequest;
import com.mercadobrq.www.MercadoBRQ.usecase.domain.CategoriaDomainResponse;
import com.mercadobrq.www.MercadoBRQ.usecase.CategoriaUseCase;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping(value="/categorias")
public class MercadoControler {

    private final CategoriaUseCase categoriaUseCase;

    @PostMapping
    public ResponseEntity<CategoriaModelResponse> add(@RequestBody CategoriaModelRequest categoriaModelRequest) {
       CategoriaDomainRequest categoriaDomainRequest = CategoriaEntrypointMapperRequest.toDomain(categoriaModelRequest);
       CategoriaDomainResponse categoriaDomainResponse = categoriaUseCase.cadastrarCategoria(categoriaDomainRequest);
       CategoriaModelResponse categoriaModelResponse = CategoriaEntryopintMapperResponse.toModel(categoriaDomainResponse);

       return ResponseEntity.status(HttpStatus.CREATED).body(categoriaModelResponse);
    }

    @GetMapping
    public ResponseEntity<List<CategoriaModelResponse>> search() {
        List<CategoriaDomainResponse> categoriaDomain = categoriaUseCase.buscarCategoria();
        List<CategoriaModelResponse> categoriaModel = CategoriaEntryopintMapperResponse.toCollectionModel(categoriaDomain);

        return ResponseEntity.ok(categoriaModel);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CategoriaModelResponse> findWithID(@PathVariable("id") Long idCategoria,
                                                         @RequestBody CategoriaModelRequest categoriaModelRequest) {
        CategoriaDomainResponse categoriaDomainResponse =  categoriaUseCase.buscarCategoriaPorID(idCategoria);
        CategoriaModelResponse categoriaModelResponse = CategoriaEntryopintMapperResponse.toModel(categoriaDomainResponse);

        return ResponseEntity.ok(categoriaModelResponse);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CategoriaModelResponse> update(@PathVariable("id") Long idCategoria,
                                                         @RequestBody CategoriaModelRequest categoriaModelRequest) {
        CategoriaDomainRequest categoriaDomainnew = CategoriaEntrypointMapperRequest.toDomain(categoriaModelRequest);
        CategoriaDomainResponse categoriaDomainResponse = categoriaUseCase.atualizarCategoria(idCategoria,categoriaDomainnew);
        CategoriaModelResponse categoriaModelResponse = CategoriaEntryopintMapperResponse.toModel(categoriaDomainResponse);

        return ResponseEntity.ok(categoriaModelResponse);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCategory(@PathVariable("id") Long idCategoria) {
        categoriaUseCase.removerCategoriaPorID(idCategoria);

        return ResponseEntity.noContent().build();
    }
}
