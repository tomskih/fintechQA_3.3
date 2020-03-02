import java.util.Scanner;

public class Printer {
    int countOfPaper = 10;   //количество бумаги в принтере
    public static final int maxCountOfPaper = 100;    //максимально возможно количество загруженной бумаги
    //int document; //количество страниц, которые надо напечатать

    public static void main(String[] args) throws InterruptedException {
        Printer printer = new Printer();
        Scanner action = new Scanner(System.in);
        System.out.print("Введите команду: p - печать, r - заправка ");
        char button = action.next().charAt(0);
        printer.setCount(button, printer);
    }

    public void setCount(char button, Printer printer) throws InterruptedException {
        if (button == 'p'){
            if (countOfPaper == 0){
                System.out.println("Нет бумаги. Печать невозможна");
            } else {
                Scanner printDoc = new Scanner(System.in);
                System.out.print("Введите количество листов, которые нужно напечатать ");
                int document = printDoc.nextInt();
                printer.print(countOfPaper, document);
            }
        } else if (button == 'r'){
            Scanner refillPrinter = new Scanner(System.in);
            System.out.print("Введите количество листов, которые нужно загрузить в принтер ");
            int refillCount = refillPrinter.nextInt();
            printer.refill(refillCount, maxCountOfPaper);
        }
    }


    public void print (int countOfPaper, int document) throws InterruptedException {
        System.out.println("Печать началась");
        int i = 1;
        while (document > 0) {  //выполняем пока док не напечатан полностью
            if (countOfPaper == 0){
                System.out.println("Бумага закончилась, документ не напечатан. Не хватило " + document + " листов бумаги");
                break;
            }
            System.out.println("Печать листа " + i);
            i+=1;
            countOfPaper -= 1;
            document -= 1;
            Thread.sleep(10000);

        }
        System.out.println("Печать завершена");
    }
    public void refill (int countOfPaper, int maxCountOfPaper){
        System.out.println("Началась заправка бумаги");
        while (countOfPaper <= maxCountOfPaper){
            countOfPaper += 1;
        }
        System.out.println("Принтер заправлен. В лотке " + countOfPaper + "листов бумаги");
    }

    /*public void refillOneList (int countOfPaper, int maxCountOfPaper){
        if (countOfPaper <= maxCountOfPaper){
            countOfPaper += 1;
        }
    }*/

}
