package com.xiaoxiaopm.dao;

import java.util.List;

import com.xiaoxiaopm.model.Workflow;

public interface WorkflowDAO {

    public void addWorkflow(Workflow workflow);

    public void updateWorkflow(Workflow workflow);
    
    public Workflow getWorkflowById(String workflowID);
    
    public void removeWorkflow(String workflowID);
    
    public List<Workflow> listWorkflows();
}
