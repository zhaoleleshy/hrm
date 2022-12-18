package com.zll.common.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * 用于返回分页数据
 * @param <T>
 */
@Data //添加常用方法以及无参构造
@AllArgsConstructor //添加全参构造
@NoArgsConstructor //添加无参构造
public class PageResult<T> {

    private Long total; //总行数
    private List<T> rows; //数据行
}
