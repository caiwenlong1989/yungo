package com.caiwl.yungo.ctrl;

import com.caiwl.yungo.bean.Body;
import com.caiwl.yungo.conf.Constants;
import com.caiwl.yungo.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 客户管理
 * @author caiwl
 * @date 2019/1/13 11:54
 */
@RestController
@RequestMapping("/admin/v1/customer")
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @GetMapping("/")
    public Body page(String phone,
            @RequestParam(defaultValue = Constants.PAGE_NUM) int pageNum,
            @RequestParam(defaultValue = Constants.PAGE_SIZE) int pageSize) {
        return customerService.page(phone, pageNum, pageSize);
    }
}
