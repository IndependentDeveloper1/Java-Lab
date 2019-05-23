package po74.fomenkov.oop.model;

public enum ClientStatus {
    GOOD(0 | 1 | 2), GOLD(3 | 4), PLATINUM(5), RISKY(-2 | -1), BAD(-4 | -3);
    private int creditScoreBound;
    ClientStatus(int creditScoreBound){
        this.creditScoreBound = creditScoreBound;
    }
    public int getCreditScoreBound() {
        return creditScoreBound;
    }
}

