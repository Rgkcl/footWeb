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
<title>私厨 - 为你推荐遍布全球最新鲜，最与众不同的顶级生活方式</title>
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
<form action="regUser" method="post">
<div class="loginwrapper">
  <div class="wrap pr">
    <div class="loginbox">
      <h1 class="hd">用户注册</h1>
      <div class="tc" style="margin-top:-10px;"><img src="images/regtxt.png"></div>
      <div class="boxbd mt20">
        <label class="label">
          <input type="text" name="uemail" value="" class="loginipt key user">
          <span class="text">请输入您的邮箱</span>
        </label>
        <label class="label">
          <input type="text" name="uname" value="" class="loginipt key Nickname">
          <span class="text">请输入您的昵称</span>
        </label>
        <label class="label">
          <input type="password" name="password" value="" class="loginipt key pwd">
          <span class="text">请输入您的密码</span>
        </label>
        <button type="submit" name="login" value="" class="button btn-reg">立即注册</button>
        <p class="mt20 tc">注册则表示同意<a href="#" class="o">《会员条款》</a></p>
        <div class="ohter"><span class="ohtertxt">或</span></div>
      </div>
      <p class="boxbd tr">已有帐号？<a href="login" class="o">登陆</a></p>
    </div>    
  </div>
</div>
</form>
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
</html>