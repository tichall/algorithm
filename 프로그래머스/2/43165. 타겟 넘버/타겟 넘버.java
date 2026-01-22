class Solution {
    int[] numbers;
    int target = 0;
    
    public int solution(int[] numbers, int target) {
        this.target = target;
        this.numbers = numbers;
        
        // 각 숫자마다 더하기 빼기를 선택할 수 있다.
        // 모든 경우의 수를 모두 시도해보고 개수를 세야 한다.
        // 모든 경우의 수는 2^numbers.length 
        // 일단 이 문제를 깊이/너비 우선 탐색으로 어떻게 접근해야 할지는 떠오르지 않는다.
        // 그냥 완전 탐색 방식으로 하는 건..?
        // 아니면 타겟 넘버에서 빼거나 더하는 방식으로 0이 되는지 확인하는 건?
        // for문을 돌리려고 해도 잘 생각을 못하겠음.. 
        // numbers 배열의 길이가 고정되어 있는 것이 아니기 때문에 for문의 깊이를 사전에 설정할 수 없다.
        // 이렇게 깊이를 사전 설정할 수 없는 경우에 재귀를 써야 하는 것인가..?
        // 재귀를 써야 한다는 접근 방식이 생각났음에도 불구하고 재귀함수 어떤 식으로 작성해야 할지 감 안 잡힘
        
        return targetNumber(-1, 0);
    }
    
    public int targetNumber(int index, int sum) {
        if (index == numbers.length - 1) {
            return sum == target ? 1 : 0;
        }
        
        return targetNumber(index + 1, sum + numbers[index + 1]) +
        targetNumber(index + 1, sum - numbers[index + 1]);
    }
}