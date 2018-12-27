package com.caiwl.yungo.ctrl;

import com.caiwl.yungo.bean.Body;
import com.caiwl.yungo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/app/v1/product")
public class ProductController {
    @Autowired
    private ProductService productService;

    @PostMapping("/buy")
    public Body buy(String phone, long productId, int count) {
        return productService.buy(phone, productId, count);
    }
}
