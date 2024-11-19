SELECT table1.id, table1.name, table2.name AS parent_name
FROM table AS table1
LEFT JOIN table AS table2 ON table1.parent_id = table2.id
ORDER BY table1.id;