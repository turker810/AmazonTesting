package api.trellopojos;

public class MyPojo {
    private String name;
    private String key;
    private String token;

    public MyPojo() {
    }

    public MyPojo(String name, String key, String token) {
        this.name = name;
        this.key = key;
        this.token = token;
    }

    public MyPojo( String token) {

        this.token = token;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    @Override
    public String toString() {
        return "MyPojo{" +
                "name='" + name + '\'' +
                ", key='" + key + '\'' +
                ", token='" + token + '\'' +
                '}';
    }
}
