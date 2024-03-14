package com.clone.amazon.serviceImpl;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.clone.amazon.collections.Brand;
import com.clone.amazon.collections.Color;
import com.clone.amazon.collections.ProdCategory;
import com.clone.amazon.collections.Product;
import com.clone.amazon.collections.Rating;
import com.clone.amazon.model.ProductDto;
import com.clone.amazon.repositories.ProductRepository;
import com.clone.amazon.service.BrandService;
import com.clone.amazon.service.ColorService;
import com.clone.amazon.service.ProductCategoryService;
import com.clone.amazon.service.ProductService;
import com.clone.amazon.service.RatingService;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepository productRepository;

	@Autowired
	private ColorService colorService;

	@Autowired
	private BrandService brandService;

	@Autowired
	private ProductCategoryService categoryService;
	
	@Autowired
	private RatingService ratingService;
	
    private static final BigDecimal EXCHANGE_RATE_INR_TO_USD = new BigDecimal("0.013");


	@Override
	public Product createProducts(Product product) {
		return productRepository.save(product);
	}


	@Override
	public Page<Product> getAll(String title, String sort, String fields, int page, Integer limit, String categoryId,
	        String brandId, String colorId) {
		Pageable pageable = PageRequest.of(page - 1, limit  != null ? limit.intValue() : 22);

	    ProdCategory category = (categoryId != null) ? categoryService.getCategoryById(categoryId) : null;
	    Brand brand = (brandId != null) ? brandService.getBrandById(brandId) : null;
	    Color color = (colorId != null) ? colorService.getColorById(colorId) : null;

	    // Define query conditions based on objects
	    Page<Product> productsPage;

	    if (category != null && brand != null && color != null) {
	        // Query by category, brand, and color
	        productsPage = productRepository.findByCategoryAndBrandAndColor(category, brand, color, pageable);
	    } else if (category != null && brand != null) {
	        // Query by category and brand
	        productsPage = productRepository.findByCategoryAndBrand(category, brand, pageable);
	    } else if (category != null && color != null) {
	        // Query by category and color
	        productsPage = productRepository.findByCategoryAndColor(category, color, pageable);
	    } else if (brand != null && color != null) {
	        // Query by brand and color
	        productsPage = productRepository.findByBrandAndColor(brand, color, pageable);
	    } else if (category != null) {
	        // Query by category
	        productsPage = productRepository.findByCategory(category, pageable);
	    } else if (brand != null) {
	        // Query by brand
	        productsPage = productRepository.findByBrand(brand, pageable);
	    } else if (color != null) {
	        // Query by color
	        productsPage = productRepository.findByColor(color, pageable);
	    } else {
	        // Query all products if no parameters are provided
	        productsPage = productRepository.findAll(pageable);
	    }

	    return productsPage;
	}

	
	@Override
	public Product getProduct(String id) {
		return productRepository.findById(id).get();
	}

	@Override
	public String addRating(Rating rating, String prodId) {
		Product product = getProduct(prodId);
		ratingService.save(rating);
		List<Rating> ratings = product.getRatings();
		ratings.add(rating);
		product.setTotalRating(product.getTotalRating()+1);
		createProducts(product);
		return "Rating saved successfully";
	}

	@Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

	@Override
	public Product updateProductDetails(ProductDto productDto) {
		Product product = productRepository.findById(productDto.getId()).get();
		product.setQuantity(productDto.getQuantity());
        BigDecimal priceInINR = BigDecimal.valueOf(productDto.getPrice());
        BigDecimal priceInUSD = priceInINR.multiply(EXCHANGE_RATE_INR_TO_USD);
        product.setPrice(priceInUSD.doubleValue());
		return productRepository.save(product);
		
	}

	@Override
	public String deleteProduct(String id) {
	    try {
	        productRepository.deleteById(id);
	        return "deleted successfully";
	    } catch (Exception e) {
	        return "Error deleting product: " + e.getMessage();
	    }
	}

}
