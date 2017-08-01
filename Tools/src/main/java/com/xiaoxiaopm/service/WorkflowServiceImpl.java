package com.xiaoxiaopm.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.xiaoxiaopm.dao.WorkflowDAO;
import com.xiaoxiaopm.model.Workflow;

public class WorkflowServiceImpl implements WorkflowService {
    
    private WorkflowDAO workflowDAO;
    
    public void setWorkflowDAO(WorkflowDAO workflowDAO) {
        this.workflowDAO = workflowDAO;
    }

    @Override
    @Transactional
    public void addWorkflow(Workflow workflow) {
        //
        this.workflowDAO.addWorkflow(workflow);
    }

    @Override
    @Transactional
    public void updateWorkflow(Workflow workflow) {
        //
        this.workflowDAO.updateWorkflow(workflow);
    }

    @Override
    @Transactional
    public Workflow getWorkflowById(String workflowID) {
        // 
        return this.workflowDAO.getWorkflowById(workflowID);
    }

    @Override
    @Transactional
    public void removeWorkflow(String workflowID) {
        //
        this.workflowDAO.removeWorkflow(workflowID);
        
    }

    @Override
    @Transactional
    public List<Workflow> listWorkflows() {
        //
        return this.listWorkflows();
    }

}
