package com.huynhnam.pma_filmanagement.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.huynhnam.pma_filmanagement.entity.CastMembers;


public interface Cast_membersService {
    List<CastMembers> getAllCastMembers();
    Optional<CastMembers> getCastMemberById(Integer id);
    CastMembers saveCastMember(CastMembers castMember);
    CastMembers updateCastMember(Integer id, CastMembers castMember);
    void deleteCastMember(Integer id);
}