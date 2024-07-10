package et.telebof.types;

import java.util.List;
import java.util.Objects;

public class StarTransactions {
    public List<StarTransaction> transactions;

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        StarTransactions that = (StarTransactions) object;
        return Objects.equals(transactions, that.transactions);
    }

    @Override
    public int hashCode() {
        return Objects.hash(transactions);
    }
}
