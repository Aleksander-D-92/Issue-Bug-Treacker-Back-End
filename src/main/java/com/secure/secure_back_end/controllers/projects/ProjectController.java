package com.secure.secure_back_end.controllers.projects;

import com.secure.secure_back_end.dto.project.binding.ProjectCreateForm;
import com.secure.secure_back_end.dto.project.binding.ProjectEditForm;
import com.secure.secure_back_end.dto.project.binding.ProjectQAForm;
import com.secure.secure_back_end.dto.project.view.ProjectViewModel;
import com.secure.secure_back_end.dto.user.view.UserViewModel;
import com.secure.secure_back_end.services.interfaces.ProjectService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@RestController
@Validated
public class ProjectController
{
    private final ProjectService projectService;

    @Autowired
    public ProjectController(ProjectService projectService)
    {
        this.projectService = projectService;
    }

    @GetMapping("/projects")
    @ApiOperation("action must equal \"all\", \"single\" or \"own\" or \"include-qa\". If \"single\" or \"own\" you must pass a projectId or userId to specify. If  \"include-qa\" specify userId Example: GET /projects?action=single&id=12")
    public List<ProjectViewModel> getProjects(@RequestParam(value = "action") @Pattern(regexp = "^all$|^single$|^own$|^include-developer$|^include-qa$") String action,
                                              @RequestParam(value = "id", required = false) @Min(1) Long id)
    {
        switch (action)
        {
            case "all":
                return this.projectService.findALl();
            case "single":
                return Collections.singletonList(this.projectService.findOne(id));
            case "own":
                return this.projectService.findByProjectManager(id);
            case "include-qa":
                return this.projectService.findIncludingQA(id);
            default:
                return new ArrayList<>();
        }
    }

    @GetMapping("/projects/qa")
    @ApiOperation("action must equal \"assigned\" or \"available\". Returns assigned or available developers for a given project.\n " +
            "Example GET /projects/qa?action=available&projectId=1&managerId=1 GET /projects/qa?action=assigned&projectId=1")
    public List<UserViewModel> getQas(@RequestParam(value = "action") @Pattern(regexp = "^assigned$|^available$") String action,
                                      @RequestParam(value = "projectId") @Min(1) Long projectId,
                                      @RequestParam(value = "managerId", required = false) @Min(1) Long managerId)
    {
        switch (action)
        {
            case "assigned":
                return this.projectService.findAssignedQa(projectId);
            case "available":
                return this.projectService.findAvailableQaToAssign(projectId, managerId);
            default:
                return new ArrayList<>();
        }
    }

    @PostMapping("/projects/{userId}")
    @ApiOperation(value = "create a new project")
    public void createProject(@Valid @RequestBody ProjectCreateForm form, @PathVariable("userId") @Min(1) Long userId)
    {
        this.projectService.createProject(form, userId);
    }

    @PutMapping("/projects/{projectId}")
    @ApiOperation(value = "edit an existing project")
    public void editProject(@Valid @RequestBody ProjectEditForm form,
                            @PathVariable("projectId") @Min(1) Long projectId)
    {
        this.projectService.editProject(form, projectId);
    }

    @PutMapping("/projects/qa")
    @ApiOperation(value = "action can be \"add\" or \"remove\". Example PUT /projects/qa?action=add&projectId=2")
    public void assignDevelopers(@Valid @RequestBody ProjectQAForm form,
                                 @RequestParam("projectId") @Min(1) Long projectId,
                                 @RequestParam("action") @Pattern(regexp = "^add$|^remove$") String action)
    {
        switch (action)
        {
            case "add":
                this.projectService.addQaToProject(form, projectId);
                break;
            case "remove":
                this.projectService.removeQAFromProject(form, projectId);
                break;
            default:
                break;
        }
    }
}
