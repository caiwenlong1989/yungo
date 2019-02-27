package com.caiwl.yungo.ctrl;

import com.caiwl.yungo.bean.Body;
import com.caiwl.yungo.conf.Constants;
import com.caiwl.yungo.entity.Product;
import org.springframework.web.bind.annotation.*;

/**
 * 产品管理
 *
 * @author caiwl
 * @date 2019/1/13 11:51
 */
@RestController
@RequestMapping("/admin/v1/product")
public class ProductController {

    /**
     * 分页查询
     * @param pageNum
     * @param pageSize
     * @return
     */
    @GetMapping("/")
    public Body page(@RequestParam(defaultValue = Constants.PAGE_NUM) int pageNum,
                     @RequestParam(defaultValue = Constants.PAGE_SIZE) int pageSize) {
        return Body.success();
    }

    /**
     * 新增
     * @param product
     * @return
     */
    @PostMapping("/")
    public Body save(Product product) {
        return Body.success();
    }

    /**
     * 查询单个
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public Body get(@PathVariable Long id) {
        return Body.success();
    }

    /**
     * 修改单个
     * @param id
     * @param product
     * @return
     */
    @PutMapping("/{id}")
    public Body put(@PathVariable Long id, @ModelAttribute Product product) {
        return Body.success();
    }

    /**
     * 删除单个
     * @param id
     * @return
     */
    @DeleteMapping("/{id}")
    public Body delete(@PathVariable Long id) {
        return Body.success();
    }
}
