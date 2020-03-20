package finki.ukim.mk.carrent.service;

import finki.ukim.mk.carrent.model.Admin;

import java.util.List;

public interface AdminService {
    Admin findById(Long adminId);

    List<Admin> getAdmin();


}
