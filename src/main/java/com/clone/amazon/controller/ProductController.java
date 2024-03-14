package com.clone.amazon.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.clone.amazon.collections.Product;
import com.clone.amazon.collections.Rating;
import com.clone.amazon.model.ProductDto;
import com.clone.amazon.model.RatingRequest;
import com.clone.amazon.service.ProductService;

@RestController
@RequestMapping("/product")
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	@PostMapping("/save")
	public Product create(@RequestBody Product product){
		return productService.createProducts(product);
		
	}
	
	@PostMapping("/rating")
	public String addRatingToProduct(@RequestBody RatingRequest ratingRequest) {
		Rating rating = new Rating();
		rating.setComment(ratingRequest.getComment());
		rating.setStar(ratingRequest.getStar());
		rating.setTitle(ratingRequest.getTitle());
		rating.setPostedBy(ratingRequest.getProdId());
				return productService.addRating(rating, ratingRequest.getProdId());
		
	}
	
	@GetMapping
	public List<Product> getAllProduct(@RequestParam(required = false) String title,
            @RequestParam(required = false) String sort,
            @RequestParam(required = false) String fields,
            @RequestParam(defaultValue = "1") int page,
            @RequestParam(required = false) Integer limit,
		    @RequestParam(required = false) String category,
	        @RequestParam(required = false) String brand,
	        @RequestParam(required = false) String color)
	{
		Page<Product> productsPage = productService.getAll(title, sort, fields, page, limit, category, brand, color);
	    List<Product> productList = productsPage.getContent();
	    return productList;
	}
	
	@GetMapping("/{id}")
	public Product getSingleProduct(@PathVariable String id){
		return productService.getProduct(id);
	}
	
    @GetMapping("/getproducts")
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }
    
    @PutMapping("/update")
    public Product updateProduct(@RequestBody ProductDto productDto) {
    	return productService.updateProductDetails(productDto);
    	
    }
    @DeleteMapping("/{id}")
    public String deleteProductById(@PathVariable String id) {
    	return productService.deleteProduct(id);
    }

}
