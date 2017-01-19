-- --------------------------------------------------------
-- 主机:                           localhost
-- 服务器版本:                        5.5.28 - MySQL Community Server (GPL)
-- 服务器操作系统:                      Win64
-- HeidiSQL 版本:                  9.0.0.4865
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

-- 导出 aaron 的数据库结构
CREATE DATABASE IF NOT EXISTS `aaron` /*!40100 DEFAULT CHARACTER SET gbk */;
USE `aaron`;


-- 导出  表 aaron.user 结构
CREATE TABLE IF NOT EXISTS `user` (
  `id` varchar(255) NOT NULL COMMENT '用户id',
  `user_name` varchar(255) DEFAULT NULL COMMENT '昵称/用户名',
  `login_name` varchar(255) DEFAULT NULL COMMENT '登录用户名',
  `password` varchar(255) DEFAULT NULL COMMENT '用户密码',
  `qq_name` varchar(255) DEFAULT NULL COMMENT 'qq密码',
  `wx_name` varchar(255) DEFAULT NULL COMMENT '微信名称',
  `sex` int(10) NOT NULL DEFAULT '0' COMMENT '1代表男 0代表女',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=gbk;

-- 正在导出表  aaron.user 的数据：~1 rows (大约)
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
REPLACE INTO `user` (`id`, `user_name`, `login_name`, `password`, `qq_name`, `wx_name`, `sex`) VALUES
	('123', 'tom', 'tom', '11', '11', '1', 0);
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
