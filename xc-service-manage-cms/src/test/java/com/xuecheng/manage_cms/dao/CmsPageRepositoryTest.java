package com.xuecheng.manage_cms.dao;

import com.xuecheng.framework.domain.cms.CmsPage;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.*;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
public class CmsPageRepositoryTest {
    @Autowired
    CmsPageRepository cmsPageRepository;

    @Test
    public void testFindAll(){
       List<CmsPage> all = cmsPageRepository.findAll();
        System.out.println(all);
    }

    //分页查询测试
    @Test
    public void testFindPage(){
        //分页参数
        int page = 1;
        int size = 10;
        Pageable pageable = PageRequest.of(page,size);
        Page<CmsPage> all = cmsPageRepository.findAll(pageable);
        System.out.println(all);
    }

    @Test
    public void testFindAllByExample(){
        int page = 1;
        int size = 10;
        Pageable pageable = PageRequest.of(page,size);
        //条件值对象
        CmsPage cmsPage = new CmsPage();
        cmsPage.setPageAliase("轮播");
        //cmsPage.setSiteId("5a751fab6abb5044e0d19ea1");

        //条件匹配器
        ExampleMatcher exampleMatcher = ExampleMatcher.matching()
                .withMatcher("pageAliase",ExampleMatcher.GenericPropertyMatchers.contains());//定义模糊匹配
        //定义Example
        Example<CmsPage> example = Example.of(cmsPage,exampleMatcher);
        Page<CmsPage> all = cmsPageRepository.findAll(example,pageable);
        List<CmsPage> content = all.getContent();
        System.out.println(content);
    }

    //修改
    @Test
    public void testUpdate(){

    }


}
