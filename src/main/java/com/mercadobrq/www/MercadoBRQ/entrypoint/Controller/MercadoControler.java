package com.mercadobrq.www.MercadoBRQ.entrypoint.Controller;

import com.mercadobrq.www.MercadoBRQ.dataprovider.mapper.CategoriaMapperRequest;
import com.mercadobrq.www.MercadoBRQ.dataprovider.mapper.CategoriaMapperResponse;
import com.mercadobrq.www.MercadoBRQ.entrypoint.Controller.model.CategoriaModelRequest;
import com.mercadobrq.www.MercadoBRQ.entrypoint.Controller.model.CategoriaModelResponse;
import com.mercadobrq.www.MercadoBRQ.usecase.CategoriaDomainRequest;
import com.mercadobrq.www.MercadoBRQ.usecase.CategoriaDomainResponse;
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
       CategoriaDomainRequest categoriaDomainRequest = CategoriaMapperRequest.toDomain(categoriaModelRequest);
       CategoriaDomainResponse categoriaDomainResponse = categoriaUseCase.cadastrarCategoria(categoriaDomainRequest);
       CategoriaModelResponse categoriaModelResponse = CategoriaMapperResponse.toModel(categoriaDomainResponse);

       return ResponseEntity.status(HttpStatus.CREATED).body(categoriaModelResponse);
    }

    @GetMapping
    public ResponseEntity<List<CategoriaModelResponse>> search() {
        List<CategoriaDomainResponse> categoriaDomain = categoriaUseCase.buscarCategoria();
        List<CategoriaModelResponse> categoriaModel = CategoriaMapperResponse.toCollectionsModel(categoriaDomain);

        return ResponseEntity.ok(categoriaModel);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CategoriaModelResponse> findWithID(@PathVariable("id") Long idCategoria,
                                                         @RequestBody CategoriaModelRequest categoriaModelRequest) {
        CategoriaDomainResponse categoriaDomainResponse =  categoriaUseCase.buscarCategoriaPorID(idCategoria);
        CategoriaModelResponse categoriaModelResponse = CategoriaMapperResponse.toModel(categoriaDomainResponse);

        return ResponseEntity.ok(categoriaModelResponse);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CategoriaModelResponse> update(@PathVariable("id") Long idCategoria,
                                                         @RequestBody CategoriaModelRequest categoriaModelRequest) {
        CategoriaDomainRequest categoriaDomainnew = CategoriaMapperRequest.toDomain(categoriaModelRequest);
        CategoriaDomainResponse categoriaDomainResponse = categoriaUseCase.atualizarCategoria(idCategoria,categoriaDomainnew);
        CategoriaModelResponse categoriaModelResponse = CategoriaMapperResponse.toModel(categoriaDomainResponse);

        return ResponseEntity.ok(categoriaModelResponse);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCategory(@PathVariable("id") Long idCategoria) {
        categoriaUseCase.removerCategoriaPorID(idCategoria);

        return ResponseEntity.noContent().build();
    }
}
