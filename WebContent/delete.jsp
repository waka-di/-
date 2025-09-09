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
	
	<title>アカウント削除画面</title>
	<link rel="stylesheet" type="text/css" href="./css/styles.css">
	<style type="text/css">
		#delete{
	    	margin-top:82px
	    }
		.delete-container {
   			align-items: center;  
			height: 1000px;
			text-align: center;
		}

		.delete-container table{
			margin: 0 auto;
			text-align:left;
		}
		.inline-form {
   			 display: inline-block; 
   			 margin: 0 10px;       
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
			<div id="delete">
				<p>アカウント削除画面</p>
			</div>
			<div class="delete-container">
			<table>
				<tr>
					<td>名前（姓）</td>
					<td><s:property value="account.familyName"/></td>
				</tr>
	            <tr>
	            	<td>名前（名）</td>
	            	<td><s:property value="account.lastName"/></td>
	            </tr>
	            <tr>
	            	<td>カナ（姓）</td>
	            	<td><s:property value="account.familyNameKana"/></td>
	            </tr>
	            <tr>
	            	<td>カナ（名）</td>
	            	<td><s:property value="account.lastNameKana"/></td>
	            </tr>
	            <tr>
	            	<td>メールアドレス</td>
	            	<td><s:property value="account.mail"/></td>
	            </tr>
	            <tr>
	            	<td>パスワード</td>
	            	<td><s:property value="account.passwordMasked"/></td>
	            </tr>
           		<tr>
           			<td>性別</td>
	                <td>
	                    <s:if test="account.gender == 0">男</s:if>
	                    <s:if test="account.gender == 1">女</s:if>
	                </td>
           		 </tr>
	            <tr>
	            	<td>郵便番号</td>
	            	<td><s:property value="account.postalCode"/></td>
	            </tr>
	            <tr>
	            	<td>住所（都道府県）</td>
	            	<td><s:property value="account.prefecture"/></td>
	            </tr>
	            <tr>
	            	<td>住所（市区町村）</td>
	            	<td><s:property value="account.address1"/></td>
	            </tr>
	            <tr>
	            	<td>住所（番地）</td>
	            	<td><s:property value="account.address2"/></td>
	            </tr>
	            <tr>
	            	<td>アカウント権限</td>
	                <td>
	                    <s:if test="account.authority == 0">一般</s:if>
	                    <s:if test="account.authority == 1">管理者</s:if>
	                </td>
	            </tr>
        </table>

        <s:form action="delete_confirm" cssClass="inline-form">
            <s:hidden name="id" value="%{account.id}"/>
            <s:submit value="確認する"/>
        </s:form>
    </div>
	</main>
    <footer>
      Copyright D.I.works|D.I.blog is the one which provides A to Z about programming
    </footer>
</body>
</html>