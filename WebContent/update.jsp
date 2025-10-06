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

    <title>アカウント更新画面</title> 
    <link rel="stylesheet" type="text/css" href="./css/styles.css"> 

    <style type="text/css"> 
        #update{ 
            margin-top:82px 
        } 
        
        .update-container { 
            max-width:800px;
		    margin: 0 auto;
		    padding: 20px;
        } 
        .form-group {
		    display: flex;
		    align-items: flex-start;
		    margin-bottom: 20px;
		}
		
		.form-group label {
		    width: 200px;         
		    font-weight: bold;
		    margin-right: 10px;
		    padding-top: 5px;    
		}
		
		.input-wrapper {
		    display: flex;
		    flex-direction: column;
		}
		
		.input-wrapper input,
		.input-wrapper select,
		.input-wrapper textarea {
		    width: 250px; 
		    padding: 5px;
		}
		.input-wrapper.small-input input,
		.input-wrapper.small-input select {
	   	 width: 150px;
		}

		.input-wrapper .radio,
		.input-wrapper .checkbox {
		    display: flex;
		    gap: 10px;
		    margin-top: 5px;
		}
		.input-wrapper_1{
			flex-direction: row;
		}
		.input-wrapper .radio {
		    display: flex;
		    gap: 20px;
		    align-items: center;
		     width: 55px;
		}
		
		.error {
		    color: red;
		    margin-top: 5px; 
		}
		

		.form-actions {
		    display: flex;
		    justify-content: center;  
		    margin-top: 40px;
		    margin-right:50px;
		}
		
		.form-actions input[type="submit"] {
		    padding: 10px 30px;
		    font-size: 1.1em;
		    cursor: pointer;
		}
        footer {
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
    <div id="update"> 
        <p>アカウント更新画面</p> 
    </div> 
    <div class="update-container">
            <s:form action="update_confirm" theme="simple">
  			  <s:hidden name="id" value="%{id}"/>

    <div class="form-group">
        <label>名前（姓）</label>
        <div class="input-wrapper">
            <s:textfield name="familyName" value="%{familyName}" maxlength="10"/>
            <s:fielderror fieldName="familyName" cssStyle="color:red;"/>
        </div>
    </div>
    <div class="form-group">
        <label>名前（名）</label>
        <div class="input-wrapper">
            <s:textfield name="lastName" value="%{lastName}" maxlength="10"/>
            <s:fielderror fieldName="lastName" cssStyle="color:red;"/>
        </div>
    </div>
    <div class="form-group">
        <label>カナ（姓）</label>
        <div class="input-wrapper">
            <s:textfield name="familyNameKana" value="%{familyNameKana}" maxlength="10"/>
            <s:fielderror fieldName="familyNameKana" cssStyle="color:red;"/>
        </div>
    </div>
    <div class="form-group">
        <label>カナ（名）</label>
        <div class="input-wrapper">
            <s:textfield name="lastNameKana" value="%{lastNameKana}" maxlength="10"/>
            <s:fielderror fieldName="lastNameKana" cssStyle="color:red;"/>
        </div>
    </div>
    <div class="form-group">
        <label>メールアドレス</label>
        <div class="input-wrapper">
            <s:textfield name="mail" value="%{mail}" maxlength="100"/>
            <s:fielderror fieldName="mail" cssStyle="color:red;"/>
        </div>
    </div>
    <div class="form-group">
  		<label>パスワード</label>
        <div class="input-wrapper">
           <s:textfield name="password" value="%{password}" maxlength="10"/>
           <p>※パスワードは変更する場合のみ入力してください</p>
            <s:fielderror fieldName="password" cssStyle="color:red;"/>
        </div>
    </div>
    <div class="form-group">
        <label>性別</label>
        <div class="input-wrapper_1">
            <s:radio name="gender" list="#{'0':'男','1':'女'}" value="%{gender}"/>
        </div>
    </div>
    <div class="form-group">
        <label>郵便番号</label>
        <div class="input-wrapper small-input">
            <s:textfield name="postalCode" value="%{postalCode}" maxlength="7"/>
            <s:fielderror fieldName="postalCode" cssStyle="color:red;"/>
        </div>
    </div>
    <div class="form-group">
        <label>住所（都道府県）</label>
         <div class="input-wrapper small-input">
            <s:select name="prefecture"
                      list="#{
                        '':'',
                        '北海道':'北海道','青森県':'青森県','岩手県':'岩手県',
                        '宮城県':'宮城県','秋田県':'秋田県','山形県':'山形県',
                        '福島県':'福島県','茨城県':'茨城県','栃木県':'栃木県',
                        '群馬県':'群馬県','埼玉県':'埼玉県','千葉県':'千葉県',
                        '東京都':'東京都','神奈川県':'神奈川県',
                        '新潟県':'新潟県','富山県':'富山県','石川県':'石川県',
                        '福井県':'福井県','山梨県':'山梨県','長野県':'長野県',
                        '岐阜県':'岐阜県','静岡県':'静岡県','愛知県':'愛知県',
                        '三重県':'三重県','滋賀県':'滋賀県','京都府':'京都府',
                        '大阪府':'大阪府','兵庫県':'兵庫県','奈良県':'奈良県',
                        '和歌山県':'和歌山県','鳥取県':'鳥取県','島根県':'島根県',
                        '岡山県':'岡山県','広島県':'広島県','山口県':'山口県',
                        '徳島県':'徳島県','香川県':'香川県','愛媛県':'愛媛県',
                        '高知県':'高知県','福岡県':'福岡県','佐賀県':'佐賀県',
                        '長崎県':'長崎県','熊本県':'熊本県','大分県':'大分県',
                        '宮崎県':'宮崎県','鹿児島県':'鹿児島県','沖縄県':'沖縄県'
                      }"
                      value="%{prefecture}"/>
                      <s:fielderror fieldName="prefecture" cssClass="error"/>
        </div>
    </div>
    <div class="form-group">
        <label>住所（市区町村）</label>
        <div class="input-wrapper">
            <s:textfield name="address_1" value="%{address_1}" maxlength="10"/>
            <s:fielderror fieldName="address_1" cssClass="error"/>
        </div>
    </div>
    <div class="form-group">
        <label>住所（番地）</label>
        <div class="input-wrapper">
            <s:textfield name="address_2" value="%{address_2}" maxlength="100"/>
            <s:fielderror fieldName="address_2" cssClass="error"/>
        </div>
    </div>
    <div class="form-group">
        <label>アカウント権限</label>
        <div class="input-wrapper small-input">
            <s:select name="authority" list="#{'0':'一般','1':'管理者'}" value="%{authority}"/>
        </div>
    </div>
    <div class="form-actions">
         <s:submit value="確認する"/>
     </div>
</s:form>
        </table>
    </div> 
</main> 
<footer> 
    Copyright D.I.works|D.I.blog is the one which provides A to Z about programming 
</footer> 
</body> 
</html>