<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html><head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta name="keywords" content="">
<meta name="description" content="mezz">
<meta name="author" content="mezz">
<link href="css/css.css" rel="stylesheet">
<link href="css/chosen.css" rel="stylesheet">
<script src="js/jquery-1.8.3.min.js" type="text/javascript"></script>
<script src="http://www.jq22.com/jquery/1.11.1/jquery.min.js"></script>
<script src="http://www.jq22.com/jquery/bootstrap-3.3.4.js"></script>
<script src="js/jQueryDistpicker20160621/distpicker.data.js"></script>
<script src="js/jQueryDistpicker20160621/distpicker.js"></script>
<!--[if lt IE 9]>
    <link href="css/ie.css" rel="stylesheet" type="text/css" >
    <meta http-equiv="X-UA-Compatible" content="IE=8" >
<![endif]-->
<!--[if lte IE 6]><meta http-equiv="refresh" content="0;url=IE6/IE6"><![endif]-->
<link href="favicon.ico" rel="SHORTCUT ICON">
<title>17素材·私厨 - 为你推荐遍布全球最新鲜，最与众不同的顶级生活方式</title>
</head>
<%
    String mess=(String)session.getAttribute("message");
    if("".equals(mess)||mess==null){}
    else{%>
<script type="text/javascript">
    alert("<%=mess%>");
</script>
<%session.setAttribute("message", "");}%>
<body>
<script type="text/javascript">
$(function(){
	var sex = "${user.sex}";
	if(sex=="男"){
		$("#displaySex").html("<label><input type='radio' name='sex' value='男' id='RadioGroup1_0' checked='checked'>  男</label>&nbsp;&nbsp;&nbsp;&nbsp; <label><input type='radio' name='sex' value='女' id='RadioGroup1_1'>  女</label>");
	}
	if(sex=="女"){
		$("#displaySex").html("<label><input type='radio' name='sex' value='男' id='RadioGroup1_0'>  男</label>&nbsp;&nbsp;&nbsp;&nbsp; <label><input type='radio' name='sex' value='女' id='RadioGroup1_1' checked='checked'>  女</label>");
	}
});
</script>
<div class="head">
  <div class="wrap clearfix">
    <a href="index" class="logo indent">logo</a>
    <div class="headr fr">
      <form action="active" method="post" class="headsearch">
        <label class="label">
          <input type="text" value="" name="" class="key">
          <span class="text">搜索地址、名称、时间等</span>
        </label>
        <button type="submit" class="button btn-search">&#xe628;</button>
      </form>
      <a href="#"><em><img src="images/sb.png"></em>  &nbsp;&nbsp;发布我的饭局</a>
      <div class="user" id="displayName">
        <span class="clearfix"><span class="userimg"><img src=${ user.headportrait}><i></i></span>
        <a href="javascript:;" class="fr">${ user.uname}  <em>&#xe607;</em></a></span>
        <ul class="topslide">
          <li><em>&#xe627;</em><a href="mem">个人设置</a></li>
          <li><em>&#xe63d;</em><a href="Message">消息中心<s>3</s></a></li>
          <li><em>&#xe63c;</em><a href="Dinner">饭局管理</a></li>
          <li><em>&#xe63e;</em><a href="fans">我的好友</a></li>
          <li><em>&#xe611;</em><a href="index">退出</a></li>
        </ul>
      </div>
    </div>
  </div>
</div>

<div class="mem-banner" style="background-image:url(upload/img11.jpg);"></div>

