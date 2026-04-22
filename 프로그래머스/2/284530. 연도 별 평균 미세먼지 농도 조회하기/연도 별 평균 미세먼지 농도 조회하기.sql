# 수원 지역의 연도별 평균

# 여기서 왜 문법 오류 나는 건지 모르겠음
# SELECT * 그냥 이렇게 출력하면 오류가 안 나는 걸로 봐서는.. SELECT 절의 오류인가?

SELECT YEAR(YM) YEAR, ROUND(AVG(PM_VAL1), 2) AS PM10, ROUND(AVG(PM_VAL2), 2) AS 'PM2.5'
FROM AIR_POLLUTION
WHERE LOCATION2 = '수원'
GROUP BY YEAR(YM)
ORDER BY YEAR