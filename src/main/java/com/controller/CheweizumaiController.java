package com.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

import com.utils.ValidatorUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.annotation.IgnoreAuth;

import com.entity.CheweizumaiEntity;
import com.entity.view.CheweizumaiView;

import com.service.CheweizumaiService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MD5Util;
import com.utils.MPUtil;
import com.utils.CommonUtil;


/**
 * 车位租买
 * 后端接口
 * @author 
 * @email 
 * @date 2021-04-23 10:20:09
 */
@RestController
@RequestMapping("/cheweizumai")
public class CheweizumaiController {
    @Autowired
    private CheweizumaiService cheweizumaiService;
    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,CheweizumaiEntity cheweizumai,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("kehu")) {
			cheweizumai.setYonghuming((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<CheweizumaiEntity> ew = new EntityWrapper<CheweizumaiEntity>();
		PageUtils page = cheweizumaiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, cheweizumai), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,CheweizumaiEntity cheweizumai, 
		HttpServletRequest request){
        EntityWrapper<CheweizumaiEntity> ew = new EntityWrapper<CheweizumaiEntity>();
		PageUtils page = cheweizumaiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, cheweizumai), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( CheweizumaiEntity cheweizumai){
       	EntityWrapper<CheweizumaiEntity> ew = new EntityWrapper<CheweizumaiEntity>();
      	ew.allEq(MPUtil.allEQMapPre( cheweizumai, "cheweizumai")); 
        return R.ok().put("data", cheweizumaiService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(CheweizumaiEntity cheweizumai){
        EntityWrapper< CheweizumaiEntity> ew = new EntityWrapper< CheweizumaiEntity>();
 		ew.allEq(MPUtil.allEQMapPre( cheweizumai, "cheweizumai")); 
		CheweizumaiView cheweizumaiView =  cheweizumaiService.selectView(ew);
		return R.ok("查询车位租买成功").put("data", cheweizumaiView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        CheweizumaiEntity cheweizumai = cheweizumaiService.selectById(id);
        return R.ok().put("data", cheweizumai);
    }

    /**
     * 前端详情
     */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        CheweizumaiEntity cheweizumai = cheweizumaiService.selectById(id);
        return R.ok().put("data", cheweizumai);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody CheweizumaiEntity cheweizumai, HttpServletRequest request){
    	cheweizumai.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(cheweizumai);
        cheweizumaiService.insert(cheweizumai);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody CheweizumaiEntity cheweizumai, HttpServletRequest request){
    	cheweizumai.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(cheweizumai);
        cheweizumaiService.insert(cheweizumai);
        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody CheweizumaiEntity cheweizumai, HttpServletRequest request){
        //ValidatorUtils.validateEntity(cheweizumai);
        cheweizumaiService.updateById(cheweizumai);//全部更新
        return R.ok();
    }
    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        cheweizumaiService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
    /**
     * 提醒接口
     */
	@RequestMapping("/remind/{columnName}/{type}")
	public R remindCount(@PathVariable("columnName") String columnName, HttpServletRequest request, 
						 @PathVariable("type") String type,@RequestParam Map<String, Object> map) {
		map.put("column", columnName);
		map.put("type", type);
		
		if(type.equals("2")) {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Calendar c = Calendar.getInstance();
			Date remindStartDate = null;
			Date remindEndDate = null;
			if(map.get("remindstart")!=null) {
				Integer remindStart = Integer.parseInt(map.get("remindstart").toString());
				c.setTime(new Date()); 
				c.add(Calendar.DAY_OF_MONTH,remindStart);
				remindStartDate = c.getTime();
				map.put("remindstart", sdf.format(remindStartDate));
			}
			if(map.get("remindend")!=null) {
				Integer remindEnd = Integer.parseInt(map.get("remindend").toString());
				c.setTime(new Date());
				c.add(Calendar.DAY_OF_MONTH,remindEnd);
				remindEndDate = c.getTime();
				map.put("remindend", sdf.format(remindEndDate));
			}
		}
		
		Wrapper<CheweizumaiEntity> wrapper = new EntityWrapper<CheweizumaiEntity>();
		if(map.get("remindstart")!=null) {
			wrapper.ge(columnName, map.get("remindstart"));
		}
		if(map.get("remindend")!=null) {
			wrapper.le(columnName, map.get("remindend"));
		}

		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("kehu")) {
			wrapper.eq("yonghuming", (String)request.getSession().getAttribute("username"));
		}

		int count = cheweizumaiService.selectCount(wrapper);
		return R.ok().put("count", count);
	}
	


}
