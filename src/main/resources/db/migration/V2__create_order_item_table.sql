CREATE TABLE IF NOT EXISTS order_items
(
    id     INT AUTO_INCREMENT PRIMARY KEY COMMENT '自增主键',
    cost varchar(200) NOT NULL COMMENT '金额',
    order_id INT NOT NULL ,
    FOREIGN KEY(order_id) REFERENCES Orders(id)
    ) ENGINE = InnoDB
    DEFAULT CHARSET = utf8mb4
    COLLATE = utf8mb4_bin;

