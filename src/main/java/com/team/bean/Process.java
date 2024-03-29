package com.team.bean;

public class Process {
    private String processId;

    private String technologyPlanId;

    private Integer sequence;

    private Integer quota;

    private TechnologyPlan technologyPlan;
    private String note;

    public TechnologyPlan getTechnologyPlan() {
        return technologyPlan;
    }

    public void setTechnologyPlan(TechnologyPlan technologyPlan) {
        this.technologyPlan = technologyPlan;
    }

    public String getProcessId() {
        return processId;
    }

    public void setProcessId(String processId) {
        this.processId = processId == null ? null : processId.trim();
    }

    public String getTechnologyPlanId() {
        return technologyPlanId;
    }

    public void setTechnologyPlanId(String technologyPlanId) {
        this.technologyPlanId = technologyPlanId == null ? null : technologyPlanId.trim();
    }

    public Integer getSequence() {
        return sequence;
    }

    public void setSequence(Integer sequence) {
        this.sequence = sequence;
    }

    public Integer getQuota() {
        return quota;
    }

    public void setQuota(Integer quota) {
        this.quota = quota;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getNote() {
        return note;
    }
}