import java.util.Hashtable;

class WebSiteFactory{
    private Hashtable<String,WebSite> ht = new Hashtable<>();

    public WebSite onGetWebSite(String key){
        if(null == ht.get(key)){
            ht.put(key, new ConcreteWebSite(key));
        }

        return (WebSite)ht.get(key);
    }
}