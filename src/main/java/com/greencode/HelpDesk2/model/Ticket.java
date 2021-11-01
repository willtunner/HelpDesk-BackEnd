package com.greencode.HelpDesk2.model;

import com.greencode.HelpDesk2.enun.PriorityEmun;
import com.greencode.HelpDesk2.enun.StatusEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import java.util.Date;
import java.util.List;

import static javax.persistence.GenerationType.AUTO;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Ticket {

    @Id
    @GeneratedValue(strategy = AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_user")
    private User user;

    @ManyToOne
    @JoinColumn(name = "id_Assigned_user")
    private User assignedUser;

    // Mapeamento com entidade ticket, usuario que fez o chamado
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "ticket")
    private List<ChangeStatus> changes;

    private Date date;
    private String title;
    private String description;
    private Integer number;
    private String image;
    private StatusEnum status;
    private PriorityEmun priority;
}
