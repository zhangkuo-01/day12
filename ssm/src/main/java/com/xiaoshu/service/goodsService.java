package com.xiaoshu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.github.pagehelper.util.StringUtil;
import com.xiaoshu.dao.GoodsMapper;
import com.xiaoshu.dao.TypeMapper;
import com.xiaoshu.entity.Goods;
import com.xiaoshu.entity.GoodsVo;
import com.xiaoshu.entity.Type;
import com.xiaoshu.entity.User;
import com.xiaoshu.entity.UserExample;
import com.xiaoshu.entity.UserExample.Criteria;



@Service
public class goodsService {

	@Autowired
	GoodsMapper goodsMapper; 

	@Autowired
	TypeMapper typeMapper;

	public List<Type> findTypeAll() {
		// TODO Auto-generated method stub
		return typeMapper.selectAll();
	}

	public PageInfo<GoodsVo> findGoodsVo(GoodsVo goodsVo, Integer pageNum, Integer pageSize, String ordername,
			String order) {
		// TODO Auto-generated method stub
		PageHelper.startPage(pageNum, pageSize);
		List<GoodsVo> userList = goodsMapper.findGoodsVoAll(goodsVo);
		PageInfo<GoodsVo> pageInfo = new PageInfo<GoodsVo>(userList);
		return pageInfo;
	}

	public void deleteGoods(int parseInt) {
		// TODO Auto-generated method stub
		goodsMapper.deleteByPrimaryKey(parseInt);
	}

	public void addGoods(Goods goods) {
		// TODO Auto-generated method stub
		goodsMapper.insert(goods);
	}

	public Goods findByName(String name) {
		// TODO Auto-generated method stub
		Goods goods = new Goods();
		goods.setName(name);
		return goodsMapper.selectOne(goods);
	}

	public void updateGoods(Goods goods) {
		// TODO Auto-generated method stub
		goodsMapper.updateByPrimaryKey(goods);
	}

	public void addType(Type type) {
		// TODO Auto-generated method stub
		typeMapper.insert(type);
	}

	public Type selectOne(Type type) {
		// TODO Auto-generated method stub
		return typeMapper.selectOne(type);
	}

	public List<GoodsVo> countPerson() {
		// TODO Auto-generated method stub
		return goodsMapper.countPerson();
	} 
	
	
}
