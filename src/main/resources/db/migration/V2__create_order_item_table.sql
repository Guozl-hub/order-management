CREATE TABLE IF NOT EXISTS order_items
(
    id       BIGINT AUTO_INCREMENT PRIMARY KEY COMMENT '自增主键',
    name     varchar(20)   NOT NULL COMMENT '物品名称',
    cost     DECIMAL(6, 2) NOT NULL COMMENT '金额',
    order_id BIGINT        NOT NULL,
    FOREIGN KEY (order_id) REFERENCES Orders (id)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_bin;

