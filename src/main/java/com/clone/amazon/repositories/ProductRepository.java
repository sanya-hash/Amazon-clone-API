package com.clone.amazon.repositories;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.clone.amazon.collections.Brand;
import com.clone.amazon.collections.Color;
import com.clone.amazon.collections.ProdCategory;
import com.clone.amazon.collections.Product;

@Repository
public interface ProductRepository extends MongoRepository<Product, String>{
	
//	Page<Product> findByTitle(@Param("title") String title, Pageable pageable);
//	
//    List<Product> findByCategory(ProdCategory category);
//    
//    // Query methods to find products by brand
//    List<Product> findByBrand(Brand brand);
//    
//    // Query methods to find products by color
//    List<Product> findByColor(Color color);
//
//    // Query methods to find products by category and brand
//    List<Product> findByCategoryAndBrand(ProdCategory category, Brand brand);
//    
//    // Query methods to find products by category and color
//    List<Product> findByCategoryAndColor(ProdCategory category, Color color);
//    
//    // Query methods to find products by brand and color
//    List<Product> findByBrandAndColor(Brand brand, Color color);
//
//	List<Product> findByCategoryAndBrandAndColor(ProdCategory category, Brand brand, Color color);
	
	Page<Product> findByTitle(@Param("title") String title, Pageable pageable);

    Page<Product> findByCategory(ProdCategory category, Pageable pageable);

    Page<Product> findByBrand(Brand brand, Pageable pageable);

    Page<Product> findByColor(Color color, Pageable pageable);

    Page<Product> findByCategoryAndBrand(ProdCategory category, Brand brand, Pageable pageable);

    Page<Product> findByCategoryAndColor(ProdCategory category, Color color, Pageable pageable);

    Page<Product> findByBrandAndColor(Brand brand, Color color, Pageable pageable);

    Page<Product> findByCategoryAndBrandAndColor(ProdCategory category, Brand brand, Color color, Pageable pageable);
	
}
