import java.util.Date;

public class WareHouse {
    int id;
    Date createDate;

    @Override
    public String toString() {
        return "WareHouse{" +
                "id=" + id +
                ", createDate=" + createDate +
                '}';
    }

    public WareHouse(int id, Date createDate) {
        this.id = id;
        this.createDate = createDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
}
