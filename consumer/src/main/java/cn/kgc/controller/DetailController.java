package cn.kgc.controller;

import cn.kgc.service.CategoryService;
import cn.kgc.service.DetailService;
import cn.kgc.vo.Detail;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Controller
public class DetailController {
    @Resource
    private CategoryService categoryService;
    @Resource
    private DetailService detailService;

    @RequestMapping("/findAllCategory.do")
    @ResponseBody
    public List<Map<String,Object>> findAllCategory(){
        List<Map<String, Object>> list = categoryService.findAll();
        System.out.println(list);
        return list;
    }

    @RequestMapping("/findAllDetail.do")
    @ResponseBody
    public PageInfo<Map<String,Object>> findAllDetail(@RequestParam(defaultValue = "1") Integer pageNo, @RequestParam(defaultValue = "") String title,@RequestParam(defaultValue = "") Integer categoryId){
        PageInfo<Map<String, Object>> pageInfo = detailService.findAll(pageNo, title,categoryId);
        System.out.println(pageInfo);
        return pageInfo;
    }

    @RequestMapping("/add.do")
    @ResponseBody
    public String add(Detail detail){
        SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date=format.format(new Date());
        detail.setCreateDate(date);
        detail.setUpdateDate(date);
        detailService.addDetail(detail);
        return "ok";
    }

    @RequestMapping("/findById.do")
    @ResponseBody
    public Map<String,Object> findById(Integer id){
        Map<String, Object> map = detailService.findById(id);
        List<Map<String, Object>> list = categoryService.findAll();
        map.put("category",list);
        return map;
    }

    @RequestMapping("/update.do")
    @ResponseBody
    public String update(Detail detail){
        SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date=format.format(new Date());
        detail.setUpdateDate(date);
        detailService.updateDetail(detail);
        return "ok";
    }

    @RequestMapping("/del.do")
    @ResponseBody
    public String del(Integer id){
        detailService.delDetail(id);
        return "ok";
    }
}
