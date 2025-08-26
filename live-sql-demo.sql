

Task / Problems:
	
-- List all the books that are written by Author Loni and has price  
-- 		less then 600.
select * from books where author_name = 'Loni' AND cost< 600;

-- List the Issue details for the books that are not returned yet.
select * from ISSUE where RETURN_DATE is NULL

-- Update all the blank return_date with 31-Dec-06 excluding 7005 and 7006.
update issue set RETURN_DATE = TO_DATE('31-Dec-2006', 'DD-MON-YYYY') where LIB_ISSUE_ID in (select LIB_ISSUE_ID from ISSUE where RETURN_DATE is NULL and LIB_ISSUE_ID not in (7005,7006))

-- List all the Issue details that have books issued for more then 30 days.
select * from issue where ((TO_DATE(return_date) - TO_DATE(Issue_Date)) < 30 )


-- List all the books that have price in range of 500 to 750 and has category as Database.
select * from books where cost < 750 and cost > 500 and category = 'Database'

-- List all the books that belong to any one of the following categories Science, Database, Fiction, Management.
select * from books where category in ('Science', 'Database', 'Fiction', 'Management')

-- List all the members in the descending order of Penalty due on them.
select * from member order by -PENALTY_AMOUNT

-- List all the books in ascending order of category and descending order of price.
select * from books ORDER BY category ASC, cost DESC

-- List all the books that contain word SQL in the name of the book.
select * from books where BOOK_NAME LIKE '%SQL%'

-- List all the members whose name starts with R or G and contains letter I in it.


-- List the entire book name in Init cap and author in upper case in the descending order of the book name.
SELECT INITCAP(book_name) AS book_name_initcap, UPPER(author_name) AS author_name_upper FROM books ORDER BY BOOK_NAME DESC


-- List the Issue Details for all the books issue by member 101  
-- with Issue_date and Return Date in following format. ‘Monday, 
-- July, 10, 2006’.
SELECT LIB_ISSUE_ID, BOOK_NO, MEMBER_ID, TO_CHAR(issue_date, 'Day, Month, DD, YYYY') AS issue_date_formatted,
    TO_CHAR(return_date, 'Day, Month, DD, YYYY') AS return_date_formatted from ISSUE where MEMBER_ID = 101


-- List the data in the book table with category data displayed as  
-- 	D for Database, S for Science, R for RDBMS and O for all the  
-- others.
select BOOK_NAME, BOOK_NO, AUTHOR_NAME, COST, 
CASE 
    WHEN UPPER(category) = 'DATABASE' THEN 'D'
    WHEN UPPER(category) = 'SCIENCE'  THEN 'S'
    WHEN UPPER(category) = 'RDBMS'    THEN 'R'
    ELSE 'O' END 
AS CATEGORY  from books


-- List all the members that became the member in the year 2006.
SELECT * from MEMBER  WHERE TO_CHAR(acc_open_date, 'YYYY') = '2006'


-- List the Lib_Issue_Id, Issue_Date, Return_Date and No of days 
-- Book was issued.
-- Find the details of the member of the Library in the order of their 
-- joining the library.
select * from member order by ACC_OPEN_DATE

-- Display the count of total no of books issued to Member 101.
select COUNT(BOOK_NO) as total_count from issue where MEMBER_ID = 101

-- Display the total penalty due for all the members.
select SUM(penalty_amount) as total_pen from member

-- Display the total no of members 
SELECT COUNT(member_id) from member

-- Display the total no of books issued 
select count(book_no) from issue;

-- Display the average membership fees paid by all the members
select AVG(FEES_PAID) from member


-- Display no of months between issue date and return date for all issue
select LIB_ISSUE_ID, TO_CHAR(issue_date, 'YYYY-MM-DD') AS issue_date_formatted,
  TO_CHAR(return_date, 'YYYY-MM-DD') AS return_date_formatted,
  MONTHS_BETWEEN(return_date, issue_date) AS months_between from issue

-- Display the length of member’s name
SELECT LENGTH(MEMBER_NAME) from MEMBER

-- Display the first 5 characters of  membership_type for all members
SELECT  SUBSTR(membership_type, 1, 5) AS membership_type_first5 from MEMBER

-- Display the last day of the month of issue date 
select TO_CHAR( LAST_DAY(issue_date),'Day, DD-MM-YYYY' ) AS last_day_of_month
FROM issue;





