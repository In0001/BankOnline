public class BankOnlineException extends Exception {
    String error;

    public BankOnlineException(String error) {
        this.error = error;
    }

    public String message() {
        return error;
    }
}