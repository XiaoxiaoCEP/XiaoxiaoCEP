package com.xiaoxiaopm.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.xiaoxiaopm.model.Workflow;
import com.xiaoxiaopm.service.WorkflowService;

public class WorflowController {

    private WorkflowService workflowService;
    
    @Autowired(required=true)
    @Qualifier(value="WorkflowService")
    public void setWorkflowService(WorkflowService workflowService) {
        this.workflowService = workflowService;
    }
    
    @RequestMapping(value="/workflows", method=RequestMethod.GET)
    public String listWorkflows(Model model) {
        model.addAttribute("workflow", new Workflow());
        model.addAttribute("listWorkflows", this.workflowService.listWorkflows());
        
        return "Workflow";
    }
    
    @RequestMapping(value="/workflow/add", method=RequestMethod.POST)
    public String addWorkflow(@ModelAttribute("workflow") Workflow workflow) {
        
        if(workflow.getWorkflowID() == "") {
            this.workflowService.addWorkflow(workflow);
        }
        else {
            this.workflowService.updateWorkflow(workflow);
        }
        
        return "redirect:/workflows";
    }
    
    @RequestMapping("/remove/{workflowID}")
    public String removeWorkflow(@PathVariable("workflowID") String workflowID) {
        
        this.workflowService.removeWorkflow(workflowID);
        return "redirect:/workflows";
    }
    
    @RequestMapping("/update/{workflowID}")
    public String updateWorkflow(@PathVariable("workflowID") String workflowID,
            Model model) {
        model.addAttribute("workflow", new Workflow());
        model.addAttribute("listWorkflows", this.workflowService.listWorkflows());
        
        return "Workflow";
    }
}
