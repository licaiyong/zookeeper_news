package cn.kgc.service;

import cn.kgc.mapper.DetailMapper;
import cn.kgc.vo.Detail;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;
@Service
@Transactional
public class DetailServiceImpl implements DetailService {
    @Resource
    private DetailMapper detailMapper;

    @Override
    public PageInfo<Map<String, Object>> findAll(Integer pageNo,String title,Integer categoryId) {
        PageHelper.startPage(pageNo,2);
        List<Map<String, Object>> list = detailMapper.findAll(title,categoryId);
        PageInfo pageInfo=new PageInfo(list);
        return pageInfo;
    }

    @Override
    public Integer addDetail(Detail detail) {
        return detailMapper.addDetail(detail);
    }

    @Override
    public Map<String, Object> findById(Integer id) {
        return detailMapper.findById(id);
    }

    @Override
    public Integer updateDetail(Detail detail) {
        return detailMapper.updateDetail(detail);
    }

    @Override
    public Integer delDetail(Integer id) {
        return detailMapper.delDetail(id);
    }
}
