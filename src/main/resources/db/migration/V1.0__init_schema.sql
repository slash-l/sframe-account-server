-- ----------------------------
-- oauth_client_details 应用注册表
-- ----------------------------
DROP TABLE IF EXISTS `oauth_client_details`;
CREATE TABLE `oauth_client_details`
(
    `id`                      varchar(50) NOT NULL,
    `client_id`               varchar(48) NOT NULL,
    `resource_ids`            varchar(256)  DEFAULT NULL,
    `client_secret`           varchar(256)  DEFAULT NULL,
    `scope`                   varchar(256)  DEFAULT NULL,
    `authorized_grant_types`  varchar(256)  DEFAULT NULL,
    `web_server_redirect_uri` varchar(256)  DEFAULT NULL,
    `authorities`             varchar(256)  DEFAULT NULL,
    `access_token_validity`   int(11) DEFAULT NULL,
    `refresh_token_validity`  int(11) DEFAULT NULL,
    `additional_information`  varchar(4096) DEFAULT NULL,
    `autoapprove`             varchar(256)  DEFAULT NULL,
    `cst_create`              DATETIME      DEFAULT NULL,
    `create_user`             varchar(50)   DEFAULT NULL,
    `cst_modified`            DATETIME      DEFAULT NULL,
    `update_user`             varchar(50)   DEFAULT NULL,
    `log_id`                  varchar(50)   DEFAULT NULL,
    PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- t_user 系统用户表
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user`
(
    `id`           varchar(50)  NOT NULL,
    `user_name`    varchar(20)  NOT NULL,
    `password`     varchar(256) NOT NULL,
    `role`         varchar(20)  NOT NULL,
    `cst_create`   DATETIME    DEFAULT NULL,
    `create_user`  varchar(50) DEFAULT NULL,
    `cst_modified` DATETIME    DEFAULT NULL,
    `update_user`  varchar(50) DEFAULT NULL,
    `log_id`       varchar(50) DEFAULT NULL,
    PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;