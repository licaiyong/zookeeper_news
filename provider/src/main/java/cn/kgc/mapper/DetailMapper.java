package cn.kgc.mapper;

import cn.kgc.vo.Detail;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface DetailMapper {

    public List<Map<String,Object>> findAll(@Param("title") String title,@Param("categoryId") Integer categoryId);

    public Integer addDetail(Detail detail);

    public Map<String,Object> findById(@Param("id") Integer id);

    public Integer updateDetail(Detail detail);

    public Integer delDetail(@Param("id") Integer id);
}
