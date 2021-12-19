/*
 Navicat Premium Data Transfer

 Source Server         : mysql8.0.20
 Source Server Type    : MySQL
 Source Server Version : 80022
 Source Host           : localhost:3306
 Source Schema         : sams

 Target Server Type    : MySQL
 Target Server Version : 80022
 File Encoding         : 65001

 Date: 19/12/2021 12:15:57
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for admin
-- ----------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin`  (
  `Account` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `Password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`Account`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of admin
-- ----------------------------
INSERT INTO `admin` VALUES ('111', '111');
INSERT INTO `admin` VALUES ('EamonX', '111');

-- ----------------------------
-- Table structure for class
-- ----------------------------
DROP TABLE IF EXISTS `class`;
CREATE TABLE `class`  (
  `ClassName` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `StudentNum` int(0) NULL DEFAULT NULL,
  PRIMARY KEY (`ClassName`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of class
-- ----------------------------
INSERT INTO `class` VALUES ('18网络工程1', 1);
INSERT INTO `class` VALUES ('18网络工程2', 2);
INSERT INTO `class` VALUES ('18网络工程3', 0);
INSERT INTO `class` VALUES ('18网络工程4', 0);
INSERT INTO `class` VALUES ('18网络工程5', 1);

-- ----------------------------
-- Table structure for course
-- ----------------------------
DROP TABLE IF EXISTS `course`;
CREATE TABLE `course`  (
  `CourseName` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `CourseHour` int(0) NULL DEFAULT NULL,
  `Credit` int(0) NULL DEFAULT NULL,
  PRIMARY KEY (`CourseName`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of course
-- ----------------------------
INSERT INTO `course` VALUES ('C语言', 48, 5);
INSERT INTO `course` VALUES ('Datebase', 32, 3);
INSERT INTO `course` VALUES ('Javaweb', 32, 3);
INSERT INTO `course` VALUES ('数学', 64, 6);
INSERT INTO `course` VALUES ('物理学', 32, 1);
INSERT INTO `course` VALUES ('社会工作', 48, 5);
INSERT INTO `course` VALUES ('英语', 32, 3);

-- ----------------------------
-- Table structure for grade
-- ----------------------------
DROP TABLE IF EXISTS `grade`;
CREATE TABLE `grade`  (
  `StudentId` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `CourseName` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `Grade` int(0) NULL DEFAULT NULL,
  `Semester` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`StudentId`, `CourseName`) USING BTREE,
  INDEX `CourseName2`(`CourseName`) USING BTREE,
  CONSTRAINT `CourseName2` FOREIGN KEY (`CourseName`) REFERENCES `course` (`CourseName`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `StudentId` FOREIGN KEY (`StudentId`) REFERENCES `student` (`StudentId`) ON DELETE CASCADE ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of grade
-- ----------------------------
INSERT INTO `grade` VALUES ('20180390001', 'Datebase', 70, '2021年秋');
INSERT INTO `grade` VALUES ('20180390001', 'Javaweb', 59, '2021年秋');
INSERT INTO `grade` VALUES ('20180390002', 'Datebase', 59, '2021年秋');
INSERT INTO `grade` VALUES ('20180390002', '数学', 100, '2021年秋');
INSERT INTO `grade` VALUES ('20180390002', '英语', 50, '2020年春');
INSERT INTO `grade` VALUES ('20180390250', '数学', NULL, '2021年春');

-- ----------------------------
-- Table structure for student
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student`  (
  `StudentId` varchar(11) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `StudentName` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `Sex` varchar(4) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `ClassName` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`StudentId`) USING BTREE,
  INDEX `ClassName`(`ClassName`) USING BTREE,
  CONSTRAINT `ClassName` FOREIGN KEY (`ClassName`) REFERENCES `class` (`ClassName`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of student
-- ----------------------------
INSERT INTO `student` VALUES ('20180390001', '校长', '女', '18网络工程1');
INSERT INTO `student` VALUES ('20180390002', '小蓝', '女', '18网络工程2');
INSERT INTO `student` VALUES ('20180390003', '测试触发器', '男', '18网络工程2');
INSERT INTO `student` VALUES ('20180390250', '前端', '女', '18网络工程5');

-- ----------------------------
-- Table structure for teacher
-- ----------------------------
DROP TABLE IF EXISTS `teacher`;
CREATE TABLE `teacher`  (
  `TeacherName` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `TeacherSex` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `TeacherId` int(0) NOT NULL,
  PRIMARY KEY (`TeacherId`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of teacher
-- ----------------------------
INSERT INTO `teacher` VALUES ('程序员', '女', 1);
INSERT INTO `teacher` VALUES ('林老师', '女', 2);
INSERT INTO `teacher` VALUES ('夏老师', '男', 18);
INSERT INTO `teacher` VALUES ('夏老师', '男', 19);
INSERT INTO `teacher` VALUES ('王老师', '女', 20);
INSERT INTO `teacher` VALUES ('铁', '男', 23);

-- ----------------------------
-- Table structure for teaching
-- ----------------------------
DROP TABLE IF EXISTS `teaching`;
CREATE TABLE `teaching`  (
  `CourseName` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `TeacherId` int(0) NOT NULL,
  PRIMARY KEY (`CourseName`, `TeacherId`) USING BTREE,
  INDEX `TeacherId`(`TeacherId`) USING BTREE,
  CONSTRAINT `CourseName` FOREIGN KEY (`CourseName`) REFERENCES `course` (`CourseName`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `TeacherId` FOREIGN KEY (`TeacherId`) REFERENCES `teacher` (`TeacherId`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of teaching
-- ----------------------------
INSERT INTO `teaching` VALUES ('社会工作', 2);
INSERT INTO `teaching` VALUES ('Datebase', 18);
INSERT INTO `teaching` VALUES ('物理学', 18);
INSERT INTO `teaching` VALUES ('C语言', 19);
INSERT INTO `teaching` VALUES ('C语言', 20);
INSERT INTO `teaching` VALUES ('数学', 20);
INSERT INTO `teaching` VALUES ('C语言', 23);
INSERT INTO `teaching` VALUES ('Datebase', 23);

-- ----------------------------
-- View structure for class_avg_grade
-- ----------------------------
DROP VIEW IF EXISTS `class_avg_grade`;
CREATE ALGORITHM = UNDEFINED SQL SECURITY DEFINER VIEW `class_avg_grade` AS select `class`.`ClassName` AS `ClassName`,avg(`grade`.`Grade`) AS `avg(grade.Grade)` from ((`student` join `grade` on((`student`.`StudentId` = `grade`.`StudentId`))) join `class` on((`student`.`ClassName` = `class`.`ClassName`))) group by `class`.`ClassName`;

-- ----------------------------
-- View structure for course_avg_grade
-- ----------------------------
DROP VIEW IF EXISTS `course_avg_grade`;
CREATE ALGORITHM = UNDEFINED SQL SECURITY DEFINER VIEW `course_avg_grade` AS select `course`.`CourseName` AS `CourseName`,avg(`grade`.`Grade`) AS `avg(grade.Grade)` from ((`grade` join `student`) join `course`) where ((`grade`.`StudentId` = `student`.`StudentId`) and (`course`.`CourseName` = `grade`.`CourseName`)) group by `grade`.`CourseName`;

-- ----------------------------
-- View structure for course_view
-- ----------------------------
DROP VIEW IF EXISTS `course_view`;
CREATE ALGORITHM = UNDEFINED SQL SECURITY DEFINER VIEW `course_view` AS select `course`.`CourseName` AS `CourseName`,`course`.`CourseHour` AS `CourseHour`,`course`.`Credit` AS `Credit`,`teacher`.`TeacherName` AS `TeacherName`,`teaching`.`TeacherId` AS `TeacherId` from ((`course` left join `teaching` on((`teaching`.`CourseName` = `course`.`CourseName`))) left join `teacher` on((`teaching`.`TeacherId` = `teacher`.`TeacherId`)));

-- ----------------------------
-- View structure for grade_view
-- ----------------------------
DROP VIEW IF EXISTS `grade_view`;
CREATE ALGORITHM = UNDEFINED SQL SECURITY DEFINER VIEW `grade_view` AS select `grade`.`CourseName` AS `CourseName`,`grade`.`Grade` AS `Grade`,`grade`.`Semester` AS `Semester`,`class`.`ClassName` AS `ClassName` from ((`class` join `student` on((`class`.`ClassName` = `student`.`ClassName`))) join `grade` on((`grade`.`StudentId` = `student`.`StudentId`)));

-- ----------------------------
-- View structure for student_semester_grade
-- ----------------------------
DROP VIEW IF EXISTS `student_semester_grade`;
CREATE ALGORITHM = UNDEFINED SQL SECURITY DEFINER VIEW `student_semester_grade` AS select `student`.`StudentId` AS `StudentId`,`student`.`StudentName` AS `StudentName`,`grade`.`Semester` AS `Semester`,avg(`grade`.`Grade`) AS `AVG(grade.Grade)` from (`student` join `grade` on((`student`.`StudentId` = `grade`.`StudentId`))) group by `student`.`StudentId`,`student`.`StudentName`,`grade`.`Semester`;

-- ----------------------------
-- View structure for teaching_view
-- ----------------------------
DROP VIEW IF EXISTS `teaching_view`;
CREATE ALGORITHM = UNDEFINED SQL SECURITY DEFINER VIEW `teaching_view` AS select `teaching`.`CourseName` AS `CourseName`,`teacher`.`TeacherName` AS `TeacherName`,`teaching`.`TeacherId` AS `TeacherId` from (`teacher` join `teaching` on((`teacher`.`TeacherId` = `teaching`.`TeacherId`))) order by `teaching`.`CourseName`;

-- ----------------------------
-- Triggers structure for table student
-- ----------------------------
DROP TRIGGER IF EXISTS `classNum_add_trigger`;
delimiter ;;
CREATE TRIGGER `classNum_add_trigger` AFTER INSERT ON `student` FOR EACH ROW begin
UPDATE class SET StudentNum=StudentNum+1 WHERE ClassName= New.ClassName;
end
;;
delimiter ;

-- ----------------------------
-- Triggers structure for table student
-- ----------------------------
DROP TRIGGER IF EXISTS `classNum_del_trigger`;
delimiter ;;
CREATE TRIGGER `classNum_del_trigger` AFTER DELETE ON `student` FOR EACH ROW begin
UPDATE class SET StudentNum=StudentNum-1 WHERE ClassName= old.ClassName;
end
;;
delimiter ;

-- ----------------------------
-- Triggers structure for table student
-- ----------------------------
DROP TRIGGER IF EXISTS `classNum_update_trigger`;
delimiter ;;
CREATE TRIGGER `classNum_update_trigger` AFTER UPDATE ON `student` FOR EACH ROW begin
UPDATE class SET StudentNum=StudentNum-1 WHERE ClassName=old.ClassName;
UPDATE class SET StudentNum=StudentNum+1 WHERE ClassName= New.ClassName;
end
;;
delimiter ;

SET FOREIGN_KEY_CHECKS = 1;
