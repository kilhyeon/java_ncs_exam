-- 내 스키마
DROP SCHEMA IF EXISTS `ncs_exam`;

-- 내 스키마
CREATE SCHEMA `ncs_exam`;

-- 직책
CREATE TABLE `ncs_exam`.`title` (
	`tno`   INT         NOT NULL COMMENT '번호', -- 번호
	`tname` VARCHAR(20) NOT NULL COMMENT '직책' -- 직책
)
COMMENT '직책';

-- 직책
ALTER TABLE `ncs_exam`.`title`
	ADD CONSTRAINT `PK_title` -- 직책 기본키
		PRIMARY KEY (
			`tno` -- 번호
		);