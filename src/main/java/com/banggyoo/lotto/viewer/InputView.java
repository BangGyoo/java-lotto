package com.banggyoo.lotto.viewer;

import java.util.List;
import java.util.Scanner;

public class InputView {

    public static final String INPUT_PURCHASE_PRICE_MESSAGE = "구입금액을 입력해 주세요.";
    private Scanner scanner = new Scanner(System.in);

    public String requestBuyLottoMoney() {
        System.out.println(INPUT_PURCHASE_PRICE_MESSAGE);
        return scanner.nextLine();
    }

    public String requestWinningLottoNumbers() {
        System.out.println("지난주 당첨 번호를 입력해주세요.");
        return scanner.nextLine();
    }


    public List<Integer> requestInputWinningLottoNumbers() {
        return null;
    }
}
