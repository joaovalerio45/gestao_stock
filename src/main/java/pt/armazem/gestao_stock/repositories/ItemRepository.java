package pt.armazem.gestao_stock.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import pt.armazem.gestao_stock.domain.entities.Item;

public interface ItemRepository extends JpaRepository<Item, Long>{

    boolean existsByCode(String code);

    Optional<Item> findByCode(String code);

    boolean existsByName(String name);

    Optional<Item> findByName(String name);


}
