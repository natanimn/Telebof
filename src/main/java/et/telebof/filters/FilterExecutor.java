package et.telebof.filters;

@FunctionalInterface
public interface FilterExecutor {
    boolean execute(Filter filter);
}
