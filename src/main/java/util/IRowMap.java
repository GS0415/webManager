package util;

import java.sql.ResultSet;


public interface IRowMap<T> {
    public T rowMap(ResultSet rs);

}
