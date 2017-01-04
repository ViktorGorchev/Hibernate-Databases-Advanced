package app.domain.models.camera;

public interface Camera {

    Long getId();

    String getMake();

    void setMake(String make);

    String getModel();

    void setModel(String model);

    Boolean getFullFrame();

    void setFullFrame(Boolean fullFrame);

    Integer getMinISO();

    void setMinISO(Integer minISO);

    Integer getMaxISO();

    void setMaxISO(Integer maxISO);
}
