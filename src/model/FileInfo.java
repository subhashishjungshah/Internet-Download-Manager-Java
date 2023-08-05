package model;

public class FileInfo {
    private int index;
    private String name;
    private String url;

    private String downloadStatus;

    public FileInfo(int index, String name, String url, String downloadStatus) {
        this.index = index;
        this.name = name;
        this.url = url;
        this.downloadStatus = downloadStatus;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
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

    public String getDownloadStatus() {
        return downloadStatus;
    }

    public void setDownloadStatus(String downloadStatus) {
        this.downloadStatus = downloadStatus;
    }
}

