package org.app.farmhouse.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.app.farmhouse.dto.inventory.ProductDto;
import org.app.farmhouse.dto.order.OrderDto;
import org.app.farmhouse.dto.user.AddressDto;
import org.app.farmhouse.modal.inventory.Product;
import org.app.farmhouse.modal.order.Order;
import org.app.farmhouse.modal.order.OrderInfo;
import org.app.farmhouse.service.inventory.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/inventory/product")
public class InventoryController {

    @Autowired
    private ProductService productService;
    @GetMapping("/address")
    public ResponseEntity<AddressDto> getAddress(){
        return ResponseEntity.ok(new AddressDto());
    }

    @GetMapping("/info")
    public ResponseEntity<OrderInfo> getOrderInfo(){
        return ResponseEntity.ok(new OrderInfo());
    }

    @GetMapping("/order")
    public ResponseEntity<OrderDto> test(){
        return ResponseEntity.ok(new OrderDto());
    }

    @GetMapping("/loadall")
    public void loadAllProduct(@AuthenticationPrincipal Authentication authentication, HttpServletRequest request, HttpServletResponse response) throws IOException {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        response.setHeader("principal", auth.getPrincipal().toString());
        response.sendRedirect("http://localhost:3000/auth");
    }

    @PostMapping("/add")
    public ResponseEntity<ProductDto> addProduct(@RequestBody ProductDto dto){
        dto =  productService.addProductToInventory(dto);
        return ResponseEntity.ok(dto);
    }

    @GetMapping("/delete")
    public ResponseEntity<String> deleteProduct(@RequestParam Long productId){
        productService.deleteProductById(productId);
        return ResponseEntity.ok("Successfully deleted");
    }

    @PostMapping("/update")
    public ResponseEntity<String> updateProduct(@RequestBody ProductDto productKey){
        productService.updateProduct(productKey);
        return ResponseEntity.ok("Product updated successfully");
    }

    @GetMapping("/search")
    public ResponseEntity<List> search(@RequestParam String searchKey){
           List<ProductDto> li= productService.searchProduct(searchKey);
            return ResponseEntity.ok(li);
    }

}
