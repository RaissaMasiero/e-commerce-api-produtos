package br.senac.ecommerceapiprodutos.produto;

import br.senac.ecommerceapiprodutos.categoria.Categoria;
import br.senac.ecommerceapiprodutos.categoria.CategoriaRepresentation;
import br.senac.ecommerceapiprodutos.categoria.CategoriaService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/produto")
@AllArgsConstructor
public class ProdutoController {

    private final ProdutoService produtoService;
    private final CategoriaService categoriaService;

    @PostMapping("/")
    public ResponseEntity<ProdutoRepresentation.Detalhes> cadastrarProduto(@Valid @RequestBody
                                                                            ProdutoRepresentation.CreateOrUpdateProduto createOrUpdateProduto){

        Categoria categoria = this.categoriaService.getCategoria(createOrUpdateProduto.getCategoria());

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(ProdutoRepresentation.Detalhes.from(this.produtoService.salvar(createOrUpdateProduto, categoria)));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteProduto(@PathVariable("id") Long id){
        this.categoriaService.deleteCategoria(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
