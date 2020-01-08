package com.mbs.service.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.log4j.Logger;

import com.mbs.dao.SelfDAO;
import com.mbs.dao.impl.SelfDAOImpl;
import com.mbs.dto.UsersInfo;
import com.mbs.pojo.Goods;
import com.mbs.pojo.Receivinggoods;
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
	
	//根据用户Id,商品名称在收藏商品查询相关商品
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
	//修改用户与账号表信息,成功返回 true ,失败则返回false
	@Override
	public boolean updateUsersAndAccountByAccountId(UsersInfo usersInfo) {
		boolean flag = false;
		try {
			dao.updateAccountByUsersId("accountName", usersInfo.getAccountName(),usersInfo.getAccountId());
			dao.updateUsersByUsersId(usersInfo);
			flag = true;
		} catch (SQLException e) {
			e.printStackTrace();
			flag = false;
		}
		return flag;
	}
	
	//根据用户Id查询该用户所有录入的收货地址
	@Override
	public List<Receivinggoods> queryReceAddress(String usersId) {
		List<Receivinggoods> receList = null;
		try {
			receList = dao.queryReceAddress(usersId);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return receList;
	}
	
	//根据用户Id增加用户的收货地址
	@Override
	public int insertReceAddressByUsersId(Receivinggoods rece) {
		int rows = -1;
		try {
			rows = dao.insertReceAddressByUsersId(rece);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rows;
	}
	
	//根据收货信息ID删除该收获地址
	@Override
	public int deleteReceAddressByUsersIdAndReceId(String receId) {
		int rows = -1;
		try {
			rows = dao.deleteReceAddressByUsersIdAndReceId(receId);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rows;
	}
	
	//根据用户Id与收货信息ID修改该收获地址
	@Override
	public int updateReceAddressByUsersIdAndReceId(Receivinggoods rece) {
		int rows = -1;
		try {
			rows = dao.updateReceAddressByUsersIdAndReceId(rece);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rows;
	}
	
	//xx 根据收货地址Id修改为默认地址 beforeReceId为用户更改前的默认地址 afterReceId为更改后的地址 true表示都修改成功 , false表示为修改失败 xx 失效
	//根据用户Id将该用户所有地址都设为不默认 并将receId设为默认地址
	@Override
	public boolean setDefaultAddressByUsersIdAndReceId(String userId, String receId) {
		boolean flag = false;
		try {
			dao.removeDefaultAddressByUsersIdAndReceId(userId);
			dao.setDefaultAddressByUsersIdAndReceId(receId);
			flag = true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return flag;
	}
	
}
