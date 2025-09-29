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
	
	<title>アカウント一覧画面</title>
	<link rel="stylesheet" type="text/css" href="./css/styles.css">
	<style type="text/css">

		#list{
			margin-top:90px;
		}
		#list p{
			padding-left:50px;
			font-size:25px;
		}
		.list-container{
			margin-top:50px;		
		}
		
		 table {
            border-collapse: collapse;
            margin: 20px auto;
            width: 60%;
        }
        th, td {
            border: 1px solid #999;
            padding: 16px 12px;
            text-align: left;
        }
		.search-container input[type="text"],
		.search-container input[type="email"],
		.search-container select,
		.search-container .s-radio {
		    width: 100%;          
		    box-sizing: border-box;
		    padding: 8px;
		}
		
		.action-btn {
		   margin: 10px 0;
		    padding: 12px 24px;   
		    font-size: 18px;  
		    cursor: pointer;   
		    color: black;
        }
		 .action-button {
	        display: flex;
	        justify-content: space-between;
	        width: 100px; 
	        margin: 0 auto;
   		 }
		

		.center-form{
		margin:0 50% 0 50%;
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
    	<div id=list>
			<p>アカウント一覧画面</p>
		</div>
		
		<div class="search-container" style="margin:20px auto; width:80%;">
		    <s:form action="list" method="post" theme="simple">
		        <table style="border-collapse: collapse; width: 100%;">
		            <tr>
		                <td style="width:15%;">名前（姓）</td>
		                <td style="width:35%;"><s:textfield name="familyName" style="width:100%;"/></td>
		                <td style="width:15%;">名前（名）</td>
		                <td style="width:35%;"><s:textfield name="lastName" style="width:100%;"/></td>
		            </tr>
		            <tr>
		                <td>カナ（姓）</td>
		                <td><s:textfield name="familyNameKana" style="width:100%;"/></td>
		                <td>カナ（名）</td>
		                <td><s:textfield name="lastNameKana" style="width:100%;"/></td>
		            </tr>
		            <tr>
		                <td>メールアドレス</td>
		                <td><s:textfield name="mail" style="width:100%;"/></td>
		                <td>性別</td>
		                <td>
		                    <s:radio name="gender" list="genderList" value="0" theme="simple"/>
		                </td>
		            </tr>
		            <tr>
		                <td>アカウント権限</td>
		                <td colspan="3">
		                    <s:select name="authority" list="authorityList" value="0" style="width:20%;"/>
		                </td>
		            </tr>
		        </table>
	
		        <div style="text-align: right; margin-top: 10px;">
		            <s:submit value="検索" cssClass="action-btn"/>
		        </div>
		    </s:form>
		</div>
		
		<div class="list-container">
			<s:if test="accountList != null">
			 <table>
			        <tr>
			            <th>ID</th>
			            <th>名前（姓）</th>
			            <th>名前（名）</th>
			            <th>カナ（姓）</th>
			            <th>カナ（名）</th>
			            <th>メールアドレス</th>
			            <th>性別</th>
			            <th>アカウント権限</th>
			            <th>削除フラグ</th>
			            <th>登録日時</th>
			            <th>更新日時</th>
			            <th>操作</th>
			        </tr>
			
			        <s:iterator value="accountList" var="acc">
			            <tr>
			                <td><s:property value="#acc.id"/></td>
			                <td><s:property value="#acc.familyName"/></td>
			                <td><s:property value="#acc.lastName"/></td>
			                <td><s:property value="#acc.familyNameKana"/></td>
			                <td><s:property value="#acc.lastNameKana"/></td>
			                <td><s:property value="#acc.mail"/></td>
			                <td>
			                    <s:if test="#acc.gender == 0">男</s:if>
			                    <s:elseif test="#acc.gender == 1">女</s:elseif>
			                </td>
			                <td>
			                    <s:if test="#acc.authority == 0">一般</s:if>
			                    <s:elseif test="#acc.authority == 1">管理者</s:elseif>
			                </td>
			                <td>
			                    <s:if test="#acc.deleteFlg == 0">有効</s:if>
			                    <s:elseif test="#acc.deleteFlg == 1">無効</s:elseif>
			                </td>
			                <td><s:date name="#acc.insertDate" format="yyyy/MM/dd"/></td>
			                <td><s:date name="#acc.updateDate" format="yyyy/MM/dd"/></td>
			                <td>
			                    <div class="action-button">
							        <s:form action="update" method="post" theme="simple">
							            <s:hidden name="id" value="%{#acc.id}"/>
							            <s:submit value="更新"/>
							        </s:form>
							        <s:form action="delete" method="post" theme="simple">
							            <s:hidden name="id" value="%{#acc.id}"/>
							            <s:submit value="削除"/>
							        </s:form>
							    </div>
			                </td>
			            </tr>
			        </s:iterator>
			    </table>
				 </s:if>			
			</div>
	</main>
    <footer>
      Copyright D.I.works|D.I.blog is the one which provides A to Z about programming
    </footer>
    </body>
  </html>