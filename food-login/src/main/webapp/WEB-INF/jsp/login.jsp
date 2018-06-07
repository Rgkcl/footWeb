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
      <a href="login">登录</a><a href="reg">注册</a><a href="#">发布我的饭局</a>
    </div>
  </div>
</div>
<div class="loginwrapper">
  <div class="wrap pr">
    <div class="loginbox">
      <h1 class="hd">用户登录</h1>
      <div class="boxbd">
        <label class="label">
          <input type="text" name="user" value="" class="loginipt user">
          <span class="text">请输入您的邮箱</span>
        </label>
        <label class="label">
          <input type="password" name="pwd" value="" class="loginipt pwd">
          <span class="text">请输入您的密码</span>
        </label>
        <button type="submit" name="login" value="" class="button btn-login" onClick="location.href='mem'">登录</button>
        <p class="mt20"><label for="remember"><input name="" type="checkbox" id="remember" value="" checked> 记住我</label><a href="forgot" class="fr"> 忘记密码？</a></p>
        <div class="ohter"><span class="ohtertxt">或</span></div>
        <p class="mt10 tr">还没有账号？<a href="reg" class="o">注册</a></p>
      </div>
      
    </div>    
  </div>
</div>
<div class="foot2">
  <div class="wrap clearfix">
    <div class="txt fl">
     <div class="foot-nav"> <a href="#">关于17素材</a>/<a href="#">加入我们</a>/<a href="#">联系我们</a>/<a href="#">媒体报道</a>/<a href="#">会员条款</a>/<a href="#">版权声明</a></div>
     Copyright © 2003-2015 17素材, All Rights Reserved　
    </div>
    <div class="orc fr"><img src="images/img2.jpg" width="63"><img src="images/img3.jpg" width="63"></div>
  </div>
</div>
<script src="js/jquery.js"></script>
<script src="js/Action.js"></script>
</html>>