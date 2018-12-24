package com.caiwl.yungo.ctrl;

import com.caiwl.yungo.mapper.IndexMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/app/v1")
public class IndexController {
    @Autowired
    private IndexMapper indexMapper;

    @RequestMapping("/")
    public String index() {
        return indexMapper.getMsg();
    }
}
