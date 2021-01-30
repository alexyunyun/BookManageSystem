	CREATE TABLE `book`.`bookrecord` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `author` VARCHAR(45) NOT NULL,
  `publish` VARCHAR(45) NOT NULL,
  `type` VARCHAR(45) NOT NULL,
  `time` VARCHAR(45) NOT NULL,
  `price` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

INSERT INTO `book`.`bookrecord` (`name`, `author`, `publish`, `type`, `time`, `price`) VALUES ('三体Ⅰ地球往事', '刘慈欣', '科幻世界杂志', '科幻', '2008-01-15', '49.8');
INSERT INTO `book`.`bookrecord` (`name`, `author`, `publish`, `type`, `time`, `price`) VALUES ('三体Ⅱ黑暗森林', '刘慈欣', '科幻世界杂志', '科幻', '2010-01-15', '49.8');
INSERT INTO `book`.`bookrecord` (`name`, `author`, `publish`, `type`, `time`, `price`) VALUES ('三体Ⅲ死神永生', '刘慈欣', '科幻世界杂志', '科幻', '2012-01-15', '49.8');
INSERT INTO `book`.`bookrecord` (`name`, `author`, `publish`, `type`, `time`, `price`) VALUES('Python编程入门经典 ', '张三', '机械工业出版社', '编程', '2008-01-15', '49.8');
INSERT INTO `book`.`bookrecord` (`name`, `author`, `publish`, `type`, `time`, `price`) VALUES ('Java零基础入门', '李四', '机械工业出版社','编程', '2008-01-15', '59.8');
INSERT INTO `book`.`bookrecord` (`name`, `author`, `publish`, `type`, `time`, `price`) VALUES('测试1', '111', '222', '科幻', '2008-01-15', '49.8');
INSERT INTO `book`.`bookrecord` (`name`, `author`, `publish`, `type`, `time`, `price`) VALUES ('测试2', '333', '3333', '科幻', '2008-01-15', '49.8');
