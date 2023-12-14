package com.example.product.product;

import com.example.product.core.utils.ApiUtils;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@AllArgsConstructor
@RequestMapping("/product")
public class ProductController {

    private final ProductService productService;

    @ResponseBody
    @PostMapping("/save")
    public ResponseEntity<?> save(@RequestBody ProductRequest.SaveDTO product){
        Product save = productService.save(product);
        ApiUtils.ApiResult<?> apiResult = ApiUtils.success(save);
        return ResponseEntity.ok(apiResult);
    }

}