<form action="user_save" method="post" enctype="multipart/form-data">
<div class="memwrap wrap clearfix">
  <div class="section fl">
  
    <div class="location tr"><a href="mem" class="current">基本资料</a><a href="pwd">修改密码</a><a href="binding">手机绑定</a></div>
    <div class="pd20">
      <table class="baseinfo">
        <tr>
          <th>账号：</th>
          <td>${ user.uemail}</td>
        </tr>
        <tr>
          <th>昵称：</th>
          <td><input type="text" name="uname" value=${ user.uname} class="baseipt"></td>
        </tr>
        <tr>
          <th valign="top">头像：</th>
          <td>
            <div class="user-photo img fl"><img src=${ user.headportrait} id="ImgPr"></div>
            <input type="hidden" id="img_src" name="img_src"/>
            <div class="upfilebox mt20">
              <label class="btn-upfiles"><input type="file" name="photo" id="up" />选择照片</label>
              <p class="mt10">支持jpg,gif,png格式，建议尺寸大于100*100。</p>
            </div>
          </td>
        </tr>
        <tr>
          <th>性别：</th>
          <td id="displaySex">
            <label><input type="radio" name="sex" value="男" id="RadioGroup1_0">  男</label>&nbsp;&nbsp;&nbsp;&nbsp;
            <label><input type="radio" name="sex" value="女" id="RadioGroup1_1">  女</label>
          </td>
        </tr>
        <tr>
          <th>职业：</th>
          <td><input type="text" name="pro" value=${ user.pro}></td>
        </tr>
         <tr>
          <th>手机号码：</th>
          <td>${ user.tel}</td>
        </tr>
        <tr>
           <th>所在城市：</th>
          <td colspan="2"><div data-toggle="distpicker" >
           <select data-province="${ user.uprovince}" name="province" id="province"></select>
           <select data-city="${ user.ucity}" name="city" id="city"></select>
           <select data-district="${ user.uarea}" name="uarea" id="uarea"></select>
           </div>
           </td>
        <input type="hidden" id="inpprovince" name="inpprovince"/>
        <input type="hidden" id="inpcity" name="inpcity"/>
        <input type="hidden" id="inpuarea" name="inpuarea"/>
        </tr>
        <tr>
          <th valign="top">个人简介：</th>
          <td>
            <textarea  name="intro" cols="" rows="" class="baseinfo-textarea" value="bhg">${ user.intro}</textarea>
            <p class="mt30 tc"><button type="submit" name="save" value="" class="button btn-save" onclick="$.save()">保存</button></p>
          </td>
        </tr>
      </table>
    </div>

  </div>
  <div class="aside fr">
    <div class="pd15">
      <div class="userimg"><img src=${ user.headportrait}><i></i></div>
      <div class="user-level tc">${ user.uname} <em></em><em></em><em></em></div>
      <div class="tc"><a href="javascript:;" class="button btn-control btn-follow"> + 关注</a><a href="javascript:;" class="button btn-control btn-sent"><em class="myfont f18">&#xe63f;</em> 私信</a></div>
      <div class="Praise tc">${ user.pro}，中国，陕西 <em>&#xe61d;</em><em>&#xe61d;</em><em>&#xe61d;</em></div>
      <div class="txtwrap tc"><h1 class="f16">个人简介</h1>${ user.intro}</div>
      <h1 class="f16">关注 4</h1>
      <ul class="followlist clearfix">
        <li><a href="#"><img src="upload/img12.png"></a></li>
        <li><a href="#"><img src="upload/img12.png"></a></li>
        <li><a href="#"><img src="upload/img12.png"></a></li>
        <li><a href="#"><img src="upload/img12.png"></a></li>
      </ul>
      <h1 class="f16">粉丝 4</h1>
      <ul class="followlist bd0 clearfix">
        <li><a href="#"><img src="upload/img12.png"></a></li>
        <li><a href="#"><img src="upload/img12.png"></a></li>
        <li><a href="#"><img src="upload/img12.png"></a></li>
        <li><a href="#"><img src="upload/img12.png"></a></li>
      </ul>
    </div>
  </div>
</div>
</form>

<script src="js/jquery.js"></script>
<script src="js/Action.js"></script>
<script src="js/upfiles.js"></script>

<script src="js/chosen.jquery.js"></script>
<script type="text/javascript">


$.save=function(){
	var s = $("#ImgPr").attr("src");
	$("#img_src").attr("value",s);
	var pro = $("#province").attr("value");
	$("#inpprovince").attr("value",pro);
	var cit = $("#city").attr("value");
	$("#inpcity").attr("value",cit);
	var are = $("#uarea").attr("value");
	$("#inpuarea").attr("value",are);
}
$(document).ready(function($){
	//select 样式美化
	 var config = {
		'.chosen-select-no-single' : {disable_search_threshold:10}
	}
	for (var selector in config) {
		$(selector).chosen(config[selector]);
	}
	$("#up").uploadPreview({
		Img: "ImgPr",
	});
});
</script>
</html>