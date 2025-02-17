package com.huynhnam.pma_filmanagement.Service.implement;

import com.huynhnam.pma_filmanagement.dao.Cast_membersDAO;
import com.huynhnam.pma_filmanagement.entity.CastMembers;
import com.huynhnam.pma_filmanagement.Service.Cast_membersService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CastMembersServiceImpl implements Cast_membersService {

    @Autowired
    private Cast_membersDAO castMembersDAO;

    @Override
    	public List<CastMembers> getAllCastMembers() {
    	    List<CastMembers> castMembersList = castMembersDAO.findAll();
    	    System.out.println("Dữ liệu castMembers: " + castMembersList);
    	    return castMembersList;
    	}

    

    @Override
    public Optional<CastMembers> getCastMemberById(Integer id) {
        return castMembersDAO.findById(id);
    }

    @Override
    public CastMembers saveCastMember(CastMembers castMember) {
        return castMembersDAO.save(castMember);
    }

    @Override
    public CastMembers updateCastMember(Integer id, CastMembers castMember) {
        Optional<CastMembers> existingCastMember = castMembersDAO.findById(id);
        if (existingCastMember.isPresent()) {
            CastMembers updatedCastMember = existingCastMember.get();
            updatedCastMember.setCastName(castMember.getCastName());
            return castMembersDAO.save(updatedCastMember);
        } else {
            throw new RuntimeException("Cast Member with ID " + id + " not found!");
        }
    }

    @Override
    public void deleteCastMember(Integer id) {
        if (castMembersDAO.existsById(id)) {
            castMembersDAO.deleteById(id);
        } else {
            throw new RuntimeException("Cast Member with ID " + id + " not found!");
        }
    }
}
