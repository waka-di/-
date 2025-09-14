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
            height: min-height; 
            text-align: center; 
            width: 500px;
		  	margin: 0 auto;
		  	padding-bottom:100px;
        } 
       

        .form-display {
		  display: flex;
		  align-items: center;
		  margin-bottom: 15px;
		}

		.form-display label {
		  width: 160px;
		  font-weight: bold;
		  font-size: 18px;
		}

		.form-input input {
		  font-size: 18px;
		  padding: 8px; 
		  height: 40px; 
		  width: 100%;    
		  box-sizing: border-box;
		}
		
		.login-container .form-submit {
		  margin-top: 20px;
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
				
				<div class="form-display">
       				<label>メールアドレス</label>
	      			<div class="form-input">
							<s:textfield name = "mail" theme="simple"/>
					</div>
				</div>
				<div class="form-display">
					<label>パスワード</label>
					<div class="form-input">
						<s:password name="password" theme="simple"/>
					</div>
				</div>
				<div class="form-submit">
					<s:submit value="ログイン" theme="simple"/>
				</div>
			</s:form> 
	</div>
</main>
<footer> 
    Copyright D.I.works|D.I.blog is the one which provides A to Z about programming 
</footer> 
</body> 
</html>
</body>
</html>