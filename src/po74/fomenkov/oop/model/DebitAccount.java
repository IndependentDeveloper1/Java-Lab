package po74.fomenkov.oop.model;

public class DebitAccount extends AbstractAccount {

    public DebitAccount(){
        super(NUMBER_DEFAULT,BALANCE_DEFAULT);
            }
    public DebitAccount(String number, double balance){
        super(number, balance);
    }
}
