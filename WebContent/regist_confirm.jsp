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
	        
	      </ul>
	    </div>
    </header>
    <main>
    	<div class="regist_container">
			<div id="regist">
				<p>アカウント登録画面</p>
			</div>
			
			<table>
				<s:form action="regist_CompleteAction">
					<tr>
						<td>
							<label>名前（姓）</label>
						</td>
						<td>
							<s:property value="familyName" escape="false"/>
						</td>
					</tr>
					<tr>
						<td>
							<label>名前（名）</label>	
						</td>
						<td>
							<s:property value="lastName" escape="false"/>
						</td>
					</tr>
					<tr>
						<td>
							<label>カナ（姓）</label>
						</td>
						<td>
							<s:property value="familyNameKana" escape="false"/>
						</td>
					</tr>
					<tr>
						<td>
							<label>名カナ（名）</label>
						</td>
						<td>
							<s:property value="lastNameKana" escape="false"/>
						</td>
					</tr>
					<tr>
						<td>
							<label>メールアドレス</label>	
						</td>
						<td>
							<s:property value="mail" escape="false"/>
						</td>
					</tr>
					<tr id="box">
						<td>
							<label>パスワード</label>
						</td>
						<td>
							<s:password name="password"/>
						</td>
					</tr>
					<tr>
						<td>
							<label>性別</label>
						</td>
						<td>
							<s:if test="gender == 0">男</s:if>
							<s:if test="gender == 1">女</s:if>
						</td>
					</tr>
					<tr>
						<td>
							<label>郵便番号</label>	
						</td>
						<td>
							<s:property value="postalCode" escape="false"/>
						</td>
					</tr>
					<tr>
						<td>
							<label>住所（都道府県）</label>
						</td>
						<td>
							<s:property value="prefecture" escape="false"/>
						</td>
					</tr>
					<tr>
						<td>
							<label>住所（市区町村）</label>
						</td>
						<td>
							<s:property value="address_1" escape="false"/>
						</td>
					</tr>
					<tr>
						<td>
							<label>住所（番地）</label>	
						</td>
						<td>
							<s:property value="address_2" escape="false"/>
						</td>
					</tr>
					<tr>
						<td>
							<label>アカウント権限</label>
						</td>
						<td>
							<s:property value="authority" escape="false"/>
						</td>
					</tr>
				</s:form>
				<s:form action="registAction">
    				<s:submit value="前に戻る"/>
				</s:form>
				<s:form action="regist_CompleteAction">
    				<s:submit value="登録する"/>
				</s:form>
			</table>
		</div>
	</main>
    <footer>
      Copyright D.I.works|D.I.blog is the one which provides A to Z about programming
    </footer>
</body>
</html>