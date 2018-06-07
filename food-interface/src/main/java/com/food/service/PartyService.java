package com.food.service;

import java.util.List;

import com.food.pojo.Party;
import com.github.pagehelper.PageInfo;

public interface PartyService {
	
	public boolean bl_money(String money);
	
	public int insertParty(Party party);

	public void insertSelectiveParty(Party party);

	public List<Party> selectAll();

	public PageInfo<Party> selectByPage(int i, int j);
	
}
