CREATE TABLE emp (
    id SERIAL PRIMARY KEY,
    name VARCHAR(30) NOT NULL,
    salary NUMERIC
);
INSERT INTO emp (name, salary)
VALUES ('Vincent', 100);

SELECT DISTINCT(salary) FROM emp ORDER BY salary DESC LIMIT 1 OFFSET 1;

SELECT MAX(salary) FROM emp WHERE salary < (SELECT MAX(salary) FROM emp);

SELECT salary FROM (SELECT DISTINCT salary FROM emp ORDER BY salary DESC LIMIT 2) AS emp ORDER
BY salary LIMIT 1;