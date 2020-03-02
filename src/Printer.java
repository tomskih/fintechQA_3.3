import java.util.Scanner;

public class Printer {
    static char button;
    int countOfPaper = 0;   //количество бумаги в принтере
    public static final int maxCountOfPaper = 100;    //максимально возможно количество загруженной бумаги

    public static void main(String[] args) throws Exception {
        Printer printer = new Printer();
        while (true){
            printer.setCount(printer.getAction(), printer);
        }
    }

    public char getAction() {
        Scanner action = new Scanner(System.in);
        System.out.print("Введите команду: p - печать, r - заправка, e - завершение работы ");
        return action.next().charAt(0);
    }

    public void setCount(char button, Printer printer) throws Exception {
        if (button == 'p'){
            try {
                if (countOfPaper == 0){
                    throw new Exception ("Нет бумаги. Печать невозможна");
                } else {
                    Scanner printDoc = new Scanner(System.in);
                    System.out.print("В принтере " + countOfPaper + " листов бумаги. Сколько нужно напечатать? ");
                    int document = printDoc.nextInt();
                    printer.print(countOfPaper, document);
                }
            } catch (Exception e) {
                System.out.println("Нет бумаги. Печать невозможна");
            }
        } else if (button == 'r'){
            if (countOfPaper == maxCountOfPaper) {
                System.out.println("Лоток полон. Заправка невозможна");
            } else {
                Scanner refillPrinter = new Scanner(System.in);
                System.out.print("Введите количество листов, которые нужно загрузить в принтер ");
                int refillCount = refillPrinter.nextInt();
                printer.refill(refillCount, maxCountOfPaper);
            }
        } else if (button == 'e'){
            System.exit(0);
        }
    }

    public void print (int countOfPaper, int document) throws Exception {
        int i = 1;
        if (document > countOfPaper){
            System.out.println("Предупреждение: документ будет напечатан не полностью");
        }
            while (document > 0) {  //выполняем пока док не напечатан полностью
                if (countOfPaper == 0){
                    System.out.println("Бумага закончилась, документ не напечатан. Не хватило " + document + " листов бумаги");
                    break;
                }
                System.out.println("Печать листа " + i);
                i+=1;
                countOfPaper -= 1;
                document -= 1;
                Thread.sleep(1000);

            }

        System.out.println("Печать завершена");
    }
    public void refill (int refillCount, int maxCountOfPaper){
        while (refillCount != 0 && countOfPaper < maxCountOfPaper){
            refillCount -= 1;
            countOfPaper += 1;
        }
        System.out.println("Принтер заправлен. В лотке " + countOfPaper + " листов бумаги");
    }

  /*  abstract public void refillOneList (int countOfPaper, int maxCountOfPaper){ //загрузка по 1 листу во время печати
        if (countOfPaper <= maxCountOfPaper){
            countOfPaper += 1;
        }
    }*/

}
