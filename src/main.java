public class Main {
    public static void main(String[] args) {
        Data data = new Data();
        data.menu();

        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                System.out.println(1);
                break;
            case 2:
                System.out.println(1);
                break;
            case 3:
                System.out.println(1);
                break;
            case 4:
                System.out.println(1);
                break;
            default:
                System.out.println(2);
                break;
        }
    }
}