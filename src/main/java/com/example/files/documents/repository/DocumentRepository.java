package com.example.files.documents.repository;
import com.example.files.documents.model.DocumentModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface DocumentRepository extends JpaRepository<DocumentModel, Long> {

    @Query("select d from DocumentModel d WHERE d.hashSha256 = (:hash)")
    Optional<DocumentModel> findBySha256(@Param("hash") String hash);

    @Query("select d from DocumentModel d WHERE d.hashSha512 = (:hash)")
    Optional<DocumentModel> findBySha512(@Param("hash") String hash);

}
