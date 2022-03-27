package br.com.tessaro.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import br.com.tessaro.domain.Product;

@Repository
public interface ProductsRepository extends MongoRepository<Product, String> {

//    Nenhum dos exemplos abaixo são relacionados com essa aplicação, estão aqui apenas para servir de exemplo em um futuro.

//    @Query("{'type': {$regex: '^F.*'} }")
//    public List<SpaceShip> gimmeShipsStartWithF();
//
//    @Query("{'type': {$regex: '^E.*'} }")
//    public List<SpaceShip> gimmeShipsStartWithE();
//
//    @Query(value="{'type': {$regex: '^E.*'} }", delete = true)
//    public List<SpaceShip> deleteShipsWithE();
	
}