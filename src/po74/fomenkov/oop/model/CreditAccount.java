package po74.fomenkov.oop.model;

public class CreditAccount extends AbstractAccount implements Credit {
    private double APR;
    private final static double APR_DEFAULT = 30;

    public CreditAccount(){
        this(NUMBER_DEFAULT, BALANCE_DEFAULT, APR_DEFAULT);
    }

    public CreditAccount(String number, double balance, double APR){
        super(number, balance);
        this.APR = APR;
    }

    @Override
    public double getAPR() {
        return APR;
    }

    @Override
    public void setAPR(double APR) {
        this.APR = APR;
    }

    @Override
    public String toString(){
        return String.format("Credit account - %1s APR: %2.2f", super.toString(), APR);
    }

    @Override
    public int hashCode(){
        return (71 * super.hashCode());
    }

    @Override
    public boolean equals(Object obj){
        return (super.equals(obj) && obj.hashCode() == this.hashCode());
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
