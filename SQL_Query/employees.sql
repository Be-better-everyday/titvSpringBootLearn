CREATE TABLE `employees` (
`id` int NOT NULL AUTO_INCREMENT,
`name` varchar(45) DEFAULT NULL,
`email` varchar(45) DEFAULT NULL,
`position` varchar(45) DEFAULT NULL,
`salary` bigint DEFAULT NULL,
PRIMARY KEY (`id`)
)
ENGINE=INNODB
AUTO_INCREMENT=1
DEFAULT CHARSET=UTF8MB4
COLLATE=UTF8MB4_UNICODE_CI;

INSERT INTO `employees` (`name`, `email`, `position`, `salary`) VALUES
('Employee 1', 'employee1@example.com', 'Position 1', 50000),
('Employee 2', 'employee2@example.com', 'Position 2', 55000),
('Employee 3', 'employee3@example.com', 'Position 3', 60000),
('Employee 4', 'employee4@example.com', 'Position 4', 65000),
('Employee 5', 'employee5@example.com', 'Position 5', 70000),
('Employee 6', 'employee6@example.com', 'Position 6', 75000),
('Employee 7', 'employee7@example.com', 'Position 7', 80000),
('Employee 8', 'employee8@example.com', 'Position 8', 85000),
('Employee 9', 'employee9@example.com', 'Position 9', 90000),
('Employee 10', 'employee10@example.com', 'Position 10', 95000);
