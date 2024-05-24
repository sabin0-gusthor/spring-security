package br.com.springsecurity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.springsecurity.entities.Tweet;

@Repository
public interface TweetRepository extends JpaRepository<Tweet, Long> {
    
}
