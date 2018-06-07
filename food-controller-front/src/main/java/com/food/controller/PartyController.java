package com.food.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.food.pojo.Party;
import com.food.pojo.User;
import com.food.service.PartyService;
import com.food.service.UserService;




@Controller
public class PartyController {
	
	@Autowired
	private PartyService partyService;
	
	@RequestMapping(value="selectAllParty", method=RequestMethod.POST)
	@ResponseBody
	public List<Party> selectAllParty()
	{  
		return partyService.selectAll();
	}
	
	@RequestMapping("/selectAllPartyByPage")
	
	public ModelAndView selectAllParty(@RequestParam(defaultValue="1")String page,@RequestParam(defaultValue="4")String rows)
	{ System.out.println("-------------------------------");
	
		Map<String,Object> map = new HashMap<String,Object>();
	    map.put("plist", partyService.selectByPage(Integer.parseInt(page),Integer.parseInt(rows)));
		return new ModelAndView("active",map);
	}
	
	@RequestMapping(value="addParty", method=RequestMethod.POST)
	public String addParty(String pname,String pmoney,String pnumber,String partyTime,String endTime,String type,String pImg,String desc,String inpprovince,String inpcity,String inpuarea,HttpServletRequest req)
	{
		String message = null;
		if(!pname.equals("")){
			if(!pmoney.equals("")){
				if(!pnumber.equals("请选择")){
					if(!partyTime.equals("请选择活动时间")){
						if(!endTime.equals("")){
							if(!type.equals("请选择")){
								Party party = new Party();
								User user = (User) req.getSession().getAttribute("user");
								
								SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
								try {
									Date pTime =  formatter.parse(partyTime);
									Date eTime = formatter.parse(endTime);
									int i = pTime.compareTo(eTime);
									if(i>=0){
										if(partyService.bl_money(pmoney)){
										party.setUid(user.getUid());
											party.setPname(pname);
											Integer number = Integer.parseInt(pnumber);
											party.setPnumber(number);
											Double money = Double.valueOf(pmoney);
											party.setPmoney(money);
											System.out.println(pTime);
											party.setPartytime(pTime);
											party.setEndtime(eTime);
											party.setType(type);
											System.out.println(desc);
                                            party.setDescript(desc);
											party.setProvince(inpprovince);
											party.setCity(inpcity);
											party.setArea(inpuarea);
											System.out.println(party);
											partyService.insertSelectiveParty(party);
											message = "添加成功";
											req.getSession().setAttribute("message", message);
											return "forward:/selectAllPartyByPage";
										}else{
											message = "请输入正确的价格";
											req.getSession().setAttribute("message", message);
											return "Release";
										}
									}else{
										message = "截止时间应在活动时间之前";
										req.getSession().setAttribute("message", message);
										return "Release";
									}
								} catch (Exception e) {
									e.printStackTrace();
								}
							}else{
								message = "请选择活动类型";
								req.getSession().setAttribute("message", message);
								return "Release";
							}
						}else{
							message = "请选择报名截止时间";
							req.getSession().setAttribute("message", message);
							return "Release";
						}
					}else{
						message = "请选择活动时间";
						req.getSession().setAttribute("message", message);
						return "Release";
					}
				}else{
					message = "请选择报名人数";
					req.getSession().setAttribute("message", message);
					return "Release";
				}
			}else{
				message = "请填写活动价格";
				req.getSession().setAttribute("message", message);
				return "Release";
			}
		}else{
			message = "请填写活动标题";
			req.getSession().setAttribute("message", message);
			return "Release";
		}
		return "Release";
	}
}
