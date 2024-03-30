-- --------------------------------------------------------
-- 호스트:                          127.0.0.1
-- 서버 버전:                        8.0.16 - MySQL Community Server - GPL
-- 서버 OS:                        Win64
-- HeidiSQL 버전:                  12.5.0.6677
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


-- univ 데이터베이스 구조 내보내기
CREATE DATABASE IF NOT EXISTS `univ` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `univ`;

-- 테이블 univ.dept 구조 내보내기
CREATE TABLE IF NOT EXISTS `dept` (
  `dept_id` int(11) NOT NULL AUTO_INCREMENT,
  `univ_id` int(11) NOT NULL,
  `dept_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`dept_id`),
  KEY `FK_univ_TO_dept_1` (`univ_id`),
  CONSTRAINT `FK_univ_TO_dept_1` FOREIGN KEY (`univ_id`) REFERENCES `univ` (`univ_id`)
) ENGINE=InnoDB AUTO_INCREMENT=13566 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- 내보낼 데이터가 선택되어 있지 않습니다.

-- 테이블 univ.region 구조 내보내기
CREATE TABLE IF NOT EXISTS `region` (
  `region_id` tinyint(4) NOT NULL,
  `region_name` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`region_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- 내보낼 데이터가 선택되어 있지 않습니다.

-- 테이블 univ.univ 구조 내보내기
CREATE TABLE IF NOT EXISTS `univ` (
  `univ_id` int(11) NOT NULL AUTO_INCREMENT,
  `univ_name` varchar(255) DEFAULT NULL,
  `region_id` tinyint(4) NOT NULL,
  `univ_logo_url` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`univ_id`),
  KEY `FK_region_TO_univ_1` (`region_id`),
  CONSTRAINT `FK_region_TO_univ_1` FOREIGN KEY (`region_id`) REFERENCES `region` (`region_id`)
) ENGINE=InnoDB AUTO_INCREMENT=389 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- 내보낼 데이터가 선택되어 있지 않습니다.

/*!40103 SET TIME_ZONE=IFNULL(@OLD_TIME_ZONE, 'system') */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;
