package et.telebof.filters;

import et.telebof.types.Update;

public interface CustomFilter {
    boolean check(Update update);
}