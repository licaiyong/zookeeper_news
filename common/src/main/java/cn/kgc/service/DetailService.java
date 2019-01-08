package cn.kgc.service;

import cn.kgc.vo.Detail;
import com.github.pagehelper.PageInfo;

import java.util.Map;

public interface DetailService {
    public PageInfo<Map<String,Object>> findAll(Integer pageNo,String title,Integer categoryId);

    public Integer addDetail(Detail detail);

    public Map<String,Object> findById(Integer id);

    public Integer updateDetail(Detail detail);

    public Integer delDetail(Integer id);
}
