package com.mbs.service.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.log4j.Logger;

import com.mbs.dao.SelfDAO;
import com.mbs.dao.impl.SelfDAOImpl;
import com.mbs.dto.UsersInfo;
import com.mbs.pojo.Goods;
import com.mbs.service.SelfService;
/**
 * 个人信息具体业务实现类
 * @author heluo
 *
 */

public class SelfServiceImpl implements SelfService{
	//导入日志
	private Logger log = Logger.getLogger(SelfServiceImpl.class);
	//引用dao层
	private SelfDAO dao = new SelfDAOImpl();
	
	//根据用户ID查询用户
	@Override
	public UsersInfo querySingleUser(String usersId){
		UsersInfo users = null;
		try {
			users = dao.querySingleUser(usersId);
		} catch (SQLException e) {
			e.printStackTrace();
			log.error("用户查询出错");
		}
		return users;
	}
	//根据用户Id查询该用户所有收藏的商品
	@Override
	public List<Goods> queryCollectGoodsByUsersId(String usersId){
		List<Goods> goodsList = null;
		try {
			goodsList = dao.queryCollectGoodsByUsersId(usersId);
		} catch (SQLException e) {
			e.printStackTrace();
			log.error("用户收藏查询出错");
		}
		return goodsList;
	}
	//根据用户ID与商品IDs删除用户收藏的商品
	@Override
	public List<Goods> deleteCollectByGoodsIdAndReturnGoodsList(String usersId, int goodsId){
		List<Goods> goodsList = null;
		try {
			dao.deleteCollectByGoodsId(usersId, goodsId);
			goodsList = dao.queryCollectGoodsByUsersId(usersId);
		} catch (SQLException e) {
			e.printStackTrace();
			log.error("删除商品出错or用户收藏查询出错");
		}
		return goodsList;
	}
	//根据用户ID与商品ID添加收藏返回 success 为添加成功 , fail添加失败,exit表示该商品已被收藏 
	public String addCollect(String usersId,int goodsId){
		try {
			boolean flag = dao.queryCollect(usersId, goodsId);
			if(flag){
				return "exit";
			}
			dao.addCollect(usersId, goodsId);
		} catch (SQLException e) {
			e.printStackTrace();
			return "fail";
		}
		return "success";
	}
	@Override
	public List<Goods> queryCollectGoodsByUsersId(String usersId, String goodsName) {
		List<Goods> goodsList = null;
		try {
			goodsList = dao.queryCollectGoodsByUsersId(usersId, goodsName);
		} catch (SQLException e) {
			e.printStackTrace();
			log.error("用户收藏查询出错");
		}
		return goodsList;
	}
	
}
