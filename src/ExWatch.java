public class ExWatch {
    public static void main(String[] args) {
        Watch reloj = new Watch();

        reloj.setTime(3, 25, 50);
        System.out.println(reloj.readHour() + ":" + reloj.readMinute() + ":" + reloj.readSecond());
    }

}
