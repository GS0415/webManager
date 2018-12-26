package pojo;

import java.util.Set;

public class Mark {
    private String markName;
    private int markId;
    private String logo;
    private Set<Product> set;

    @Override
    public String toString() {
        return "Mark{" +
                "markName='" + markName + '\'' +
                ", markId=" + markId +
                ", logo='" + logo + '\'' +
                ", set=" + set +
                '}';
    }

    public Set<Product> getSet() {
        return set;
    }

    public void setSet(Set<Product> set) {
        this.set = set;
    }

    public String getMarkName() {
        return markName;
    }

    public void setMarkName(String markName) {
        this.markName = markName;
    }

    public int getMarkId() {
        return markId;
    }

    public void setMarkId(int markId) {
        this.markId = markId;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }
}
