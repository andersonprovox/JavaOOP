public class ExLamp {
    public static void main(String[] args) {
        Lamp l1 = new Lamp(true);
        Lamp l2 = new Lamp(false);

        System.out.println("Estado da lampada 1: ");
        System.out.println(l1.showState());
        l1.turnOff();
        System.out.println(l1.showState());

        System.out.println("Estado lampada 2: ");
        l2.showState();
        System.out.println(l2.showState());
        l2.turnOn();
        l2.showState();
        System.out.println(l2.showState());
    }
}
