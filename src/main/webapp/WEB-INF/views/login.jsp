<%@page import="org.apache.shiro.web.filter.authc.FormAuthenticationFilter"%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html lang="zh-cn">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>登录</title>

<!-- Bootstrap -->
<link href="${ctx}/static/bootstrap/css/bootstrap.css" rel="stylesheet">
<link href="${ctx}/res/font-awesome/css/font-awesome.min.css" rel="stylesheet">


<link href="${ctx}/res/css/p.css" rel="stylesheet">
<link href="${ctx}/res/css/register.css" rel="stylesheet">
<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
      <script src="${ctx}/res/js/html5shiv-3.7.2.min.js"></script>
      <script src="${ctx}/res/js/respond-1.4.2.min.js"></script>
    <![endif]-->
</head>
<body>
	<div class="container">
		<div class="header">
			<div class="login-link">
				<span>我已注册，现在就</span>
				<button type="button" class="btn btn-default btn-sm">登录</button>
			</div>
			<div class="mod-header">
				<h3>登录</h3>
			</div>
		</div>
		<hr />
		<div class="row">
			<div class="col-sm-7">
				<form action="${ctx}/login" class="form-horizontal form-register" role="form" method="post">
						<%
			String error = (String) request.getAttribute(FormAuthenticationFilter.DEFAULT_ERROR_KEY_ATTRIBUTE_NAME);
			if(error != null){
		%>
				<div class="alert alert-error controls input-large">
					<button class="close" data-dismiss="alert">×</button>
		<%
				if(error.contains("DisabledAccountException")){
					out.print("用户已被屏蔽,请登录其他用户.");
				}
				else{
					out.print("登录失败，请重试.");
					out.print(error);
				}
		%>		
				</div>
		<%
			}
		%>
					<div class="form-group">
						<label for="inputEmail3" class="col-sm-2 control-label">帐号：</label>
						<div class="col-sm-10">
							<input type="text" class="form-control" id="username"
								name="username" placeholder="帐号">
						</div>
					</div>
					<div class="form-group">
						<label for="inputPassword3" class="col-sm-2 control-label">密码：</label>
						<div class="col-sm-10">
							<input type="password" class="form-control" id="password"
								name="password" placeholder="Password">
						</div>
					</div>
					<div class="form-group">
						<div class="col-sm-offset-2 col-sm-10">
							<button class="btn btn-lg btn-primary btn-block" type="submit">登录</button>
						</div>
					</div>
				</form>
			</div>
			<div class="col-sm-5">构建中。</div>
		</div>
	</div>
	<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
	<script src="${ctx}/res/js/jquery-1.11.1.min.js"></script>
	<!-- Include all compiled plugins (below), or include individual files as needed -->
	<script src="${ctx}/res/bootstrap/3.2.0/js/bootstrap.min.js"></script>
</body>
</html>