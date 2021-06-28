# 로또
## 진행 방법
* 로또 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 코드 리뷰 요청을 한다.
* 코드 리뷰 피드백에 대한 개선 작업을 하고 다시 PUSH한다.
* 모든 피드백을 완료하면 다음 단계를 도전하고 앞의 과정을 반복한다.

## 온라인 코드 리뷰 과정
* [텍스트와 이미지로 살펴보는 온라인 코드 리뷰 과정](https://github.com/next-step/nextstep-docs/tree/master/codereview)

## 기능 구현 목록
구입 금액을 입력 받는다.(money)
- [x]  구입 금액을 저장한다.
- [x]  돈이 음수이면 에러발생.

로또의 숫자를 저장할 객체를 생성한다.(lottoNumber)
- [x]  로또 숫자[1-45] 하나를 저장한다.
- [x]  1-45이외의 값이 들어오면 Exception을 일으킨다.
- [x]  로또의 숫자를 비교한다.

로또를 저장할 객체를 생성한다. (lotto)
- [x]  로또를 저장한다.
- [x]  로또는 6개여야한다.
- [x]  하나의 로또 숫자와 로또를 비교한다.
- [x]  로또와 로또를 비교한다.

로또번호의 상태를 저장할 객체를 생성한다. ( lottoNumberStatus)
- [x]  로또번호는 CORRECT, WRONG의 상태로 존재한다.

로또의 상태를 저장할 객체를 생성한다. (matchedLotto)
- [x]  맞춘 개수를 저장한다.
- [ ]  맞춘 개수를 반환한다.

로또의 등수를 저장할 객체를 생성한다. (lottoRank)
- [ ]  로또의 등수를 저장한다. ( FIRST , SECEND, THIRD, FOURTH, NOTHING )
- [ ]  로또의 맞춘 개수로 등수를 계산한다.
- [ ]  로또의 등수에 따라 금액을 반환한다.

로또를 여러개 담을 객체를 생성한다. (lottos)
- [x]  로또들을 저장한다.
- [x]  1개 이상이 포함되어야 한다.
- [ ]  현재 가지고 있는 로또를 로또하나와 비교한다.

최종 결과를 산출할 객체를 생성한다. (playResult)
- [ ]  구매한 돈을 저장한다.
- [ ]  받은 결과를 반환한다.

---

- InputView
    - [x]  "구입금액을 입력해 주세요."문구를 출력한다.
    - [x]  구입 금액을 입력한다.
    - [x]  "XX개를 구매했습니다."문구를 출력한다.
    - [ ]  당첨번호를 6개를 입력받는다.
        - [ ]  6개는 "X, X, X, X, X, X"형태로 입력받는다.
        - [ ]  당첨번호는 겹치지 않아야 한다.
        - [ ]  당첨번호는 [1-45]까지의 숫자이다.
        
- ResultView
    - [x]  구입 갯수만큼 출력한다.
        - [x]  로또번호 6개를 [X, X, X, X, X, X] 형태로 출력한다.
        - [x]  구입 개수만큼 반복하여 출력한다.
        - [x]  당첨번호는 숫자가 정렬되어 있다.
    - [ ]  "지난 주 당첨 번호를 입력해 주세요." 문구를 출력한다.
    - [ ]  당첨 통계를 출력한다.
         - [ ]  "당첨통계\n---------"를 출력한다.
         - [ ]  일치한 결과를 출력한다.
            - 3개 일치 (5000원)- 1개   
            4개 일치 (50000원)- 0개   
            5개 일치 (1500000원)- 0개   
            6개 일치 (2000000000원)- 0개   
            총 수익률은 0.35입니다.(기준이 1이기 때문에 결과적으로 손해라는 의미임)   
            ⇒ 의 형태로 출력
