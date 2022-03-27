package br.com.tessaro.repository.custom;

import java.math.BigDecimal;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import org.springframework.stereotype.Repository;

import br.com.tessaro.domain.Product;

@Repository
public class ProductsCustomRepository {

	@Autowired
	private MongoTemplate mongoTemplate;

	@SuppressWarnings("unchecked")
	public List<Product> findProductsByFilter(String nameOrDescription, BigDecimal minPrice, BigDecimal maxPrice) {
		Query mongoQuery = new Query();

		if (nameOrDescription != null) {
			mongoQuery.addCriteria(Criteria.where("").orOperator(
					Criteria.where("name").is(nameOrDescription),
					Criteria.where("description").is(nameOrDescription)));
		};

		if (minPrice != null && maxPrice == null) {
			mongoQuery.addCriteria(Criteria.where("price").gte(minPrice));
		};

		if (maxPrice != null && minPrice == null) {
			mongoQuery.addCriteria(Criteria.where("price").lte(maxPrice));
		};

		if (maxPrice != null && minPrice != null) {
			//O ocorreu um conflito na conversão do BigDecimal para o Decimal do mongoDb, de forma que foi necessario converter para doubleValue para a query funcionar
			mongoQuery.addCriteria(Criteria.where("price").gte(minPrice.doubleValue()).lte(maxPrice.doubleValue()));
		}

		return mongoTemplate.find(mongoQuery, Product.class);
	}
}