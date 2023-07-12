package ccserver.dto;

public class CurrencyDTO {

    private Long id;

    private String vl;


    public CurrencyDTO() {}

    public CurrencyDTO(Long id) {
        this.id = id;
    }

    public CurrencyDTO(Long id, String vl) {
        this.id = id;
        this.vl = vl;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getVl() {
        return vl;
    }

    public void setVl(String vl) {
        this.vl = vl;
    }

    @Override
    public String toString() {
        return "CurrencyDTO {" +
                "id=" + id +
                ", vl='" + vl + '\'' +
                '}';
    }

}
