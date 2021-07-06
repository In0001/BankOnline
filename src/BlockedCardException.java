public class BlockedCardException extends BankOnlineException {
    public BlockedCardException(String error) {
        super(error);
    }
}
