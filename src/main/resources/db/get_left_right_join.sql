-- LEFT JOIN returns all rows from the first(left) table,
-- and the associated rows from the second(right) table.
-- If there is no match in the second(right) table, its columns return NULL.
SELECT * FROM games g LEFT JOIN city c ON g.city = c.name WHERE g.yr < 2032


-- LEFT JOIN returns all rows from the Second(right) table,
-- and the associated rows from the first(left) table.
-- If there is no match in the first(left) table, its columns return NULL.
SELECT * FROM games g RIGHT JOIN city c ON g.city = c.name