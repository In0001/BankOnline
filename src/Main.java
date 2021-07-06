import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws BankOnlineException, IOException {

        BankOnline bankOnline = new BankOnline();

        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите номер карты");
        String cardNomber = scanner.nextLine();
        System.out.println("Введите сумму перевода");
        Double money = scanner.nextDouble();
        scanner.close();
        System.out.println();

        try {
            bankOnline.send(cardNomber, money);
        } catch (InvalidCardNumberException e) {
            System.out.print(e.message());
        } catch (OutOfLimitTransferException e) {
            System.out.print(e.message());
        } catch (NegativeTransferException e) {
            System.out.print(e.message());
        } catch (NullArgumentException e) {
            System.out.print(e.message());
        } catch (BlockedCardException e) {
            System.out.print(e.message());
        }
    }
}

