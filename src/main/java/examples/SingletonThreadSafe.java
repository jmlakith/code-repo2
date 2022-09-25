package examples;

/**
 * @author Lakith Dharmarathna
 * Date : 07/07/2022
 */
public class SingletonThreadSafe {

    private static Database database;

    public synchronized Database getDatabase(){
        if (database==null) {
            database = new Database("");
        }
        return database;
    }

}

class Database{
    private String url="www.google.com";

    public Database(String url) {
        this.url = url;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
