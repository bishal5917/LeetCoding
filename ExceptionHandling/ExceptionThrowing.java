package ExceptionHandling;

class Amount {
    private String currency;
    private int amount;

    public Amount(String currency, int amount) {
        super();
        this.currency = currency;
        this.amount = amount;
    }

    public void add(Amount that) throws CurrenciesDontMatchException {
        if (!this.currency.equals(that.currency)) {
            throw new CurrenciesDontMatchException("Currencies don't match");
        }
        this.amount = this.amount + that.amount;
    }

    public String toString() {
        return currency + " " + amount;
    }
}

class CurrenciesDontMatchException extends Exception {
    CurrenciesDontMatchException(String msg) {
        super(msg);
    }
}

public class ExceptionThrowing {

    public static void main(String[] args) {
        Amount amt1 = new Amount("$", 120000);
        Amount amt2 = new Amount("Rs.", 60);
        try {
            amt1.add(amt2);
        } catch (CurrenciesDontMatchException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println("Some Exception occured");
            e.printStackTrace();
        } finally {
            System.out.println(amt1.toString());
        }
    }
}
