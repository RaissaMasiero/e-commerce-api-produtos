package br.senac.ecommerceapiprodutos.produto;

import br.senac.ecommerceapiprodutos.categoria.CategoriaRepresentation;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public interface ProdutoRepresentation {

    @Data
    @Getter
    @Setter
    class CreateOrUpdateProduto{

        @NotNull(message = "O campo nome não pode ser nulo")
        @Size(min = 1, max = 30, message = "O campo nome deve conter entre 1 e 30")
        private String nome;

        @NotNull(message = "O campo descrição não pode ser nulo")
        @Size(max = 30, min = 1, message = "A descrição deve conter de 1 a 30 caracteres")
        private String descricao;

        private String complemento;

        @NotNull(message = "O campo valor não pode ser nulo")
        private Double valor;

        @NotNull(message = "O campo unidade de medida não pode ser nulo")
        private Produto.UnidadeMedida unidadeMedida;

        @NotNull(message = "O campo quantidade não pode ser nulo")
        private Double qtde;

        @NotNull(message = "O campo fabricante não pode ser nulo")
        @Size(max = 255, min = 1, message = "A descrição deve conter de 1 a 255 caracteres")
        private String fabricante;

        private String fornecedor;

        @NotNull(message = "A categoria é obrigatória")
        private Long categoria;
    }

    @Data
    @Getter
    @Setter
    @Builder
    class Detalhes {

        private String nome;
        private String descricao;
        private String complemento;
        private Double valor;
        private Produto.UnidadeMedida unidadeMedida;
        private Double qtde;
        private String fabricante;
        private String fornecedor;
        private CategoriaRepresentation.Detail categoria;

        public static Detalhes from(Produto produto){
            return Detalhes.builder()
                    .nome(produto.getNome())
                    .descricao(produto.getDescricao())
                    .complemento(produto.getComplemento())
                    .valor(produto.getValor())
                    .unidadeMedida(produto.getUnidadeMedida())
                    .qtde(produto.getQtde())
                    .fabricante(produto.getFabricante())
                    .fornecedor(produto.getFornecedor())
                    .categoria(CategoriaRepresentation.Detail.from(produto.getCategoria()))
                    .build();
        }
    }
}
