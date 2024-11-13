package com.devsuperior.projeto06.resource;  

import java.util.List;  
import java.util.Optional;  

import org.springframework.beans.factory.annotation.Autowired;  
import org.springframework.http.ResponseEntity;  
import org.springframework.web.bind.annotation.GetMapping;  
import org.springframework.web.bind.annotation.PathVariable;  
import org.springframework.web.bind.annotation.RequestMapping;  
import org.springframework.web.bind.annotation.RestController;  

import com.devsuperior.projeto06.entities.Category;  
import com.devsuperior.projeto06.repositories.CategoryRepository;  

@RestController  
@RequestMapping(value = "/categories")  
public class CategoryResource {  

    @Autowired  
    private CategoryRepository categoryRepository;  
    
    @GetMapping  
    public ResponseEntity<List<Category>> findAll(){  
        List<Category> list = categoryRepository.findAll();  
        return ResponseEntity.ok().body(list);  
    }  

    @GetMapping(value = "/{id}")  
    public ResponseEntity<Category> findById(@PathVariable Long id){  
        Optional<Category> cat = categoryRepository.findById(id);  
        return cat.map(ResponseEntity::ok)  
                  .orElseGet(() -> ResponseEntity.notFound().build());  
    }  
}
