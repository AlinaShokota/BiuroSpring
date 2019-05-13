package pl.sda.controller.model;

public class ImageRequest {
    private Integer id;
    private String name;
    private String url;
    private Integer tripId;

    public ImageRequest(Integer id, String name, String url, Integer tripId) {
        this.id = id;
        this.name = name;
        this.url = url;
        this.tripId = tripId;
    }

    public ImageRequest() {
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

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Integer getTripId() {
        return tripId;
    }

    public void setTripId(Integer tripId) {
        this.tripId = tripId;
    }
}
