-- ----------------------------
-- oauth_client_details 初始化注册应用：
-- 应用名 clientapp
-- 初始密码 123
-- ----------------------------
insert into oauth_client_details
(`id`, `client_id`,
 `resource_ids`,
 `client_secret`,
 `scope`,
 `authorized_grant_types`,
 `web_server_redirect_uri`,
 `authorities`,
 `access_token_validity`,
 `refresh_token_validity`,
 `additional_information`,
 `autoapprove`)
values ('1', 'clientapp', '', '$2a$10$F4Ws2Y6j7xglmMb1RPhi/eloR9dCQlWXufMugPhoI133jE.Vb1jZC', 'Any',
        'password,authorization_code,refresh_token', '', '', 3600, 3600, '', '');

-- ----------------------------
-- t_user 初始化用户：
-- 系统管理员 admin
-- 普通用户 guest
-- 初始密码 123456
-- ----------------------------
insert into t_user
(`id`,
 `user_name`,
 `password`,
 `role`,
 `cst_create`,
 `create_user`,
 `cst_modified`,
 `update_user`,
 `log_id`)
values ('1', 'admin', '$2a$10$yAtArspz2vPkwVNZC8QFHutK/mFd9P82WpeIzquUu4eYM/xzJkxaW', 'ADMIN', sysdate(), 'SYSTEM',
        sysdate(), 'SYSTEM', uuid());
insert into t_user
(`id`,
 `user_name`,
 `password`,
 `role`,
 `cst_create`,
 `create_user`,
 `cst_modified`,
 `update_user`,
 `log_id`)
values ('2', 'guest', '$2a$10$yAtArspz2vPkwVNZC8QFHutK/mFd9P82WpeIzquUu4eYM/xzJkxaW', 'NORMAL', sysdate(), 'SYSTEM',
        sysdate(), 'SYSTEM', uuid());


