CREATE TABLE IF NOT EXISTS `Orders`
(
    id     INT AUTO_INCREMENT PRIMARY KEY COMMENT '自增主键',
    status varchar(200) NOT NULL COMMENT '订单状态'
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_bin;
