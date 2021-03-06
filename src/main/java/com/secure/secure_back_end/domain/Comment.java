package com.secure.secure_back_end.domain;

import javax.persistence.*;
import java.util.Date;

@Entity(name = "comments")
@NamedEntityGraphs({
        @NamedEntityGraph(name = "ticketSubmitter", attributeNodes = {
                @NamedAttributeNode(value = "ticket"),
                @NamedAttributeNode(value = "submitter")
        })
})
public class Comment
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long commentId;
    @Column
    private String description;
    @Column
    private Date creationDate;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ticket_id", referencedColumnName = "ticketId")
    private Ticket ticket;
    @ManyToOne(targetEntity = User.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "submitter_id", referencedColumnName = "userId")
    private User submitter;

    public Comment()
    {
    }

    public Long getCommentId()
    {
        return commentId;
    }

    public void setCommentId(Long id)
    {
        this.commentId = id;
    }

    public String getDescription()
    {
        return description;
    }

    public void setDescription(String value)
    {
        this.description = value;
    }

    public Date getCreationDate()
    {
        return creationDate;
    }

    public void setCreationDate(Date creationDate)
    {
        this.creationDate = creationDate;
    }

    public Ticket getTicket()
    {
        return ticket;
    }

    public void setTicket(Ticket ticket)
    {
        this.ticket = ticket;
    }

    public User getSubmitter()
    {
        return submitter;
    }

    public void setSubmitter(User user)
    {
        this.submitter = user;
    }
}
