/*
SQLyog Ultimate v12.09 (64 bit)
MySQL - 5.5.61 : Database - ly_db
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`ly_db` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `ly_db`;

/*Table structure for table `tb_evaluate` */

DROP TABLE IF EXISTS `tb_evaluate`;

CREATE TABLE `tb_evaluate` (
  `evaluateUUID` char(32) NOT NULL COMMENT '评分编号',
  `sponsorUUID` char(32) DEFAULT NULL COMMENT '主办方编号',
  `gradeUUID` char(32) DEFAULT NULL COMMENT '评分项编号',
  `projectUUID` char(32) DEFAULT NULL COMMENT '项目编号',
  `score` int(11) DEFAULT NULL COMMENT '分数',
  `remark` text COMMENT '评委评语',
  `flag` tinyint(1) DEFAULT '0' COMMENT '是否为统计数据行',
  `status` tinyint(1) DEFAULT NULL COMMENT '是否提交(为统计数据行时判断)',
  PRIMARY KEY (`evaluateUUID`),
  KEY `gradeUUID` (`gradeUUID`),
  KEY `projectUUID` (`projectUUID`),
  KEY `sponsorUUID` (`sponsorUUID`),
  CONSTRAINT `tb_evaluate_ibfk_1` FOREIGN KEY (`gradeUUID`) REFERENCES `tb_grade` (`gradeUUID`),
  CONSTRAINT `tb_evaluate_ibfk_2` FOREIGN KEY (`projectUUID`) REFERENCES `tb_project` (`projectUUID`),
  CONSTRAINT `tb_evaluate_ibfk_3` FOREIGN KEY (`sponsorUUID`) REFERENCES `tb_sponsor` (`sponsorUUID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='评分表';

/*Data for the table `tb_evaluate` */

insert  into `tb_evaluate`(`evaluateUUID`,`sponsorUUID`,`gradeUUID`,`projectUUID`,`score`,`remark`,`flag`,`status`) values ('378aa85a4a1411e98ab7b4b6864c1dda','ed8c0a819f8a4882945e0a3a8bda3660','c29ec0c093d3424aa17ae183e6c5d6ab','c2dd92f8e8ab4ae9b5cbaae0367ccfd1',60,'string',1,1),('7ce1fd6b4a1411e98ab7b4b6864c1dda','ed8c0a819f8a4882945e0a3a8bda3660','c29ec0c093d3424aa17ae183e6c5d6ab','c2dd92f8e8ab4ae9b5cbaae0367ccfd1',70,'string',1,1);

/*Table structure for table `tb_grade` */

DROP TABLE IF EXISTS `tb_grade`;

CREATE TABLE `tb_grade` (
  `gradeUUID` char(32) NOT NULL COMMENT '评分项编号',
  `sponsorUUID` char(32) DEFAULT NULL COMMENT '路演编号',
  `gradeName` varchar(10) DEFAULT NULL COMMENT '评分项',
  `grade` int(11) DEFAULT NULL COMMENT '分值',
  PRIMARY KEY (`gradeUUID`),
  KEY `sponsorUUID` (`sponsorUUID`),
  CONSTRAINT `tb_grade_ibfk_1` FOREIGN KEY (`sponsorUUID`) REFERENCES `tb_sponsor` (`sponsorUUID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='评分项';

/*Data for the table `tb_grade` */

insert  into `tb_grade`(`gradeUUID`,`sponsorUUID`,`gradeName`,`grade`) values ('c29ec0c093d3424aa17ae183e6c5d6ab','ed8c0a819f8a4882945e0a3a8bda3660','HAHAHHA',100);

/*Table structure for table `tb_judge` */

DROP TABLE IF EXISTS `tb_judge`;

CREATE TABLE `tb_judge` (
  `judgeUUID` char(32) NOT NULL COMMENT '评委方编号',
  `sponsorUUID` char(32) DEFAULT NULL COMMENT '主办方编号',
  `userUUID` char(32) DEFAULT NULL COMMENT '用户编号',
  `judgeName` varchar(10) DEFAULT NULL COMMENT '评委姓名',
  `phone` char(11) DEFAULT NULL COMMENT '电话',
  `organ` varchar(25) DEFAULT NULL COMMENT '机构名称',
  `flag` char(1) DEFAULT '1' COMMENT '0主办方 1评委方 2项目方',
  PRIMARY KEY (`judgeUUID`),
  KEY `sponsorUUID` (`sponsorUUID`),
  KEY `userUUID` (`userUUID`),
  CONSTRAINT `tb_judge_ibfk_1` FOREIGN KEY (`sponsorUUID`) REFERENCES `tb_sponsor` (`sponsorUUID`),
  CONSTRAINT `tb_judge_ibfk_2` FOREIGN KEY (`userUUID`) REFERENCES `tb_user` (`userUUID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='评委方';

/*Data for the table `tb_judge` */

insert  into `tb_judge`(`judgeUUID`,`sponsorUUID`,`userUUID`,`judgeName`,`phone`,`organ`,`flag`) values ('920ede53f4474c7bbb70c605c9e370d3','ed8c0a819f8a4882945e0a3a8bda3660','123','好好给你起个名','119','ORG','1');

/*Table structure for table `tb_project` */

DROP TABLE IF EXISTS `tb_project`;

CREATE TABLE `tb_project` (
  `projectUUID` char(32) NOT NULL COMMENT '项目方编号',
  `sponsorUUID` char(32) DEFAULT NULL COMMENT '主办方编号',
  `userUUID` char(32) DEFAULT NULL COMMENT '用户编号',
  `linkMan` varchar(10) DEFAULT NULL COMMENT '联系人',
  `phone` char(11) DEFAULT NULL COMMENT '电话',
  `projectName` varchar(25) DEFAULT NULL COMMENT '项目名称',
  `flag` char(1) DEFAULT '2' COMMENT '0主办方 1评委方 2项目方',
  PRIMARY KEY (`projectUUID`),
  KEY `sponsorUUID` (`sponsorUUID`),
  KEY `userUUID` (`userUUID`),
  CONSTRAINT `tb_project_ibfk_1` FOREIGN KEY (`sponsorUUID`) REFERENCES `tb_sponsor` (`sponsorUUID`),
  CONSTRAINT `tb_project_ibfk_2` FOREIGN KEY (`userUUID`) REFERENCES `tb_user` (`userUUID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='项目方';

/*Data for the table `tb_project` */

insert  into `tb_project`(`projectUUID`,`sponsorUUID`,`userUUID`,`linkMan`,`phone`,`projectName`,`flag`) values ('c2dd92f8e8ab4ae9b5cbaae0367ccfd1','ed8c0a819f8a4882945e0a3a8bda3660','123','123','123','123','2');

/*Table structure for table `tb_sponsor` */

DROP TABLE IF EXISTS `tb_sponsor`;

CREATE TABLE `tb_sponsor` (
  `sponsorUUID` char(32) NOT NULL COMMENT '主办方编号',
  `userUUID` char(32) DEFAULT NULL COMMENT '用户编号',
  `sponsorName` varchar(30) DEFAULT NULL COMMENT '路演名称',
  `sponsorOrg` varchar(25) DEFAULT NULL COMMENT '路演单位',
  `sponsorAdd` varchar(25) DEFAULT NULL COMMENT '路演地点',
  `beginTime` date DEFAULT NULL COMMENT '开始时间',
  `endTime` date DEFAULT NULL COMMENT '结束时间',
  `remark` text COMMENT '补充说明',
  `poster` varchar(255) DEFAULT NULL COMMENT '路演海报',
  `projectCode` char(4) DEFAULT NULL COMMENT '项目邀请码',
  `judgeCode` char(4) DEFAULT NULL COMMENT '评委邀请码',
  `flag` char(1) DEFAULT '0' COMMENT '0主办方 1评委方 2项目方',
  `status` char(1) DEFAULT NULL COMMENT '0未开始 1进行中 2已结束',
  PRIMARY KEY (`sponsorUUID`),
  KEY `userUUID` (`userUUID`),
  CONSTRAINT `tb_sponsor_ibfk_1` FOREIGN KEY (`userUUID`) REFERENCES `tb_user` (`userUUID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='主办方';

/*Data for the table `tb_sponsor` */

insert  into `tb_sponsor`(`sponsorUUID`,`userUUID`,`sponsorName`,`sponsorOrg`,`sponsorAdd`,`beginTime`,`endTime`,`remark`,`poster`,`projectCode`,`judgeCode`,`flag`,`status`) values ('08b80a6065ed416c95059473cef33dfe','123','132的路演','专才','广现','2019-03-18','2019-03-18','发啊发','无','SUER','OPIU','0','1'),('ed8c0a819f8a4882945e0a3a8bda3660','742e87a827894f02aa3f653e935fed68','我是王百逸的路演','专才','广现','2019-03-16','2019-03-17','哈哈哈','这个有点慢啊','SUOP','POLA','0','1');

/*Table structure for table `tb_user` */

DROP TABLE IF EXISTS `tb_user`;

CREATE TABLE `tb_user` (
  `userUUID` char(32) NOT NULL COMMENT '用户编号',
  `openID` char(28) DEFAULT NULL COMMENT '用户openID',
  `username` varchar(10) DEFAULT NULL COMMENT '姓名',
  `phone` char(11) DEFAULT NULL COMMENT '手机号码',
  `organ` varchar(25) DEFAULT NULL COMMENT '机构/项目',
  PRIMARY KEY (`userUUID`),
  UNIQUE KEY `openID` (`openID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户表';

/*Data for the table `tb_user` */

insert  into `tb_user`(`userUUID`,`openID`,`username`,`phone`,`organ`) values ('0','0','缓存用户',NULL,NULL),('123','test321','王百逸2','13143625426','专才'),('742e87a827894f02aa3f653e935fed68','test123','王百逸','13719664496','专才'),('9c79605242b84fa2977d4fa1775c8bab','odVm94gSthhI_8-9mTKaf_hce-tU','tanaa','13671477734','haha12');

/* Procedure structure for procedure `pro_sponsor_checkStatus` */

/*!50003 DROP PROCEDURE IF EXISTS  `pro_sponsor_checkStatus` */;

DELIMITER $$

/*!50003 CREATE DEFINER=`root`@`localhost` PROCEDURE `pro_sponsor_checkStatus`()
begin  
update tb_sponsor 
set status = 2
where endTime < CURDATE();
update tb_sponsor 
set status = 1
where endTime >= CURDATE()
and beginTime <= CURDATE();
update tb_sponsor 
set status = 0
where beginTime > CURDATE();
end */$$
DELIMITER ;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
