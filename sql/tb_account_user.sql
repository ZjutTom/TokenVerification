create table tb_account_user(
    id varchar (10) not null comment 'id',
    username varchar (20) not null default "" comment '用户名',
    password varchar (50) not null default "" comment '密码',
    primary key (id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;