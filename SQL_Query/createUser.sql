-- Create new User and Password
CREATE USER 'spring'@'%' IDENTIFIED BY 'spring';
-- Grant user privilege (quyen truy cap, lam viec)
GRANT ALL PRIVILEGES ON * . * TO 'spring'@'%';
-- Create database
CREATE DATABASE
IF NOT EXISTS `student_management`
CHARACTER SET utf8mb4
COLLATE UTF8MB4_GENERAL_CI;

USE student_management;
-- CREATE table
CREATE TABLE `students` (
`id` int NOT NULL AUTO_INCREMENT,
`last_name` varchar(45) DEFAULT NULL,
`first_name` varchar(45) DEFAULT NULL,
`email` varchar(45) DEFAULT NULL,
PRIMARY KEY (`id`)
)
ENGINE=INNODB
AUTO_INCREMENT=1
DEFAULT CHARSET=UTF8MB4
COLLATE=UTF8MB4_UNICODE_CI;

-- Insert some data
INSERT INTO `students` (`last_name`, `first_name`, `email`)
        VALUES
        ('Nguyễn', 'Văn K', 'vana@gmail.com'),
        ('Trần', 'Thị B', 'thib@gmail.com'),
        ('Lê', 'Văn C', 'vanc@gmail.com'),
        ('Phạm', 'Thị D', 'thid@gmail.com'),
        ('Huỳnh', 'Văn E', 'vane@gmail.com'),
        ('Nguyễn', 'Thị F', 'thif@gmail.com'),
        ('Trần', 'Văn G', 'vang@gmail.com'),
        ('Lê', 'Thị H', 'thih@gmail.com'),
        ('Phạm', 'Văn I', 'vani@gmail.com'),
        ('Huỳnh', 'Thị K', 'thik@gmail.com');
        
   -- Query
   SELECT * FROM sinhvien WHERE ho_dem LIKE '%Nguyễn';
   
   select * from sinhvien;