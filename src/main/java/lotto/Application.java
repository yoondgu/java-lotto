package lotto;

import lotto.controller.GameController;

public class Application {
    public static void main(String[] args) {
        try {
            GameController.runGame();
        } catch (IllegalArgumentException exception) {
            // TODO [ERROR] 에러메시지 출력하기
        }
    }
}