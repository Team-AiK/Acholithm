# Week1 카카오 1차 코딩 테스트 5번 문제
[포스트 링크](https://hongjeseong.github.io/kakao-news/)


단어를 입력받아 한글자 단위로 쪼개어 배열에 저장한다. 이렇게 쪼개어진 총 n자의 단어를 2자씩 끊기위해 n-1번의 비교를 수행한다. 이 비교를 수행하면서 n번째 단어와 n+1번째의 단어를 하나로 묶고 특수문자, 숫자, 공백을 제거하였을때 단어의 길이가 2개가 되지 않는다면 유효한 글자 단위가 아니기 때문에 버리고 유효하다면 배열리스트에 추가를 한다. 자카드 유사도를 계산한다!  

![과정](https://hongjeseong.github.io/images/posts/algokakao/jaccard1.png)
-------
### 소스 코드(.java)
```java
import java.util.ArrayList;

public class JaccardSimilarity {

	public ArrayList<String> preprocess(String data) {
		String temp = "";
		ArrayList<String> stringList = new ArrayList<String>();

		data = data.toUpperCase();// 대문자 변환
		String[] stringSplit = data.split("");// 쪼개기
		for (int i = 0; i < stringSplit.length - 1; i++) {// 유효한 것만 합치기
			temp = stringSplit[i].concat(stringSplit[i + 1]);
			if (validation(temp) == true) {
				stringList.add(temp);
			}
		}
		return stringList;
	}

	public boolean validation(String data) { // 유효성검사
		data = data.replaceAll("[^\uAC00-\uD7A3xfe0-9a-zA-Z\\s]", "");// 특수문자 제거
		data = data.replaceAll("[0-9]", "");// 숫자제거
		data = data.replaceAll(" ", "");// 공백제거
		if (data.length() != 2) { // 두 글자 쌍
			return false;
		}
		return true;
	}

	public void compare(String data1, String data2) {
		if (!((data1.length() >= 2 && data1.length() <= 1000) && (data2.length() >= 2 && data2.length() <= 1000))) {
			System.out.println("입력 형식에 맞지 않습니다.");
		} else {
			float intersection = 0, union = 0, result = 0;
			ArrayList<String> list1 = new ArrayList<String>();
			ArrayList<String> list2 = new ArrayList<String>();
			list1 = preprocess(data1);
			list2 = preprocess(data2);
			if (list1.size() == 0 && list2.size() == 0) { // 공집합인 경우
				result = 1 * 65536;
				System.out.println("유사도 =" + (int) result);

			} else {
				for (int i = 0; i < list1.size(); i++) {
					String value = list1.get(i);// 성능위해 cast 남발 줄이기...
					for (int j = 0; j < list2.size(); j++) {
						if (value.equals(list2.get(j))) {
							list2.remove(j);
							intersection++;// 교집합
							break;
						}
					}
				}
				union = list1.size() + list2.size();// 합집합
				result = (intersection / union) * 65536;
				System.out.println("유사도 =" + (int) result);
			}
		}
	}

	public static void main(String[] args) {
		JaccardSimilarity jaccard = new JaccardSimilarity();
		jaccard.compare("FRANCE", "french");
		jaccard.compare("handshake", "shake hands");
		jaccard.compare("aa1+aa2", "AAAA12");
		jaccard.compare("e=m*c^2", "E=M*C^2");
	}

}  

```  

-----------------	

### 결과  

![결과사진](https://hongjeseong.github.io/images/posts/algokakao/jaccard.png)

