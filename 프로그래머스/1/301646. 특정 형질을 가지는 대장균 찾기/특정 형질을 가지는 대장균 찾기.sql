# 2번 형질은 없고, 1이나 3번 형질은 있는 대장균 개체의 수
# 2번 형질과 and를 했을 때 0이어야 함
# 1이나 3번 형질과 and 했을 때 0이 아니면 됨

select count(*) COUNT
from ecoli_data
where genotype & 2 = 0 and
    genotype & 5 != 0
    