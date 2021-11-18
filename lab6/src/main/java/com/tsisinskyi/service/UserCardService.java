package com.tsisinskyi.service;

import com.tsisinskyi.DTO.UserCardDTO;
import com.tsisinskyi.mapper.UserCardMapper;
import com.tsisinskyi.model.UserCard;
import com.tsisinskyi.repository.UserCardRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class UserCardService {

    private final UserCardRepository userCardRepository;

    public List<UserCard> getAllUserCard() {
        return userCardRepository.findAll();
    }

    public UserCard getUserCardById(Integer id) {
        return userCardRepository.findById(id).orElse(null);
    }

    public UserCard createUserCard(UserCardDTO userCardDTO) {
        return userCardRepository.save(UserCardMapper.mapDTOToUserCard(userCardDTO));
    }

    public UserCard updateUserCard(UserCardDTO userCardDTO) {
        if (getUserCardById(userCardDTO.getId()) != null) {
            return userCardRepository.save(UserCardMapper.mapDTOToUserCard(userCardDTO));
        }
        return null;
    }

    public UserCard deleteUserCardById(Integer id) {
        UserCard userCard = getUserCardById(id);
        if (userCard != null) {
            userCardRepository.deleteById(id);
            return userCard;
        }
        return null;
    }
}