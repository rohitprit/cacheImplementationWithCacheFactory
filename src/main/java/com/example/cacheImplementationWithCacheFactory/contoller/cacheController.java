package com.example.cacheImplementationWithCacheFactory.contoller;

import com.example.cacheImplementationWithCacheFactory.Exceptions.ErrorResponse;
import com.example.cacheImplementationWithCacheFactory.service.CacheService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cache")
public class cacheController {

    @Autowired
    private final CacheService cacheService;

    public cacheController(CacheService cacheService) {
        this.cacheService = cacheService;
    }


    @PostMapping("/{cachePolicy}")
    public ResponseEntity<?> createCache(@PathVariable String cachePolicy, @RequestParam(name = "cacheSize", required = true) int cacheSize) {
        try {
            return ResponseEntity.ok().body(cacheService.createCache(cachePolicy, cacheSize));
        } catch (Exception ex) {
            return ResponseEntity.unprocessableEntity().body(new ErrorResponse("422","Could not create Cache"));
        }
    }

    @PostMapping("/{cachePolicy}/insert")
    public ResponseEntity<?> insert(@PathVariable String cachePolicy, @RequestParam(name = "key", required = true) int key, @RequestParam(name = "value", required = true) int value) {
        try {
            return ResponseEntity.ok().body(cacheService.insert(cachePolicy, key, value));
        } catch (Exception ex) {
            return ResponseEntity.unprocessableEntity().body(new ErrorResponse("422","Could not insert in Cache"));
        }
    }

    @GetMapping("/{cachePolicy}/get")
    public ResponseEntity<?> get(@PathVariable String cachePolicy, @RequestParam(name = "key", required = true) int key) {
        try {
            return ResponseEntity.ok().body(cacheService.get(cachePolicy, key));
        } catch (Exception ex) {
            return ResponseEntity.unprocessableEntity().body(new ErrorResponse("422","Could not get in Cache"));
        }
    }

    @GetMapping("/{cachePolicy}/getData")
    public ResponseEntity<?> getData(@PathVariable String cachePolicy) {
        try {
            return ResponseEntity.ok().body(cacheService.getData(cachePolicy));
        } catch (Exception ex) {
            return ResponseEntity.unprocessableEntity().body(new ErrorResponse("422","Could not Cache"));
        }
    }

}
