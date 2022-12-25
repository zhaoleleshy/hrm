package com.hrm.company.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.hrm.company.service.CompanyService;
import com.hrm.entity.company.Company;
import com.zll.common.entity.PageResult;
import com.zll.common.entity.Result;
import com.zll.common.entity.ResultCode;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Map;

@RestController
@RequestMapping("/company")
public class CompanyController {

    @Resource
    private CompanyService companyService;

    /**
     * 查询所有企业
     */
    @GetMapping
    public PageResult<Company> queryPage(Map<String, Object> params) {
        IPage<Company> companyIPage = companyService.queryPage(params);
        return new PageResult<>(companyIPage.getTotal(), companyIPage.getRecords());
    }

    /**
     * 保存企业
     */
    @PostMapping
    public Result saveCompany(@RequestBody Company company) {
        companyService.saveCompany(company);
        return Result.success();
    }

    /**
     * 修改企业
     */
    @PutMapping
    public Result updateCompany(@RequestBody Company company) {
        companyService.updateCompany(company);
        return Result.success();
    }

    /**
     * 删除企业
     */
    @DeleteMapping("/{id}")
    public Result deleteCompany(@PathVariable Long id) {
        companyService.deleteCompany(id);
        return Result.success();
    }

    /**
     * 根据id查询企业
     */
    @GetMapping("/{id}")
    public Result queryById(@PathVariable Long id) {
        Company company = companyService.queryById(id);
        return new Result(ResultCode.SUCCESS, company);
    }
}
