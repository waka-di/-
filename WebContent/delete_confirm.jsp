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
	
	<title>アカウント削除確認画面</title>
	<link rel="stylesheet" type="text/css" href="./css/styles.css">
	<style type="text/css">
		#delete-complete{
	    	margin-top:82px
	    }
		.delete-complete-container {
   			padding-top:100px;
			height: 600px;
			text-align: center;
		}
		.center-form{
		margin:0 50% 0 50%;
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
	        <li>アカウント登録</li>
	        <li>アカウント一覧</li>
	        
	      </ul>
	    </div>
    </header>
    <main>
    	<div id="delete-complete">
			<p>アカウント削除確認画面</p>
		</div>
		<div class="delete-complete-container">
			<h3>本当に削除してよろしいですか？</h3>
			<s:actionerror cssStyle="color:red;" />
			<div class="center-form">
				<s:form action="DeleteAction" cssClass="inline-form">
    					<s:submit value="前に戻る"/>
				</s:form>	
				<s:form action="Delete_completeAction" cssClass="inline-form">
					<s:hidden name="id" value="%{account.id}"/>
    				<s:submit value="削除する"/>
				</s:form>	
				
			</div>
		</div>
	</main>
    <footer>
      Copyright D.I.works|D.I.blog is the one which provides A to Z about programming
    </footer>
   </body>
   </html>