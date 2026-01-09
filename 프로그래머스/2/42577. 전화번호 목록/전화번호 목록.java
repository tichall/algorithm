import java.util.*;

class Solution {
    public boolean solution(String[] phone_book) {
        // 만약 해시를 쓴다면..
        // HashMap? HashSet? 
        // 중복된 전화번호가 없으므로 HashSet 사용 가능
        // HashSet에 키값 일부 일치 여부를 확인할 수 있는 함수가 있었던가?
        // String 배열 값들을 HashSet에 넣는다.
        HashSet<String> phoneBook = new HashSet<>();
        
        for (String phone : phone_book) {
            phoneBook.add(phone);
        }
        
        for (int i = 0; i < phoneBook.size(); i++) {
            for (int j = 0; j < phone_book[i].length(); j++) {
                if (phoneBook.contains(phone_book[i].substring(0, j))) {
                    return false;
                }
            }
        }
        
        return true;
    }
}