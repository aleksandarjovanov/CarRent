package finki.ukim.mk.carrent.service;

import finki.ukim.mk.carrent.model.Admin;

import java.util.List;

public interface AdminService {

    Admin findById(Long adminId);

    Admin createAdmin(Long adminId, String firstName, String lastName, String imgUrl);

}
