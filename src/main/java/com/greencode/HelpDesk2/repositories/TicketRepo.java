package com.greencode.HelpDesk2.repositories;

import com.greencode.HelpDesk2.model.Ticket;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;



public interface TicketRepo extends JpaRepository<Ticket, Long> {

    //    @Query(nativeQuery = true, value = "select * from tb_users")
//    List<User> findAllUsers();

    Page<Ticket> findByUserIdOrderByDateDesc(Long userId, Pageable pages);
    Page<Ticket> findByTitleIgnoreCaseContainingAndStatusAndPriorityOrderByDateDesc( String title, String status, String priority, Pageable pages);
    Page<Ticket> findByTitleIgnoreCaseContainingAndStatusAndPriorityAndUserIdOrderByDateDesc( String title, String status, String priority, Long idUser, Pageable pages);
    Page<Ticket> findByTitleIgnoreCaseContainingAndStatusAndPriorityAndAssignedUserIdOrderByDateDesc( String title, String status, String priority, Long idAssignedUser, Pageable pages);
    Page<Ticket> findByNumber(Integer number, Pageable pages);
}