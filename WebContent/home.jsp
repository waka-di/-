<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
<meta http-equiv="Content-Style-Type" content="text/css"/>
<meta http-equiv="Content-Script-Type" content="text/javascript"/>
<meta http-equiv="imagetoolbar" content="no"/>
<meta name="description" content=""/>
<meta name="keywords" content=""/>
<title>ブログ・ニュース系コンテンツ</title>
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
        <li><a href='<s:url action="registAction"/>'>アカウント登録</a></li>
        
      </ul>
    </div>
    </header>
        <main>
            <div class="container">
          <div class="main-container">
          <h1>プログラミングに役立つ書籍</h1>
          <p class="date">2017年1月15日</p>
          <div class="homepic">
            <img src="./data/bookstore.jpg">
          </div>
          <p class="description">D.I.BlogはD.I.worksが提供する演習課題です。</p>
          <h2>記事中身</h2>
          <div class="images">
            <div class="up">
              <div class="pic1">
                <img src="./data/pic1.jpg">
                <p class="pic-comment">ドメイン取得方法</p>
              </div>
              <div class="pic2">
                <img src="./data/pic2.jpg">
                <p class="pic-comment">快感な職場環境</p>
              </div>
              <div class="pic3">
                <img src="./data/pic3.jpg">
                <p class="pic-comment">Linuxの基礎</p>
              </div>
              <div class="pic4">
                <img src="./data/pic4.jpg">
                <p class="pic-comment">マーケティング入門</p>
              </div>
            </div>
            <div class="down">
              <div class="pic5">
                <img src="./data/pic5.jpg">
                <p class="pic-comment">アクティブラーニング</p>
              </div>
              <div class="pic6">
                <img src="./data/pic6.jpg">
                <p class="pic-comment">CSSの効率的な勉強方法</p>
              </div>
              <div class="pic7">
                <img src="./data/pic7.jpg">
                <p class="pic-comment">リーダブルコードとは</p>
              </div>
              <div class="pic8">
                <img src="./data/pic8.jpg">
                <p class="pic-comment">HTMLの可能性</p>
              </div>
            </div>
          </div>
        </div>
        <div class="aside-container">
          <div class="aside-title">人気の記事</div>
          <ul>
            <li>PHPオススメ本</li>
            <li>PHP　MyAdminの使い方</li>
            <li>いま　人気のエディタTops</li>
            <li>HTMLの基礎</li>
          </ul>
          <div class="aside-title">オススメリンク</div>
          <ul>
            <li class="line-spacing">ディーアイワークス株式会社</li>
            <li>XAMPPのダウンロード</li>
            <li>Eclipseのダウンロード</li>
            <li>Braketsのダウンロード</li>
          </ul>
          <div class="aside-title">カテゴリ</div>
          <ul>
            <li>HTML</li>
            <li>PHP</li>
            <li>MySQL</li>
            <li>JavaScript</li>
          </ul>
        </div>
      </div>
    </main>
    <footer>
      Copyright D.I.works|D.I.blog is the one which provides A to Z about programming
    </footer>
    
  </body>
</html>