package com.moses.eshop.productservice.query_apis.queryhandler;

import com.moses.eshop.productservice.core.entity.ProductEntity;
import com.moses.eshop.productservice.core.repository.ProductsRepository;
import com.moses.eshop.productservice.query_apis.model.ProductRestModel;
import com.moses.eshop.productservice.query_apis.queries.FindProductsQuery;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ProductsQueryHandler {
	
	private final ProductsRepository productsRepository;
	
	public ProductsQueryHandler(ProductsRepository productsRepository) {
		this.productsRepository = productsRepository;
	}
	
	@QueryHandler
	public List<ProductRestModel> findProducts(FindProductsQuery query) {
		List<ProductEntity> storedProducts =  productsRepository.findAll();
		return storedProducts.stream()
				.map(product -> ProductRestModel
						.builder()
						.quantity(product.getQuantity())
						.price(product.getPrice())
						.title(product.getTitle())
						.build())
				.collect(Collectors.toList());
		
	}

}