package com.example.provide_old_backend.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.provide_old_backend.entity.BedDetails;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import java.time.LocalDate;

@Mapper
public interface BedDetailsMapper extends BaseMapper<BedDetails> {

    @Select("<script>" +
            "SELECT * FROM beddetails WHERE 1=1 " +
            "<if test='isDeleted != null'> AND is_deleted = #{isDeleted} </if>" +
            "<if test='startDate != null'> AND start_date &lt;= #{endDate} </if>" +
            "<if test='endDate != null'> AND end_date &gt;= #{startDate} </if>" +
            "</script>")
    Page<BedDetails> selectPageIgnoreLogicDelete(Page<BedDetails> page, @Param("isDeleted") Integer isDeleted, @Param("startDate") LocalDate startDate, @Param("endDate") LocalDate endDate);
}
