package com.caiwl.yungo.util;

import com.alibaba.fastjson.JSON;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * @author caiwl
 * @date 2019/1/10 11:21
 */
public class FileUtil {

    private static int id = 1;

    /**
     * 递归
     * @param path
     * @return
     */
    private static Node recursion(String path) {
        File file = new File(path);
        Node node = Node.builder().id(id++).name(file.getName()).build();
        if (file.isDirectory()) {
            List<Node> children = new ArrayList<>();
            node.setChildren(children);
            String[] list = file.list();
            for (int i = 0; i < list.length; i++) {
                children.add(recursion(path + "/" + list[i]));
            }
        }
        return node;
    }

    public static void main(String[] args) {
        System.out.println(JSON.toJSONString(recursion("image")));
    }
}
