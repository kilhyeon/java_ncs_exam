-- �� ��Ű��
DROP SCHEMA IF EXISTS `ncs_exam`;

-- �� ��Ű��
CREATE SCHEMA `ncs_exam`;

-- ��å
CREATE TABLE `ncs_exam`.`title` (
	`tno`   INT         NOT NULL COMMENT '��ȣ', -- ��ȣ
	`tname` VARCHAR(20) NOT NULL COMMENT '��å' -- ��å
)
COMMENT '��å';

-- ��å
ALTER TABLE `ncs_exam`.`title`
	ADD CONSTRAINT `PK_title` -- ��å �⺻Ű
		PRIMARY KEY (
			`tno` -- ��ȣ
		);