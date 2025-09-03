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
	
	<title>アカウント登録画面</title>
	<link rel="stylesheet" type="text/css" href="./css/styles.css">
	<style type="text/css">
	    #regist{
	    	margin-top:82px
	    }
		.regist-container {
   			align-items: center;  
			height: 1000px;
			text-align: center;
		}

		.regist-container table{
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
	        <li>アカウント登録</li>
	        
	      </ul>
	    </div>
    </header>
    <main>
    	<div id="regist">
			<p>アカウント登録画面</p>
		</div>
		<div class="regist-container">		
			<table>
				<s:form action= "regist_confirmAction">
					<tr>
						<td>
							<label>名前（姓）</label>
						</td>
						<td>
							<s:textfield name="familyName" value="%{#session.familyName}" maxlength="10"/>
							<s:fielderror fieldName="familyName" style="color:red;"/>
						</td>
					</tr>
					<tr>
						<td>
							<label>名前（名）</label>
						</td>
						<td>
							<s:textfield name="lastName" value="%{#session.lastName}" maxlength="10"/>
							<s:fielderror fieldName="lastName" style="color:red;"/>
						</td>
					</tr>
					<tr>
						<td>
							<label>カナ（姓）</label>
						</td>
						<td>
							<s:textfield name="familyNameKana" value="%{#session.familyNameKana}" maxlength="10"/>
							<s:fielderror fieldName="familyNameKana" style="color:red;"/>
						</td>
					</tr>
					<tr>
						<td>
							<label>名カナ（名）</label>
						</td>
						<td>
							<s:textfield name="lastNameKana" value="%{#session.lastNameKana}" maxlength="10"/>
							<s:fielderror fieldName="lastNameKana" style="color:red;"/>
						</td>
					</tr>
					<tr>
						<td>
							<label>メールアドレス</label>
						</td>
						<td>
							<s:textfield name="mail" value="%{#session.mail}" maxlength="100"/>
							<s:fielderror fieldName="mail" style="color:red;"/>
						</td>
					</tr>
					<tr>
						<td>
							<label>パスワード</label>
						</td>
						<td>
							<s:textfield name="password" value="%{#session.password}" maxlength="10"/>
							<s:fielderror fieldName="password" style="color:red;"/>
						</td>
					</tr>
					<tr>
						<td>
							<label>性別</label>
						</td>
						<td>
							 <s:radio name="gender" list="#{'0':'男','1':'女'}" value="%{#session.gender != null ? #session.gender : '0'}"/>
						</td>
					</tr>
					<tr>
						<td>
							<label>郵便番号</label>
						</td>
						<td>
							<s:textfield name="postalCode" value="%{#session.postalCode}" maxlength="7"/>
							<s:fielderror fieldName="postalCode" style="color:red;"/>
						</td>
					</tr>
					<tr>
						<td>
							<label>住所（都道府県）</label>
						</td>
						<td>
							<s:select name="prefecture" list="#{
							    '':'',
								'北海道':'北海道',
								'青森県':'青森県',
								'岩手県':'岩手県',
								'宮城県':'宮城県',
								'秋田県':'秋田県',
								'山形県':'山形県',
								'福島県':'福島県',
								'茨城県':'茨城県',
								'栃木県':'栃木県',
								'群馬県':'群馬県',
								'埼玉県':'埼玉県',
								'千葉県':'千葉県',
								'東京都':'東京都',
								'神奈川県':'神奈川県',
								'新潟県':'新潟県',
								'富山県':'富山県',
								'石川県':'石川県',
								'福井県':'福井県',
								'山梨県':'山梨県',
								'長野県':'長野県',
								'岐阜県':'岐阜県',
								'静岡県':'静岡県',
								'愛知県':'愛知県',
								'三重県':'三重県',
								'滋賀県':'滋賀県',
								'京都府':'京都府',
								'大阪府':'大阪府',
								'兵庫県':'兵庫県',
								'奈良県':'奈良県',
								'和歌山県':'和歌山県',
								'鳥取県':'鳥取県',
								'島根県':'島根県',
								'岡山県':'岡山県',
								'広島県':'広島県',
								'山口県':'山口県',
								'徳島県':'徳島県',
								'香川県':'香川県',
								'愛媛県':'愛媛県',
								'福岡県':'福岡県',
								'佐賀県':'佐賀県',
								'長崎県':'長崎県',
								'熊本県':'熊本県',
								'大分県':'大分県',
								'宮崎県':'宮崎県',
								'鹿児島県':'鹿児島県',
								'沖縄県':'沖縄県'
							}" value="%{#session.prefecture}"/>
							<s:fielderror fieldName="prefecture" style="color:red;"/>
						</td>
					</tr>
					<tr>
						<td>
							<label>住所（市区町村）</label>
						</td>
						<td>
							<s:textfield name="address_1" value="%{#session.address_1}" maxlength="10"/>
							<s:fielderror fieldName="address_1" style="color:red;"/>
						</td>
					</tr>
					<tr>
						<td>
							<label>住所（番地）</label>
						</td>
						<td>
							<s:textfield name="address_2" value="%{#session.address_2}" maxlength="100"/>
							<s:fielderror fieldName="address_2" style="color:red;"/>
						</td>
					</tr>
					<tr>
						<td>
							<label>アカウント権限</label>
						</td>
						<td>
							 <select name="authority">
								<option value="0" selected>一般</option>
    							<option value="1">管理者</option>
							</select>
						</td>
					</tr>
					<tr>
                    <td colspan="2">
                        <s:submit value="確認する" style="margin-right:100px;"/>
                    </td>
            	    </tr>
				</s:form>
			</table>
		</div>
	</main>
    <footer>
      Copyright D.I.works|D.I.blog is the one which provides A to Z about programming
    </footer>
</body>
</html>