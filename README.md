https://shardingsphere.apache.org/index_zh.html

Senario 1:
create 1 database (course_db)
==> if cid % 2 == 0, add to course_1
==> if cid % 2 == 1, add to course_2


Senario 2:
Create 2 database (edu_db_1 and edu_db_2)
edu_db1: course_1 and course_2
edu_db2: course_1 and course_2
==> if userid % 2 == 0, add to edu_db_1
==> if userid % 2 == 1, add to edu_db_2
==> if cid % 2 == 0, add to course_1
==> if cid % 2 == 1, add to course_2