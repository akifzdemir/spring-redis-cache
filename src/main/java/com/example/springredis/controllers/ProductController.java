package com.example.springredis.controllers;

import com.example.springredis.models.Product;
import com.example.springredis.services.ProductService;
import org.apache.coyote.Response;
import org.json.HTTP;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/product")
public class ProductController {

    @Autowired
    ProductService productService;

    @GetMapping("/getall")
    ResponseEntity<List<Product>> getAll(){
       return new ResponseEntity<>(productService.getAll(), HttpStatus.OK);

    }

    @GetMapping("/get/{id}")
    ResponseEntity<Product> getById(@PathVariable int id){
        return new ResponseEntity<>(productService.getById(id),HttpStatus.OK);
    }

    @PostMapping("/add")
    ResponseEntity<String> add(@RequestBody Product product){
        productService.add(product);
        return new ResponseEntity<>("Added",HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{id}")
    ResponseEntity<String> delete(@PathVariable int id){
        productService.delete(id);
        return new ResponseEntity<>("Deleted",HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    ResponseEntity<String> update(@PathVariable int id,@RequestBody Product product){
        productService.update(id,product);
        return new ResponseEntity<>("Updated",HttpStatus.OK);

    }

}
