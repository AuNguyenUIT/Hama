package com.hama.Hama.model;

public class Report extends BaseModel {
    private String reportType;
    private String title;
    private float turnover;

    public Report() {
        super();
    }

    public Report(String reportType, String title, float turnover) {
        super();
        this.reportType = reportType;
        this.title = title;
        this.turnover = turnover;
    }

    public String getReportType() {
        return reportType;
    }

    public void setReportType(String reportType) {
        this.reportType = reportType;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public float getTurnover() {
        return turnover;
    }

    public void setTurnover(float turnover) {
        this.turnover = turnover;
    }
}
