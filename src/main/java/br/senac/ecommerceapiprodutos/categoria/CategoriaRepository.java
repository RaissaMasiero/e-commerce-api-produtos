package br.senac.ecommerceapiprodutos.categoria;

import com.querydsl.core.types.Predicate;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public interface CategoriaRepository extends PagingAndSortingRepository<Categoria, Long>,
        QuerydslPredicateExecutor<Categoria> {

    /**
     * Método responsável por retornar uma lista de categorias com a oportunidade de informar filtros
     * @param filter
     * @return
     */
    List<Categoria> findAll(Predicate filter);
}
