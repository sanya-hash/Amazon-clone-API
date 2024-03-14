package com.clone.amazon.serviceImpl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.clone.amazon.collections.Order;
import com.clone.amazon.collections.Product;
import com.clone.amazon.collections.User;
import com.clone.amazon.collections.UserRole;
import com.clone.amazon.config.MyConfig;
import com.clone.amazon.model.UserModel;
import com.clone.amazon.repositories.UserRepository;
import com.clone.amazon.repositories.UserRoleRepository;
import com.clone.amazon.service.ProductService;
import com.clone.amazon.service.UserService;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private ProductService productService;
	
	@Autowired
	private UserRoleRepository userRoleRepository;
	
	@Autowired
	private JavaSmtpGmailSenderService javasmtpgmailsenderservice;

	@Override
	public User createUser(UserModel userModel) {
		User user = new User();
		user.setRefreshToken("none");
		user.setPassword(passwordEncoder.encode(userModel.getPassword()));
		user.setPasswordResetToken("passwordResetToken");
		user.setFirstname(userModel.getFirstname());
		user.setLastname(userModel.getLastname());
		user.setUsername(userModel.getEmail());
		user.setMobile(userModel.getMobile());
		user.setCart(new ArrayList<>());
		user.setWishlist(new ArrayList<>());
		user.setOrders(new ArrayList<>());
		UserRole role = userRoleRepository.findById("65db83f2811cfd3e0e28c8b6").orElse(null);
	    Set<UserRole> roles = new HashSet<>();
	    if (role != null) {
	        roles.add(role);
	    }
	    user.setRoles(roles);
		return userRepository.save(user);
	}

	@Override
	public List<Product> getWishListItem(String id) {
		User user = userRepository.findById(id).get();
		return user.getWishlist();
	}

	@Override
	public String addWishlist(String prodId, String userId) {
	    Product product = productService.getProduct(prodId);
	    User user = userRepository.findById(userId).get(); 
	    if (user != null) {
	        List<Product> existingWishlist = user.getWishlist();
	        if (existingWishlist == null) {
	            existingWishlist = new ArrayList<>(); 
	        }
	        existingWishlist.add(product);
	        user.setWishlist(existingWishlist);
	        userRepository.save(user);
	        return "added to wishlist";
	    }
	    return "error";
	}

	@Override
	public String removeFromWishLiist(String prodId, String userId) {
		Product product = productService.getProduct(prodId);
	    User user = userRepository.findById(userId).get();
	    if (user != null) {
	        List<Product> existingWishlist = user.getWishlist();
	        if (existingWishlist == null) {
	            return "wishlist not found";
	        }
	        existingWishlist.remove(product);
	        user.setWishlist(existingWishlist);
	        userRepository.save(user);
	    }
	    return "removed from wishlist";
	}

	@Override
	public User findUser(String username) {
	
		return userRepository.findByUsername(username);
	}

	 @Override
	    public void forgotPassword(String username) {
	    	 User user = userRepository.findByUsername(username);
	         if (user == null) {
	        	 throw new UsernameNotFoundException("User not found with email: " + username);
	         }
	         
	         Map<String, Object> resetInfo;
	         MyConfig myConfig = new MyConfig();
	         
	         resetInfo = myConfig.createPasswordResetToken();
	         String passwordResetToken = (String) resetInfo.get("passwordResetToken");
	         Date passwordResetExpires = (Date) resetInfo.get("passwordResetExpires");
	         user.setPasswordResetToken(passwordResetToken);
	         user.setPasswordResetExpires(passwordResetExpires);
	         userRepository.save(user);

	         // Send reset password email
	         javasmtpgmailsenderservice.sendResetPasswordEmail(username, user, passwordResetToken);
	    }
	    
	    @Override
	    public User resetPassword(String token, String newPassword) {
	        // Find the user by the password reset token
	        User user = userRepository.findByPasswordResetToken(token);
	        if (user == null) {
	            throw new RuntimeException("Invalid or expired token");
	        }
	        
	        // Validate token expiration (check if current date is before passwordResetExpires)
	        if (user.getPasswordResetExpires() == null || user.getPasswordResetExpires().before(new Date())) {
	            throw new RuntimeException("Token expired");
	        }
	        
	        user.setPassword(passwordEncoder.encode(newPassword));
	        user.setPasswordChangedAt(new Date());
	        user.setPasswordResetToken("passwordResetToken");
	        user.setPasswordResetExpires(null);
	        // Save the updated user in the database
	        return userRepository.save(user);
	    }

		@Override
		public List<Order> getOrders(String userId) {
			
			User user = userRepository.findById(userId).get();
			return user.getOrders();
		}

		
		@Override
		public String deleteUser(String id) {
		    try {
		    	userRepository.deleteById(id);
		        return "deleted successfully";
		    } catch (Exception e) {
		        return "Error deleting User: " + e.getMessage();
		    }
		}
		



}
