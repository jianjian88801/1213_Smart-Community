package com.entity.model;

import com.entity.CheweixinxiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
 

/**
 * 车位信息
 * 接收传参的实体类  
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了） 
 * 取自ModelAndView 的model名称
 * @author 
 * @email 
 * @date 2021-04-23 10:20:09
 */
public class CheweixinxiModel  implements Serializable {
	private static final long serialVersionUID = 1L;

	 			
	/**
	 * 车位名称
	 */
	
	private String cheweimingcheng;
		
	/**
	 * 车位类别
	 */
	
	private String cheweileibie;
		
	/**
	 * 车位图片
	 */
	
	private String cheweitupian;
		
	/**
	 * 车位位置
	 */
	
	private String cheweiweizhi;
		
	/**
	 * 车位状态
	 */
	
	private String cheweizhuangtai;
		
	/**
	 * 车位价格
	 */
	
	private Integer cheweijiage;
		
	/**
	 * 车位详情
	 */
	
	private String cheweixiangqing;
				
	
	/**
	 * 设置：车位名称
	 */
	 
	public void setCheweimingcheng(String cheweimingcheng) {
		this.cheweimingcheng = cheweimingcheng;
	}
	
	/**
	 * 获取：车位名称
	 */
	public String getCheweimingcheng() {
		return cheweimingcheng;
	}
				
	
	/**
	 * 设置：车位类别
	 */
	 
	public void setCheweileibie(String cheweileibie) {
		this.cheweileibie = cheweileibie;
	}
	
	/**
	 * 获取：车位类别
	 */
	public String getCheweileibie() {
		return cheweileibie;
	}
				
	
	/**
	 * 设置：车位图片
	 */
	 
	public void setCheweitupian(String cheweitupian) {
		this.cheweitupian = cheweitupian;
	}
	
	/**
	 * 获取：车位图片
	 */
	public String getCheweitupian() {
		return cheweitupian;
	}
				
	
	/**
	 * 设置：车位位置
	 */
	 
	public void setCheweiweizhi(String cheweiweizhi) {
		this.cheweiweizhi = cheweiweizhi;
	}
	
	/**
	 * 获取：车位位置
	 */
	public String getCheweiweizhi() {
		return cheweiweizhi;
	}
				
	
	/**
	 * 设置：车位状态
	 */
	 
	public void setCheweizhuangtai(String cheweizhuangtai) {
		this.cheweizhuangtai = cheweizhuangtai;
	}
	
	/**
	 * 获取：车位状态
	 */
	public String getCheweizhuangtai() {
		return cheweizhuangtai;
	}
				
	
	/**
	 * 设置：车位价格
	 */
	 
	public void setCheweijiage(Integer cheweijiage) {
		this.cheweijiage = cheweijiage;
	}
	
	/**
	 * 获取：车位价格
	 */
	public Integer getCheweijiage() {
		return cheweijiage;
	}
				
	
	/**
	 * 设置：车位详情
	 */
	 
	public void setCheweixiangqing(String cheweixiangqing) {
		this.cheweixiangqing = cheweixiangqing;
	}
	
	/**
	 * 获取：车位详情
	 */
	public String getCheweixiangqing() {
		return cheweixiangqing;
	}
			
}
