package com.hrm.company.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hrm.company.dao.CompanyDao;
import com.hrm.company.service.CompanyService;
import com.hrm.entity.company.Company;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.Map;

@Service
public class CompanyServiceImpl extends ServiceImpl<CompanyDao, Company> implements CompanyService {

    @Resource
    private CompanyDao companyDao;

    @Override
    public IPage<Company> queryPage(Map<String, Object> params) {
        Integer curPage = (Integer)params.get("curPage");
        Integer limit = (Integer)params.get("limit");
        return this.page(new Page<>(curPage, limit));
    }
    @Override
    public boolean saveCompany(Company company) {
        company.setCreateTime(new Date());
        company.setAuditState("0"); //"0"未审核  "1"已审核
        company.setState(1); // 0未激活 1 已激活
        return this.save(company);
    }

    @Override
    public boolean updateCompany(Company company) {
        return this.updateById(company);
    }

    @Override
    public boolean deleteCompany(Long id) {
        return this.removeById(id);
    }

    @Override
    public Company queryById(Long id) {
        return this.getById(id);
    }


}
