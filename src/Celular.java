import java.util.Comparator;

public class Celular implements Precedable<Celular> {
    private int numero;
    private String titular;

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getTitular() {
        return titular;
    }

    public void setTitular(String titular) {
        this.titular = titular;
    }

    @Override
    public String toString() {
        return "Celular{" +
                "numero=" + numero +
                ", titular='" + titular + '\'' +
                '}';
    }

    @Override
    public int precedeA(Celular celular) {
        return numero- celular.getNumero();
    }



}
