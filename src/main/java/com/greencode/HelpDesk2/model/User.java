package com.greencode.HelpDesk2.model;

import com.greencode.HelpDesk2.enun.ProfileEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Indexed;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import java.time.LocalDateTime;
import java.util.List;

import static javax.persistence.GenerationType.AUTO;

@Entity(name = "users")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = AUTO)
    private Long id;

    @Column(unique=true)
    @NotBlank(message = "Email required")
    @Email(message = "Email invalid")
    private String email;

    @NotBlank(message = "Password required")
    @Size(min = 4)
    private String password;
    private String username;
    private ProfileEnum profile;

    @Column(columnDefinition = "BOOLEAN DEFAULT FALSE")
    private Boolean deleted = false;

    private LocalDateTime dateCreated;

    // Mapeamento com entidade ticket, usuario que fez o chamado
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
    private List<Ticket> ticket;

    // Mapeamento com entidade ticket, funcionário que aceitou o chamado
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "assignedUser")
    private List<Ticket> assignedUser;

    // Mapeamento com entidade changeStatus, quem mudou o status do ticket
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
    private List<ChangeStatus> statusTicket;



}
