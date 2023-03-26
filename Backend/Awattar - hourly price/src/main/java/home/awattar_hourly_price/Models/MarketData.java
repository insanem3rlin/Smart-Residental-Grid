package home.awattar_hourly_price.Models;

import home.awattar_hourly_price.Models.Datapoint;

import java.util.List;

public class MarketData {
    private String object;
    private List<Datapoint> data;
    private String url;

    public String getObject() {
        return object;
    }

    public void setObject(String object) {
        this.object = object;
    }

    public List<Datapoint> getData() {
        return data;
    }

    public void setData(List<Datapoint> data) {
        this.data = data;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
