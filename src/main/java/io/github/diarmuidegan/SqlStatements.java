package io.github.diarmuidegan;

public class SqlStatements {
    public static final String Delete = "Delete From TABLE Where ID = ?";
    public static final String GetAll = "Select * From TABLE";
    public static final String GetById = "Select * From TABLE Where ID = ?";
    public static final String Insert = "Insert Into TABLE (COL1, COL2, COL3) Values (?,?,?)";
    public static final String Update = "Update TABLE Set COL1 = ?, COL2 = ?, COL3 = ? Where ID = ?";
}
