<%@ page language="java" contentType="text/html; charset=UTF-8" 
    pageEncoding="UTF-8"%> 
<%@ taglib prefix="s" uri="/struts-tags"%> 
<!DOCTYPE html> 
<html> 
<head> 
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/> 
    <meta http-equiv="Content-Style-Type" content="text/css"/> 
    <meta http-equiv="Content-Script-Type" content="text/javascript"/> 
    <meta http-equiv=" imagetoolbar" content="no"/> 
    <meta name="description" content=""/> 
    <meta name="keywords" content=""/> 

    <title>ログイン画面</title> 
    <link rel="stylesheet" type="text/css" href="./css/styles.css"> 

    <style type="text/css"> 
        #login{ 
            margin-top:82px 
        } 
        
        .login-container { 
            align-items: center; 
            height: 1000px; 
            text-align: center; 
        } 
        .login-container table{ 
            margin: 0 auto; 
            text-align:left; 
        } 
        
    </style> 
</head> 
<body>
<header> 
    <div class="header-up"> 
        <div class="logo"> 
            <img src="./data/diblog_logo.jpg"> 
        </div> 
    </div> 
    <div class="top-bar"> 
        <ul> 
            <li>トップ</li> 
            <li>プロフィール</li> 
            <li>D.I.Blogについて</li> 
            <li>登録フォーム</li> 
            <li>問い合わせ</li> 
            <li>その他</li> 

        </ul> 
    </div> 
</header> 
<main>
	<div id="login"> 
        <p>ログイン画面</p> 
    </div> 
    <div class="login-container">
			<s:form action = "login"> 
			<s:actionerror cssStyle="color:red;" /> 
			<table> 
			 <tr>
       			 <td><label>メールアドレス</label></td>
      			  <td>
						<s:textfield name = "mail"/>
				  </td>
			</tr>
			<tr>
				<td><label>パスワード</label></td>
				<td>
					<s:password name="password"/>
				</td>
				<s:submit value="ログイン"/>
			</s:form> 
</main> 
<footer> 
    Copyright D.I.works|D.I.blog is the one which provides A to Z about programming 
</footer> 
</body> 
</html>
</body>
</html>