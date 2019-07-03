package br.ufjf.dcc193.t3.documentos;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item, Long>
{
}