-- 코드를 입력하세요
WITH RECURSIVE hours
AS (
    SELECT 0 AS hour
    UNION ALL 
    SELECT hour + 1 AS n
    FROM hours
    where hour < 23
)

select hours.hour, ifnull(count, 0) count 
from (
SELECT hour(datetime) hour, count(*) count 
from animal_outs o
group by hour(datetime)
) a
right join hours
on a.hour = hours.hour
order by 1
