package finki.ukim.mk.carrent.service.impl;

import finki.ukim.mk.carrent.model.Admin;
import finki.ukim.mk.carrent.model.exceptions.InvalidAdminException;
import finki.ukim.mk.carrent.repository.repoInterfaces.AdminRepository;
import finki.ukim.mk.carrent.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminRepository adminRepository;

    @Override
    public Admin findById(Long adminId) {
        return adminRepository.findById(adminId).orElseThrow(InvalidAdminException::new);
    }

    @Override
    public Admin createAdmin(Long adminId, String firstName, String lastName, String imgUrl) {
        Admin admin = new Admin();
        admin.createAdmin(adminId, firstName, lastName, imgUrl);
        return adminRepository.save(admin);
    }
}
