select count(*) fish_count, max(length) max_length, fish_type
from (
    select ifnull(length, 10) length, fish_type
    from fish_info
) a
group by fish_type
having avg(length) >= 33
order by fish_type

