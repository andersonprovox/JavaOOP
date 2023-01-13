package br.com.javainsider.parteum;

public class Lamp {
    private boolean on;

    public Lamp(boolean on) {
        this.on = on;
    }
    void turnOn() {
        this.on = true;
    }

    void turnOff() {
        this.on = false;
    }

    public boolean isOn() {
        return on;
    }

    public void setOn(boolean on) {
        this.on = on;
    }

    String showState() {
        if (on == true) {
            return "Lâmpada ligada";
        }
        return "Lâmpada desligada";
    }
}
