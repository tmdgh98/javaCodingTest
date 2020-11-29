//2/5 고장난 버튼
//시간 제한 : 2초메모리 제한 : 256MB
//문제 설명
//당신은 어떤 페이지를 보고 싶지만 불행히도 리모컨의 숫자 버튼의 일부가 고장났다. 하지만 원하는 페이지의 번호를 입력할 수 없다해도 다른 번호를 눌러서 고장나지 않은 '+'와 '-'버튼으로 원하는 페이지를 찾아갈 수는 있다. '+'버튼은 숫자를 1 올리고 '-'버튼은 숫자를 1 내린다. 처음 페이지는 100번에 설정되어 있다. 다른 페이지에 가려면 고장나지 않은 숫자 버튼을 이용하여 페이지 번호를 눌러야 한다. 그리고 나서 '+'와 '-' 버튼을 눌러서 원하는 페이지로 이동해야 한다.
//
//문제에서는 원하는 페이지 번호 int page과 고장난 숫자 버튼들 정수 배열 int[] broken이 주어진다. 원하는 페이지로 가기 위해서 버튼을 눌러야 하는 최소한의 횟수를 리턴하시오.
//
//참고 / 제약 사항
//page는 최소값 0, 최대값 500,000의 범위를 가진다.
//broken은 0개 이상, 10개 이하의 요소를 가진다.
//broken의 각 요소는 최소값 0, 최대값 9의 범위를 가진다.
//broken에 중복되는 요소는 없다.
//테스트 케이스
//int page = 5457
//int[] broken = [6,7,8]리턴(정답): 6
//5457로 가기 위해 "5 4 5 5 + +" 를 누르거나 "5 4 5 9 - -"를 누를 수 있다.
//
//int page = 100
//int[] broken = [1,0,5]리턴(정답): 0
//처음 시작하는 페이지가 100이므로 아무것도 누르지 않아도 된다.
//
//int page = 99999
//int[] broken = [0,2,3,4,5,6,7,8,9]리턴(정답): 11118
//int page = 158
//int[] broken = [1,9,2,5,4]리턴(정답): 58
//int page = 151241
//int[] broken = [0,1,2,3,4,7,8,9]리턴(정답): 84580

package nhngodo;

public class Two {

}
