# 사원별 성과금 정보 -> 기준 점수에 따라 평가 등급, 성과금
# 사원별로 평가 점수 평균 내고, 등급 매기기
# 사원 테이블과 조인해 연봉과 등급 활용해 성과금 계산하기

select e.emp_no, emp_name, grade,
    case when grade = 'S' then sal * 0.2
        when grade = 'A' then sal * 0.15
        when grade = 'B' then sal * 0.1
        else 0 end as bonus
from
(
select emp_no, case when avg(score) >= 96 then 'S'
    when avg(score) >= 90 then 'A'
    when avg(score) >= 80 then 'B'
    else 'C' end as grade
from HR_GRADE 
group by emp_no
) a 
join HR_EMPLOYEES e on a.emp_no = e.emp_no
order by e.emp_no