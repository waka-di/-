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
	
	<title>アカウント登録確認画面</title>
	<link rel="stylesheet" type="text/css" href="./css/styles.css">
	<style type="text/css">
		#update_confirm{
	    	margin-top:82px
	    }
		.update-confirm-container {
   			align-items: center;  
			height: 1000px;
			text-align: center;
		}

		.update-confirm-container table{
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
			<div id="update_confirm">
				<p>アカウント更新確認画面</p>
			</div>
			<div class="update-confirm-container">
			 <table>
            <tr><td>名前（姓）</td><td><s:property value="familyName"/></td></tr>
            <tr><td>名前（名）</td><td><s:property value="lastName"/></td></tr>
            <tr><td>カナ（姓）</td><td><s:property value="familyNameKana"/></td></tr>
            <tr><td>カナ（名）</td><td><s:property value="lastNameKana"/></td></tr>
            <tr><td>メールアドレス</td><td><s:property value="mail"/></td></tr>
            <tr><td>パスワード</td>
            	<td><s:property value="passwordMasked"/></td>
            		<s:hidden name="password" value="%{password}"/>
            	
            </tr>
            <tr><td>性別</td><td>
                <s:if test="gender == 0">男</s:if>
                <s:if test="gender == 1">女</s:if>
            </td></tr>
            <tr><td>郵便番号</td><td><s:property value="postalCode"/></td></tr>
            <tr><td>住所（都道府県）</td><td><s:property value="prefecture"/></td></tr>
            <tr><td>住所（市区町村）</td><td><s:property value="address_1"/></td></tr>
            <tr><td>住所（番地）</td><td><s:property value="address_2"/></td></tr>
            <tr><td>アカウント権限</td><td>
                <s:if test="authority == 0">一般</s:if>
                <s:if test="authority == 1">管理者</s:if>
            </td></tr>
        </table>

        <!-- 前に戻るフォーム -->
        <s:form action="update" cssClass="inline-form">
            <s:hidden name="back" value="true"/>
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
            <s:submit value="前に戻る"/>
        </s:form>

        <!-- 更新するフォーム -->
        <s:form action="update_complete" cssClass="inline-form">
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
            <s:submit value="更新する"/>
        </s:form>        
		</div>
	</main>
    <footer>
      Copyright D.I.works|D.I.blog is the one which provides A to Z about programming
    </footer>
</body>
</html>