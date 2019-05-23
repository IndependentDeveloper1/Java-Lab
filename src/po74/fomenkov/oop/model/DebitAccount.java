package po74.fomenkov.oop.model;

public class DebitAccount extends AbstractAccount {

    private final static String UNKNOWN_NUMBER = "";
    private final static double BALANCE_DEFAULT = 0.0;

    public DebitAccount(){
        super(UNKNOWN_NUMBER,BALANCE_DEFAULT);
            }
    public DebitAccount(String number, double balance){
        super(number, balance);
    }
}
