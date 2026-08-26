# Write your MySQL query statement below
WITH user_counts AS (
    SELECT u.name, COUNT(*) AS cnt
    FROM MovieRating mr
    JOIN Users u ON mr.user_id = u.user_id
    GROUP BY u.name
),
top_user AS (
    SELECT name
    FROM user_counts
    ORDER BY cnt DESC, name ASC
    LIMIT 1
),
movie_avg AS (
    SELECT m.title, AVG(mr.rating) AS avg_rating
    FROM MovieRating mr
    JOIN Movies m ON mr.movie_id = m.movie_id
    WHERE mr.created_at BETWEEN '2020-02-01' AND '2020-02-29'
    GROUP BY m.title
),
top_movie AS (
    SELECT title
    FROM movie_avg
    ORDER BY avg_rating DESC, title ASC
    LIMIT 1
)
SELECT name AS results FROM top_user
UNION ALL
SELECT title FROM top_movie;
