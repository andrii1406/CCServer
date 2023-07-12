package ccserver.dto;

public class KstatDTO {

    private Long id;

    private String stat;


    public KstatDTO() {}

    public KstatDTO(Long id) {
        this.id = id;
    }

    public KstatDTO(Long id, String stat) {
        this.id = id;
        this.stat = stat;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStat() {
        return stat;
    }

    public void setStat(String stat) {
        this.stat = stat;
    }

    @Override
    public String toString() {
        return "KstatDTO {" +
                "id=" + id +
                ", stat='" + stat + '\'' +
                '}';
    }

}