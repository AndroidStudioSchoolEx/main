package pojo;

public class Food {

    private Integer id;
    private String name;
    private String dcp;
    private String file;

    public Food(Integer id, String name, String dcp, String file) {
        this.id = id;
        this.name = name;
        this.dcp = dcp;
        this.file = file;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDcp() {
        return dcp;
    }

    public void setDcp(String dcp) {
        this.dcp = dcp;
    }

    public String getFile() {
        return file;
    }

    public void setFile(String file) {
        this.file = file;
    }
}
