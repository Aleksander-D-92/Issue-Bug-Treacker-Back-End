package com.secure.secure_back_end.services.implementations;

import com.secure.secure_back_end.domain.Project;
import com.secure.secure_back_end.domain.User;
import com.secure.secure_back_end.dto.project.binding.ProjectChangeDevelopersForm;
import com.secure.secure_back_end.dto.project.binding.ProjectCreateEditForm;
import com.secure.secure_back_end.dto.project.view.ProjectViewModel;
import com.secure.secure_back_end.repositories.ProjectRepository;
import com.secure.secure_back_end.repositories.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProjectServiceImpl
{
    private final ProjectRepository projectRepository;
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public ProjectServiceImpl(ProjectRepository projectRepository, UserRepository userRepository, ModelMapper modelMapper)
    {
        this.projectRepository = projectRepository;
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
    }

    public void createProject(ProjectCreateEditForm projectCreateEditForm)
    {
        Project newProject = this.modelMapper.map(projectCreateEditForm, Project.class);
        newProject.setId(null);
        User user = this.userRepository.getOne(projectCreateEditForm.getOwnerId());
        newProject.setProjectManager(user);
        newProject.setCreationDate(new Date());
        this.projectRepository.save(newProject);
    }

    public void editProject(ProjectEditForm projectEditForm)
    {
        this.projectRepository.editProject(projectEditForm.getProjectId(), projectEditForm.getTitle(), projectEditForm.getDescription());
    }

    public ProjectViewModel getProject(long id)
    {
        Project project = this.projectRepository.findById(id).orElse(null);
        ProjectViewModel viewModel = this.modelMapper.map(project, ProjectViewModel.class);
        assert project != null;
        viewModel.setProjectManagerName(project.getProjectManager().getUsername());
        viewModel.setProjectManagerId(project.getProjectManager().getId());
        return viewModel;
    }

    public List<ProjectViewModel> getAllProjects()
    {
        List<Project> byProjectManager = this.projectRepository.findAll();
        return byProjectManager.stream().map(project ->
        {
            ProjectViewModel viewModel = this.modelMapper.map(project, ProjectViewModel.class);
            User projectManager = project.getProjectManager();
            viewModel.setProjectManagerName(projectManager.getUsername());
            viewModel.setProjectManagerId(projectManager.getId());
            return viewModel;
        }).collect(Collectors.toList());
    }

    public List<ProjectViewModel> getOwnProjects(long userId)
    {
        User projectManager = this.userRepository.getOne(userId);
        List<Project> byProjectManager = this.projectRepository.findByProjectManager(projectManager);
        return byProjectManager.stream().map(project ->
        {
            ProjectViewModel viewModel = this.modelMapper.map(project, ProjectViewModel.class);
            viewModel.setProjectManagerName(projectManager.getUsername());
            viewModel.setProjectManagerId(projectManager.getId());
            return viewModel;
        }).collect(Collectors.toList());
    }

    //todo below
    public void assignDevelopers(ProjectChangeDevelopersForm form)
    {
        List<User> developers = this.userRepository.findByIdIn(form.getDeveloperIds());
        Project project = this.projectRepository.findById(form.getProjectId()).orElse(null);
        assert project != null;
        developers.forEach(dev -> project.getAssignedDevelopers().add(dev));
        this.projectRepository.save(project);
    }

    public void removeDevelopers(ProjectChangeDevelopersForm form)
    {
        List<Long> developerIds = form.getDeveloperIds();
        Project project = this.projectRepository.findById(form.getProjectId()).orElse(null);
        assert project != null;
        List<User> filtered = project.getAssignedDevelopers().stream().filter(dev -> !developerIds.contains(dev.getId())).collect(Collectors.toList());
        project.getAssignedDevelopers().clear();
        project.setAssignedDevelopers(new HashSet<>(filtered));
        this.projectRepository.save(project);
    }
}
