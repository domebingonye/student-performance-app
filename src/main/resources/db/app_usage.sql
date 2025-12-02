SELECT
    userId,
    AVG(duration) AS avg_duration
FROM sessions
GROUP BY userId
HAVING COUNT(id) > 1;