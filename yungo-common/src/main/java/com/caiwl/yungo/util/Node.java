package com.caiwl.yungo.util;

import lombok.Builder;
import lombok.Data;

import java.util.List;

/**
 * @author caiwl
 * @date 2019/1/10 11:54
 */
@Data
@Builder
public class Node {
    private int id;
    private String name;
    private List<Node> children;
}
