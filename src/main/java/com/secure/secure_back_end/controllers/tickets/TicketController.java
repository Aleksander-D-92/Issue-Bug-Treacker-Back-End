package com.secure.secure_back_end.controllers.tickets;

import com.secure.secure_back_end.dto.ticket.binding.TicketCreateForm;
import com.secure.secure_back_end.dto.ticket.binding.TicketDevEditForm;
import com.secure.secure_back_end.dto.ticket.binding.TicketManagerEditForm;
import com.secure.secure_back_end.dto.ticket.view.TicketViewModel;
import com.secure.secure_back_end.services.interfaces.TicketService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import java.util.List;

@RestController
@Validated
public class TicketController
{
    private final TicketService ticketService;

    @Autowired
    public TicketController(TicketService ticketService)
    {
        this.ticketService = ticketService;
    }

    @GetMapping("/tickets/all")
    @ApiOperation(value = "returns all tickets in the system")
    public List<TicketViewModel> getAll()
    {
        return this.ticketService.getAllTickets();
    }

    @GetMapping("/tickets/by-submitter/{submitterId}")
    @ApiOperation(value = "returns all tickets by submitterId")
    public List<TicketViewModel> getAllByUserId(@PathVariable(value = "submitterId") @Min(1) Long submitterId)
    {
        return this.ticketService.getAllTicketsBySubmitterId(submitterId);
    }

    @GetMapping("/tickets/by-project/{projectId}")
    @ApiOperation(value = "returns all tickets by projectId")
    public List<TicketViewModel> getAllByProjectId(@PathVariable(value = "projectId") @Min(1) Long projectId)
    {
        return this.ticketService.getAllTicketsByProjectId(projectId);
    }

    @PostMapping("/tickets/{projectId}")
    @ApiOperation(value = "creates a new ticket")
    public void submitTicket(@Valid @RequestBody TicketCreateForm form,
                             @PathVariable(value = "projectId") @Min(1) Long projectId)
    {
        this.ticketService.submitTicket(form, projectId);
    }

    @PutMapping("/tickets/{ticketId}/manager")
    @ApiOperation(value = "used to edit tickets by project managers")
    public void editTicket(@Valid @RequestBody TicketManagerEditForm form,
                           @PathVariable("ticketId") @Min(1) Long ticketId)
    {
        this.ticketService.editTicketManager(form, ticketId);
    }

    @PutMapping("/tickets/{ticketId}/developer")
    @ApiOperation(value = "used to edit tickets by developers and submitters")
    public void editTicket(@Valid @RequestBody TicketDevEditForm form,
                           @PathVariable("ticketId") @Min(1) Long ticketId)
    {
        this.ticketService.editTicketDevs(form, ticketId);
    }
}