package br.com.tessaro.domain;

import java.math.BigDecimal;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.FieldType;

@Data
@Document("TB_PRODUCT")
@NoArgsConstructor
public class Product {

	@Id
	private String productId;

	private String name;
	
	private String description;

	@Field(targetType = FieldType.DECIMAL128)
	private BigDecimal price;

	public Product(String name, String description, BigDecimal price) {
		this.name = name;
		this.description = description;
		this.price = price;
	}

}

