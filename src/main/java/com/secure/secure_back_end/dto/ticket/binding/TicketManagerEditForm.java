package com.secure.secure_back_end.dto.ticket.binding;

import com.secure.secure_back_end.domain.enums.Category;
import com.secure.secure_back_end.domain.enums.Priority;
import com.secure.secure_back_end.domain.enums.Status;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class TicketManagerEditForm
{
    @Size(min = 5, max = 30, message = "title must be between 10 and 255 symbols long")
    private String title;
    @Size(min = 10, max = 255, message = "description must be between 10 and 255 symbols long")
    private String description;
    @NotNull
    private Category category;
    @NotNull
    private Priority priority;
    private Status status;
    private Long assignedDeveloperId;


    public String getTitle()
    {
        return title;
    }

    public void setTitle(String title)
    {
        this.title = title;
    }

    public String getDescription()
    {
        return description;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

    public Category getCategory()
    {
        return category;
    }

    public void setCategory(Category category)
    {
        this.category = category;
    }

    public Priority getPriority()
    {
        return priority;
    }

    public void setPriority(Priority priority)
    {
        this.priority = priority;
    }

    public Status getStatus()
    {
        return status;
    }

    public void setStatus(Status status)
    {
        this.status = status;
    }

    public Long getAssignedDeveloperId()
    {
        return assignedDeveloperId;
    }

    public void setAssignedDeveloperId(Long assignedDeveloperId)
    {
        this.assignedDeveloperId = assignedDeveloperId;
    }
}
