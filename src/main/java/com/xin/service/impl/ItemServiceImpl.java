package com.xin.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xin.mapper.ItemMapper;
import com.xin.pojo.Item;
import com.xin.pojo.ItemExample;
import com.xin.service.ItemService;
@Service
@Transactional
public class ItemServiceImpl implements ItemService {

	@Resource
	private ItemMapper itemMapper;
	
	@Override
	public List<Item> findItemsList() {
		ItemExample example = new ItemExample();
		List<Item> list = itemMapper.selectByExample(example);
		return list;
	}

	@Override
	public Item findItemById(Integer id) {
		Item item = itemMapper.selectByPrimaryKey(id);
		return item;
	}

	@Override
	public void updateItem(Item item) {
		itemMapper.updateByPrimaryKeySelective(item);
	}

}
