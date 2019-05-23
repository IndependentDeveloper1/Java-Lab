package po74.fomenkov.oop.model;

public class CreditAccount extends AbstractAccount implements Credit {
    private double APR;
    private final static double APR_DEFAULT = 30;
    private final static double BALANCE_DEFAULT = 0.0;
    private final static String NUMBER_DEFAULT = "";


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
}
