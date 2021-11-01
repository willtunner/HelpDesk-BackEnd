package com.greencode.HelpDesk2.model;

import com.greencode.HelpDesk2.enun.StatusEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import java.util.Date;

import static javax.persistence.GenerationType.AUTO;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ChangeStatus {

    @Id
    @GeneratedValue(strategy = AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_ticket")
    private Ticket ticket;

    @ManyToOne
    @JoinColumn(name = "id_user")
    private User user;

    private Date dateChangeStatus;
    private StatusEnum status;
}
