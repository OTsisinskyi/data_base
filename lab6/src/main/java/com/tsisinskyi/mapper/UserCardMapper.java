package com.tsisinskyi.mapper;

import com.tsisinskyi.DTO.UserCardDTO;
import com.tsisinskyi.model.UserCard;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class UserCardMapper {

    public static UserCardDTO mapUserCardToDTO(UserCard userCard) {
        return new UserCardDTO(
                userCard.getId(),
                userCard.getName(),
                userCard.getSurname(),
                userCard.getPhoneNumber(),
                userCard.getEnterprise_id(),
                userCard.getRegularUser()
        );
    }

    public static UserCard mapDTOToUserCard(UserCardDTO userCardDTO) {
        return new UserCard(
                userCardDTO.getId(),
                userCardDTO.getName(),
                userCardDTO.getSurname(),
                userCardDTO.getPhoneNumber(),
                userCardDTO.getEnterprise_id(),
                userCardDTO.getRegularUser()
        );
    }
}