package org.app.farmhouse.repository;

import org.app.farmhouse.modal.user.AccountVerification;
import org.app.farmhouse.modal.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AccountVerificationRepository extends JpaRepository<AccountVerification, Long> {

    Optional<AccountVerification> findByUserIdentifierAndExpired(String identifier, boolean expired);
}
