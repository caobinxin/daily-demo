class DataAccess{

    private static final String SQL = "Sqlserver";
    private static final String ACC = "Access";
    // private String db = "Sqlserver";
    private String db = "Access";

    public DataAccess(){
        System.out.println("DataAccess...");
    }

    public IUser onCreateUser(){
        IUser ret = null;
        switch(db){
            case SQL:
                ret = new SqlserverUser();
                break;
            case ACC:
                ret = new AccessUser();
                break;
            default:
                break;
        }
        return ret;
    }

    public IDepartment onCreateDepartment(){
        IDepartment ret = null;
        switch(db){
            case SQL:
                ret = new SqlserverDepartment();
                break;
            case ACC:
                ret = new SqlserverDepartment();
                break;
            default:
                break;
        }
        return ret;
    }

}