import java.io.*;

public class BankOnline {
    public void send(String cardNumber, Double money) throws BankOnlineException, IOException {

        if (!cardNumber.matches("\\d+") || cardNumber.length() != 16)
            throw new InvalidCardNumberException("Номер карты введен не правильно!");
        if (money > 50000)
            throw new OutOfLimitTransferException("Превышен лимит в 50000 рублей!");
        if (money < 0)
            throw new NegativeTransferException("Введена отрицательная сумма перевода!");
        if (cardNumber == null || money == null)
            throw new NegativeTransferException("Ошибка чтения одного из аргументов!");
        if (isBlocked(cardNumber) == 0)
            throw new BlockedCardException("Карта получателя заблокирована!");
        if (isBlocked(cardNumber) == 1)
            throw new BlockedCardException("Не удалось найти файл с номерами заблокированных карт. Операция прервана");
        if (isBlocked(cardNumber) == 2)
            throw new BlockedCardException("Ошибка чтения файла с номерами заблокированных карт. Операция прервана");

        System.out.print("Перевод выполнен");
    }

    public int isBlocked(String cardNumber) throws IOException {
        BufferedReader bufferReader = null;
        try {
            bufferReader = new BufferedReader(new FileReader("C:\\Users\\DNS\\IdeaProjects\\BankOnline\\src\\BlockedCardNumbers.txt"));

            String string;
            while ((string = bufferReader.readLine()) != null) {
                if (string.contentEquals(cardNumber)) {
                    return 0;
                }
            }
        } catch (FileNotFoundException e) {
            return 1;
        } catch (IOException e) {
            return 2;
        } finally {
            if (bufferReader != null)
                bufferReader.close();
        }
        return 3;
    }
}