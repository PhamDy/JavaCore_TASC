-- Tạo bảng
CREATE TABLE IF NOT EXISTS `student` (
    `id` BIGINT AUTO_INCREMENT PRIMARY KEY,
    `name` VARCHAR(100) NOT NULL UNIQUE,
   `age` VARCHAR(100) NOT NULL,
   `gender` VARCHAR(100) NOT NULL
);

CREATE TABLE IF NOT EXISTS `class` (
    `id` BIGINT AUTO_INCREMENT PRIMARY KEY,
    `name` VARCHAR(100) NOT NULL UNIQUE
);

CREATE TABLE IF NOT EXISTS `student_class` (
    `student_id` BIGINT NOT NULL,
    `class_id` BIGINT NOT NULL,
    FOREIGN KEY (`student_id`) REFERENCES student(id),
    FOREIGN KEY (`class_id`) REFERENCES class(id)
);

CREATE TABLE IF NOT EXISTS `skill` (
   `id` BIGINT AUTO_INCREMENT PRIMARY KEY,
   `name` VARCHAR(100) NOT NULL UNIQUE
);


CREATE TABLE IF NOT EXISTS `student_skill` (
    `student_id` BIGINT NOT NULL,
    `skill_id` BIGINT NOT NULL,
    FOREIGN KEY (`student_id`) REFERENCES student(id),
    FOREIGN KEY (`skill_id`) REFERENCES skill(id)
);

INSERT INTO student (`name`, `age`, `gender`) VALUES
			  ('Nguyen van A', 18, 'Male'),
			  ('Trang', 24, 'Female'),
			  ('Duy', 32, 'Male');
			  
INSERT INTO class (`name`) VALUES
			  ('T1911E'),
			  ('T2302M');

INSERT INTO skill (`name`) VALUES
			  ('Võ'),
			  ('Vẽ'),
			  ('Hát');

-- 1. Thực hiện tìm các kỹ năng của học sinh tên 'Nguyen van A' thuoc lop T1911E.
SELECT st.name AS student_name, sk.name AS skill FROM skill sk
INNER JOIN student_skill ss ON sk.id = ss.skill_id
INNER JOIN student st ON st.id = ss.student_id
INNER JOIN student_class sc ON sc.student_id = st.id
INNER JOIN class c ON c.id = sc.class_id
WHERE st.name = 'Nguyen van A' AND c.name = 'T1911E';

-- 2. Thống kê các kỹ năng của học sinh lớp T1911E.
SELECT st.name AS student_name, sk.name AS skill, c.name AS class_name FROM skill sk
INNER JOIN student_skill ss ON sk.id = ss.skill_id
INNER JOIN student st ON st.id = ss.student_id
INNER JOIN student_class sc ON sc.student_id = st.id
INNER JOIN class c ON c.id = sc.class_id
WHERE c.name = 'T1911E';

-- 3. Tìm kỹ năng mà nhiều học sinh có nhất .
SELECT s.name, COUNT(*) AS student_count FROM skill s
INNER JOIN student_skill ss ON ss.skill_id = s.id
GROUP BY s.id
ORDER BY student_count DESC
LIMIT 1

-- 4.Thống kê học sinh theo lớp và kỹ năng (trong đó kỹ năng , lớp của học sinh gộp lại dưới dạng nối với nhau bằng dấu phẩy) 
SELECT st.name AS student_name, s.name AS skill_name FROM student st
INNER JOIN student_class sc ON sc.student_id = st.id
INNER JOIN class c ON c.id = sc.class_id
INNER JOIN student_skill sk ON sk.student_id = st.id
INNER JOIN skill s ON s.id = sk.skill_id
-- GROUP BY student_name

SELECT  st.name AS student_name, GROUP_CONCAT(DISTINCT CONCAT(c.name, ', ', s.name)) AS class_skills
FROM student st
INNER JOIN student_class sc ON sc.student_id = st.id
INNER JOIN class c ON c.id = sc.class_id
INNER JOIN student_skill sk ON sk.student_id = st.id
INNER JOIN skill s ON s.id = sk.skill_id
GROUP BY student_name;

-- 5. Tìm lớp mà trung binh hoc sinh co nhiêu ky nang nhat.
SELECT 
    c.name AS class_name,
    AVG(skill_count) AS average_skill_count
FROM (
    SELECT 
        sc.class_id,
        COUNT(DISTINCT sk.skill_id) AS skill_count
    FROM 
        student_class sc
    INNER JOIN 
        student_skill sk ON sk.student_id = sc.student_id
    GROUP BY 
        sc.class_id, sk.student_id
) AS class_skills
INNER JOIN 
    class c ON c.id = class_skills.class_id
GROUP BY 
    class_name
ORDER BY 
    average_skill_count DESC
LIMIT 1;

			  