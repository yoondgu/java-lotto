package lotto.domain.exception;

public class IllegalCountOfRankingsException extends Exception {
    public IllegalCountOfRankingsException() { }

    public IllegalCountOfRankingsException(String message) {
        super(message);
    }
}
