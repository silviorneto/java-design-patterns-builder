package srn.desafiodesignpatterns.model;

public enum Combo {
    FAMILIA(1),
    COMPLETO(2),
    VEGETARIANO(3);

    private int number;

    Combo(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    public static Combo fromNumber(int numero) {
        for (Combo combo : Combo.values()) {
            if (combo.getNumber() == numero) {
                return combo;
            }
        }
        throw new IllegalArgumentException("Número de combo inválido: " + numero);
    }
}
