package br.senac.ecommerceapiprodutos.categoria;

import org.springframework.data.jpa.repository.support.QuerydslJpaPredicateExecutor;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface CategoriaRepository extends CrudRepository<Categoria, UUID> {
    QuerydslPredicateExecutor<Categoria>
}
