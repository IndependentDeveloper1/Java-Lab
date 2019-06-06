package po74.fomenkov.oop.model;

public class DebitAccount extends AbstractAccount {

    public DebitAccount(){
        super(NUMBER_DEFAULT,BALANCE_DEFAULT);
            }
    public DebitAccount(String number, double balance){
        super(number, balance);
    }

    @Override
    public String toString(){
        return String.format("Debit account - %1", super.toString());
    }

    @Override
    public int hashCode(){
        return (53 * super.hashCode());
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
