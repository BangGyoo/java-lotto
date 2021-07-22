# 로또(2등)
## 진행 방법
* 로또 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 코드 리뷰 요청을 한다.
* 코드 리뷰 피드백에 대한 개선 작업을 하고 다시 PUSH한다.
* 모든 피드백을 완료하면 다음 단계를 도전하고 앞의 과정을 반복한다.

## 온라인 코드 리뷰 과정
* [텍스트와 이미지로 살펴보는 온라인 코드 리뷰 과정](https://github.com/next-step/nextstep-docs/tree/master/codereview)

## 기능 구현 목록

로또를 저장할 객체를 생성한다. (lotto)
- [ ]  로또와 당첨로또를 비교한다.

로또의 서비스 코드를 생성한다. (lottoStore)
- [ ]  당첨 번호와 보너스 번호를 입력받는다.

로또의 등수를 저장할 객체를 생성한다. (lottoRank)
- [ ]  로또의 등수를 저장한다. ( FIRST, SECEND, THIRD, FOURTH, FiFTH, NOTHING )
- [ ]  로또의 맞춘 개수와 보너스번호를 포함한 등수를 계산한다.
- [ ]  로또의 등수에 따라 금액을 반환한다.


로또를 여러개 담을 객체를 생성한다. (lottos)
- [ ]  당첨로또 객체와 현재 로또들을 비교한다.

   
당첨 로또 객체를 생성한다. (winningLotto)
- [ ] 로또객체와 보너스 볼을 저장한다.

---

- InputView
    - [ ] "보너스 볼을 입력해 주세요." 문구를 출력한다.
    - [ ] 보너스 볼을 입력받는다.
        
- ResultView
    - [ ]  당첨 통계를 출력한다.
         - [ ]  일치한 결과를 출력한다.
            - 3개 일치 (5000원)- 1개   
            4개 일치 (50000원)- 0개   
            5개 일치 (1500000원)- 0개 
            5개 일치, 보너스 볼 일치(30000000원) - 0개
            6개 일치 (2000000000원)- 0개
