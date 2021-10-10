package com.classdesign.service.impl;

import com.classdesign.dao.PartDao;
import com.classdesign.domain.Parts;
import com.classdesign.service.PartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Array;
import java.util.List;
import java.util.Set;

/**
 * @Author yang97
 * @Date 2020/6/17 15:38
 */
@Service("PartService")
public class PartServiceImpl implements PartService {
    @Autowired
    private PartDao partDao;

    //查询零件的价格和相关信息
    @Override
    public List<Parts> findPartsAll() {
        return partDao.findPartsAll();
    }

    //通过零件名称和供应商，查询零件价格
    @Override
    public Integer findPrice(String part, String suppliers) {
        Integer price=partDao.findPrice(part,suppliers);
        return price;
    }

    @Override
    public Set findPartPrice(String part) {
        return partDao.findPartPrice(part);
    }

    @Override
    public Integer findPartNumber(String part, String suppliers) {
        Integer number=partDao.findPartNumber(part,suppliers);
        return number;
    }

    //下单更新零件库存
    @Override
    public void updatePartNumber(String part, String suppliers,Integer number) {
        partDao.updatePartNumber(part,suppliers,number);
    }

    //修改零件库存
    @Override
    public void changePN(String part, String suppliers, Integer number) {
        partDao.changePN(part,suppliers,number);
    }

    //修改零件价格
    @Override
    public void updatePrice(String part, String suppliers, Integer price) {
        partDao.updatePrice(part,suppliers,price);
    }
}
