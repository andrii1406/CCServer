package ccserver.dto;

public class OperationDTO {

    private Long id;

    private String opr;


    public OperationDTO() {}

    public OperationDTO(Long id) {
        this.id = id;
    }

    public OperationDTO(Long id, String opr) {
        this.id = id;
        this.opr = opr;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOpr() {
        return opr;
    }

    public void setOpr(String opr) {
        this.opr = opr;
    }

    @Override
    public String toString() {
        return "OperationDTO {" +
                "id=" + id +
                ", opr='" + opr + '\'' +
                '}';
    }

}
