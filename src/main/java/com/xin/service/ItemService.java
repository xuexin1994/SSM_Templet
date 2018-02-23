package com.xin.service;

import java.util.List;

import com.xin.pojo.Item;

public interface ItemService {
	/**
	 * 查询所有商品列表
	 * @return	所有商品
	 */
	public List<Item> findItemsList();

	/**
	 * 根据商品Id查询产品
	 * @return	通过给定商品Id查出的Item对象
	 */
	public Item findItemById(Integer id);
	
	/**
	 * 更新商品(为null的字段不更新)
	 * @param item 更新后的商品数据
	 */
	public void updateItem(Item item);
}
