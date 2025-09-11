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
		#delete-confirm{
	    	margin-top:82px
	    }
		.delete-confirm-container {
   			padding-top:100px;
			height: 600px;
			text-align: center;
			font-size:50px;
		}
		.inline-form {
		    display: inline-block;  
		    margin: 0 10px;  
		     vertical-align: middle;      
		}
		footer {
		    position: fixed;
		    bottom: 0;
		    left: 0;
		    width: 100%;
		    text-align: center;
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
    	<div id="delete-confirm">
				<p>アカウント削除確認画面</p>
		</div>
		
    	<div class="delete-confirm-container">
        	<h3>本当に削除してよろしいですか？</h3>
	        <s:actionerror cssStyle="color:red;"/>
	        <s:form action="delete" method="post"  cssClass="inline-form">
			    <s:hidden name="id" value="%{id}"/>
			    <s:hidden name="familyName" value="%{familyName}"/>
			    <s:hidden name="lastName" value="%{lastName}"/>
			    <s:hidden name="familyNameKana" value="%{familyNameKana}"/>
			    <s:hidden name="lastNameKana" value="%{lastNameKana}"/>
			    <s:hidden name="mail" value="%{mail}"/>
			    <s:hidden name="password" value="%{password}"/>
			    <s:hidden name="gender" value="%{gender}"/>
			    <s:hidden name="postalCode" value="%{postalCode}"/>
			    <s:hidden name="prefecture" value="%{prefecture}"/>
			    <s:hidden name="address_1" value="%{address_1}"/>
			    <s:hidden name="address_2" value="%{address_2}"/>
			    <s:hidden name="authority" value="%{authority}"/>
	
	   			 <s:submit value="前に戻る" action="delete_confirm"/>
			</s:form>
       		<s:form action="delete_complete" cssClass="inline-form">
            	<s:hidden name="id" value="%{id}"/>
            <s:submit value="削除する"/>
       		 </s:form>
   		 </div>
	</main>
    <footer>
      Copyright D.I.works|D.I.blog is the one which provides A to Z about programming
    </footer>
</body>
</html>