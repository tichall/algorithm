select count(*) FISH_COUNT, month(time) MONTH
from fish_info
group by month(time)
order by MONTH
