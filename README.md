# 로또
## 진행 방법
* 로또 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 코드 리뷰 요청을 한다.
* 코드 리뷰 피드백에 대한 개선 작업을 하고 다시 PUSH한다.
* 모든 피드백을 완료하면 다음 단계를 도전하고 앞의 과정을 반복한다.

## 온라인 코드 리뷰 과정
* [텍스트와 이미지로 살펴보는 온라인 코드 리뷰 과정](https://github.com/next-step/nextstep-docs/tree/master/codereview)

## 기능 구현 목록
* 입력한 문자열을 파싱하여 더한 값 리턴
    * [x] 입력된 문자열이 null 또는 empty이면 0을 반환    
    * [x] 숫자 이외의 값이 입력되면 RuntimeException 발생(유효성 체크)
    * [ ] 음수 입력되면 RuntimeException발생(유효성 체크)
    * [x] 쉼표 또는 콜론 값으로 문자열 split 기능 
    * [ ] 커스텀 구분자 입력 시 커스텀 구분자를 이용하여 문자열 split 기능