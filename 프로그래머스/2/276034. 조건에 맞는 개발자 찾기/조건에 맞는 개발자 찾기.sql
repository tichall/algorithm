# 비트 연산 정리
# and(&) -> 두 비트가 1이면 1 반환 = 공통으로 가지고 있는 비트만 남음 
# or(|)-> 두 비트 중 하나라도 1이면 1 반환 
# not(~) -> 비트를 반전시킨다 (0이면 1로, 1이면 0으로)
# xor(^) -> 두 비트가 서로 다르면 1 반환

# 파이썬이나 C# 스킬을 가진 개발자
# 파이썬과 C#에 해당하는 스킬 코드를 찾고, or 연산을 한다 -> 
# 파이썬 코드 100000000
# C# 코드     10000000
# or 연산    110000000

# 이 코드와 스킬 코드를 and 연산해서 답이 0이 아니면 됨!

# select 절에 오는 컬럼의 순서가 다르면 오답 처리됨 

# select ID, EMAIL, FIRST_NAME, LAST_NAME
# from developers
# where skill_code & (
#     select sum(code)
#     from skillcodes
#     where name in ('Python', 'C#')
# ) != 0
# order by id

select ID, EMAIL, FIRST_NAME, LAST_NAME
from developers 
where skill_code & 
( 
    select code | ( select code from skillcodes where name = 'C#' ) 
    from skillcodes 
    where name = 'Python' 
) != 0 
order by id
