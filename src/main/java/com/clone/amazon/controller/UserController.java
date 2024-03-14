package com.clone.amazon.controller;

import java.util.List;

import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.csrf.InvalidCsrfTokenException;
import org.springframework.web.bind.annotation.CrossOrigin;
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
import com.clone.amazon.collections.User;
import com.clone.amazon.collections.UserRole;
import com.clone.amazon.dto.AuthRequest;
import com.clone.amazon.dto.LoginResponse;
import com.clone.amazon.dto.ResetDto;
import com.clone.amazon.dto.UserDto;
import com.clone.amazon.helper.JwtService;
import com.clone.amazon.model.LoginRequest;
import com.clone.amazon.model.UserModel;
import com.clone.amazon.model.Wishlist;
import com.clone.amazon.repositories.UserRepository;
import com.clone.amazon.service.UserService;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;



@RestController
@CrossOrigin(origins = "http://localhost:5173")
@RequestMapping("/users")
public class UserController {

	@Autowired
    private UserService userService;
	
	@Autowired
    private UserRepository userRepository;
	
	@Autowired
	private JwtService jwtService;
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@PostMapping("/login")
    public LoginResponse AuthenticateAndGetToken(@RequestBody LoginRequest loginRequest) {
		AuthRequest authRequest=new AuthRequest();
		authRequest.setUsername(loginRequest.getEmail());
		authRequest.setPassword(loginRequest.getPassword());
				
        Authentication authentication = authenticationManager
                .authenticate(new UsernamePasswordAuthenticationToken(authRequest.getUsername(),
                        authRequest.getPassword()));
        if (authentication.isAuthenticated()) {
        	String token = jwtService.GenerateToken(authRequest.getUsername());
        	User user = userService.findUser(authRequest.getUsername());
        	user.setRefreshToken(token);
            UserDto userDto = UserDto.fromUser(user);
            LoginResponse loginResponse = new LoginResponse("user logged in sucessfully",true,userDto);
            return loginResponse;
           
        } else {
            throw new UsernameNotFoundException("invalid user request..!!");
        }
    }
	
	
//  
    @PostMapping("/register")
    public User createUser(@RequestBody UserModel userModel) {
        return userService.createUser(userModel);
    }
  

    //wishlist
    @GetMapping("/wishlist/{userId}")
    public List<Product> getUsersWishlist(@PathVariable String userId){
    	return userService.getWishListItem(userId);
    }
    
    @PostMapping("/wishlist")
    public String addWishlist(@RequestBody Wishlist wishlist) {
    	return userService.addWishlist(wishlist.getProdId(), wishlist.getUserId());
    }
    
    @PutMapping("/wishlist/remove")
    public String removeWishlist(@RequestBody Wishlist wishlist) {
    	return userService.removeFromWishLiist(wishlist.getProdId(), wishlist.getUserId());
    }
    
    

    //forgot password
    @PostMapping("/forgot-password-token")
    public ResponseEntity<String> forgotPassword(@RequestBody Map<String, String> requestBody) {
        String email = requestBody.get("email");
      
            userService.forgotPassword(email);
            return ResponseEntity.ok("Password reset email sent successfully");
    }
    
  
    @PutMapping("/resetpassword/{token}")
    public ResponseEntity<String> resetPassword(@PathVariable("token") String token, @RequestBody ResetDto resetDto) {
        String newPassword = resetDto.getPassword();
       
        try {
            userService.resetPassword(token, newPassword);
            return ResponseEntity.ok("Password reset successfully");
        } catch (InvalidCsrfTokenException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid or expired token");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to reset password");
        }
    }
    
    @GetMapping("/logout")
    public String logoutUser() {
    	return "logged out successfully";
    }
    
    @PreAuthorize("hasAuthority('admin')")
    @GetMapping("/byrole")
    public List<User> getUsersByRoleId() {
        return userRepository.findByRoles_Id("65db83f2811cfd3e0e28c8b6");
    }
    
    @PreAuthorize("hasAuthority('admin')")
    @DeleteMapping("/{id}")
    public String deleteUserById(@PathVariable String id) {
    	return userService.deleteUser(id);
    }

}
