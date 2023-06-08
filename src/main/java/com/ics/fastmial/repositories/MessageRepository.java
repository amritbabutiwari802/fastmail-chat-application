package com.ics.fastmial.repositories;

import com.ics.fastmial.entity.Message;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface MessageRepository extends CrudRepository<Message, Integer> {
    List<Message> findBySenderUsername(String senderUsername);

    List<Message> findByReceiverUsername(String receiverUsername);

    @Query(value = "SELECT * FROM message m " +
            "WHERE" +
            " (m.sender_username=:myUsername AND m.receiver_username=:peerUsername) " +
            "OR " +
            "(m.sender_username=:peerUsername AND m.receiver_username=:myUsername)",
            nativeQuery = true
    )
    List<Message> listAllMessageByPeerUsername(@Param("myUsername") String myUsername, @Param("peerUsername") String peerUsername);

	@Query(
			value="SELECT * FROM message m " +
					"WHERE" +
					" m.senderUsernam=:myUsername OR m.receiverUsername=:myUsername",
			nativeQuery = true
	)
	List <Message> findAllMessage(@Param("myUsername") String myUsername);
}
