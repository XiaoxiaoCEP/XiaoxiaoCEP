package com.xiaoxiaopm.dao;

import java.util.List;

import com.xiaoxiaopm.model.Workflow;

public interface WorkflowDAO {

    public void save(Workflow workflow);
    
    public List<Workflow> list();
}
