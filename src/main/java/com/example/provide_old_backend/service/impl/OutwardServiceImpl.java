package com.example.provide_old_backend.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.provide_old_backend.entity.Outward;
import com.example.provide_old_backend.mapper.OutwardMapper;
import com.example.provide_old_backend.service.OutwardService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OutwardServiceImpl extends ServiceImpl<OutwardMapper, Outward> implements OutwardService {

    @Override
    public List<Outward> listNotDeleted() {
        LambdaQueryWrapper<Outward> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(Outward::getIsDeleted, 0);
        return list(wrapper);
    }

    @Override
    public void addOutward(Outward outward) {
        outward.setIsDeleted(0);
        outward.setAuditstatus(0);
        save(outward);
    }

    @Override
    public void examineOutward(Integer id, Integer auditstatus) {
        Outward outward = getById(id);
        if (outward != null) {
            outward.setAuditstatus(auditstatus);
            updateById(outward);
        }
    }

    @Override
    public void deleteOutward(Integer id, Integer isDeleted) {
        Outward outward = getById(id);
        if (outward != null) {
            outward.setIsDeleted(isDeleted);
            updateById(outward);
        }
    }
}
