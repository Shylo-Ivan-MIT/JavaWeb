/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.obrii.fit.mit.springMVCThymleafCRUD2021.ReposLayer;

import org.obrii.fit.mit.springMVCThymleafCRUD2021.DomainLayer.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Користувач
 */
@Repository
public interface UserRepository extends CrudRepository<User, Long> {}
