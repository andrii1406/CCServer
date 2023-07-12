package ccserver.dto;

public class FilialDTO {

    private Long id;

    private Long tv;

    private String cn;


    public FilialDTO() {}

    public FilialDTO(Long id) {
        this.id = id;
    }

    public FilialDTO(Long id, Long tv, String cn) {
        this.id = id;
        this.tv = tv;
        this.cn = cn;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getTv() {
        return tv;
    }

    public void setTv(Long tv) {
        this.tv = tv;
    }

    public String getCn() {
        return cn;
    }

    public void setCn(String cn) {
        this.cn = cn;
    }

    @Override
    public String toString() {
        return "FilialDTO{" +
                "id=" + id +
                ", tv=" + tv +
                ", cn='" + cn + '\'' +
                '}';
    }

}