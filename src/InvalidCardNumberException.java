public class InvalidCardNumberException extends BankOnlineException {
    public InvalidCardNumberException(String error) {
        super(error);
    }
}
