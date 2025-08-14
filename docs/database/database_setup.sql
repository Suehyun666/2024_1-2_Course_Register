-- 데이터베이스 생성
create database student;
use student;

-- create table

CREATE TABLE `enrollment` (
  `student_id` int NOT NULL,
  `course_id` int NOT NULL,
  `course_time` varchar(20) DEFAULT NULL,
  `course_day` varchar(10) DEFAULT NULL,
  `course_day1` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`student_id`,`course_id`),
  UNIQUE KEY `course_id` (`course_id`,`student_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `members` (
  `student_id` int NOT NULL,
  `pw` char(64) NOT NULL,
  `name` char(8) NOT NULL,
  `department` varchar(45) NOT NULL,
  `Score` int DEFAULT NULL,
  `maxScore` int DEFAULT NULL,
  `lectures` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`student_id`,`pw`),
  UNIQUE KEY `idx_student_id` (`student_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `all_lecture` (
  `id` int NOT NULL,
  `name` varchar(45) DEFAULT NULL,
  `proname` varchar(45) DEFAULT NULL,
  `Score` varchar(45) DEFAULT NULL,
  `Time` varchar(45) DEFAULT NULL,
  `day` varchar(45) DEFAULT NULL,
  `day2` varchar(45) DEFAULT NULL,
  `link` varchar(45) DEFAULT NULL,
  `etc` varchar(45) DEFAULT NULL,
  `currentpeople` int DEFAULT NULL,
  `wishpeople` int DEFAULT NULL,
  `peoplelimit` int DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `basket` (
  `student_id` int NOT NULL,
  `course_id` int NOT NULL,
  PRIMARY KEY (`student_id`,`course_id`),
  UNIQUE KEY `course_id` (`course_id`,`student_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- insert 문

-- 전체 강좌
INSERT INTO `all_lecture` VALUES (1010,'영어1','여인욱','3','1030-1145','월','수','englishYG',NULL,0,0,3),(1011,'영어회화1','다니엘','2','1030-1145','월','수','englishYG',NULL,1,0,3),(1020,'글쓰기','육민수','3','1030-1145','월','수','basic',NULL,0,0,3),(1021,'발표와토의','주민재','3','1030-1145','월','수','basic',NULL,0,0,3),(1030,'한국근현대사의이해','윤홍석','3','1030-1145','월','수','selective',NULL,0,0,3),(1031,'민주주의와현대사','윤홍석','3','1200-1315','월','수','selective',NULL,0,0,3),(1110,'전기공학1','한국열','3','0900-1015','월','수','electricity',NULL,0,0,3),(1111,'전기공학2','한국열','3','1030-1145','월','수','electricity',NULL,0,0,3),(1140,'화학','김선경','3','0900-1015','월','수','chemistry',NULL,0,0,3),(1210,'C언어','전종훈','3','1800-1950','화','목','computer',NULL,0,0,3),(1211,'시스템과프로그래밍','권동섭','4','1300-1450','목','금','computer',NULL,0,0,33),(1221,'수학교재연구','박진형','2','1300-1450','화',NULL,'math',NULL,0,0,3),(1222,'정수론','소순태','3','1300-1350','월',NULL,'math',NULL,0,0,3),(1230,'식품학','황지영','3','1300-1350','월',NULL,'food',NULL,0,0,3),(1240,'미생물학','이상희','4','0900-1015','월',NULL,'life',NULL,0,0,3),(1310,'물리학1','김주학','3','1000-1150','월',NULL,'physics',NULL,0,0,3),(1311,'물리학2','김주학','3','1200-1350','월',NULL,'physics',NULL,0,0,3);
-- 수강신청한 강좌
INSERT INTO `enrollment` VALUES (60221333,1011,'1030-1145','월','수');
-- 학생
INSERT INTO `members` VALUES (0,'03ac674216f3e15c761ee1a5e255f067953623c8b388b4459e13f978d7c846f4','관리자','관리자',0,18,NULL),(60221123,'03ac674216f3e15c761ee1a5e255f067953623c8b388b4459e13f978d7c846f4','칼융','신소재공학과',0,18,NULL),(60221330,'03ac674216f3e15c761ee1a5e255f067953623c8b388b4459e13f978d7c846f4','조하르','철학과',0,16,NULL),(60221331,'03ac674216f3e15c761ee1a5e255f067953623c8b388b4459e13f978d7c846f4','박수현','융합소프트웨어학부',0,18,''),(60221332,'03ac674216f3e15c761ee1a5e255f067953623c8b388b4459e13f978d7c846f4','박수현','융합소프트웨어학부',0,18,NULL),(60221333,'03ac674216f3e15c761ee1a5e255f067953623c8b388b4459e13f978d7c846f4','박수현','융합소프트웨어학부',2,21,''),(60221334,'03ac674216f3e15c761ee1a5e255f067953623c8b388b4459e13f978d7c846f4','황수인','디지털미디어콘텐츠학과',0,18,NULL),(60221335,'03ac674216f3e15c761ee1a5e255f067953623c8b388b4459e13f978d7c846f4','조하선','문예창작학과',0,16,NULL),(60221336,'03ac674216f3e15c761ee1a5e255f067953623c8b388b4459e13f978d7c846f4','덩샤오핑','중문학과',0,16,NULL),(60221337,'03ac674216f3e15c761ee1a5e255f067953623c8b388b4459e13f978d7c846f4','박정희','청소년교육학과',0,16,NULL),(60221338,'03ac674216f3e15c761ee1a5e255f067953623c8b388b4459e13f978d7c846f4','김종필','경제학과',0,16,NULL),(60221339,'03ac674216f3e15c761ee1a5e255f067953623c8b388b4459e13f978d7c846f4','김재익','경제학과',0,16,NULL);