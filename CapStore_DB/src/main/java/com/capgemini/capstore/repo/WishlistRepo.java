package com.capgemini.capstore.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.capgemini.capstore.beans.Wishlist;

public interface WishlistRepo extends JpaRepository<Wishlist, Integer>, CrudRepository<Wishlist, Integer> {

}
