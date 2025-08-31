set names utf8;
set foreign_key_checks = 0;
drop database if exists account;
create database if not exists account;
use account; 

drop table if exists account_data;

create table account_data(
id int(100) primary key auto_increment , --ID primary key=自動採番
family_name varchar(100),                 --名前（姓）
last_name varchar(100),                   --名前（名）
family_name_kana varchar(100),            --カナ（姓）
last_name_kana varchar(100),              --カナ（名）
mail varchar(255),                        --メアド
password varchar(255),                    --パスワード
gender int(1),                             -- 性別→ 0:男, 1:女
postal_code int(7),                        --郵便番号
prefecture varchar(100),                  --住所（都道府県）
address_1 varchar(100),                   --住所（市区町村）
address_2 varchar(255),                   --住所（番地）
authority int(1),                          -- アカウント権限→ 0:一般, 1:管理者
delete_flag int(1),                        -- 削除フラグ→ 0:有効, 1:無効
registered_time datetime,                  --登録日時
update_time datetime                       --更新日時
);

