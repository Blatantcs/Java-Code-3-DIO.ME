import java.util.Scanner;

abstract class X {
    protected double s;
    public X(double s) { this.s = s; }
    public abstract void a(double v);
    public void r() { System.out.printf("Saldo Atual: %.2f%n", s); }
}

class Y extends X {
    private double l;
    public Y(double s, double l) { super(s); this.l = l; }
    @Override
    public void a(double v) {
        if (s - v >= -l) { s -= v; System.out.printf("Saque realizado: %.2f%n", v); }
        else System.out.println("Saque invalido: Excede limite");
        r();
    }
}

class Z extends X {
    public Z(double s) { super(s); }
    @Override
    public void a(double v) {
        if (s >= v) { s -= v; System.out.printf("Saque realizado: %.2f%n", v); }
        else System.out.println("Saque invalido: Saldo insuficiente");
        r();
    }
}

public class M {
    public static void main(String[] args) {
        Scanner l = new Scanner(System.in);
        String t = l.next(); l.nextLine(); l.nextLine(); l.next();
        double sI = l.nextDouble(); X c = t.equals("Corrente") ? new Y(sI, l.nextDouble()) : new Z(sI);
        while (l.hasNextDouble()) c.a(l.nextDouble());
        l.close();
    }
}
