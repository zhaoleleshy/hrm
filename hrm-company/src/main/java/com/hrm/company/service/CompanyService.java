package com.hrm.company.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.hrm.entity.company.Company;

import java.util.List;
import java.util.Map;

/**
 * 公司实体增删改查
 */
public interface CompanyService extends IService<Company> {

    /**
     * 查询所有企业
     */
    IPage<Company> queryPage(Map<String, Object> params);

    /**
     * 保存企业
     */
    boolean saveCompany(Company company);

    /**
     * 修改企业
     */
    boolean updateCompany(Company company);

    /**
     * 删除企业
     */
    boolean deleteCompany(Long id);

    /**
     * 根据id查询企业
     */
    Company queryById(Long id);


}
