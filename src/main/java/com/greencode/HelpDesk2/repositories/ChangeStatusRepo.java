package com.greencode.HelpDesk2.repositories;

import com.greencode.HelpDesk2.model.ChangeStatus;
import com.greencode.HelpDesk2.model.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChangeStatusRepo extends JpaRepository<ChangeStatus, Long> {

    Iterable<ChangeStatus> findByTicketIdOrderByDateChangeStatus(Long ticketId);
}
