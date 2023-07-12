package ccserver.dto;

public class ObmenDTO {

    private Long id;

    private String obm;


    public ObmenDTO() {}

    public ObmenDTO(Long id) {
        this.id = id;
    }

    public ObmenDTO(Long id, String obm) {
        this.id = id;
        this.obm = obm;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getObm() {
        return obm;
    }

    public void setObm(String obm) {
        this.obm = obm;
    }

    @Override
    public String toString() {
        return "ObmenDTO {" +
                "id=" + id +
                ", obm='" + obm + '\'' +
                '}';
    }

}
